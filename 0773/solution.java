import java.util.HashMap;
import java.util.Map;

class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder state = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                state.append(board[i][j]);
            }
        }

        Map<Integer, int[]> moves = new HashMap<>();
        moves.put(0, new int[] { 1, 3 });
        moves.put(1, new int[] { 0, 2, 4 });
        moves.put(2, new int[] { 1, 5 });
        moves.put(3, new int[] { 0, 4 });
        moves.put(4, new int[] { 1, 3, 5 });
        moves.put(5, new int[] { 2, 4 });

        Map<String, Integer> visited = new HashMap<>();
        dfs(state.toString(), 0, moves, visited);
        return visited.getOrDefault("123450", -1);
    }

    private void dfs(String state, int currMoves, Map<Integer, int[]> moves, Map<String, Integer> visited) {
        if (state.equals("123450")) {
            visited.put(state, Math.min(visited.getOrDefault(state, Integer.MAX_VALUE), currMoves));
            return;
        }

        if (visited.containsKey(state) && visited.get(state) <= currMoves) {
            return;
        }

        visited.put(state, currMoves);
        int zeroLocation = state.indexOf('0');
        int[] possibleMoves = moves.get(zeroLocation);

        for (int newLoc : possibleMoves) {
            char[] stateArray = state.toCharArray();
            char temp = stateArray[newLoc];
            stateArray[newLoc] = '0';
            stateArray[zeroLocation] = temp;
            String newState = new String(stateArray);
            dfs(newState, currMoves + 1, moves, visited);
        }
    }
}

// time O(mn!^2)
// space O(mn!)