# 📁 Project Structure - Snake Mukbang

```
Snake-Mukbang/
│
├── 📄 SnakeMukbang.java          # Main game source code (402 lines)
│                                  # Contains: SnakeMukbang + GamePanel classes
│
├── 📘 README.md                   # Comprehensive project documentation
│                                  # - Feature overview
│                                  # - Installation guide
│                                  # - Controls and gameplay
│                                  # - Contributing info
│
├── 🚀 QUICKSTART.md               # 5-minute getting started guide
│                                  # - Quick installation
│                                  # - Basic controls
│                                  # - Tips for beginners
│                                  # - Troubleshooting
│
├── 🤝 CONTRIBUTING.md             # Contribution guidelines
│                                  # - How to contribute
│                                  # - Code style guide
│                                  # - Feature suggestions
│                                  # - Pull request process
│
├── 🌟 FEATURES.md                 # Detailed feature documentation
│                                  # - Core gameplay mechanics
│                                  # - New features explained
│                                  # - Visual design specs
│                                  # - Technical details
│
├── 📝 CHANGELOG.md                # Version history and changes
│                                  # - Release notes
│                                  # - Feature tracking
│                                  # - Future plans
│
├── 🎃 HACKTOBERFEST_SUMMARY.md    # Enhancement summary
│                                  # - All new features listed
│                                  # - Impact assessment
│                                  # - Statistics
│                                  # - Future ideas
│
├── 📜 LICENSE                     # MIT License
│                                  # - Open source terms
│                                  # - Usage permissions
│
├── 🚫 .gitignore                  # Git ignore rules
│                                  # - Compiled files
│                                  # - IDE files
│                                  # - OS files
│                                  # - High score data
│
├── 💾 highscore.dat               # High score storage (auto-generated)
│                                  # - Created on first game over
│                                  # - Persistent between sessions
│
└── 📦 *.class                     # Compiled Java files (auto-generated)
    ├── SnakeMukbang.class
    ├── GamePanel.class
    └── GamePanel$MyKeyAdapter.class

```

---

## 📊 File Statistics

### Source Code

```
SnakeMukbang.java:      402 lines
- Imports:              7 lines
- Main class:           15 lines
- GamePanel class:      380 lines
```

### Documentation

```
README.md:              ~180 lines
CONTRIBUTING.md:        ~180 lines
FEATURES.md:            ~280 lines
QUICKSTART.md:          ~140 lines
CHANGELOG.md:           ~90 lines
HACKTOBERFEST_SUMMARY:  ~200 lines
Total Documentation:    ~1,070 lines
```

### Project Totals

```
Total Files:            8 documentation + 1 source
Total Lines:            ~1,470 lines
Documentation Ratio:    72% docs, 28% code
```

---

## 🏗️ Architecture Overview

### Class Structure

```
SnakeMukbang (Main Class)
└── main()
    └── Creates JFrame
        └── Contains GamePanel

GamePanel (extends JPanel, implements ActionListener)
├── Game State Variables
│   ├── Snake coordinates (x[], y[])
│   ├── Score tracking
│   ├── Food positions
│   └── Game flags
│
├── Core Methods
│   ├── startGame()
│   ├── move()
│   ├── checkApple()
│   ├── checkCollisions()
│   └── draw()
│
├── New Feature Methods
│   ├── showDifficultyMenu()
│   ├── spawnSpecialFood()
│   ├── loadHighScore()
│   └── saveHighScore()
│
└── Inner Class: MyKeyAdapter
    └── Handles all keyboard input
```

---

## 🎨 Visual Assets (Text-based)

### Colors Used

```java
// Snake
Head:           new Color(34, 139, 34)   // Forest Green
Body Light:     new Color(144, 238, 144) // Light Green
Body Dark:      new Color(50, 205, 50)   // Lime Green

// Food
Apple:          new Color(255, 99, 71)   // Tomato
Apple Light:    new Color(255, 160, 122) // Light Salmon
Special Food:   new Color(255, 215, 0)   // Gold
Special Center: new Color(255, 255, 0)   // Yellow

// UI
Background:     Color.BLACK
Grid:           new Color(30, 30, 30)    // Very Dark Grey
Score:          Color.WHITE
High Score:     Color.YELLOW
Difficulty:     Color.CYAN
Game Over:      Color.RED
Pause:          new Color(255, 255, 255, 200) // Semi-transparent
```

### Fonts

```java
Score:          "Ink Free", BOLD, 28px
High Score:     "Ink Free", BOLD, 20px
Difficulty:     "Ink Free", BOLD, 20px
Game Over:      "Ink Free", BOLD, 60px
Instructions:   "Ink Free", PLAIN, 24px
Pause:          "Ink Free", BOLD, 60px
```

---

## 💾 Data Storage

### High Score File (highscore.dat)

```
Format:         Plain text, single integer
Location:       Same directory as .java file
Creation:       Auto-generated on first game over
Persistence:    Permanent (until deleted)
Error Handling: Creates with 0 if missing/corrupt
```

---

## 🔧 Build Process

### Compilation

```bash
javac SnakeMukbang.java

Generates:
- SnakeMukbang.class
- GamePanel.class
- GamePanel$MyKeyAdapter.class
```

### Execution

```bash
java SnakeMukbang

Creates:
- Game window (800x600)
- Difficulty selection dialog
- Game starts immediately after selection
```

---

## 📋 Documentation Guide

### For Players

```
1. Start Here:    QUICKSTART.md
2. Then Read:     README.md
3. Learn More:    FEATURES.md
```

### For Contributors

```
1. Read:          CONTRIBUTING.md
2. Review:        HACKTOBERFEST_SUMMARY.md
3. Check:         CHANGELOG.md
4. Reference:     FEATURES.md (for technical details)
```

### For Maintainers

```
1. Update:        CHANGELOG.md (on each release)
2. Review:        Pull requests against CONTRIBUTING.md
3. Maintain:      README.md (keep features updated)
```

---

## 🎯 File Relationships

```
SnakeMukbang.java
    ↓ creates
highscore.dat (on game over)
    ↓ read by
SnakeMukbang.java (on startup)

README.md
    ↓ references
CONTRIBUTING.md, QUICKSTART.md, FEATURES.md

CONTRIBUTING.md
    ↓ references
README.md, CHANGELOG.md

All .md files
    ↓ reference
SnakeMukbang.java (the game)
```

---

## 📦 Distribution

### Minimum Files for Game

```
Required:
- SnakeMukbang.java (or .class files)

Optional:
- highscore.dat (auto-generated if missing)
```

### Complete Package

```
Recommended:
- SnakeMukbang.java
- README.md
- QUICKSTART.md
- LICENSE

Full Package:
- All files in repository
```

---

## 🔍 Navigation Tips

| Want to...         | Go to...                 |
| ------------------ | ------------------------ |
| Play the game      | Run SnakeMukbang.java    |
| Quick start        | QUICKSTART.md            |
| Learn features     | FEATURES.md              |
| Contribute         | CONTRIBUTING.md          |
| See changes        | CHANGELOG.md             |
| Check license      | LICENSE                  |
| Understand project | README.md                |
| See enhancements   | HACKTOBERFEST_SUMMARY.md |

---

**Project is well-organized and ready for contributions!** 🎮✨
