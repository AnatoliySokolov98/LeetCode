impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        let (rows, cols) = (matrix.len(), matrix[0].len());
        let mut row = rows;
        let (mut left, mut right) = (0, rows - 1);

        while left <= right && right != usize::MAX {
            let pivot = left + (right - left) / 2;
            if matrix[pivot][0] <= target && target <= matrix[pivot][cols - 1] {
                row = pivot;
                break;
            }
            if matrix[pivot][0] > target {
                right = pivot.wrapping_sub(1);
            } else {
                left = pivot + 1;
            }
        }
        if row == rows {
            return false;
        }

        (left, right) = (0, cols - 1);

        while left <= right && right != usize::MAX {
            let pivot = left + (right - left) / 2;
            if matrix[row][pivot] == target {
                return true;
            }
            if matrix[row][pivot] > target {
                right = pivot.wrapping_sub(1);
            } else {
                left = pivot + 1;
            }
        }
        return false;
    }
}
