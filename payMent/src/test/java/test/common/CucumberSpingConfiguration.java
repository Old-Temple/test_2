package test.common;


import test.PayMentApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PayMentApplication.class })
public class CucumberSpingConfiguration {
    
}
