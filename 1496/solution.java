class Solution {
    public boolean isPathCrossing(String path) {
        Set<Long> visited = new HashSet<>();
        long x = 0;
        long y = 0;
        visited.add(x + (y * 10000));
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                x--;
            } else if (path.charAt(i) == 'S') {
                x++;
            } else if (path.charAt(i) == 'E') {
                y++;
            } else {
                y--;
            }

            if (visited.contains(x + (y * 10000))) {
                return true;
            }
            visited.add(x + (y * 10000));
        }
        return false;
    }
}