class Solution {
    String startPath = "";
    String endPath = "";
    StringBuilder path = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        traverse(root, startValue, destValue);
        int i = 0;
        while (i < startPath.length() && i < endPath.length() && startPath.charAt(i) == endPath.charAt(i)) {
            i++;
        }
        int stepsUp = startPath.length() - i;
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < stepsUp; j++) {
            result.append('U');
        }
        return result.toString() + endPath.substring(i);
    }

    private void traverse(TreeNode node, int startValue, int destValue) {
        if (node.val == startValue) {
            startPath = path.toString();
        }

        if (node.val == destValue) {
            endPath = path.toString();
        }

        if (node.left != null) {
            path.append('L');
            traverse(node.left, startValue, destValue);
            path.deleteCharAt(path.length() - 1);
        }

        if (node.right != null) {
            path.append('R');
            traverse(node.right, startValue, destValue);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
