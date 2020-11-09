package Employee;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating 3 employee objects...");
            Employee tempEmployee = new Employee("Kris", "Lin", "Pyramid");
            Employee tempEmployee1 = new Employee("Oliver", "James", "Delta");
            Employee tempEmployee2 = new Employee("Murasaki", "Ko", "United");

            session.beginTransaction();
            System.out.println("Beginning transaction...");

            session.save(tempEmployee);
            session.save(tempEmployee1);
            session.save(tempEmployee2);
            System.out.println("Saving the new employees...");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}