package info.developia.detestable

import info.developia.detestable.fixtures.Book
import info.developia.detestable.fixtures.Constants
import info.developia.detestable.fixtures.User
import spock.lang.Specification

class LibraryTest extends Specification {

    def "A new integer value should be set to static final field"() {
        given:
        User user = new User()
        assert user.ageStaticFinal == Constants.OLD_AGE
        assert user.getAgeFinal() == Constants.OLD_AGE

        when:
        Detestable.setStaticFinal("ageStaticFinal", Constants.NEW_AGE, user)

        then:
        user.ageStaticFinal == Constants.NEW_AGE
        user.getAgeStaticFinal() == Constants.NEW_AGE
    }

    def "A new string value should be set to static final field"() {
        given:
        def user = new User()
        assert user.nameStaticFinal == Constants.OLD_NAME
        assert user.getNameStaticFinal() == Constants.OLD_NAME

        when:
        Detestable.setStaticFinal("nameStaticFinal", Constants.NEW_NAME, user)

        then:
        user.nameStaticFinal == Constants.NEW_NAME
        user.getNameStaticFinal() == Constants.NEW_NAME
    }

    def "A new integer value should be set to final field"() {
        given:
        User user = new User()
        assert user.ageFinal == Constants.OLD_AGE
        assert user.getAgeFinal() == Constants.OLD_AGE

        when:
        Detestable.setFinal("ageFinal", Constants.NEW_AGE, user)

        then:
        user.ageFinal == Constants.NEW_AGE
        user.getAgeFinal() == Constants.NEW_AGE
    }

    def "A new string value should be set to final field"() {
        given:
        User user = new User()
        assert user.nameFinal == Constants.OLD_NAME
        assert user.getNameFinal() == Constants.OLD_NAME

        when:
        Detestable.setFinal("nameFinal", Constants.NEW_NAME, user)

        then:
        user.nameFinal == Constants.NEW_NAME
        user.getNameFinal() == Constants.NEW_NAME
    }

    def "A new custom object value should be set to final field"() {
        given:
        User user = new User()
        List<Book> newBooks = [new Book(), new Book(), new Book()]
        assert user.getBooksFinal().size() == 1

        when:
        Detestable.setFinal("booksFinal", newBooks, user)

        then:
        user.getBooksFinal().size() == newBooks.size()
    }

    def "A return value should be retrieved after private method is called"() {
        given:
        User user = new User()

        when:
        def result = Detestable.callPrivate("sayMyAge", user)

        then:
        result == Constants.OLD_AGE
    }


    def "A return value should be retrieved after private method is called with args"() {
        given:
        User user = new User()
        Book book = new Book()

        when:
        def result = Detestable.callPrivate("readBook", user, book)

        then:
        result == "I'm Manuel, and I'm reading 1984 which has 275 pages"
    }
}
