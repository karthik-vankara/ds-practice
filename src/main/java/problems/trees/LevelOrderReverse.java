package problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderReverse {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root ==  null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> levelResult = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i <levelSize ; i++) {
                TreeNode node = queue.poll();
                levelResult.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(0,levelResult);
        }

        return result;

    }
}
