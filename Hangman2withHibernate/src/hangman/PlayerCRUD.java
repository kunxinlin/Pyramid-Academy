package hangman;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PlayerCRUD {

    public static void createRecord(Player player) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Player.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();

        try {
            //create 3 student objects
            System.out.println("Creating player record");

            //start a transaction
            session.beginTransaction();

            //save the student object
            session.save(player);
            System.out.println("Saving player record");

            //commit the transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    public static List<Player> getAllPlayers() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Player.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Player> players = session.createQuery("FROM Player").getResultList();
            return players;

        } finally {
            factory.close();
        }
    }

    public static int getHighScoreFromDatabase() {
        List<Player> players = getAllPlayers();

        //return -1 as score if no record in database
        if(players.size() == 0)
        {
            return -1;
        }

        return players.stream().map(x -> x.getScore()).reduce(Integer::max).get();
    }
}
