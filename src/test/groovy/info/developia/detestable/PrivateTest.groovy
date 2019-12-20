package info.developia.detestable

import info.developia.detestable.field.Private
import info.developia.detestable.fixtures.Constants
import info.developia.detestable.fixtures.User
import spock.lang.Specification

class PrivateTest extends Specification{

    def "Private field should be changed"(){
        given:
        User user = new User()
        assert user.namePrivate == Constants.OLD_NAME

        when:
        Detestable.setPrivate("namePrivate", Constants.NEW_NAME, user)

        then:
        assert user.namePrivate == Constants.NEW_NAME
    }

}
