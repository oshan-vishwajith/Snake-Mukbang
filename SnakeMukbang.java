/* SnakeMukbang.java
 * Simple Java Swing Snake game with a "mukbang" twist.
 * Works with JDK 8+.
 *
 * Controls:
 *   Arrow keys or WASD - move
 *   SPACE - restart after Game Over
 *
 * Author: ChatGPT (example)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeMukbang {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Snake Mukbang 🍜🐍");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            GamePanel panel = new GamePanel();
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 20; // size of one square
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    static final int DELAY = 90; // timer delay ms (lower = faster)

    final int x[] = new int[GAME_UNITS]; // x positions of snake body parts
    final int y[] = new int[GAME_UNITS]; // y positions of snake body parts
    int bodyParts = 6; // starting length
    int applesEaten = 0;
    int appleX;
    int appleY;
    char direction = 'R'; // 'U', 'D', 'L', 'R'
    boolean running = false;
    Timer timer;
    Random random;
