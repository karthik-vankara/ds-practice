package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {

    static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int[][] copy = new int[a.size()][a.get(0).size()];

        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.get(0).size();j++){
                copy[i][j] = a.get(i).get(j);
            }
        }

        for(int i=0;i<copy.length;i++){
            for(int j=0;j<copy[0].length;j++){
                if(copy[i][j] == 0){
                    updateZeroes(i,j,a);
                }
            }
        }
    }

    static void updateZeroes(int row,int col, ArrayList<ArrayList<Integer>> a){
        //row
        for(int i=0;i<a.get(0).size();i++){
            a.get(row).set(i,0);
        }

        //col
        for(int i=0;i<a.size();i++){
            a.get(i).set(col,0);
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inp = new ArrayList<>();
        ArrayList<Integer> r1 = new ArrayList<>();
        r1.addAll(Arrays.asList(1,1,0));
        ArrayList<Integer> r2 = new ArrayList<>();
        r2.addAll(Arrays.asList(0,1,1));
        ArrayList<Integer> r3 = new ArrayList<>();
        r3.addAll(Arrays.asList(1,1,1));

        inp.addAll(Arrays.asList(r1,r2,r3));

        System.out.println(inp);
        ArrayListTest.setZeroes(inp);
        System.out.println(inp);

    }
}
