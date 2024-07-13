import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            robots.add(new int[] { positions[i], healths[i], directions.charAt(i), i });
        }
        robots.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> stack = new ArrayList<>();
        for (int[] robot : robots) {
            int health = robot[1];
            char direction = (char) robot[2];
            int index = robot[3];
            if (direction == 'R') {
                stack.add(new int[] { health, direction, index });
            } else {
                while (!stack.isEmpty() && stack.getLast()[1] == 'R' && health > 0) {
                    int[] lastRobot = stack.getLast();
                    if (health > lastRobot[0]) {
                        health -= 1;
                        stack.removeLast();
                    } else if (health < lastRobot[0]) {
                        lastRobot[0] -= 1;
                        health = 0;
                    } else {
                        stack.removeLast();
                        health = 0;
                    }
                }
                if (health > 0) {
                    stack.add(new int[] { health, direction, index });
                }
            }
        }
        List<int[]> survivedRobots = new ArrayList<>(stack);
        survivedRobots.sort(Comparator.comparingInt(a -> a[2]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : survivedRobots) {
            result.add(robot[0]);
        }

        return result;
    }
}

// time O(nlogn)
// space O(n)