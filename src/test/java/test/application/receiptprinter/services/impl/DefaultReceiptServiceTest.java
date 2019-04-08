package test.application.receiptprinter.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.application.receiptprinter.dto.ReceiptDTO;
import test.application.receiptprinter.models.Cart;
import test.application.receiptprinter.models.Product;
import test.application.receiptprinter.models.ProductType;
import test.application.receiptprinter.services.ReceiptService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultReceiptServiceTest {

    @Resource
    private ReceiptService receiptService;

    private Product book;
    private Product cd;
    private Product chocolate1;
    private Product chocolate2;
    private Product perfume;

    @Before
    public void setUp() throws Exception {
        book = createProduct("Book", 12.49d, ProductType.BOOK, false);
        cd = createProduct("Music CD", 14.99d, ProductType.GENERIC, false);
        chocolate1 = createProduct("Chocolate", 0.85, ProductType.FOOD, false);
        chocolate2 = createProduct("Chocolate", 10.00, ProductType.FOOD, true);
        perfume = createProduct("Perfume", 47.50, ProductType.GENERIC, true);
    }

    @Test
    public void test1() throws Exception {
        Cart cart = new Cart();
        cart.addProduct(book);
        cart.addProduct(cd);
        cart.addProduct(chocolate1);

        ReceiptDTO receiptDTO = receiptService.getReceipt(cart);
        System.out.println(receiptDTO.toString());
    }

    @Test
    public void test2() throws Exception {
        Cart cart = new Cart();
        cart.addProduct(chocolate2);
        cart.addProduct(chocolate2);
        cart.addProduct(perfume);

        ReceiptDTO receiptDTO = receiptService.getReceipt(cart);
        System.out.println(receiptDTO.toString());
    }

    private Product createProduct(String name, double price, ProductType type, boolean imported) {
        return new Product(name, BigDecimal.valueOf(price), type, imported);
    }
}