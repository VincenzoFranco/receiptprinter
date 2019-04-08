package test.application.receiptprinter.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.application.receiptprinter.models.Product;
import test.application.receiptprinter.services.TaxService;
import test.application.receiptprinter.strategies.taxes.TaxCalculatorStrategy;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DefaultTaxService implements TaxService {

    @Autowired
    private List<TaxCalculatorStrategy> strategies;

    @Override
    public BigDecimal calculateTaxes(Product product) {
        BigDecimal taxes = BigDecimal.ZERO;

        for (TaxCalculatorStrategy strategy : strategies) {
            taxes = taxes.add(strategy.calculateTax(product));
        }

        return taxes;
    }
}