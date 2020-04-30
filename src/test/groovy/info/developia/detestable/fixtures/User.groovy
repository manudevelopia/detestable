package info.developia.detestable.fixtures

class User {

    static final String nameStaticFinal = Constants.OLD_NAME
    static final Integer ageStaticFinal = Constants.OLD_AGE

    final String nameFinal = Constants.OLD_NAME
    final Integer ageFinal = Constants.OLD_AGE

    private String namePrivate = Constants.OLD_NAME
    private Integer agePrivate = Constants.OLD_AGE

    final List<Book> booksFinal = [new Book()]

    private int sayMyAge() {
        return Constants.OLD_AGE
    }

    private String readBook(Book book) {
        return "I'm $Constants.OLD_NAME, and I'm reading $book.titleFinal which has $book.pagesFinal pages"
    }

    private static String readBookStatic(Book book) {
        return "I'm $Constants.OLD_NAME, and I'm reading static $book.titleFinal which has $book.pagesFinal pages"
    }
}
