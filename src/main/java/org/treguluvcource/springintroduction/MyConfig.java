package org.treguluvcource.springintroduction;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.treguluvcource.springintroduction")
@PropertySource("classpath:myApp.properties")
public class MyConfig {

    @Bean
    @Scope("prototype")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
//    @Scope("prototype")
    public Person personBean() {
        return new Person(catBean());
    }
}
