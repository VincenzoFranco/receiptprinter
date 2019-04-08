package test.application.receiptprinter.strategies.taxes;

import test.application.receiptprinter.models.Product;

import java.math.BigDecimal;

public interface TaxCalculatorStrategy {

    BigDecimal calculateTax(Product product);

}