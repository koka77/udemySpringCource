package org.treguluvcource.hibernate_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.treguluvcource.hibernate_many_to_many.entity.Child;
import org.treguluvcource.hibernate_many_to_many.entity.Section;

public class Test1 {
    public static void main(String[] args) {
        try (
                SessionFactory factory = new Configuration().
                        configure("hibernate.cfg.xml").
                        addAnnotatedClass(Child.class).
                        addAnnotatedClass(Section.class).
                        buildSessionFactory();
                Session session = factory.getCurrentSession()) {


            Section section1 = new Section("Football");
            Child child1 = new Child("Alex", 5);
            Child child2 = new Child("Masha", 7);
            Child child3 = new Child("Vasya", 6);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.save(section1);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
    }
}
