use std::collections::BinaryHeap;

impl Solution {
    pub fn min_meeting_rooms(mut intervals: Vec<Vec<i32>>) -> i32 {
        intervals.sort();
        let mut heap = BinaryHeap::new();
        for interval in intervals {
            if heap.peek().is_some_and(|&val| (-1 * val) <= interval[0]) {
                heap.pop();
            }
            heap.push(-interval[1]);
        }
        heap.len() as i32
    }
}
