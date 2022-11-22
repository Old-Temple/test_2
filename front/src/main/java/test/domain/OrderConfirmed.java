package test.domain;

import test.domain.*;
import test.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderConfirmed extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long customerId;
    private String customerAddress;
    private Integer price;
    private Long shopId;

    public OrderConfirmed(Order aggregate){
        super(aggregate);
    }
    public OrderConfirmed(){
        super();
    }
}
