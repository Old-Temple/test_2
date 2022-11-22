package test.domain;

import test.domain.*;
import test.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PayCancled extends AbstractEvent {

    private Long id;
    private Integer price;
    private Long customerId;
    private Long shopId;
    private Long menuId;
    private Boolean status;

    public PayCancled(Payment aggregate){
        super(aggregate);
    }
    public PayCancled(){
        super();
    }
}
