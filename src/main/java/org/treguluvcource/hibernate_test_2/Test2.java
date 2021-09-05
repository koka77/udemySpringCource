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

            session.beginTransaction();

//            получение по id
            Detail detail = session.get(Detail.class, 1);

//            чтобы разрушить связь roreign key нужно прописать нуль
            detail.getEmployee().setEmpDetail(null);

//            удаление
            session.delete(detail);

            System.out.println(detail.getEmployee());

            session.getTransaction().commit();
            System.out.println("Done!");

        }
    }
}
