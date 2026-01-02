#[derive(Clone, Copy)]
enum Direction {
    Right,
    Down,
    Left,
    Up,
}

impl Direction {
    fn next_direction(self) -> Direction {
        match self {
            Direction::Right => Direction::Down,
            Direction::Down => Direction::Left,
            Direction::Left => Direction::Up,
            Direction::Up => Direction::Right,
        }
    }
}

impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        let (rows, cols) = (matrix.len(), matrix[0].len());
        let (mut row, mut col) = (0, 0);
        let total_elements = rows * cols;
        let mut top = 0;
        let mut bot = rows - 1;
        let mut left = 0;
        let mut right = cols - 1;
        let mut res: Vec<i32> = Vec::with_capacity(total_elements);
        let mut direction = Direction::Right;
        while res.len() < total_elements {
            res.push(matrix[row][col]);
            let on_border = match direction {
                Direction::Right => col == right,
                Direction::Down => row == bot,
                Direction::Left => col == left,
                Direction::Up => row == top,
            };

            if on_border {
                match direction {
                    Direction::Right => top += 1,
                    Direction::Down => right -= 1,
                    Direction::Left => bot -= 1,
                    Direction::Up => left += 1,
                };
                direction = direction.next_direction();
            }

            match direction {
                Direction::Right => col += 1,
                Direction::Down => row += 1,
                Direction::Left => col -= 1,
                Direction::Up => row -= 1,
            };
        }
        return res;
    }
}
