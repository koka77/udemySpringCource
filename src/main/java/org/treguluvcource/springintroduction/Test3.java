package org.treguluvcource.springintroduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Pet pet = new Cat();
//        Pet pet= context.getBean("myPet", Pet.class);

        Person person = context.getBean("myPerson", Person.class);
        System.out.println("person.getSurname() = " + person.getSurname());
        System.out.println("person.getAge() = " + person.getAge());

        context.close();
    }
}
