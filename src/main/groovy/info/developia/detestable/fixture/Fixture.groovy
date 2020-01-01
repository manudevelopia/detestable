package info.developia.detestable.fixture

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory

class Fixture {

    static final path = "src/test/resources"
    Class clazz

    static def builder(Class clazz) {
        // TODO: getName() returns qualified name, maybe can be used as path for yaml
        String className = clazz.getSimpleName()
        def mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules()
        return mapper.readValue(new File("$path/$className" + ".yml"), clazz)
    }

    static def of(Class clazz) {
        return new Fixture(clazz: clazz)
    }

    def build() {
        // TODO: getName() returns qualified name, maybe can be used as path for yaml
        String className = clazz.getSimpleName()
        def mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules()
        return mapper.readValue(new File("$path/$className" + ".yml"), clazz)
    }

}
