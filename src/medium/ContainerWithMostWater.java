package medium;

public class ContainerWithMostWater {
	
	private static int maxArea(int[] height) {
		int len = height.length;
        if (len == 0 || len == 1)
            return 0;
        
        int maxarea = 0, left = 0, right = len - 1;
        while (left < right){
        	int shorter = Math.min(height[left], height[right]);
        	if (shorter * (right - left) > maxarea)
        		maxarea = shorter * (right - left);
        	if (height[left] < height[right])
        		left++;
        	else 
        		right--;
        }
        
		return maxarea;
    }
	
	
	public static void main(String args[]){
		int[] t = {1,2,3};
		System.out.println(maxArea(t));
		
		return;
	}
}
