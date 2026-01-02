impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
      let mut counts = [0,0,0];
      for &num in nums.iter() {
        counts[num as usize] += 1
      } 
      let mut curr = 0;
      for (i, &v) in counts.iter().enumerate() {
        for _ in 0..v {
            nums[curr] = i as i32;
            curr += 1;
        }
      }
    }
}