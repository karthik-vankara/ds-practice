package customs.trees.binarytree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
    }

    public static class Node{
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void pupulate(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

//     if arry is sorted
    public void pupulateSorted(int[] arr){
        pupulateSorted(arr,0,arr.length);
    }

    public void pupulateSorted(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        this.insert(mid);
        pupulateSorted(arr,start,mid);
        pupulateSorted(arr,mid+1,end);
    }


    public void insert(int value){
        root = insert(value,root);
    }
    public Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(value,node.left);
        }else{
            node.right = insert(value,node.right);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        return node;
    }

    public boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        return Math.max(height(node.left),height(node.right)) <=1 && isBalanced(node.left) && isBalanced((node.right));
    }

    public void display(){
        display(root,"Root node: ");
    }

    private void display(Node node, String indent) {
        if(node == null){
            return;
        }
        System.out.println(indent+node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");

    }
}
