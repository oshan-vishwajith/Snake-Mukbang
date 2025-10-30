import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeMukbang {

    // Entry point: runs the Swing UI on the Event Dispatch Thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Snake Mukbang");
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
    static final int DELAY_EASY = 120;
    static final int DELAY_MEDIUM = 90;
    static final int DELAY_HARD = 60;

    final int x[] = new int[GAME_UNITS]; // snake body X coords
    final int y[] = new int[GAME_UNITS]; // snake body Y coords
    int bodyParts = 6; // initial length
    int applesEaten = 0;
    int appleX;
    int appleY;
    
    // Special food feature
    int specialFoodX = -1;
    int specialFoodY = -1;
    int specialFoodTimer = 0;
    boolean specialFoodActive = false;
    
    // Combo system for score multiplier
    int comboCount = 0;
    int movesSinceLastFood = 0;
    int comboDisplayTimer = 0;
    String comboMessage = "";
    static final int COMBO_THRESHOLD_FAST = 15;    // < 15 moves = 2x
    static final int COMBO_THRESHOLD_NORMAL = 30;  // < 30 moves = normal
    
    // Difficulty and game state
    int difficulty = DELAY_MEDIUM; // default medium
    String difficultyName = "Medium";
    int highScore = 0;
    boolean paused = false;
    boolean showGrid = true;
    
    char direction = 'R'; // starting direction
    boolean running = false;
    Timer timer;
    Random random;
    
    // High score file
    static final String HIGH_SCORE_FILE = "highscore.dat";

    GamePanel() {
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter()); // listen to keyboard
        loadHighScore();
        showDifficultyMenu();
    }

    // Starts or restarts the game
    public void startGame() {
        bodyParts = 6;
        applesEaten = 0;
        direction = 'R';
        paused = false;
        specialFoodActive = false;
        specialFoodTimer = 0;
        comboCount = 0;
        movesSinceLastFood = 0;
        comboDisplayTimer = 0;

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
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(difficulty, this);
        timer.start();
    }
    
    // Show difficulty selection menu
    public void showDifficultyMenu() {
        String[] options = {"Easy", "Medium", "Hard"};
        int choice = JOptionPane.showOptionDialog(
            this,
            "Select Difficulty Level:",
            "Snake Mukbang - Difficulty",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]
        );
        
        switch (choice) {
            case 0:
                difficulty = DELAY_EASY;
                difficultyName = "Easy";
                break;
            case 1:
                difficulty = DELAY_MEDIUM;
                difficultyName = "Medium";
                break;
            case 2:
                difficulty = DELAY_HARD;
                difficultyName = "Hard";
                break;
            default:
                difficulty = DELAY_MEDIUM;
                difficultyName = "Medium";
        }
        
        startGame();
    }
    
    // Load high score from file
    public void loadHighScore() {
        try {
            File file = new File(HIGH_SCORE_FILE);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                if (line != null) {
                    highScore = Integer.parseInt(line);
                }
                reader.close();
            }
        } catch (Exception e) {
            highScore = 0;
        }
    }
    
    // Save high score to file
    public void saveHighScore() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(HIGH_SCORE_FILE));
            writer.write(String.valueOf(highScore));
            writer.close();
        } catch (Exception e) {
            // Ignore save errors
        }
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
    
    // Spawn special bonus food (appears every 5 apples)
    public void spawnSpecialFood() {
        specialFoodX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        specialFoodY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        
        // avoid spawning on snake body or regular apple
        for (int i = 0; i < bodyParts; i++) {
            if ((x[i] == specialFoodX && y[i] == specialFoodY) ||
                (specialFoodX == appleX && specialFoodY == appleY)) {
                spawnSpecialFood();
                return;
            }
        }
        
        specialFoodActive = true;
        specialFoodTimer = 100; // Disappears after 100 game ticks
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // Draws everything on screen
    public void draw(Graphics g) {
        if (running) {
            // Draw grid (optional)
            if (showGrid) {
                g.setColor(new Color(30, 30, 30));
                for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                    g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
                }
                for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
                    g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                }
            }
            
            // draw apple
            g.setColor(new Color(255, 99, 71));
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            g.setColor(new Color(255, 160, 122));
            g.fillOval(appleX + UNIT_SIZE/4, appleY + UNIT_SIZE/6, UNIT_SIZE/3, UNIT_SIZE/3);
            
            // draw special food if active
            if (specialFoodActive) {
                g.setColor(new Color(255, 215, 0)); // Gold color
                g.fillOval(specialFoodX, specialFoodY, UNIT_SIZE, UNIT_SIZE);
                g.setColor(new Color(255, 255, 0));
                g.fillOval(specialFoodX + UNIT_SIZE/4, specialFoodY + UNIT_SIZE/4, UNIT_SIZE/2, UNIT_SIZE/2);
                
                // Draw star effect
                g.setColor(Color.YELLOW);
                int cx = specialFoodX + UNIT_SIZE/2;
                int cy = specialFoodY + UNIT_SIZE/2;
                g.drawLine(cx - 3, cy - 3, cx + 3, cy + 3);
                g.drawLine(cx - 3, cy + 3, cx + 3, cy - 3);
            }
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

            // ✅ Enhanced Score Text (Shadow + Bold)
            g.setFont(new Font("Ink Free", Font.BOLD, 28));

            // shadow
            g.setColor(Color.BLACK);
            g.drawString("Score: " + applesEaten, 352, 42);

            // main text
            g.setColor(Color.WHITE);
            g.drawString("Score: " + applesEaten, 350, 40);
            
            // Display high score
            g.setFont(new Font("Ink Free", Font.BOLD, 20));
            g.setColor(Color.YELLOW);
            g.drawString("High Score: " + highScore, 10, 30);
            
            // Display difficulty
            g.setColor(Color.CYAN);
            g.drawString("Difficulty: " + difficultyName, 10, 55);
            
            // Display combo message if active
            if (comboDisplayTimer > 0) {
                g.setFont(new Font("Ink Free", Font.BOLD, 36));
                g.setColor(new Color(255, 215, 0)); // Gold
                int msgX = SCREEN_WIDTH / 2 - 80;
                int msgY = SCREEN_HEIGHT / 2;
                // Shadow
                g.setColor(new Color(0, 0, 0, 150));
                g.drawString(comboMessage, msgX + 2, msgY + 2);
                // Main text with fade effect
                int alpha = Math.min(255, comboDisplayTimer * 8);
                g.setColor(new Color(255, 215, 0, alpha));
                g.drawString(comboMessage, msgX, msgY);
            }
            
            // Display combo counter if active
            if (comboCount > 1) {
                g.setFont(new Font("Ink Free", Font.BOLD, 22));
                g.setColor(new Color(255, 140, 0)); // Dark orange
                g.drawString("Combo x" + comboCount + "!", SCREEN_WIDTH - 150, 30);
            }
            
            // Pause indicator
            if (paused) {
                g.setColor(new Color(255, 255, 255, 200));
                g.setFont(new Font("Ink Free", Font.BOLD, 60));
                g.drawString("PAUSED", 280, 300);
                g.setFont(new Font("Ink Free", Font.PLAIN, 24));
                g.drawString("Press P to Resume", 280, 340);
            }

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
        
        // Track moves for combo system
        movesSinceLastFood++;
    }

    // Check if snake eats apple
    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            
            // Calculate score with combo multiplier
            int basePoints = 1;
            int pointsEarned = calculatePoints(basePoints);
            applesEaten += pointsEarned;
            
            spawnApple();
            
            // Spawn special food every 5 apples
            if (applesEaten % 5 == 0 && !specialFoodActive) {
                spawnSpecialFood();
            }
        }
        
        // Check if snake eats special food
        if (specialFoodActive && x[0] == specialFoodX && y[0] == specialFoodY) {
            bodyParts += 2; // Give 2 extra segments
            
            // Special food always gets bonus with combo
            int basePoints = 3;
            int pointsEarned = calculatePoints(basePoints);
            applesEaten += pointsEarned;
            
            specialFoodActive = false;
            specialFoodTimer = 0;
        }
    }
    
    // Calculate points based on speed (combo system)
    public int calculatePoints(int basePoints) {
        int pointsEarned = basePoints;
        
        // Check if player was fast enough for combo
        if (movesSinceLastFood < COMBO_THRESHOLD_FAST) {
            comboCount++;
            pointsEarned = basePoints * 2; // Double points!
            
            // Show combo message
            if (comboCount >= 5) {
                comboMessage = "AMAZING x" + comboCount + "!";
            } else if (comboCount >= 3) {
                comboMessage = "GREAT x" + comboCount + "!";
            } else {
                comboMessage = "FAST x" + comboCount + "!";
            }
            comboDisplayTimer = 30; // Display for 30 frames
            
        } else if (movesSinceLastFood < COMBO_THRESHOLD_NORMAL) {
            comboCount = 1; // Reset combo but still good
            pointsEarned = basePoints;
        } else {
            comboCount = 0; // Too slow, no combo
            pointsEarned = basePoints;
        }
        
        // Reset move counter
        movesSinceLastFood = 0;
        
        return pointsEarned;
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
        // Update high score if needed
        if (applesEaten > highScore) {
            highScore = applesEaten;
            saveHighScore();
        }
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        g.drawString("Score: " + applesEaten, 340, 250);
        
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Ink Free", Font.BOLD, 24));
        g.drawString("High Score: " + highScore, 320, 280);

        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 60));
        g.drawString("Game Over", 250, 320);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.PLAIN, 24));
        g.drawString("Press SPACE to restart", 265, 360);
        g.drawString("Press ESC for difficulty menu", 235, 390);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running && !paused) {
            move();
            checkApple();
            checkCollisions();
            
            // Update special food timer
            if (specialFoodActive) {
                specialFoodTimer--;
                if (specialFoodTimer <= 0) {
                    specialFoodActive = false;
                }
            }
            
            // Update combo display timer
            if (comboDisplayTimer > 0) {
                comboDisplayTimer--;
            }
        }
        repaint();
    }

    // Controls (WASD + arrows + space restart + pause + grid toggle)
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && direction != 'R') direction = 'L';
            else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && direction != 'L') direction = 'R';
            else if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && direction != 'D') direction = 'U';
            else if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && direction != 'U') direction = 'D';
            else if (key == KeyEvent.VK_SPACE && !running) startGame();
            else if (key == KeyEvent.VK_P && running) paused = !paused; // Toggle pause
            else if (key == KeyEvent.VK_G) showGrid = !showGrid; // Toggle grid
            else if (key == KeyEvent.VK_ESCAPE && !running) showDifficultyMenu(); // Change difficulty
        }
    }
}
