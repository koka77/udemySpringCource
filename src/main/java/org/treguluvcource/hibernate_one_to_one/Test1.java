package org.treguluvcource.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.treguluvcource.hibernate_one_to_one.entity.Detail;
import org.treguluvcource.hibernate_one_to_one.entity.Employee;

public class Test1 {
    public static void main(String[] args) {


        try (SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                addAnnotatedClass(Detail.class).
                buildSessionFactory();
             Session session = factory.getCurrentSession()) {
//            Employee employee = new Employee("Alex", "Somov", "IT", 500);
//            Detail detail = new Detail("Moscow", "+71234567", "mail@mail.com");
//
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            Employee employee = new Employee("Oleg", "Smirnov", "Saleas", 700);
//            Detail detail = new Detail("Sarov", "+7123-123", "mail.oleg@mail.com");
//
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            session.beginTransaction();

            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
    }
}
