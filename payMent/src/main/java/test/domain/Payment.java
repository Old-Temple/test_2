package test.domain;

import test.domain.PayCancled;
import test.PayMentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Payment_table")
@Data

public class Payment  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private Long shopId;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private Boolean status;

    @PostPersist
    public void onPostPersist(){


        PayCancled payCancled = new PayCancled(this);
        payCancled.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PayMentApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }



    public void pay(){
        Paid paid = new Paid(this);
        paid.publishAfterCommit();

    }



}
