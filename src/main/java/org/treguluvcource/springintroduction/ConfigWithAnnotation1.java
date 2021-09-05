package org.treguluvcource.springintroduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotation1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Person person = context.getBean("personBean", Person.class);
        person.calYourPet();

        System.out.println("person.getSurname() = " + person.getSurname());
        System.out.println("person.getAge() = " + person.getAge());


//        Cat myCat = context.getBean("cat", Cat.class);
//        myCat.say();

        context.close();
    }
}
