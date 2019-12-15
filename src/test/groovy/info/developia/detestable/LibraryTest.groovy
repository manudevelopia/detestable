package info.developia.detestable

import info.developia.detestable.fixtures.Book
import info.developia.detestable.fixtures.Constants
import info.developia.detestable.fixtures.User
import spock.lang.Specification

class LibraryTest extends Specification {

    def "Set Integer ageStaticFinal"() {
        given:
        User user = new User()
        assert user.ageStaticFinal == Constants.OLD_AGE
        assert user.getAgeFinal() == Constants.OLD_AGE

        when:
        StaticFinal.set("ageStaticFinal", Constants.NEW_AGE, user)

        then:
        user.ageStaticFinal == Constants.NEW_AGE
        user.getAgeStaticFinal() == Constants.NEW_AGE
    }

    def "set String nameStaticFinal"() {
        given:
        def user = new User()
        assert user.nameStaticFinal == Constants.OLD_NAME
        assert user.getNameStaticFinal() == Constants.OLD_NAME

        when:
        StaticFinal.set("nameStaticFinal", Constants.NEW_NAME, user)

        then:
        user.nameStaticFinal == Constants.NEW_NAME
        user.getNameStaticFinal() == Constants.NEW_NAME
    }

    def "Set Integer"() {
        given:
        User user = new User()
        assert user.ageFinal == Constants.OLD_AGE
        assert user.getAgeFinal() == Constants.OLD_AGE

        when:
        FinalField.set("ageFinal", Constants.NEW_AGE, user)

        then:
        user.ageFinal == Constants.NEW_AGE
        user.getAgeFinal() == Constants.NEW_AGE
    }

    def "Set String"() {
        given:
        User user = new User()
        assert user.nameFinal == Constants.OLD_NAME
        assert user.getNameFinal() == Constants.OLD_NAME

        when:
        FinalField.set("nameFinal", Constants.NEW_NAME, user)

        then:
        user.nameFinal == Constants.NEW_NAME
        user.getNameFinal() == Constants.NEW_NAME
    }

    def "Custom field"() {
        given:
        User user = new User()
        List<Book> newBooks = [new Book(), new Book(), new Book()]
        assert user.getBooksFinal().size() == 1

        when:
        FinalField.set("booksFinal", newBooks, user)

        then:
        user.getBooksFinal().size() == newBooks.size()
    }

    def "Execute method"() {
        given:
        User user = new User()

        when:
        def result = PrivateMethod.call("sayMyAge", user)

        then:
        result == Constants.OLD_AGE
    }


    def "Execute method with args"() {
        given:
        User user = new User()
        Book book = new Book()

        when:
        def result = PrivateMethod.call("readBook", user, book)

        then:
        result == "I'm Manuel, and I'm reading 1984 which has 275 pages"
    }
}
