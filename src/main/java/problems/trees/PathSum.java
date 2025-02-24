package problems.trees;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }

        int leftSum = sumNumbersHelper(node.left, sum);
        int rightSum = sumNumbersHelper(node.right, sum);

        return leftSum + rightSum;
    }


    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxPathSum;
    }

    private int maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxPathSumHelper(node.left);
        int right = maxPathSumHelper(node.right);

//        Ignoring negative numbers for both left and right
        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + node.val;
        maxPathSum = Math.max(pathSum, maxPathSum);

        return Math.max(left, right) + node.val;

    }

    public boolean isPathExists(TreeNode root, int[] path){
        if(root == null){
            return false;
        }
        return isPathExistsHelper(root,path,0);
    }

    private boolean isPathExistsHelper(TreeNode node, int[] path, int index) {
        if(node == null){
            return false;
        }
        if(node.val != path[index] || index >= path.length){
            return false;
        }
        if(node.left == null && node.right == null && index == path.length-1){
            return true;
        }

        return isPathExistsHelper(node.left,path,index+1)
                || isPathExistsHelper(node.right,path,index+1);
    }


}
