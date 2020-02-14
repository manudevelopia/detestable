package info.developia.detestable.fixture.generator

class Text implements Generator {

    @Override
    def generate(args) {
        return "Word"
    }

    @Override
    def parse(args) {
        return null
    }
}
