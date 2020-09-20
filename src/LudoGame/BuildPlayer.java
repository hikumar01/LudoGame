package LudoGame;

import java.awt.Graphics2D;

public class BuildPlayer {
    Player[] players;
    int[][] initialX = {
        { 1,  1,  3,  3},
        {10, 10, 12, 12},
        {10, 10, 12, 12},
        { 1,  1,  3,  3}
    };
    int[][] initialY = {
        { 1,  3,  1,  3},
        { 1,  3,  1,  3},
        {10, 12, 10, 12},
        {10, 12, 10, 12}
    };

    public BuildPlayer(int height, int width) {
        players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player(height, width);
        }
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // TODO: Use Path.initialX & Path.InitialY instead
                players[i].pawns[j].draw(g, initialX[i][j], initialY[i][j], i);
            }
        }
    }
}
