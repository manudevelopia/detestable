package info.developia.detestable

import info.developia.detestable.fixtures.Book
import info.developia.detestable.fixtures.Constants
import info.developia.detestable.fixtures.User
import spock.lang.Specification

class MethodPrivateTest extends Specification {

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

    def "A return value should be retrieved after private static method is called with args"() {
        given:
        User user = new User()
        Book book = new Book()

        when:
        def result = Detestable.callPrivate("readBookStatic", user, book)

        then:
        result == "I'm Manuel, and I'm reading static 1984 which has 275 pages"
    }
}
