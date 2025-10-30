import unittest
import sys
import os

# Add the parent directory to the path so we can import the game
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

# Set SDL to use dummy video driver for headless testing
os.environ['SDL_VIDEODRIVER'] = 'dummy'
os.environ['SDL_AUDIODRIVER'] = 'dummy'

import snake_game

class TestSnakeGame(unittest.TestCase):
    def test_snake_initialization(self):
        """Test that Snake initializes correctly"""
        snake = snake_game.Snake()
        self.assertEqual(snake.length, 1)
        self.assertEqual(len(snake.positions), 1)
        self.assertEqual(snake.score, 0)
        self.assertIn(snake.direction, [snake_game.UP, snake_game.DOWN, 
                                         snake_game.LEFT, snake_game.RIGHT])

    def test_snake_turn(self):
        """Test that snake can turn"""
        snake = snake_game.Snake()
        snake.direction = snake_game.UP
        
        # Should allow turning left
        snake.turn(snake_game.LEFT)
        self.assertEqual(snake.direction, snake_game.LEFT)
        
        # Should allow turning up
        snake.turn(snake_game.UP)
        self.assertEqual(snake.direction, snake_game.UP)

    def test_snake_no_reverse(self):
        """Test that snake cannot reverse direction when length > 1"""
        snake = snake_game.Snake()
        snake.length = 2
        snake.positions = [(400, 300), (400, 320)]
        snake.direction = snake_game.UP
        
        # Should not allow reversing (turning down when moving up)
        snake.turn(snake_game.DOWN)
        self.assertEqual(snake.direction, snake_game.UP)

    def test_snake_movement(self):
        """Test that snake moves correctly"""
        snake = snake_game.Snake()
        initial_pos = snake.get_head_position()
        snake.direction = snake_game.RIGHT
        snake.move()
        new_pos = snake.get_head_position()
        
        # Head should have moved to the right
        self.assertEqual(new_pos[0], (initial_pos[0] + snake_game.GRID_SIZE) % snake_game.SCREEN_WIDTH)

    def test_snake_reset(self):
        """Test that snake resets correctly"""
        snake = snake_game.Snake()
        snake.length = 5
        snake.score = 100
        snake.positions = [(100, 100), (100, 120), (100, 140), (100, 160), (100, 180)]
        
        snake.reset()
        
        self.assertEqual(snake.length, 1)
        self.assertEqual(snake.score, 0)
        self.assertEqual(len(snake.positions), 1)

    def test_food_initialization(self):
        """Test that Food initializes correctly"""
        food = snake_game.Food()
        self.assertIsNotNone(food.position)
        self.assertEqual(len(food.position), 2)
        self.assertEqual(food.color, snake_game.RED)

    def test_food_position_in_bounds(self):
        """Test that food position is within screen bounds"""
        food = snake_game.Food()
        x, y = food.position
        
        self.assertGreaterEqual(x, 0)
        self.assertLess(x, snake_game.SCREEN_WIDTH)
        self.assertGreaterEqual(y, 0)
        self.assertLess(y, snake_game.SCREEN_HEIGHT)

    def test_constants(self):
        """Test that game constants are defined"""
        self.assertEqual(snake_game.SCREEN_WIDTH, 800)
        self.assertEqual(snake_game.SCREEN_HEIGHT, 600)
        self.assertEqual(snake_game.GRID_SIZE, 20)
        self.assertIsNotNone(snake_game.BLACK)
        self.assertIsNotNone(snake_game.WHITE)
        self.assertIsNotNone(snake_game.RED)
        self.assertIsNotNone(snake_game.GREEN)

if __name__ == '__main__':
    unittest.main()
