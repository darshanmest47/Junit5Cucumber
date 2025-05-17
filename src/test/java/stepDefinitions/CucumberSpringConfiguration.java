package stepDefinitions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
    public class CucumberSpringConfiguration {
        // You can leave this class empty or add other Spring-related configurations
    }

