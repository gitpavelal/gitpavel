import java.util.Random;

/**
 * Created by Xander on 20.02.2016.
 */
public class AiPlayer extends Player {

    private Random rand = new Random();

    public AiPlayer() {
        super();
    }

    @Override
    public void turn(GameField fl) {
        int x;
        int y;
        do {
            //System.out.println("Ходит компьютер");
            x = rand.nextInt(10);
            y = rand.nextInt(10);
        }while (!fl.checkStrike(x, y));
        fl.strike(x, y);
    }

}
