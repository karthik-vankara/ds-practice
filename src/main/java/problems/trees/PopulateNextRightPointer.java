package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {

        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Node temp = root;
        queue.offer(temp);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if(i == levelSize-1){
                    node.next = null;
                }else {
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }

            }
        }
        return root;
    }

    public Node connectWithOutUsingQueue(Node root) {

        if(root == null){
            return null;
        }

        Node leftLast = root;

        while (leftLast.left != null){
            Node currentNode = leftLast;
            while (currentNode != null){
                currentNode.left.next = currentNode.right;
                if(currentNode.next != null){
                    currentNode.right.next = currentNode.next.left;
                }
                currentNode = currentNode.next;
            }
            leftLast = leftLast.left;
        }

        return root;
    }
}


