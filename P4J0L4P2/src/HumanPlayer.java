import java.util.Scanner;

/**
 * Created by Xander on 20.02.2016.
 */
public class HumanPlayer extends Player {

    private Scanner sc = new Scanner(System.in);

    public HumanPlayer() {
        super();
    }

    @Override
    public void turn(GameField fl) {
        int x;
        int y;
        do {
            System.out.println("Введите координаты стрельбы в формате X и Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!fl.checkStrike(x, y));
        fl.strike(x, y);
    }



}
