package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    @Mock
    OrderService orderService;

    OrderRepository orderRepository;
    List<Order> orders;


    List<Payment> payments;

    private Order mockOrder;
    private Map<String, String> mockPaymentData;

    @BeforeEach
    void setUp() {

        mockPaymentData = new HashMap<>();
        mockPaymentData.put("key1", "value1");
        mockPaymentData.put("key2", "value2");

        orderRepository = new OrderRepository();
        payments = new ArrayList<>();  // Inisialisasi list payments

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        orders = new ArrayList<>();
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");
        orders.add(order1);

        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("key", "value");

        Payment payment1 = new Payment("123-qweasd-zxczxc", order1, "methode", "SUCCESS", paymentData);
        Payment payment2 = new Payment("345-ert-dfg-cvbcvb", order1, "methode", "FAILED", paymentData);

        payments.add(payment1);
        payments.add(payment2);

        // Inisialisasi paymentRepository dan setPaymentData
        paymentRepository = new PaymentRepository();
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);
    }

    @Test
    void testAddPayment() {
        Order order = orders.get(0);

        Payment payment = payments.get(0);
        doReturn(payment).when(paymentRepository).save(payment);

        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("key", "value");

        Payment result = paymentService.addPayment(order,"CREDIT", paymentData) ;
        verify(paymentRepository, times(1)).save(payment);
        assertEquals(payment.getId(), result.getId());
    }
    @Test
    void testSetStatusSuccess() {
        // Arrange
        Payment payment = payments.get(0);
        String newStatus = "SUCCESS";

        // Act
        Payment updatedPayment = paymentService.setStatus(payment, newStatus);

        // Assert
        assertEquals(newStatus, updatedPayment.getStatus());
        verify(orderService, times(1)).updateStatus(payment.getId(), newStatus);
    }

    @Test
    void testSetStatusRejected() {
        // Arrange
        Payment payment = payments.get(0);
        String newStatus = "REJECTED";

        // Act
        Payment updatedPayment = paymentService.setStatus(payment, newStatus);

        // Assert
        assertEquals(newStatus, updatedPayment.getStatus());
        verify(orderService, times(1)).updateStatus(payment.getId(), newStatus);
    }

    @Test
    public void testGetAllPayments() {
        // Arrange (already set up in @BeforeEach)

        // Act
        List<Payment> allPayments = paymentService.getAllPayments();

        // Assert
        assertEquals(payments.size(), allPayments.size());
        for (int i = 0; i < payments.size(); i++) {
            assertEquals(payments.get(i).getId(), allPayments.get(i).getId());
        }
    }

    @Test
    public void testGetPaymentExisting() {
        // Arrange
        String existingPaymentId = payments.get(0).getId();

        // Act
        Payment retrievedPayment = paymentService.getPayment(existingPaymentId);

        // Assert
        assertNotNull(retrievedPayment);
        assertEquals(existingPaymentId, retrievedPayment.getId());
    }

    @Test
    public void testGetPaymentNonexistent() {
        // Arrange
        String nonexistentId = "non-existent-id";

        // Act
        Payment retrievedPayment = paymentService.getPayment(nonexistentId);

        // Assert
        assertNull(retrievedPayment);
    }








}

