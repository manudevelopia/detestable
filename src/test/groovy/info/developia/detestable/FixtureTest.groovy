package info.developia.detestable


import info.developia.detestable.fixture.Fixture
import info.developia.detestable.fixtures.Order
import spock.lang.Specification

import java.time.LocalDate

class FixtureTest extends Specification {

    def "Object can be initialized from yaml"() {
        given:
        String className = "Order"

        when:
        Order order = Fixture.builder(Order)
        def fixture = Fixture.of(Order).build()

        then:
        with(order) {
            orderNo: "A001"
            date:
            LocalDate.of(2019, 04, 17)
            customerName: "Customer, Joe"
        }
    }
}
