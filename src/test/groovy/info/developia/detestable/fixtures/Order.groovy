package info.developia.detestable.fixtures

import java.time.LocalDate

class Order {

    String orderNo;
    LocalDate date;
    String customerName;
    List<OrderLine> orderLines;

}