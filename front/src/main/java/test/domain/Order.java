package test.domain;

import test.domain.OrderCancled;
import test.domain.OrderChecked;
import test.domain.OrderConfirmed;
import test.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private String customerAddress;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private Long shopId;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        test.external.Payment payment = new test.external.Payment();
        // mappings goes here
        FrontApplication.applicationContext.getBean(test.external.PaymentService.class)
            .payCancle(payment);


        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();



        OrderChecked orderChecked = new OrderChecked(this);
        orderChecked.publishAfterCommit();



        OrderConfirmed orderConfirmed = new OrderConfirmed(this);
        orderConfirmed.publishAfterCommit();

        // Get request from Payment
        //test.external.Payment payment =
        //    Application.applicationContext.getBean(test.external.PaymentService.class)
        //    .getPayment(/** mapping value needed */);

        // Get request from ShopOrder
        //test.external.ShopOrder shopOrder =
        //    Application.applicationContext.getBean(test.external.ShopOrderService.class)
        //    .getShopOrder(/** mapping value needed */);

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }



    public void order(){
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        test.external.Payment payment = new test.external.Payment();
        // mappings goes here
        FrontApplication.applicationContext.getBean(test.external.PaymentService.class)
            .pay(payment);

    }

    public static void updateStatus(AcceptOrder acceptOrder){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(acceptOrder.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(RejectOrder rejectOrder){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejectOrder.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(DeliveryStarted deliveryStarted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(OrderConfirmed orderConfirmed){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderConfirmed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
