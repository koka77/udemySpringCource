package org.treguluvcource.hibernate_test_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.treguluvcource.hibernate_test_2.entity.Detail;
import org.treguluvcource.hibernate_test_2.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                addAnnotatedClass(Detail.class).
                buildSessionFactory();

        try (Session session = factory.getCurrentSession()){
            Employee employee = new Employee("Alex", "Somov", "IT", 500);
            Detail detail = new Detail("Moscow", "+71234567", "mail@mail.com");

            employee.setEmpDetail(detail);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
