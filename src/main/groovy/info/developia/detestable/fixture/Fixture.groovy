package info.developia.detestable.fixture

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory

class Fixture {

    private ObjectMapper mapper
    private Class clazz
    private Set<String> types = []
    private JsonNode nodes

    Fixture(Class clazz) {
        this.clazz = clazz
        initMapper()
    }

    static def of(Class clazz) {
        return new Fixture(clazz)
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
        return process(nodes)
    }

    private void initMapper() {
        mapper = new ObjectMapper(new YAMLFactory())
        mapper.findAndRegisterModules()
        nodes = mapper.readTree(new File("src/test/resources/Orders.yml"))
    }

    private def process(JsonNode node) {
        return types.stream()
                .map { type -> mapper.convertValue(node.get(type), clazz) }
                .toList()
    }
}
