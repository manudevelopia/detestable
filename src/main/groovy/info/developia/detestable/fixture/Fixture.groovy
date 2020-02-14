package info.developia.detestable.fixture

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import info.developia.detestable.field.Final

class Fixture {

    private ObjectMapper mapper
    private Class clazz
    private Set<String> types = []

    static def of(Class clazz) {
        return new Fixture(clazz: clazz)
    }

    def type(String type) {
        types.add(type)
        return this
    }

    def types(Set<String> types) {
        this.types = types
        return this
    }

    def build() {
        JsonNode nodes = readNodes("${clazz.simpleName}s.yml")
        return process(nodes)
    }

    private def readNodes(String filename) {
        mapper = new ObjectMapper(new YAMLFactory())
        mapper.findAndRegisterModules()
        return mapper.readTree(getClass().getClassLoader().getResourceAsStream(filename))
    }

    private def process(JsonNode jsonNode) {
        if (jsonNode.isObject()) {
            return processNode(jsonNode)
        } else if (jsonNode.isArray()) {
            return jsonNode.collect { node -> processNode(node) }
        }
        return jsonNode.asType(clazz)
    }

    private def processNode(JsonNode jsonNode) {
        types.collect { type -> processType(type, jsonNode) }
    }

    private def processType(String type, JsonNode jsonNode) {
        JsonNode node = jsonNode.get(type)
        generatePatternValues(node)
        mapper.convertValue(node, clazz)
    }

    private void generatePatternValues(JsonNode jsonNode) {
        jsonNode.findAll { it.asText().startsWith("\$") }
                .each { generateValue(it as JsonNode) }
    }

    private def generateValue(JsonNode valueNode) {
        if (toGenerate(valueNode.asText())) {
            def value = ValueGenerator.generate(valueNode.asText())
            Final.set("_value", value, valueNode)
        }
    }

    boolean toGenerate(String value) {
        return value.matches("\\\$\\w+(\\(.+\\))?\$")
    }
}