# 🐍🍜 Snake Mukbang !

Snake Mukbang is a fun and addictive Java Snake Game built with Java Swing.
Control your snake, eat food to grow longer, and avoid crashing into walls or yourself. Collect special golden apples for bonus points and challenge yourself across different difficulty levels. Simple, addictive, and fun for everyone!
---

## 🎮 FEATURES

### Core Gameplay

- Classic Snake gameplay with a "mukbang" twist
- Real-time keyboard controls (WASD + Arrow keys)
- Dynamic score tracking with persistent high scores
- Smooth movement and responsive interface
- Game Over screen with restart option

### 🆕 Advanced Features

- **Multiple Difficulty Levels**: Choose between Easy, Medium, and Hard modes with different speeds
- **Combo Scoring System**: Earn 2x points for eating food quickly! Chain combos for higher scores
  - Fast eating (<15 moves) = 2x score multiplier
  - Visual combo counter and motivational messages
  - Strategic gameplay rewards skilled players
- **High Score System**: Your best score is automatically saved and tracked across sessions
- **Special Bonus Food**: Golden food appears every 5 regular apples for bonus points
  - Awards +3 points (6 with combo!)
  - Adds +2 body segments
  - Disappears after a time limit if not collected
- **Pause Functionality**: Press 'P' to pause/resume the game anytime
- **Grid Toggle**: Press 'G' to show/hide the grid overlay for better navigation
- **Visual Enhancements**:
  - Animated snake with direction-aware eyes
  - Colorful food items with special effects
  - Score display with shadow effects
  - Combo messages with fade effects
  - Difficulty and high score indicators on screen
- **Timed Challenges**: Special food disappears if not collected quickly

---

## 🧩 REQUIREMENTS

- **Java Development Kit (JDK) 8 or higher**
- A Java IDE such as **Eclipse**, **IntelliJ IDEA**, or **NetBeans** (optional)

---

## 🚀 HOW TO RUN

### ▶️ Using Command Line

1. Clone this repository:

   ```bash
   git clone https://github.com/induwara-dissanayake/Snake-Mukbang.git
   cd Snake-Mukbang
   ```

2. Compile the main file:

   ```bash
   javac SnakeMukbang.java
   ```

3. Run the game:

   ```bash
   java SnakeMukbang
   ```

### 💡 Using an IDE

1. Open the project in your preferred IDE
2. Locate and open `SnakeMukbang.java`
3. Click **Run ▶️** to start playing
4. Select your difficulty level from the menu

---

## 🕹️ CONTROLS

| Key                | Action                                      |
| ------------------ | ------------------------------------------- |
| ⬆️ Arrow Up / W    | Move Up                                     |
| ⬇️ Arrow Down / S  | Move Down                                   |
| ⬅️ Arrow Left / A  | Move Left                                   |
| ➡️ Arrow Right / D | Move Right                                  |
| **P**              | Pause/Resume Game                           |
| **G**              | Toggle Grid Display                         |
| **SPACE**          | Restart Game (after Game Over)              |
| **ESC**            | Return to Difficulty Menu (after Game Over) |

---

## 🍽️ GAME RULES

- **Regular Food (Red Apple)**: Eat to grow by 1 segment and earn 1 point
- **Special Food (Golden)**: Appears every 5 apples
  - Awards 3 points instead of 1
  - Adds 2 body segments
  - Limited time to collect before it disappears
- **Avoid Collisions**: Don't crash into walls or your own tail
- **Difficulty Modes**:
  - **Easy**: Slower speed, perfect for beginners
  - **Medium**: Moderate speed, balanced challenge
  - **Hard**: Fast speed, for experienced players
- **High Score**: Your best score is saved automatically and displayed on screen

---

## 🎯 GAMEPLAY TIPS

1. Plan your path ahead to avoid trapping yourself
2. Wait for special food to appear near the edges for safer collection
3. Use the grid (press G) to help plan movements
4. Pause (press P) to take a break and plan your strategy
5. Start with Easy mode to practice, then challenge yourself with Hard mode
6. Try to beat your high score each game!

-💡 **Tip:** Try collecting special food near the corners for a safer combo!

---

## 🏆 Implemented Features (Hacktoberfest 2025)

- ✅ Multiple difficulty levels (Easy, Medium, Hard)
- ✅ Persistent high score tracking with file storage
- ✅ Special bonus food system with visual effects
- ✅ Pause/Resume functionality
- ✅ Grid toggle for enhanced gameplay
- ✅ Enhanced visual effects and UI improvements
- ✅ Direction-aware snake head animation
- ✅ Comprehensive controls and keyboard shortcuts

---

## 🔮 Future Enhancements

- Add background music and sound effects 🎵
- Introduce power-ups (speed boost, invincibility, etc.)
- Add obstacles and level designs
- Implement online leaderboard
- Add multiplayer mode
- Theme customization options
- Achievement system

---

## 🤝 Contributing

Contributions are welcome! This project participates in **Hacktoberfest 2025**.

To contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📜 License

This project is open source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**Induwara Dissanayake**

- GitHub: [@induwara-dissanayake](https://github.com/induwara-dissanayake)

---

## 🌟 Show Your Support

If you found this project helpful or fun, please give it a ⭐️!

Happy Gaming! 🎮🐍
