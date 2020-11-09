package Employee;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            //Retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: 1");
            Employee myEmployee = session.get(Employee.class, 1);
            System.out.println("Get Completed: " + myEmployee);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}