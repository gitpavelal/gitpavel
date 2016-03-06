/**
 * Created by Xander on 20.02.2016.
 */
public class MainClass {

    // поле, корабли, АИ, человек,
    public static void main(String[] args) {

        //Player p1 = new HumanPlayer();
        //Player p2 = new HumanPlayer();
        Player p1 = new AiPlayer();
        Player p2 = new AiPlayer();

        while (true) {
            System.out.println("ХОДИТ ИГРОК 1");
            p1.getField().printField(true);
            p2.getField().printField(false);
            p1.turn(p2.getField());
            if (!p2.getField().isDefeated()) {
                System.out.println();
                System.out.println("ПОБЕДИЛ ИГРОК 1");
                System.out.println("ПОЛЕ 1 ИГРОКА");
                p1.getField().printField(true);
                System.out.println("ПОЛЕ 2 ИГРОКА");
                p2.getField().printField(true);
                break;
            }
            System.out.println("ХОДИТ ИГРОК 2");
            p2.getField().printField(true);
            p1.getField().printField(false);
            p2.turn(p1.getField());
            if (!p1.getField().isDefeated()) {
                System.out.println();
                System.out.println("ПОБЕДИЛ ИГРОК 2");
                System.out.println("ПОЛЕ 1 ИГРОКА");
                p1.getField().printField(true);
                System.out.println("ПОЛЕ 2 ИГРОКА");
                p2.getField().printField(true);
                break;
            }
        }
    }
}


