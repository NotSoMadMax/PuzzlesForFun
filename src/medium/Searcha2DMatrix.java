package medium;

public class Searcha2DMatrix {
	
	private static int[] rc (int index, int r, int c){
		int[] ans = new int[2];
		ans[0] = index/r;
		ans[1] = index - c*ans[0];
		return ans;
	}
	
	 public boolean searchMatrix(int[][] matrix, int target) {
       int r = matrix.length;
       if (r < 1 || matrix == null)
           return false;
       int c = matrix[0].length;
       if (c < 1 || matrix[0] == null)
           return false;	
       
       	 int l = 0, h = r * c - 1;
	     int m =  h/2;
	     int pre_m = m;
	     
	     while (l <= h){
	         m = l + (h - l)/2;
	         int[] coor = rc(m, r, c);
	        		 
	         if (matrix[coor[0]][coor[1]] == target)
	             return true;
	         if (m == pre_m && l != 0)
	             break;
	         if (matrix[coor[0]][coor[1]] > target)
	             h = m - 1;
	         else
	             l = m + 1;
	         pre_m = m;
	     }
       
	     return false;
	 }
	 
	 
	 
	// 30%
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int r = matrix.length;
//        if (r < 1 || matrix == null)
//            return false;
//        int c = matrix[0].length;
//        if (c < 1 || matrix[0] == null)
//            return false;
//        
//        if(r == 1 && c == 1)
//            return matrix[0][0] == target;
//        if (matrix[r - 1][c - 1] < target)
//            return false;
//        
//        int row = 0;
//        while(matrix[row][c - 1] < target && row < r){
//            row++;
//        }
//        
//        int m =  (c - 1)/2;
//        int pre_m = m;
//        int l = 0, h = c - 1;
//        while (l <= h){
//            m = l + (h - l)/2;
//
//            if (matrix[row][m] == target)
//                return true;
//            if (m == pre_m && l != 0)
//                break;
//            if (matrix[row][m] > target)
//                h = m - 1;
//            else
//                l = m + 1;
//            pre_m = m;
//        }
//        
//        return false;
//    }
}
