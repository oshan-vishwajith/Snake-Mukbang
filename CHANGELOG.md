# Changelog

All notable changes to Snake Mukbang will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [2.0.0] - 2025-10-31

### Added - Hacktoberfest 2025 Features

- **Multiple Difficulty Levels**: Easy, Medium, and Hard modes with different speeds
  - Easy mode: 120ms delay
  - Medium mode: 90ms delay
  - Hard mode: 60ms delay
- **Persistent High Score System**: Scores are now saved to `highscore.dat` file
- **Special Bonus Food**: Golden food that appears every 5 regular apples
  - Awards +3 points (instead of 1)
  - Adds +2 body segments (instead of 1)
  - Time-limited availability (disappears after 100 game ticks)
  - Golden visual design with star effects
- **Pause Functionality**: Press 'P' to pause/resume the game
- **Grid Toggle**: Press 'G' to show/hide grid overlay
- **Enhanced Visual Effects**:
  - Grid overlay for better navigation
  - High score display on game screen
  - Difficulty indicator on screen
  - Pause screen overlay
  - Improved game over screen with high score
- **Additional Controls**:
  - ESC key to return to difficulty menu after game over
  - Grid toggle with 'G' key
  - Pause/resume with 'P' key
- **Documentation**:
  - Comprehensive README with all features
  - CONTRIBUTING.md guide for Hacktoberfest participants
  - LICENSE file (MIT)
  - This CHANGELOG file

### Changed

- Updated game initialization to show difficulty menu on startup
- Improved game over screen to display both current score and high score
- Enhanced score display with better formatting
- Updated README with new features and improved structure

### Fixed

- Special food now correctly avoids spawning on snake body or regular apple
- High score properly updates when game ends
- Timer properly restarts when selecting new difficulty

## [1.0.0] - Initial Release

### Added

- Basic Snake game functionality
- WASD and Arrow key controls
- Score tracking
- Apple spawning system
- Collision detection (walls and self)
- Game over screen
- Restart functionality with SPACE key
- Direction-aware snake head with eyes
- Colored snake body with alternating segments
- Simple UI with score display

---

## Future Plans

See [CONTRIBUTING.md](CONTRIBUTING.md) for a list of planned features and how to contribute!
