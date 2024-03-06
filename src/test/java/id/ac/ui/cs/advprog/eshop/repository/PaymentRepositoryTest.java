package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {

    OrderRepository orderRepository;
    List<Order> orders;
   PaymentRepository paymentRepository;

   List<Payment> payments;

    @BeforeEach
    void setUp() {
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
    void testSavePayment() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);
        orders = new ArrayList<>();
        Order order2 = new Order("13652999-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");
        orders.add(order2);

        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("key", "value");
        Payment payment = new Payment("567-rtyfgh-vbn",order2,
                "methode", "SUCCESS", paymentData );


        Payment savedPayment = paymentRepository.save(payment);

        assertNotNull(savedPayment);
        assertEquals("567-rtyfgh-vbn", savedPayment.getId());
    }

    @Test
    void testFindByIdIfIdFound(){
        for (Payment payment : payments){
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getOrder(), findResult.getOrder());
        assertEquals(payments.get(1).getMethod(), findResult.getMethod());
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
        assertEquals(payments.get(1).getPaymentData(), findResult.getPaymentData());
    }

    @Test
    void testFindByIdIfIdNotFound(){
        for (Payment payment : payments){
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("MKMK");
        assertNull(findResult);
    }



    @Test
    void testFindAllPayments() {
        // Assert
        Iterator<Payment> paymentIterator = paymentRepository.findAll();
        assertNotNull(paymentIterator);

        List<Payment> retrievedPayments = new ArrayList<>();
        paymentIterator.forEachRemaining(retrievedPayments::add);

        assertEquals(2, retrievedPayments.size());

    }


}
