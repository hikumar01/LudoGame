package LudoGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Layout {
    int x, y, width, height;

    public Layout(int xi, int yi) {
        x = xi;
        y = yi;
        width = 30;
        height = 30;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 15 * width, 15 * height);
        for (int i = 0; i < 6; i++) {
            g.setColor(Color.RED);
            g.fillRect(x + (i * width), y, width, height);
            g.fillRect(x, y + (i * height), width, height);
            g.fillRect(x + (i * width), y + (5 * height), width, height);
            g.fillRect(x + (5 * width), y + (i * height), width, height);
            g.setColor(Color.GREEN);
            g.fillRect(x + ((i + 9) * width), y, width, height);
            g.fillRect(x + (9 * width), y + (i * height), width, height);
            g.fillRect(x + ((i + 9) * width), y + (5 * height), width, height);
            g.fillRect(x + (14 * width), y + (i * height), width, height);
            g.setColor(Color.YELLOW);
            g.fillRect(x + ((i + 9) * width), y + (9 * height), width, height);
            g.fillRect(x + (9 * width), y + ((i + 9) * height), width, height);
            g.fillRect(x + ((i + 9) * width), y + (14 * height), width, height);
            g.fillRect(x + (14 * width), y + ((i + 9) * height), width, height);
            g.setColor(Color.BLUE);
            g.fillRect(x + (i * width), y + (9 * height), width, height);
            g.fillRect(x, y + ((i + 9) * height), width, height);
            g.fillRect(x + (i * width), y + (14 * height), width, height);
            g.fillRect(x + (5 * width), y + ((i + 9) * height), width, height);
        }
        for (int i = 1; i < 6; i++) {
            g.setColor(Color.RED);
            g.fillRect(x + (i * width), y + (7 * height), width, height);
            g.setColor(Color.YELLOW);
            g.fillRect(x + ((8 + i) * width), y + (7 * height), width, height);
            g.setColor(Color.GREEN);
            g.fillRect(x + (7 * width), y + (i * height), width, height);
            g.setColor(Color.BLUE);
            g.fillRect(x + ((7) * width), y + ((8 + i) * height), width, height);
        }
        g.setColor(Color.RED);
        g.fillRect(x + (1 * width), y + (6 * height), width, height);
        g.setColor(Color.YELLOW);
        g.fillRect(x + ((13) * width), y + (8 * height), width, height);
        g.setColor(Color.GREEN);
        g.fillRect(x + (8 * width), y + (1 * height), width, height);
        g.setColor(Color.BLUE);
        g.fillRect(x + ((6) * width), y + ((13) * height), width, height);
        int temp1 = x + 45, temp2 = y + 45;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                g.setColor(Color.RED);
                g.fillRect(temp1 + (2 * i * width), temp2 + (2 * j * height), width, height);
                g.setColor(Color.YELLOW);
                g.fillRect(temp1 + (2 * i * width) + 9 * width,
                           temp2 + (2 * j * height) + 9 * height, width, height);
                g.setColor(Color.GREEN);
                g.fillRect(temp1 + (2 * i * width) + 9 * width,
                           temp2 + (2 * j * height) + 0 * height, width, height);
                g.setColor(Color.BLUE);
                g.fillRect(temp1 + (2 * i * width) + 0 * width,
                           temp2 + (2 * j * height) + 9 * height, width, height);
            }
        }
        g.setColor(Color.RED);
        int[] xPoints0 = {x + (6 * width), x + (6 * width), x + 15 + (7 * width)};
        int[] yPoints0 = {y + (6 * height), y + (9 * height), y + 15 + (7 * width)};
        int nPoints = 3;
        g.fillPolygon(xPoints0, yPoints0, nPoints);
        g.setColor(Color.YELLOW);
        int[] xPoints1 = {x + (9 * width), x + (9 * width), x + 15 + (7 * width)};
        int[] yPoints1 = {y + (6 * height), y + (9 * height), y + 15 + (7 * width)};
        int nPoints1 = 3;
        g.fillPolygon(xPoints1, yPoints1, nPoints1);
        g.setColor(Color.GREEN);
        int[] xPoints2 = {x + (6 * width), x + (9 * width), x + 15 + (7 * width)};
        int[] yPoints2 = {y + (6 * height), y + (6 * height), y + 15 + (7 * width)};
        int nPoints2 = 3;
        g.fillPolygon(xPoints2, yPoints2, nPoints2);
        g.setColor(Color.BLUE);
        int[] xPoints3 = {x + (6 * width), x + (9 * width), x + 15 + (7 * width)};
        int[] yPoints3 = {y + (9 * height), y + (9 * height), y + 15 + (7 * width)};
        int nPoints3 = 3;
        g.fillPolygon(xPoints3, yPoints3, nPoints3);
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                g.drawRect(x + ((i + 6) * width), y + (j * height), width, height);
                g.drawRect(x + ((j)*width), y + ((i + 6) * height), width, height);
                g.drawRect(x + ((i + 6) * width), y + ((j + 9) * height), width, height);
                g.drawRect(x + ((j + 9) * width), y + ((i + 6) * height), width, height);
            }
        }
        g.drawRect(x + ((1) * width), y + (1 * height), 4 * width, 4 * height);
        g.drawRect(x + ((10) * width), y + (1 * height), 4 * width, 4 * height);
        g.drawRect(x + ((1) * width), y + (10 * height), 4 * width, 4 * height);
        g.drawRect(x + ((10) * width), y + (10 * height), 4 * width, 4 * height);
        g.drawRect(x, y, 15 * width, 15 * height);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                g.drawRect(temp1 + (2 * i * width), temp2 + (2 * j * height), width, height);
                g.drawRect(temp1 + (2 * i * width) + 9 * width,
                           temp2 + (2 * j * height) + 9 * height, width, height);
                g.drawRect(temp1 + (2 * i * width) + 9 * width,
                           temp2 + (2 * j * height) + 0 * height, width, height);
                g.drawRect(temp1 + (2 * i * width) + 0 * width,
                           temp2 + (2 * j * height) + 9 * height, width, height);
            }
        }
        g.drawPolygon(xPoints0, yPoints0, nPoints);
        g.drawPolygon(xPoints1, yPoints1, nPoints1);
        g.drawPolygon(xPoints2, yPoints2, nPoints2);
        g.drawPolygon(xPoints3, yPoints3, nPoints3);
        g.drawOval(x + 5 + (6 * width), y + 5 + (2 * height), width - 10, height - 10);
        g.drawOval(x + 5 + (12 * width), y + 5 + (6 * height), width - 10, height - 10);
        g.drawOval(x + 5 + (8 * width), y + 5 + (12 * height), width - 10, height - 10);
        g.drawOval(x + 5 + (2 * width), y + 5 + (8 * height), width - 10, height - 10);
        g.setFont(new Font("serif", Font.BOLD, 40));
        g.drawString("Player 1", 90, 35);
        g.drawString("Player 2", 370, 35);
        g.drawString("Player 4", 90, 540);
        g.drawString("Player 3", 370, 540);
        g.drawString("Instruction:", 550, 300);
        g.drawString("1.Press enter to roll dice.", 550, 350);
        g.drawString("2.Click on coin to move.", 550, 400);
    }
}
