package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {

    SUCCESS("SUCCESS"),

    WAITING_PAID("WAITING_PAID"),
    REJECTED("REJECTED");



    private final String value;

    private PaymentStatus(String value){
        this.value = value;
    }


    public static boolean contains(String param){
        for (PaymentStatus payementStatus:PaymentStatus.values()){
            if(payementStatus.name().equals(param)){
                return true;
            }
        }
        return false;
    }

}
