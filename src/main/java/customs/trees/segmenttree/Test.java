package customs.trees.segmenttree;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3,4,9,2,7};
        SegmentTree segmentTree = new SegmentTree(arr);
        System.out.println(segmentTree.querySum(1,3));
//        segmentTree.display();
    }
}
