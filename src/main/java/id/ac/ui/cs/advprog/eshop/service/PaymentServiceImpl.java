package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderService orderService;

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        String paymentId = generateUniquePaymentId();

        Payment payment = new Payment(paymentId, order, method, paymentData);
        paymentRepository.save(payment);

        return payment;
    }


    private String generateUniquePaymentId() {
        return "PAYMENT_" + System.currentTimeMillis();
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        payment.setStatus(status);

        if(status.equals("SUCCESS")){
            orderService.updateStatus(payment.getId(), "SUCCESS");

        } else if (status.equals("REJECTED")) {
            orderService.updateStatus(payment.getId(), "FAILED");
        }


        return payment;
    }


    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        Iterator<Payment> productIterator = paymentRepository.findAll();
        List<Payment> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return  allProduct;
    }
}