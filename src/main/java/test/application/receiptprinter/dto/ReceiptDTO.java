package test.application.receiptprinter.dto;

import java.util.List;

public class ReceiptDTO {
    private double totalRound;
    private double totalPrice;
    private List<ReceiptLineDTO> lines;

    public double getTotalRound() {
        return totalRound;
    }

    public void setTotalRound(double totalRound) {
        this.totalRound = totalRound;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ReceiptLineDTO> getLines() {
        return lines;
    }

    public void setLines(List<ReceiptLineDTO> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("*************************\n");
        for (ReceiptLineDTO line : lines) {
            builder.append(line).append("\n");
        }
        builder.append("Total Price: ").append(totalPrice).append("\n");
        builder.append("Total Round: ").append(totalRound).append("\n");
        builder.append("*************************\n");
        return builder.toString();
    }
}