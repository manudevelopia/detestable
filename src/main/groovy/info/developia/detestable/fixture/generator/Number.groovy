package info.developia.detestable.fixture.generator

class Number implements Generator {

    @Override
    def generate(args) {
        parse(args)
        return "919191"
    }

    @Override
    def parse(args) {
        args.split("\\,")
    }
}
