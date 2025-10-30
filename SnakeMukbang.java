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
    
    GamePanel() {
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        bodyParts = 6;
        applesEaten = 0;
        direction = 'R';
        // initialize snake in the center
        int startX = SCREEN_WIDTH / 2;
        int startY = SCREEN_HEIGHT / 2;
        for (int i = 0; i < bodyParts; i++) {
            x[i] = startX - i * UNIT_SIZE;
            y[i] = startY;
        }
        spawnApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void spawnApple() {
        // apples must align to the grid
        appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        // ensure apple doesn't spawn on the snake
        for (int i = 0; i < bodyParts; i++) {
            if (x[i] == appleX && y[i] == appleY) {
                spawnApple();
                return;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // optional grid (comment out if you want)
            // for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            //     g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            //     g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            // }

            // draw the apple (mukbang treat) - a colorful circle with a "shine"
            g.setColor(new Color(255, 99, 71)); // tomato-like color
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            g.setColor(new Color(255, 160, 122));
            g.fillOval(appleX + UNIT_SIZE/4, appleY + UNIT_SIZE/6, UNIT_SIZE/3, UNIT_SIZE/3);

            // draw snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) { // head
                    g.setColor(new Color(34, 139, 34)); // darker green
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    // small eye
                    g.setColor(Color.BLACK);
                    if (direction == 'L') {
                        g.fillOval(x[i] + 3, y[i] + 4, 3, 3);
                    } else if (direction == 'R') {
                        g.fillOval(x[i] + UNIT_SIZE - 6, y[i] + 4, 3, 3);
                    } else if (direction == 'U') {
                        g.fillOval(x[i] + UNIT_SIZE/2 - 1, y[i] + 3, 3, 3);
                    } else { // D
                        g.fillOval(x[i] + UNIT_SIZE/2 - 1, y[i] + UNIT_SIZE - 6, 3, 3);
                    }
                } else {
                    // body color alternates slightly for visual
                    if (i % 2 == 0) g.setColor(new Color(50, 205, 50));
                    else g.setColor(new Color(144, 238, 144));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            // score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ink Free", Font.BOLD, 20));
            FontMetrics metrics = getFontMetrics(g.getFont());
            String scoreText = "Score: " + applesEaten;
            g.drawString(scoreText, (SCREEN_WIDTH - metrics.stringWidth(scoreText)) / 2, g.getFont().getSize());
        } else {
            gameOver(g);
        }
    }


