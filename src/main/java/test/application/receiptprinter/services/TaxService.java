package test.application.receiptprinter.services;


import test.application.receiptprinter.models.Product;

import java.math.BigDecimal;

public interface TaxService {
    BigDecimal calculateTaxes(Product product);
}