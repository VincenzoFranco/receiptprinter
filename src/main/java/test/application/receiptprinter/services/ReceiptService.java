package test.application.receiptprinter.services;

import test.application.receiptprinter.dto.ReceiptDTO;
import test.application.receiptprinter.models.Cart;

public interface ReceiptService {
    ReceiptDTO getReceipt(Cart cart);
}