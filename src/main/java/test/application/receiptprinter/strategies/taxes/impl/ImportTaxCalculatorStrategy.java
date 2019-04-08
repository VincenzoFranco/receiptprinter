package test.application.receiptprinter.strategies.taxes.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import test.application.receiptprinter.models.Product;
import test.application.receiptprinter.strategies.taxes.TaxCalculatorStrategy;

import java.math.BigDecimal;

@Service
@Qualifier("importTaxCalculatorStrategy")
public class ImportTaxCalculatorStrategy implements TaxCalculatorStrategy {

    private double percentage = 5;

    @Override
    public BigDecimal calculateTax(Product product) {
        if (product.isImported()) {
            return BigDecimal.valueOf(percentage).multiply(product.getPrice()).divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_EVEN);
        }
        return BigDecimal.ZERO;
    }
}