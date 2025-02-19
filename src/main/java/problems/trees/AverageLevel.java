package problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevel {
    public static void main(String[] args) {

    }


//    Same as BFS just returning the average
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root ==  null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();
                levelSum +=node.val;
                if(node.left!= null){
                    queue.offer(node.left);
                }
                if(node.right!= null){
                    queue.offer(node.right);
                }
            }
            result.add(levelSum/levelSize);
        }
        return result;
    }
}
