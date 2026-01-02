impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        let mut gas_total = 0;
        let mut cost_total = 0;
        let mut start_index = 0;
        let mut curr_gas = 0;

        for i in 0..gas.len() {
            gas_total += gas[i];
            cost_total += cost[i];
            curr_gas += gas[i] - cost[i];
            if curr_gas < 0 {
                start_index = i + 1;
                curr_gas = 0;
            }
        }
        if gas_total >= cost_total {
            return start_index as i32;
        }
        return -1;
    }
}
