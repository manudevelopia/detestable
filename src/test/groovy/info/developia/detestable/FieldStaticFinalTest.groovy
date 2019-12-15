package info.developia.detestable


import info.developia.detestable.fixtures.Constants
import info.developia.detestable.fixtures.User
import spock.lang.Specification

class FieldStaticFinalTest extends Specification {

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

}
