package LudoGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMoves extends JPanel implements KeyListener, ActionListener, MouseListener {
    private static final long serialVersionUID = 1L;
    Layout layout;
    BuildPlayer buildPlayer;
    int currentPlayer, dice;
    int flag, roll, kill;

    public GameMoves() {
        setFocusTraversalKeysEnabled(false);
        requestFocus();
        currentPlayer = 0;
        layout = new Layout(80, 50);
        buildPlayer = new BuildPlayer(layout.height, layout.width);
        dice = 0;
        flag = 0;
        roll = 0;
        kill = 0;
    }

    @Override
    public void paint(Graphics g) {
        layout.draw((Graphics2D)g);
        buildPlayer.draw((Graphics2D)g);
        if (buildPlayer.players[currentPlayer].coin == 4) {
            setColorAndFont(g);
            g.drawString("Player " + (currentPlayer + 1) + " wins.", 600, 150);
            g.drawString("Congratulations.", 600, 200);
            currentPlayer = 0;
            layout = new Layout(80, 50);
            buildPlayer = new BuildPlayer(layout.height, layout.width);
            dice = 0;
            flag = 0;
            roll = 0;
            kill = 0;
        } else if (dice != 0) {
            setColorAndFont(g);
            g.drawString("Player " + (currentPlayer + 1), 600, 150);
            g.drawString("Number on dice is " + dice, 600, 200);
        }
        if (flag == 0 && dice != 0 && dice != 6 && kill == 0) {
            currentPlayer = (currentPlayer + 1) % 4;
        }
        kill = 0;
    }

    private void setColorAndFont(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(590, 100, 380, 130);
        g.setColor(GameMoves.setColorBasedOnPlayer(currentPlayer));
        g.setFont(new Font("serif", Font.BOLD, 40));
    }

    static Color setColorBasedOnPlayer(int currentPlayer) {
        Color playersColor = null;
        if (currentPlayer == 0) {
            playersColor = Color.RED;
        } else if (currentPlayer == 1) {
            playersColor = Color.GREEN;
        } else if (currentPlayer == 2) {
            playersColor = Color.YELLOW;
        } else if (currentPlayer == 3) {
            playersColor = Color.BLUE;
        }
        return playersColor;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && flag == 0) {
            roll = 0;
            dice = 1 + (int)(Math.random() * 6);
            repaint();
            for (int i = 0; i < 4; i++) {
                if (buildPlayer.players[currentPlayer].pawns[i].currentPawn != -1 &&
                    buildPlayer.players[currentPlayer].pawns[i].currentPawn != 56 &&
                    (buildPlayer.players[currentPlayer].pawns[i].currentPawn + dice) <= 56) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0 && dice == 6) {
                for (int i = 0; i < 4; i++) {
                    if (buildPlayer.players[currentPlayer].pawns[i].currentPawn == -1) {
                        flag = 1;
                        break;
                    }
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (flag == 1) {
            int x = e.getX();
            int y = e.getY();
            x = x - 80;
            y = y - 50;
            x = x / 30;
            y = y / 30;
            int value = -1;
            // System.out.println(x+" "+y);
            if (dice == 6) {
                value = getValue(x, y, value);
                if (value != -1) {
                    handleClick(value);
                } else {
                    for (int i = 0; i < 4; i++) {
                        if (buildPlayer.players[currentPlayer].pawns[i].currentPawn == -1) {
                            buildPlayer.players[currentPlayer].pawns[i].currentPawn = 0;
                            flag = 0;
                            break;
                        }
                    }
                }
            } else {
                value = getValue(x, y, value);
                if (value != -1) {
                    handleClick(value);
                }
            }
            repaint();
        }
    }

    private void handleClick(int value) {
        buildPlayer.players[currentPlayer].pawns[value].currentPawn += dice;
        if (buildPlayer.players[currentPlayer].pawns[value].currentPawn == 56) {
            buildPlayer.players[currentPlayer].coin++;
        }
        int k = 0;
        int hou = buildPlayer.players[currentPlayer].pawns[value].currentPawn;
        if ((hou % 13) != 0 && (hou % 13) != 8 && hou < 51) {
            for (int i = 0; i < 4; i++) {
                if (i != currentPlayer) {
                    for (int j = 0; j < 4; j++) {
                        int tem1 = Path.auxiliaryX[currentPlayer]
                                          [buildPlayer.players[currentPlayer].pawns[value].currentPawn],
                            tem2 = Path.auxiliaryY[currentPlayer]
                                          [buildPlayer.players[currentPlayer].pawns[value].currentPawn];
                        if (buildPlayer.players[i].pawns[j].x == tem1 && buildPlayer.players[i].pawns[j].y == tem2) {
                            buildPlayer.players[i].pawns[j].currentPawn = -1;
                            kill = 1;
                            k = 1;
                            break;
                        }
                    }
                }
                if (k == 1) break;
            }
        }
    }

    private int getValue(int x, int y, int value) {
        for (int i = 0; i < 4; i++) {
            if (buildPlayer.players[currentPlayer].pawns[i].x == x && buildPlayer.players[currentPlayer].pawns[i].y == y &&
                (buildPlayer.players[currentPlayer].pawns[i].currentPawn + dice) <= 56) {
                value = i;
                flag = 0;
                break;
            }
        }
        return value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }
}
