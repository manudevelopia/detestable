package info.developia.detesstable.fixtures

class User {
    static final String nameStaticFinal =  Constants.OLD_NAME
    static final Integer ageStaticFinal = Constants.OLD_AGE
    final String nameFinal = Constants.OLD_NAME
    final Integer ageFinal = Constants.OLD_AGE

    final List<Book> booksFinal = [ new Book()]
    static final List<Book> booksStaticFinal = [ new Book()]

    private int saySomething(){
        return 33
    }

    private String saySomething(String one, String two){
        return one + two
    }
}
