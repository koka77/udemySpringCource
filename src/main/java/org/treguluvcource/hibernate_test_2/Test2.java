package org.treguluvcource.hibernate_test_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.treguluvcource.hibernate_test_2.entity.Detail;
import org.treguluvcource.hibernate_test_2.entity.Employee;

public class Test2 {
    public static void main(String[] args) {


        try (SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                addAnnotatedClass(Detail.class).
                buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            Employee employee = new Employee("Nikola", "Ivanov",
                    "HR", 850);
            Detail detail = new Detail("New-York", "+0000000000", "nikola@mail.com");

            // ВАЖНО!!! чтобы прописался detail_id нуно работнику добавить детали так же как деталям работника!
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();

            session.save(detail);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
    }
}
