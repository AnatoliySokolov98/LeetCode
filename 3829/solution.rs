use std::collections::{HashSet, VecDeque};

struct RideSharingSystem {
    drivers: VecDeque<i32>,
    riders: VecDeque<i32>,
    cancelled_riders: HashSet<i32>,
    active_riders: HashSet<i32>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl RideSharingSystem {
    fn new() -> Self {
        Self {
            drivers: VecDeque::new(),
            riders: VecDeque::new(),
            cancelled_riders: HashSet::new(),
            active_riders: HashSet::new(),
        }
    }

    fn add_rider(&mut self, rider_id: i32) {
        self.riders.push_back(rider_id);
        self.active_riders.insert(rider_id);
    }

    fn add_driver(&mut self, driver_id: i32) {
        self.drivers.push_back(driver_id);
    }

    fn match_driver_with_rider(&mut self) -> Vec<i32> {
        while let Some(rider) = self.riders.front() {
            if self.cancelled_riders.contains(rider) {
                self.riders.pop_front();
            } else {
                break;
            }
        }
        if !self.drivers.is_empty() && !self.riders.is_empty() {
            let rider = self.riders.pop_front().unwrap();
            let driver = self.drivers.pop_front().unwrap();
            return vec![driver, rider];
        }
        return vec![-1, -1];
    }

    fn cancel_rider(&mut self, rider_id: i32) {
        if self.active_riders.contains(&rider_id) {
            self.cancelled_riders.insert(rider_id);
        }
    }
}
