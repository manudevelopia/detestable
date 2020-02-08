package info.developia.detestable.fixture

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import info.developia.detestable.field.Final

class Fixture {

    private ObjectMapper mapper
    private Class clazz
    private Set<String> types = []
    private String filename

    static def of(Class clazz) {
        return new Fixture(clazz: clazz, filename: "src/test/resources/Orders.yml")
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
        JsonNode nodes = readNodes()
        return process(nodes)
    }

    private def readNodes() {
        mapper = new ObjectMapper(new YAMLFactory())
        mapper.findAndRegisterModules()
        return mapper.readTree(new File(filename))
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
        types.stream()
                .map { type -> processType(type, jsonNode) }
                .toList()
    }

    private def processType(String type, JsonNode jsonNode) {
        JsonNode node = jsonNode.get(type)
        processValues(node)
        mapper.convertValue(node, clazz)
    }

    private void processValues(JsonNode jsonNode) {
        jsonNode.each {
            n -> n.isValueNode() ? processValue(n) : processValues(n)
        }

    }

    private def processValue(JsonNode value) {
        if (value.asText() == '$number') {
            Final.set("_value", "919191", value)
        }
    }
}