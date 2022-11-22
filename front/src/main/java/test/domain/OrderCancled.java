package test.domain;

import test.domain.*;
import test.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long customerId;
    private Integer price;

    public OrderCancled(Order aggregate){
        super(aggregate);
    }
    public OrderCancled(){
        super();
    }
}
