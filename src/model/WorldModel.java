package model;

/**
 * Created by timothy on 2016-10-11.
 */
public class WorldModel {
    private Player player1;
    private Player player2;

    public WorldModel(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}