import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Initialize graphs and indegree arrays for rows and columns
        Map<Integer, Set<Integer>> rowGraph = new HashMap<>();
        Map<Integer, Set<Integer>> colGraph = new HashMap<>();
        int[] rowIndegrees = new int[k];
        int[] colIndegrees = new int[k];

        for (int i = 1; i <= k; i++) {
            rowGraph.put(i, new HashSet<>());
            colGraph.put(i, new HashSet<>());
        }

        // Fill in the graphs and indegree arrays based on conditions
        for (int[] condition : rowConditions) {
            int x = condition[0];
            int y = condition[1];
            if (rowGraph.get(x).add(y)) {
                rowIndegrees[y - 1]++;
            }
        }

        for (int[] condition : colConditions) {
            int x = condition[0];
            int y = condition[1];
            if (colGraph.get(x).add(y)) {
                colIndegrees[y - 1]++;
            }
        }

        // Perform topological sort for rows
        List<Integer> rowOrder = topologicalSort(k, rowGraph, rowIndegrees);
        if (rowOrder.size() != k) {
            return new int[0][0];
        }

        // Perform topological sort for columns
        List<Integer> colOrder = topologicalSort(k, colGraph, colIndegrees);
        if (colOrder.size() != k) {
            return new int[0][0];
        }

        // Construct the matrix based on row and column orders
        int[][] res = new int[k][k];
        Map<Integer, Integer> colLocs = new HashMap<>();
        for (int i = 0; i < colOrder.size(); i++) {
            colLocs.put(colOrder.get(i), i);
        }
        for (int i = 0; i < rowOrder.size(); i++) {
            res[i][colLocs.get(rowOrder.get(i))] = rowOrder.get(i);
        }

        return res;
    }

    private List<Integer> topologicalSort(int k, Map<Integer, Set<Integer>> graph, int[] indegrees) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> bfs = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (indegrees[i] == 0) {
                bfs.add(i + 1);
            }
        }

        while (!bfs.isEmpty()) {
            int node = bfs.poll();
            order.add(node);
            for (int child : graph.get(node)) {
                indegrees[child - 1]--;
                if (indegrees[child - 1] == 0) {
                    bfs.add(child);
                }
            }
        }
        return order;
    }
}

// time O(r + c + k)
// space O(r + c + k)
