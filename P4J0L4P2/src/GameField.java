import java.util.Random;

/**
 * Created by Xander on 20.02.2016.
 */
public class GameField {

    private char[][] fl;
    private int[][] shnum;
    private Random rand = new Random();

    private final char WATER = '~';
    private final char SHIP = 'O';
    private final char MISS = '*';
    private final char HIT = 'X';


    public GameField() {
        fl = new char[10][10];
        shnum = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fl[i][j] = WATER;
            }
        }
        setAllShips();
    }

    public void printField(boolean visible) {
        for (int i = 0; i < 11; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d ", (i + 1));
            for (int j = 0; j < 10; j++) {

                if (visible) {
                    System.out.printf("%2c ", fl[i][j]);
                } else {
                    if (fl[i][j] == SHIP)
                        System.out.printf("%2c ", '~');
                    else
                        System.out.printf("%2c ", fl[i][j]);
                }

            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    public void setAllShips() {
        int[] shipLens = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        char dir;
        for (int i = 0; i < shipLens.length; i++) {
            if (rand.nextInt(2) == 0) dir = 'H';
            else dir = 'V';
            while (!setShip(rand.nextInt(10), rand.nextInt(10), shipLens[i], dir, i + 1)) ;
        }
    }

    public void strike(int cx, int cy) {

        if (fl[cy][cx] == WATER) {
            fl[cy][cx] = MISS;
            System.out.println("Промах");
        }
        if (fl[cy][cx] == SHIP) {
            fl[cy][cx] = HIT;
            if(HitOrKill(cx, cy))
                System.out.println("Корабль ранен");
            else
                System.out.println("Корабль убит");
        }
    }

    public boolean checkStrike (int cx, int cy){
        if (cx < 0 || cy < 0 || cx > 9 || cy > 9) return false;
        if (fl[cy][cx] == HIT || fl[cy][cx] == MISS) return false;
        if (fl[cy][cx] == WATER || fl[cy][cx] == SHIP)
            return true;
        return false;

    }

    public boolean HitOrKill(int cx, int cy) {
        int n = shnum[cy][cx];
        shnum[cy][cx] = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(shnum[i][j] == n) return true;
            }
        }
        return false;
    }

    public boolean setShip(int cx, int cy, int l, char dir, int shipNum) {
        int vx = 0;
        int vy = 0;
        if (dir == 'V') vy = 1;
        if (dir == 'H') vx = 1;
        if (cx + vx * l > 9) return false;
        if (cy + vy * l > 9) return false;
        for (int i = 0; i < l; i++) {
            if (!checkAround(cx + vx * i, cy + vy * i)) return false;
        }
        for (int i = 0; i < l; i++) {
            fl[cy + vy * i][cx + vx * i] = SHIP;
            shnum[cy + vy * i][cx + vx * i] = shipNum;
        }
        return true;
    }

    public boolean checkAround(int cx, int cy) {
        for (int i = cy - 1; i <= cy + 1; i++) {
            for (int j = cx - 1; j <= cx + 1; j++) {
                if (i > -1 && j > -1 && i < 10 && j < 10)
                    if (fl[i][j] != WATER) return false;
            }
        }
        return true;
    }

    public boolean isDefeated() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (fl[i][j] == SHIP) return true;
            }
        }
        return false;
    }
}
