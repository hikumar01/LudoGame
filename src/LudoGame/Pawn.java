package LudoGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Pawn {
    int x, y;
    int currentPawn;
    private final int height,  width;

    public Pawn(int height, int width) {
        currentPawn = -1;
        x = -1;
        y = -1;
        this.height = height;
        this.width = width;
    }

    public void draw(Graphics2D g, int i, int j, int currentPawn) {
        if (this.currentPawn == -1) {
            int temp1 = 80 + (height / 2), temp2 = 50 + (width / 2);
            x = i;
            y = j;
            handlePawnMovement(g, x, y, currentPawn, temp1, temp2);
        } else {
            int temp1 = 80, temp2 = 50;
            x = Path.auxiliaryX[currentPawn][this.currentPawn];
            y = Path.auxiliaryY[currentPawn][this.currentPawn];
            handlePawnMovement(g, x, y, currentPawn, temp1, temp2);
        }
    }

    private void handlePawnMovement(Graphics2D g, int x, int y, int currentPawn, int temp1, int temp2) {
        Color color = GameMoves.setColorBasedOnPlayer(currentPawn);
        fillOvalWithColor(g, x, y, color, temp1, temp2);
        g.setStroke(new BasicStroke(2));
        fillOvalWithColor(g, x, y, Color.BLACK, temp1, temp2);
    }

    private void fillOvalWithColor(Graphics2D g, int x, int y, Color color, int temp1, int temp2) {
        g.setColor(color);
        g.drawOval(temp1 + 5 + (x * width), temp2 + 5 + (y * height), width - 10, height - 10);
    }
}
