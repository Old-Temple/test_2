package test.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "payMent", url = "${api.url.payMent}")
public interface PaymentService {
    @RequestMapping(method= RequestMethod.PUT, path="/payments/{id}/pay")
    public void pay(@PathVariable("id") Long id);
}

