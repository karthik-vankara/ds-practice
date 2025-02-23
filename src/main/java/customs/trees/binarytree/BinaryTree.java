package customs.trees.binarytree;

import java.util.Scanner;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
    }

    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter root node: ");
        int rootValue = scanner.nextInt();
        root = new Node(rootValue);
        insertNextNodes(root,scanner);
    }

    private void insertNextNodes(Node node, Scanner scanner) {
        System.out.print("Do you want to insert left of "+node.value+ " ??");
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.print("Enter left value: ");
            int leftVal = scanner.nextInt();
            Node leftNode = new Node(leftVal);
            node.left = leftNode;
            insertNextNodes(leftNode,scanner);
        }

        System.out.print("Do you want to insert right of "+node.value+" ??");
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.print("Enter right value: ");
            int rightVal = scanner.nextInt();
            Node rightNode = new Node(rightVal);
            node.right = rightNode;
            insertNextNodes(rightNode,scanner);
        }
    }

    public void display(){
        display(root,"");
    }

    private void display(Node node, String indent) {
        if(node == null){
            return;
        }
        System.out.println(indent+node.value);
        display(node.left,indent + "\t");
        display(node.right,indent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root,0);
    }

    private void prettyDisplay(Node node, int level) {
        if(node == null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);

    }

    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+"->");
        preOrder(node.left);
        preOrder(node.right);
        System.out.print("END");
    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+"->");
        inOrder(node.right);
        System.out.print("END");
    }

    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+"->");
        System.out.print("END");
    }


}
