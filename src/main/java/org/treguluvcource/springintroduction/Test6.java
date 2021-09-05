package org.treguluvcource.springintroduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

//        Pet cat1 = context.getBean("catBean", Pet.class);
//        Pet cat2 = context.getBean("catBean", Pet.class);

        Person person = context.getBean("personBean", Person.class);
        System.out.println("person.getSurname() = " + person.getSurname());
        System.out.println("person.getAge() = " + person.getAge());
//        Person person2 = context.getBean("personBean", Person.class);
        person.calYourPet();
    }
}
