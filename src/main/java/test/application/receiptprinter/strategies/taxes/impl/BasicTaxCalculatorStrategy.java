package test.application.receiptprinter.strategies.taxes.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import test.application.receiptprinter.models.Product;
import test.application.receiptprinter.models.ProductType;
import test.application.receiptprinter.strategies.taxes.TaxCalculatorStrategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
@Qualifier("basicTaxCalculatorStrategy")
public class BasicTaxCalculatorStrategy implements TaxCalculatorStrategy {

    private List<ProductType> exludedProductTypes = Arrays.asList(ProductType.BOOK, ProductType.FOOD, ProductType.MEDICAL);
    private int percentage = 10;

    @Override
    public BigDecimal calculateTax(Product product) {
        if (exludedProductTypes.contains(product.getProductType())) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(percentage).multiply(product.getPrice()).divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_EVEN);
    }
}