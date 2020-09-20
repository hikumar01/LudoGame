package LudoGame;

public class Player {
    int status, coin;
    Pawn[] pawns = new Pawn[4];

    public Player(int height, int width) {
        status = -1;
        coin = 0;
        for (int i = 0; i < 4; i++) {
            pawns[i] = new Pawn(height, width);
        }
    }
}
