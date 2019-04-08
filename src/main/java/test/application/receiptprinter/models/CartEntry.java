package test.application.receiptprinter.models;

public class CartEntry {
    private Product product;
    private int quantity;

    CartEntry(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    void incrementQuantity() {
        this.quantity++;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}