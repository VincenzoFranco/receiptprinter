package test.application.receiptprinter.services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import test.application.receiptprinter.dto.ReceiptDTO;
import test.application.receiptprinter.dto.ReceiptLineDTO;
import test.application.receiptprinter.models.Cart;
import test.application.receiptprinter.models.CartEntry;
import test.application.receiptprinter.models.Product;
import test.application.receiptprinter.services.ReceiptService;
import test.application.receiptprinter.services.TaxService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("receiptService")
public class DefaultReceiptService implements ReceiptService {

    private static final BigDecimal ROUND_VALUE = BigDecimal.valueOf(0.05);

    @Resource
    private TaxService taxService;

    @Override
    public ReceiptDTO getReceipt(Cart cart) {
        BigDecimal totalGross = BigDecimal.ZERO;
        BigDecimal totalTax = BigDecimal.ZERO;

        ReceiptDTO receipt = new ReceiptDTO();
        List<ReceiptLineDTO> receiptLines = new ArrayList<>();
        for (CartEntry entry : cart.getEntries()) {
            Product product = entry.getProduct();
            BigDecimal unitPrice = product.getPrice();
            BigDecimal unitTax = taxService.calculateTaxes(product);
            BigDecimal bdQuantity = BigDecimal.valueOf(entry.getQuantity());
            BigDecimal entryPrice = unitPrice.multiply(bdQuantity);
            BigDecimal entryTax = unitTax.multiply(bdQuantity);

            ReceiptLineDTO receiptLineDTO = new ReceiptLineDTO();
            receiptLineDTO.setProductName(product.getName());
            receiptLineDTO.setQuantity(entry.getQuantity());
            receiptLineDTO.setUnitPrice(unitPrice.add(unitTax).doubleValue());
            receiptLineDTO.setTotalPrice(entryPrice.add(entryTax).doubleValue());
            receiptLines.add(receiptLineDTO);

            totalGross = totalGross.add(entryPrice);
            totalTax = totalTax.add(entryTax);
        }

        BigDecimal totalPrice = totalGross.add(totalTax);
        BigDecimal totalPriceRounded = totalPrice.divide(ROUND_VALUE, 0, BigDecimal.ROUND_HALF_EVEN).multiply(ROUND_VALUE);
        receipt.setTotalPrice(totalPriceRounded.doubleValue());
        receipt.setTotalRound(totalPrice.subtract(totalPriceRounded).doubleValue());
        receipt.setLines(receiptLines);

        return receipt;
    }
}