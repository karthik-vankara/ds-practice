package problems.trees;

import java.util.*;

public class ZigZagLevelOrder {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();

        if(root == null){
            return resultList;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                if(!reverse){
                    TreeNode node = queue.pollFirst();
                    levelList.add(node.val);
                    if(node.left != null){
                        queue.addLast(node.left);
                    }
                    if(node.right != null){
                        queue.addLast(node.right);
                    }
                }else{
                    TreeNode node = queue.pollLast();
                    levelList.add(node.val);
                    if(node.right != null){
                        queue.addFirst(node.right);
                    }
                    if(node.left != null){
                        queue.addFirst(node.left);
                    }

                }
            }
            reverse = !reverse;
            resultList.add(levelList);
        }
        return resultList;
    }
}
