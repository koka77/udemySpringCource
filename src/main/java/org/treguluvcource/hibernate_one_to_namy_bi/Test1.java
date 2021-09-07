package org.treguluvcource.hibernate_one_to_namy_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.treguluvcource.hibernate_one_to_namy_bi.entity.Department;
import org.treguluvcource.hibernate_one_to_namy_bi.entity.Employee;

public class Test1 {
    public static void main(String[] args) {


        try (SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                addAnnotatedClass(Department.class).
                buildSessionFactory();
             Session session = factory.getCurrentSession()) {

//            Department dep = new Department("Sales", 1500, 800);
//            Employee emp1 = new Employee("Alex", "Somov", 800);
//            Employee emp2 = new Employee("Helen", "Smirnova", 1500);
//            Employee emp3 = new Employee("Antony", "Sidorov", 1200);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//*********************************************

            session.beginTransaction();

//            получение департамента с работниками
            System.out.println("Get department");
            Department department = session.get(Department.class, 3);


            System.out.println("Show department");
            System.out.println(department);

//            для избежания нульпоинтера можем перед закрытием спессии подгрузить работников
            System.out.println("Подгружаем наших работников");
            department.getEmps().get(0);


            session.getTransaction().commit();

            System.out.println("Show empoloyees of the department");
            System.out.println(department.getEmps());
            System.out.println("Done!");


//*********************************************

//            получение департамента по работнику
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());

//            ВНИМАНИЕ! удалит все записи из за каскадов в обоих таблицах
//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
        }
    }
}
