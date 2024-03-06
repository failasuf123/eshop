package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        this.product = new Product();
        this.product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(100);

    }

    @Test
    void testGetProductId() {
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", this.product.getProductId());
    }

    @Test
    void testGetProductName() {
        assertEquals("Sampo Cap Bambang", product.getProductName());
    }

    @Test
    public void testGetProductQuantity() {
        assertEquals(100, product.getProductQuantity());
    }
}

class OrderTest{
    private List<Product> products;

    @BeforeEach
    void setUp(){
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);

        this.products.add(product1);
        this.products.add(product2);
    }

    @Test
    void testCreateOrderEmptyProduct(){
        this.products.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                    this.products, 1708560000L, "Safira Sudrajat")
            ;
        });
    }

    @Test
    void testCreateOrderDefaultStatus() {
        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                this.products, 1708560000L, "Safira Sudrajat");
        assertSame(this.products, order.getProducts());
        assertEquals(2, order.getProducts().size());
        assertEquals("Sampo Cap Bambang", order.getProducts().get(0).getProductName());
        assertEquals("Sabun Cap Usep", order.getProducts().get(1).getProductName());

        assertEquals("13652556-012a-4c07-b546-54eb1396d79b",order.getId());
        assertEquals(1708560000L, order.getOrderTime());
        assertEquals("Safira Sudrajat", order.getAuthor());
        assertEquals("WAITING_PAYMENT", order.getStatus());

    }

    @Test
    void  testCreateOrderSuccessStatus() {
        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                this.products, 1708560000L, "Safira Sudrajat",
                OrderStatus.SUCCESS.getValue());
        assertEquals(OrderStatus.SUCCESS.getValue(), order.getStatus());

    }
    @Test
    void testCreateOrderInvalidStatus(){
        assertThrows(IllegalArgumentException.class, () -> {
            Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                    this.products, 1708560000L, "Safira Sudrajat", "MEOW");

        });
    }

    @Test
    void testSetStatusToCancelled() {
        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                this.products, 1708560000L, "Safira Sudrajat");
        order.setStatus("CANCELLED");
        assertEquals("CANCELLED", order.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus(){
        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                this.products, 1708560000L, "Safira Sudrajat");
        assertThrows(IllegalArgumentException.class, () -> order.setStatus("MEOW"));
    }

}



class PaymentTest {

    private List<Product> products;
    private Order order;

    @BeforeEach
    void setUp() {
        this.products = new ArrayList<>();
        Product product3 = new Product();
        product3.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product3.setProductName("Sampo Cap Bambang");
        product3.setProductQuantity(2);

        this.products.add(product3);
        this.order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                this.products, 1708560000L, "Safira Sudrajat");
    }

    @Test
    void testAddWithValidData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("key", "value");

        Payment payment = new Payment("123-qweasd-zxczxc", order, "method", paymentData);

        assertEquals("123-qweasd-zxczxc", payment.getId());
        assertEquals("method", payment.getMethod());
        assertEquals(order, payment.getOrder());
        assertEquals(paymentData, payment.getPaymentData());
    }

    @Test
    void testAddValidDataAndStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("key", "value");

        Payment payment = new Payment("123-qweasd-zxczxc", order,"method",
                "SUCCESS",  paymentData);

        assertEquals("123-qweasd-zxczxc", payment.getId());
        assertEquals("method", payment.getMethod());
        assertEquals(order, payment.getOrder());
        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());

    }

    @Test
    void testAddInvalidData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("paymentId", order, "", null);
        });
    }

    @Test
    void testInvalidStatus(){
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("key", "value");
        Payment payment = new Payment("123-qweasd-zxczxc", order,"method",
                "OKEGAS",  paymentData);

        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("OKEGAS"));
    }

    @Test
    void testSetMethod() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("key", "value");

        Payment payment = new Payment("paymentId", order, "method", paymentData);
        payment.setMethod("newMethod");

        assertEquals("newMethod", payment.getMethod());
    }
}



