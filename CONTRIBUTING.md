# Contributing to Snake Mukbang 🐍🍜

First off, thank you for considering contributing to Snake Mukbang! This project is part of **Hacktoberfest 2025**, and we welcome contributions from developers of all skill levels.

## 🎯 How Can I Contribute?

### 1. Reporting Bugs 🐛

If you find a bug, please create an issue with the following information:

- A clear and descriptive title
- Steps to reproduce the bug
- Expected behavior vs actual behavior
- Screenshots (if applicable)
- Your Java version and operating system

### 2. Suggesting Enhancements 💡

Have an idea to make the game better? Create an issue with:

- A clear description of the enhancement
- Why this enhancement would be useful
- Any relevant examples or mockups

### 3. Code Contributions 💻

#### Getting Started

1. **Fork the repository** to your GitHub account
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/YOUR_USERNAME/Snake-Mukbang.git
   cd Snake-Mukbang
   ```
3. **Create a new branch** for your feature:
   ```bash
   git checkout -b feature/your-feature-name
   ```

#### Making Changes

1. Make your changes in your feature branch
2. Test your changes thoroughly
3. Ensure the code compiles without errors:
   ```bash
   javac SnakeMukbang.java
   java SnakeMukbang
   ```
4. Follow the existing code style and conventions

#### Submitting Changes

1. **Commit your changes** with a clear commit message:

   ```bash
   git add .
   git commit -m "Add: Brief description of your changes"
   ```

   Use these prefixes for commit messages:

   - `Add:` for new features
   - `Fix:` for bug fixes
   - `Update:` for updates to existing features
   - `Refactor:` for code refactoring
   - `Docs:` for documentation changes

2. **Push to your fork**:

   ```bash
   git push origin feature/your-feature-name
   ```

3. **Create a Pull Request** on the main repository
   - Provide a clear title and description
   - Reference any related issues
   - Include screenshots or GIFs if applicable

## 🎨 Feature Ideas

Looking for something to work on? Here are some ideas:

### Beginner-Friendly

- [ ] Add sound effects (eating, game over)
- [ ] Create different color themes
- [ ] Add a help/instructions screen
- [ ] Implement different snake skins
- [ ] Add a FPS counter

### Intermediate

- [ ] Background music with volume controls
- [ ] Power-ups (speed boost, slow-motion, shield)
- [ ] Different food types (fruits, vegetables)
- [ ] Obstacles that appear randomly
- [ ] Speed increases gradually with score
- [ ] Save/load game state

### Advanced

- [ ] Multiplayer mode (local)
- [ ] Level designs with different maps
- [ ] Online leaderboard integration
- [ ] AI opponent mode
- [ ] Achievement system
- [ ] Game replay system
- [ ] Mobile/touch controls support

## 📝 Code Style Guidelines

### Java Conventions

- Use **camelCase** for variable and method names
- Use **PascalCase** for class names
- Use **UPPER_SNAKE_CASE** for constants
- Add comments for complex logic
- Keep methods focused and concise
- Use meaningful variable names

### Example:

```java
// Good
public void spawnSpecialFood() {
    specialFoodX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
    specialFoodY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
}

// Avoid
public void ssf() {
    int x = random.nextInt(800 / 20) * 20;
    int y = random.nextInt(600 / 20) * 20;
}
```

## 🧪 Testing Guidelines

Before submitting your PR, please test:

- [ ] Game starts without errors
- [ ] All controls work as expected
- [ ] Game over screen displays correctly
- [ ] High score saves and loads properly
- [ ] No crashes during normal gameplay
- [ ] Works on different screen sizes (if applicable)
- [ ] Your new feature works in all difficulty modes

## 🏷️ Hacktoberfest Guidelines

To ensure your PR counts for Hacktoberfest:

- Make sure your PR is meaningful (no spam or trivial changes)
- Follow the quality standards outlined in this guide
- Be respectful and professional in all interactions
- PRs that don't follow these guidelines may be marked as `invalid`

## ❓ Questions?

If you have questions about contributing:

- Open an issue with the `question` label
- Check existing issues and PRs
- Read the README.md for project details

## 🙏 Thank You!

Your contributions help make Snake Mukbang better for everyone. We appreciate your time and effort!

Happy coding! 🎮🐍
