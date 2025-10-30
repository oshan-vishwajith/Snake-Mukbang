# 🎯 Combo Scoring System - Feature Documentation

## Overview
The combo scoring system rewards players for eating food quickly, adding a skill-based scoring mechanic that increases replay value and competitive gameplay.

## How It Works

### Speed Thresholds
- **Fast (<15 moves)**: 2x score multiplier, combo counter increases
- **Normal (15-30 moves)**: 1x score multiplier, combo resets to 1
- **Slow (>30 moves)**: 1x score multiplier, combo breaks (resets to 0)

### Scoring Examples

#### Regular Apple
- **Base Points**: 1
- **With Combo**: 2 points (when eating quickly)

#### Special Golden Food
- **Base Points**: 3
- **With Combo**: 6 points (when eating quickly)

### Combo Messages
As your combo increases, you'll see motivational messages:
- **2x Combo**: "FAST x2!"
- **3-4x Combo**: "GREAT x3!" / "GREAT x4!"
- **5+ Combo**: "AMAZING x5!", "AMAZING x6!", etc.

### Visual Feedback

#### Combo Counter (Top Right)
- Displays current combo multiplier
- Orange text: "Combo x[number]!"
- Only shows when combo is 2 or higher

#### Combo Messages (Center Screen)
- Large golden text appears when achieving combo
- Fades out after 30 frames (~2-3 seconds)
- Shadow effect for better visibility
- Messages get more exciting with higher combos

## Strategy Tips

1. **Plan Your Path**: Think ahead to reach food faster
2. **Avoid Long Routes**: More moves = combo breaks
3. **Risk vs. Reward**: Sometimes a longer safe route loses the combo
4. **Golden Food Priority**: 6 points with combo is huge!
5. **Difficulty Matters**: Harder modes = faster gameplay = easier to maintain combos

## Technical Implementation

### New Variables
```java
int comboCount = 0;              // Current combo multiplier
int movesSinceLastFood = 0;      // Tracks movement speed
int comboDisplayTimer = 0;       // Controls message fade out
String comboMessage = "";        // The message to display
```

### Constants
```java
COMBO_THRESHOLD_FAST = 15;       // Moves for 2x multiplier
COMBO_THRESHOLD_NORMAL = 30;     // Max moves before combo breaks
```

### Core Method
```java
public int calculatePoints(int basePoints)
```
- Evaluates speed since last food
- Determines combo status
- Returns adjusted points
- Updates combo counter
- Sets display messages

## Game Balance

### Easy Mode (120ms delay)
- Easier to maintain combos
- More time to plan routes
- Great for learning the system

### Medium Mode (90ms delay)
- Balanced combo opportunities
- Requires strategic planning
- Recommended for experienced players

### Hard Mode (60ms delay)
- Fast gameplay
- Combos happen naturally due to speed
- High-score potential
- Expert challenge

## Impact on Gameplay

### Before Combo System
- Linear scoring: 1 apple = 1 point
- High scores based purely on survival
- Less emphasis on speed

### After Combo System
- Dynamic scoring: 1 apple = 1-2 points
- High scores reward both survival AND speed
- Adds skill-based progression
- More engaging gameplay loop

## Future Enhancements

Potential improvements:
- Sound effects for combo milestones
- Visual combo meter/bar
- Combo preservation on special food
- Leaderboard with combo tracking
- Achievement system for high combos
- Combo-based color changes for snake

## Comparison with Other Features

| Feature | Impact | Complexity | Fun Factor |
|---------|--------|-----------|-----------|
| Combo System | High | Medium | ⭐⭐⭐⭐⭐ |
| Difficulty Levels | High | Low | ⭐⭐⭐⭐ |
| Special Food | High | Medium | ⭐⭐⭐⭐ |
| High Score | Medium | Low | ⭐⭐⭐ |
| Pause | Low | Low | ⭐⭐⭐ |
| Grid Toggle | Low | Low | ⭐⭐ |

The combo system significantly increases the fun factor by adding a skill-based element that rewards quick thinking and efficient pathing.

---

**This feature transforms Snake Mukbang from a simple survival game into a skill-based arcade experience!** 🎮✨
