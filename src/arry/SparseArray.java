package arry;

import java.lang.reflect.Array;

/**
 * description: SparseArray
 * date: 2021/11/10 下午6:47
 * author: cc
 * 0,0,0,0,0,0,0,0,0,0
 * 0,0,1,0,0,0,0,0,0,0
 * 0,0,0,2,0,0,0,0,0,0
 * 0,0,0,0,0,0,0,0,0,0
 * 0,0,0,0,0,0,0,0,0,0
 * 0,0,0,0,0,0,0,0,0,0
 */

public class SparseArray {


    public static int[][] toSparseArray(int [][] region){
        int number = 0;
        int row = region.length;
        int column = region[0].length;

        for (int i = 0; i < row; i++) {
            for(int j=0;j<column;j++){
                if(region[i][j] != 0){
                    number +=1;
                }
            }
        }
        System.out.println("总共非0数字有" + number);

        int[][] target = new int[number+1][3];
        target[0][0] = row;
        target[0][1] = column;
        target[0][2] = number;

        int start = 1;
        for (int i = 0; i < row; i++) {
            for(int j=0;j<column;j++){
                if(region[i][j] != 0){
                    System.out.println("-------");
                    System.out.println(start);
                    target[start][0] = i;
                    target[start][1] = j;
                    target[start][2] = region[i][j];
                    start +=1;
                }
            }
        }
        for (int i = 0; i < number+1; i++) {
            for(int j=0;j<3;j++){
                System.out.printf("%d,",target[i][j]);
            }
            System.out.println();
        }
        return target;
    }
    
    public static int[][] parseSparseArray(int[][] sparseArray){
    	int row = sparseArray[0][0];
    	int column = sparseArray[0][1];
    	int number = sparseArray[0][2];
    	int[][] reginArray = new int[row][column];
    	for(int i=1;i<sparseArray.length;i++) {
    		int[] itemRow = sparseArray[i];
    		reginArray[itemRow[0]][itemRow[1]] = itemRow[2];
    	}
    	for(int[] item : reginArray){
            for(int ite:item){
                System.out.printf("%d,",ite);
            }
            System.out.println();
        }
    	return reginArray;
    			
    }
    public static void main(String[] args) {
        int row = 7;
        int column = 10;
        int[][] region = new int[row][column];
        region[1][2] = 1;
        region[2][3] = 2;
        for(int[] item : region){
            for(int ite:item){
                System.out.printf("%d,",ite);
            }
            System.out.println();
        }
        int[][] target = SparseArray.toSparseArray(region);
        SparseArray.parseSparseArray(target);
    }
}
