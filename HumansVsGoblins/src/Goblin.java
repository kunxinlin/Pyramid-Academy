public class Goblin {
    static String goblin =  "\uD83D\uDC79";
    static int[] position = {0, 0};

    private String name1 = "Adam";

    @Override
    public String toString() {
        return "Goblin{" +
                "name1='" + goblin + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //new Goblin();
        System.out.println(new Goblin());
    }
}
