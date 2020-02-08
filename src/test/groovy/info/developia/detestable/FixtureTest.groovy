package info.developia.detestable


import info.developia.detestable.fixture.Fixture
import info.developia.detestable.fixtures.Order
import spock.lang.Specification

import java.time.LocalDate

class FixtureTest extends Specification {

    def "should return can be initialized from yaml"() {
        given:

        LocalDate expectedDate = LocalDate.of(2019, 04, 17)

        when:
        Order order = Fixture.of(Order)
                .type("default")
                .build()[0] as Order

        then:
        with(order) {
            orderNo == "919191"
            date == LocalDate.of(2019, 04, 17)
            customerName == "Customer, Joe"
        }
    }

    def "should return a collection of fixtures"() {
        given:
        LocalDate expectedDate = LocalDate.of(2019, 04, 17)

        when:
        List<Order> orders = Fixture.of(Order)
                .types(["default", "error", "valid", "invalid"] as Set<String>)
                .build()

        then:
        orders.size() == 4
        with(orders[3]) {
            orderNo == "A004"
            date == LocalDate.of(2019, 10, 13)
            customerName == "Customer, Joe"
        }
    }
}
