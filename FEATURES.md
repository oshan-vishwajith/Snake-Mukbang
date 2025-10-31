# 🌟 Features Showcase - Snake Mukbang..

This document provides a detailed overview of all the features in Snake Mukbang, including the new Hacktoberfest 2025 additions!

---

## 🎮 Core Gameplay Features

### Classic Snake Mechanics

- **Grid-based Movement**: Snake moves on a 20x20 pixel grid
- **Continuous Motion**: Snake keeps moving in the current direction
- **Growing Mechanism**: Snake grows when eating food
- **Collision Detection**: Detects walls and self-collision

### Responsive Controls

- **Dual Input Support**: Arrow keys AND WASD for flexibility
- **Direction Prevention**: Can't reverse directly (no 180° turns)
- **Instant Response**: Zero input lag for precise control

---

## 🆕 Hacktoberfest 2025 Features

### 1. Multiple Difficulty Levels 🎯

**Three challenge modes to suit every player:**

#### Easy Mode

- Speed: 120ms per move
- Perfect for: Beginners, learning controls, relaxed gameplay
- Strategy: Take your time to plan moves

#### Medium Mode

- Speed: 90ms per move
- Perfect for: Regular players, balanced challenge
- Strategy: Quick thinking required

#### Hard Mode

- Speed: 60ms per move
- Perfect for: Experts, maximum challenge
- Strategy: Lightning-fast reflexes needed

**How to Use:**

- Select at game start
- Press ESC after game over to change
- Each mode maintains separate high score tracking (in memory)

---

### 2. Special Bonus Food System ⭐

**Golden food with enhanced rewards:**

#### Appearance

- Spawns every 5 regular apples eaten
- Bright golden color with yellow center
- Star sparkle effect for visibility
- Only one active at a time

#### Rewards

- **3 Points** instead of 1
- **2 Body Segments** instead of 1
- Great for quick score boosts!

#### Time Limit

- Disappears after 100 game ticks (~9-12 seconds)
- Creates exciting urgency
- Risk vs. reward decision making

#### Visual Design

```
Regular Apple: Red with lighter center
Special Food: Gold with yellow center + sparkle effect
```

---

### 3. Persistent High Score System 🏆

**Your achievements are saved forever:**

#### Features

- Automatically saves best score
- Stored in `highscore.dat` file
- Survives game restarts
- Displayed on game screen
- Updated in real-time during game over

#### Display

- **In-Game**: Yellow text, top-left corner
- **Game Over**: Prominent display with current score comparison
- **Celebration**: Visual highlight when beating high score

#### Technical

- Uses simple file I/O
- Handles missing/corrupt files gracefully
- No external dependencies required

---

### 4. Pause System ⏸️

**Full control over your game pace:**

#### Functionality

- Press **P** to pause
- Press **P** again to resume
- Snake and food freeze in place
- Timer pauses
- Special food timer pauses too

#### Visual Feedback

- Large "PAUSED" overlay
- Semi-transparent white text
- Clear resume instructions
- Background remains visible

#### Use Cases

- Take a break
- Plan your strategy
- Answer notifications
- Show someone the game state

---

### 5. Grid Toggle Feature 📐

**Optional visual aid for precise movement:**

#### Grid On (Default)

- Dark grey grid lines
- 20x20 pixel cells
- Helps with precision
- Easier path planning
- Better for beginners

#### Grid Off

- Clean, minimal view
- More immersive
- Better for experienced players
- Sleeker aesthetic

**Toggle with 'G' key anytime!**

---

## 🎨 Visual Enhancements

### Snake Design

```
Head:
- Green color (#228B22)
- Direction-aware eyes
- Eye position changes with movement

Body:
- Alternating shades of green
- Segment 1: Light green (#90EE90)
- Segment 2: Medium green (#32CD32)
- Creates flowing motion effect
```

### Food Visuals

```
Regular Apple:
- Tomato red (#FF6347)
- Peachy highlight (#FFA07A)
- Two-tone circular design

Special Food:
- Gold (#FFD700)
- Yellow center (#FFFF00)
- Sparkle cross effect
```

### UI Elements

```
Score Display:
- Font: Ink Free, Bold, 28px
- White text with black shadow
- Always visible at top

High Score:
- Font: Ink Free, Bold, 20px
- Yellow color for emphasis
- Top-left position

Difficulty:
- Font: Ink Free, Bold, 20px
- Cyan color
- Below high score
```

---

## ⌨️ Complete Control Scheme

### Movement

| Input | Action     |
| ----- | ---------- |
| ↑ / W | Move Up    |
| ↓ / S | Move Down  |
| ← / A | Move Left  |
| → / D | Move Right |

### Game Control

| Input | Action                            |
| ----- | --------------------------------- |
| P     | Pause/Resume                      |
| G     | Toggle Grid                       |
| SPACE | Restart (after game over)         |
| ESC   | Difficulty Menu (after game over) |

---

## 📊 Scoring System

### Point Values

```
Regular Apple:    +1 point  (+1 segment)
Special Food:     +3 points (+2 segments)
```

### Score Progression Example

```
Game Start: 0 points, 6 segments

Eat 4 apples: 4 points, 10 segments
Eat special:  7 points, 12 segments (appears at 5th apple)
Eat 4 apples: 11 points, 16 segments
Eat special:  14 points, 18 segments (appears at 10th apple)
...and so on!
```

---

## 🎯 Game Mechanics Deep Dive

### Spawn System

```java
Regular Apples:
- Spawn at random grid position
- Never on snake body
- Immediate respawn after eating

Special Food:
- Triggers every 5 regular apples
- Random position (not on snake/apple)
- 100-tick lifetime
- Disappears if not collected
```

### Collision Detection

```
Walls:
- X < 0 or X >= 800
- Y < 0 or Y >= 600

Self-Collision:
- Head touches any body segment
- Checked every frame
```

### Movement System

```
1. Body segments shift to previous position
2. Head moves in current direction
3. Check food collision
4. Check wall/self collision
5. Update display
6. Repeat every [difficulty] milliseconds
```

---

## 🔧 Technical Features

### Performance

- Efficient grid-based rendering
- Minimal memory footprint
- No memory leaks
- Smooth 60+ FPS rendering

### Compatibility

- Java 8+ required
- Works on Windows, Mac, Linux
- No external dependencies
- Single file architecture

### Code Quality

- Well-commented code
- Modular design
- Easy to extend
- Following Java conventions

---

## 🚀 Planned Features

See [CONTRIBUTING.md](CONTRIBUTING.md) for a complete list of potential future features, including:

- Sound effects and music
- More power-ups
- Multiplayer mode
- Custom themes
- And much more!

---

## 💡 Feature Requests

Have an idea for a new feature?

1. Check if it's already in [CONTRIBUTING.md](CONTRIBUTING.md)
2. Open an issue on GitHub
3. Or even better - implement it yourself and submit a PR!

---

**Enjoy exploring all the features of Snake Mukbang!** 🐍🎮
