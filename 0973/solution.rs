use std::collections::BinaryHeap;


impl Solution {
    pub fn k_closest(points: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        let k = k as usize;
        let mut heap: BinaryHeap<(i32, usize)> = BinaryHeap::new();
        
        for (i, point) in points.iter().enumerate() {
            let dist = point[0].pow(2) + point[1].pow(2);
            heap.push((dist, i));
            if heap.len() > k {
                heap.pop();
            }
        }
        
        heap.into_iter()
            .map(|(_, index)| points[index].clone())
            .collect()
    }
}
