package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Created by jt on 2/20/21.
 */
@Configuration
public class GreetingServiceConfig {


    @Profile("EN")
    @Bean
    I18nEnglishGreetingService  i18nService(){
        return new I18nEnglishGreetingService();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")    // Para equivaler ao memso nome de beando seguinte
                            // By default spring uses the method name for the bean
                            // Unless you override it in the bean annotation
                            // and since you cannot have the same method declared twice in the same class
                            // we have to declare the name of the bean to use the same name
    I18NSpanishService i18NSpanishService() {
        return new I18NSpanishService();
    }


    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }


    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
