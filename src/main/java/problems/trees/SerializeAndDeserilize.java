package problems.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SerializeAndDeserilize {
    public static void main(String[] args) {

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        inOrderHelperToSerialize(root,list);
        return String.join(",", list);
    }

    public void inOrderHelperToSerialize(TreeNode node,List<String> list){
        if(node == null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        inOrderHelperToSerialize(node.left,list);
        inOrderHelperToSerialize(node.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.reverse(list);
        TreeNode root = helperToDeserialize(list);
        return root;
    }

    public TreeNode helperToDeserialize(List<String> list){
        if(list.size() == 0){
            return null;
        }

        String value = list.remove(list.size()-1);
        if(value.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = helperToDeserialize(list);
        node.right = helperToDeserialize(list);

        return node;
    }
}
