# Quick Start Guide - Snake Mukbang

Welcome to Snake Mukbang! This guide will help you get started in under 5 minutes.

## ⚡ Quick Start

### Step 1: Install Java

Make sure you have Java 8 or higher installed:

```bash
java -version
```

If not installed, download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/).

### Step 2: Download the Game

```bash
git clone https://github.com/induwara-dissanayake/Snake-Mukbang.git
cd Snake-Mukbang
```

### Step 3: Compile & Run

```bash
javac SnakeMukbang.java
java SnakeMukbang
```

That's it! The game will start immediately.

## 🎮 First Time Playing?

### Choose Your Difficulty

When the game starts, you'll see three options:

- **Easy** - Great for beginners, slower snake
- **Medium** - Balanced challenge
- **Hard** - Fast-paced action!

### Basic Controls

- Use **Arrow Keys** or **WASD** to move
- Press **P** to pause anytime
- Press **G** to toggle the grid (helpful for planning moves)

### Understanding the Game

#### Food Types

1. **Red Apple** (Regular Food)

   - Worth 1 point
   - Makes snake grow by 1 segment
   - Always available

2. **Golden Food** (Special Bonus)
   - Appears every 5 apples
   - Worth 3 points
   - Makes snake grow by 2 segments
   - **Time Limited** - Collect it quickly!

#### Game Over Conditions

- Hitting the wall
- Crashing into your own body

## 🎯 Tips for Beginners

1. **Start Small**: Begin with Easy mode to learn the controls
2. **Use the Grid**: Press 'G' to see the grid - it helps with precision
3. **Plan Ahead**: Look where the apple is and plan your path
4. **Avoid Corners**: Don't trap yourself in corners
5. **Stay Near Center**: Easier to maneuver with more space
6. **Watch Your Tail**: As you grow, your tail becomes the biggest threat

## 🏆 Scoring System

| Action            | Points | Growth      |
| ----------------- | ------ | ----------- |
| Eat Regular Apple | +1     | +1 segment  |
| Eat Golden Food   | +3     | +2 segments |

## 🚀 Advanced Features

### Pause Feature

Press **P** at any time to pause:

- Take a break
- Plan your next moves
- Answer that important message!

Press **P** again to resume.

### Grid Toggle

Press **G** to show/hide the grid:

- **Grid ON**: Better precision, easier planning
- **Grid OFF**: Cleaner view, more immersive

### High Score Tracking

Your best score is automatically saved:

- Displayed on the game screen
- Persists between sessions
- Try to beat your own record!

### Difficulty Menu

After game over, press **ESC** to:

- Return to difficulty selection
- Try a different challenge level
- Practice on easier modes

## ❓ Troubleshooting

### Game Won't Start

- Make sure Java is installed: `java -version`
- Check that you're in the correct directory
- Try recompiling: `javac SnakeMukbang.java`

### Compilation Errors

- Ensure you have JDK (not just JRE)
- Check your Java version (needs 8+)
- Verify the file isn't corrupted

### Controls Not Working

- Make sure the game window is focused (click on it)
- Check you're not using conflicting keys
- Try restarting the game

## 🎯 Your First Game

1. **Start on Easy** - Get comfortable with controls
2. **Score 10 Points** - Learn the basic mechanics
3. **Collect Golden Food** - Appears after 5 apples
4. **Beat Score 20** - You're getting good!
5. **Try Medium** - Ready for more challenge?

## 📚 Next Steps

- Read the full [README.md](README.md) for all features
- Check [CONTRIBUTING.md](CONTRIBUTING.md) if you want to add features
- Try to beat the high score!
- Challenge your friends!

---

**Have fun playing Snake Mukbang!** 🐍🎮

If you encounter any issues, please [open an issue](https://github.com/induwara-dissanayake/Snake-Mukbang/issues) on GitHub.
