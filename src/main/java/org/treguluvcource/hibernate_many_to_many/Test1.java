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

            session.beginTransaction();
            session.save(section1);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.save(child1);
            session.save(child2);
            session.save(child3);


            session.getTransaction().commit();
            System.out.println("Done!");
//********************************************************

//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Igor", 10);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//********************************************************
//
//
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 7);
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//********************************************************
            //

//
//            session.beginTransaction();
//            Section section = session.get(Section.class, 2);
//
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//********************************************************
        }
    }
}
