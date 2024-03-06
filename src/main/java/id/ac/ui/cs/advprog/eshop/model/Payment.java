package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Payment {
    private String id;
    private String method; // Perbaiki typo: ganti 'methode' menjadi 'method'
    private String status;
    private Map<String, String> paymentData;
    private Order order;

    public Payment(String id,Order order, String method, String status, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.status = status;
        this.order = order;

        if (paymentData == null || paymentData.isEmpty()) {
            throw new IllegalArgumentException("Data pembayaran harus disediakan.");
        } else {
            this.paymentData = paymentData;
        }
    }

    public Payment(String id, Order order, String method,  Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.order = order;
        this.status = "WAITING_PAID";

        if (paymentData == null || paymentData.isEmpty()) {
            throw new IllegalArgumentException("Data pembayaran harus disediakan.");
        } else {
            this.paymentData = paymentData;
        }
    }


    public Payment() {

    }
}
