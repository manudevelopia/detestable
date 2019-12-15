package info.developia.detesstable

import info.developia.detesstable.fixtures.Book
import info.developia.detesstable.fixtures.Constants
import info.developia.detesstable.fixtures.User
import spock.lang.Specification

import java.lang.reflect.Field
import java.lang.reflect.Modifier

class LibraryTest extends Specification {

    def "Set Integer ageStaticFinal"() {
        given:
        User user = new User()
        assert user.ageStaticFinal == Constants.OLD_AGE
        assert user.getAgeFinal() == Constants.OLD_AGE

        when:
        Library.set("ageStaticFinal", Constants.NEW_AGE, user as Class<?>)

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
        Library.set("nameStaticFinal", Constants.NEW_NAME, user)

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
        Library.setNonStatic("ageFinal", Constants.NEW_AGE, user)

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
        Library.setNonStatic("nameFinal", Constants.NEW_NAME, user)

        then:
        user.nameFinal == Constants.NEW_NAME
        user.getNameFinal() == Constants.NEW_NAME
    }

    def "Custom field"() {
        given:
        User user = new User()
        assert user.getBooksFinal().size() == 1

        when:
        Library.setNonStatic("booksFinal", [new Book(), new Book(), new Book()], user)

        then:
        user.getBooksFinal().size() == 3
    }

    def "Execute method"() {
        given:
        User user = new User()

        when:
        def result = Library.callMethod("saySomething", user)

        then:
        result == 33
    }


    def "Execute method with args"() {
        given:
        User user = new User()

        when:
        def result = Library.callMethod("saySomething", user, "one ", "two ")

        then:
        result == "one two "
    }
}
