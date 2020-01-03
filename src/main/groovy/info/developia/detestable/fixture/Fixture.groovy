package info.developia.detestable.fixture

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory

class Fixture {


    private Class clazz
    private Set<String> fixtureTypes = []

    static def of(Class clazz) {
        return new Fixture(clazz: clazz)
    }

    def type(String type) {
        fixtureTypes.add(type)
        return this
    }

    def types(Set<String> types) {
        this.fixtureTypes = types
        return this
    }

    def build() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules()
        return mapper.readValue(new File("src/test/resources/Order.yml"), clazz)
    }

}
