package customs.trees.binarytree;

public class BinaryTest {
    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.insert();
//        binaryTree.prettyDisplay();

//        BinarySearchTree binarySearchTree =new BinarySearchTree();
//        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
//        binarySearchTree.pupulate(nums);
//        binarySearchTree.display();

        AVL avlTree = new AVL();
        for (int i = 0; i < 1000; i++) {
            avlTree.insert(i);
        }
//        Its wrong, need to check the implementation
        System.out.println(avlTree.height());
    }
}
