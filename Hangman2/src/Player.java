public class Player {
    private String name;
    private int lives = 6;

    public Player(String name){
        this.name = name;
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

}
