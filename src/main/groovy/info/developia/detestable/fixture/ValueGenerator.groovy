package info.developia.detestable.fixture

class ValueGenerator {
    private static final String pkg = "info.developia.detestable.fixture.generator."

    static def generate(String valueNode) {
        String generatorName = readGeneratorName(valueNode)
        String args = readArgs(valueNode)
        def value = Class.forName(pkg + generatorName).newInstance().generate(args)
        return value
    }

    static def readArgs(String args) {
        args.replaceAll("(\\\$\\w+\\(){1}|(\\)){1}", "")
    }

    static String readGeneratorName(String generatorName) {
        generatorName.replaceAll("^(\\\$)|\\(.+\\)\$", "").capitalize()
    }
}
