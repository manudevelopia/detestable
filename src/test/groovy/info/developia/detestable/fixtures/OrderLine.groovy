package info.developia.detestable.fixtures

class OrderLine {
    private String item;
    private int quantity;
    private BigDecimal unitPrice;

    String getItem() {
        return item
    }

    void setItem(String item) {
        this.item = item
    }

    int getQuantity() {
        return quantity
    }

    void setQuantity(int quantity) {
        this.quantity = quantity
    }

    BigDecimal getUnitPrice() {
        return unitPrice
    }

    void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice
    }
}
