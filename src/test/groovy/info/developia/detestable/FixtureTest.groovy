package info.developia.detestable

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import info.developia.detestable.fixtures.Order
import spock.lang.Specification

import java.time.LocalDate

class FixtureTest extends Specification {

    def "Object can be initialized from yaml"() {
        given:
        def mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules()

        when:
        Order order = mapper.readValue(new File("src/test/resources/Order.yml"), Order)

        then:
        with(order) {
            orderNo: "A001"
            date:
            LocalDate.of(2019, 04, 17)
            customerName: "Customer, Joe"
        }
    }
}
