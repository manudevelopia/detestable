package info.developia.detestable.fixtures

import java.time.LocalDate

class Order {
    private String orderNo;
    private LocalDate date;
    private String customerName;
    private List<OrderLine> orderLines;

    String getOrderNo() {
        return orderNo
    }

    void setOrderNo(String orderNo) {
        this.orderNo = orderNo
    }

    LocalDate getDate() {
        return date
    }

    void setDate(LocalDate date) {
        this.date = date
    }

    String getCustomerName() {
        return customerName
    }

    void setCustomerName(String customerName) {
        this.customerName = customerName
    }

    List<OrderLine> getOrderLines() {
        return orderLines
    }

    void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines
    }
}