package test.domain;

import test.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class AcceptOrder extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Integer price;
    private String status;
}
