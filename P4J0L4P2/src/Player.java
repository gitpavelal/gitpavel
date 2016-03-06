/**
 * Created by Xander on 20.02.2016.
 */
public abstract class Player {
    private GameField gf;
    public GameField getField() { return gf; };

    public Player() {
        gf = new GameField();
    }

    public abstract void turn(GameField fl);
}
