// Commented SnakeMukbang.java
// Will add clear explanations above important sections.

/* SnakeMukbang.java
 * Simple Java Swing Snake game with a "mukbang" twist.
 * Works with JDK 8+.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeMukbang {

    // Entry point: runs the Swing UI on the Event Dispatch Thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Snake Mukbang 🍜🐍");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            GamePanel panel = new GamePanel(); // create game panel
            frame.add(panel);
            frame.pack(); // size window based on panel preferred size
            frame.setLocationRelativeTo(null); // center screen
            frame.setVisible(true);
        });
    }
}

// Game panel contains all game logic + drawing
class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 20; // grid size
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    static final int DELAY = 90; // game speed

    final int x[] = new int[GAME_UNITS]; // snake body X coords
    final int y[] = new int[GAME_UNITS]; // snake body Y coords
    int bodyParts = 6; // initial length
    int applesEaten = 0;
    int appleX;
    int appleY;
    char direction = 'R'; // starting direction
    boolean running = false;
    Timer timer;
    Random random;

    GamePanel() {
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter()); // listen to keyboard
        startGame();
    }

    // Starts or restarts the game
    public void startGame() {
        bodyParts = 6;
        applesEaten = 0;
        direction = 'R';

        // Place snake in the center
        int startX = SCREEN_WIDTH / 2;
        int startY = SCREEN_HEIGHT / 2;
        for (int i = 0; i < bodyParts; i++) {
            x[i] = startX - i * UNIT_SIZE;
            y[i] = startY;
        }

        spawnApple();
        running = true;

        // Timer triggers actionPerformed repeatedly
        timer = new Timer(DELAY, this);
        timer.start();
    }

    // Random apple position (on grid)
    public void spawnApple() {
        appleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        appleY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;

        // avoid spawning on snake body
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

    // Draws everything on screen
    public void draw(Graphics g) {
        if (running) {
            // draw apple
            g.setColor(new Color(255, 99, 71));
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            g.setColor(new Color(255, 160, 122));
            g.fillOval(appleX + UNIT_SIZE/4, appleY + UNIT_SIZE/6, UNIT_SIZE/3, UNIT_SIZE/3);

            // draw snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) { // head
                    g.setColor(new Color(34, 139, 34));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    // eye
                    g.setColor(Color.BLACK);
                    if (direction == 'L') g.fillOval(x[i] + 3, y[i] + 4, 3, 3);
                    else if (direction == 'R') g.fillOval(x[i] + UNIT_SIZE - 6, y[i] + 4, 3, 3);
                    else if (direction == 'U') g.fillOval(x[i] + UNIT_SIZE/2 - 1, y[i] + 3, 3, 3);
                    else g.fillOval(x[i] + UNIT_SIZE/2 - 1, y[i] + UNIT_SIZE - 6, 3, 3);
                } else {
                    // alternating body color
                    if (i % 2 == 0) g.setColor(new Color(50, 205, 50));
                    else g.setColor(new Color(144, 238, 144));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            // Show score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ink Free", Font.BOLD, 20));
            g.drawString("Score: " + applesEaten, 350, 20);
        } else {
            gameOver(g);
        }
    }

    // Moves snake forward
    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U': y[0] -= UNIT_SIZE; break;
            case 'D': y[0] += UNIT_SIZE; break;
            case 'L': x[0] -= UNIT_SIZE; break;
            case 'R': x[0] += UNIT_SIZE; break;
        }
    }

    // Check if snake eats apple
    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            applesEaten++;
            spawnApple();
        }
    }

    // Check collisions with walls or self
    public void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) running = false;
        }
        if (x[0] < 0 || x[0] >= SCREEN_WIDTH || y[0] < 0 || y[0] >= SCREEN_HEIGHT) running = false;
        if (!running) timer.stop();
    }

    // Game over screen
    public void gameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        g.drawString("Score: " + applesEaten, 340, 250);

        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 60));
        g.drawString("Game Over", 250, 320);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.PLAIN, 24));
        g.drawString("Press SPACE to restart", 265, 360);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    // Controls (WASD + arrows + space restart)
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && direction != 'R') direction = 'L';
            else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && direction != 'L') direction = 'R';
            else if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && direction != 'D') direction = 'U';
            else if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && direction != 'U') direction = 'D';
            else if (key == KeyEvent.VK_SPACE && !running) startGame();
        }
    }
}
