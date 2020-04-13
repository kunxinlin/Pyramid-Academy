package Employee;


import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployee {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            List<Employee> employees = session.createQuery("from Employee where company='Pyramid'").getResultList();
            displayQuery(employees);

            employees = session.createQuery("from Employee where company='Delta'").getResultList();
            displayQuery(employees);

        }finally{
            factory.close();
        }
    }

    private static void displayQuery(List<Employee> employees) {
        for(Employee e : employees) {
            System.out.println(e);
        }
    }
}
