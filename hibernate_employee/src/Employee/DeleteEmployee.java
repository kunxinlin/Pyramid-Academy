package Employee;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            int id = 2;
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + id);
            Employee myEmployee = session.get(Employee.class, id);

            //Delete the student
            //System.out.println("Deleting student: " + myEmployee);
            //session.delete(myEmployee);

            System.out.println("Deleting student where id=2");
            session.createQuery("delete from Employee where id=2").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}