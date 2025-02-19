package problems.trees;

public class CousinsInBT {
    public static void main(String[] args) {

    }
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode node1 = findNode(root,x);
        TreeNode node2 = findNode(root,y);

        return ((level(root,node1,0) == level(root,node2,0)) && !isSiblings(root,node1,node2));
    }

    public TreeNode findNode(TreeNode root, int key) {
        TreeNode node = root;
        if(node == null ){
            return null;
        }
        if(node.val == key){
            return node;
        }
        TreeNode left = findNode(node.left,key);
        if(left != null){
            return left;
        }
        return findNode(node.right,key);
    }

    public boolean isSiblings(TreeNode node, TreeNode x, TreeNode y){
        if(node == null){
            return false;
        }
        return ((node.left == x && node.right == y) || (node.left == y && node.right == x)
        || isSiblings(node.left,x,y) || isSiblings(node.right,x,y)
        );
    }

    public int level(TreeNode node, TreeNode x, int lev){
        if(node == null){
            return 0;
        }
        if(node == x){
            return lev;
        }
        int l = level(node.left,x,lev+1);
        if(l != 0){
            return l;
        }
        return level(node.right,x,lev+1);
    }

}
