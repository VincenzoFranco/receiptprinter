package test.application.receiptprinter.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartEntry> entries = new ArrayList<>();

    public void addProduct(Product product) {
        CartEntry entry = getEntryForProduct(product);
        if (entry != null) {
            entry.incrementQuantity();
        } else {
            entry = new CartEntry(product, 1);
            entries.add(entry);
        }
    }

    public List<CartEntry> getEntries() {
        return new ArrayList<>(entries);
    }

    private CartEntry getEntryForProduct(Product product) {
        for (CartEntry entry : entries) {
            if (product.equals(entry.getProduct())) {
                return entry;
            }
        }
        return null;
    }
}