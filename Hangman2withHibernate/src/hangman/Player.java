package hangman;


import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "score")
    private int lives = 6;

    public Player(){

    }
    public Player(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return lives;
    }

    public String getName()
    {
        return name;
    }

    public void decLives(){
        lives--;
    }


    @Override
    public String toString(){
        return "Player{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Score='" + lives + '\'' +
                '}';
    }
}
