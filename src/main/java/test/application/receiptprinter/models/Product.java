package test.application.receiptprinter.models;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private boolean imported;

    public Product(String name, BigDecimal price, ProductType productType, boolean imported) {
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.imported = imported;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public boolean isImported() {
        return imported;
    }
}