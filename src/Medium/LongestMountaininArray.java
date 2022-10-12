class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length < 3) {
            return 0;
        }
        
        int[] up = new int[arr.length];
        int[] down = new int[arr.length];
        int res = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i - 1]) {
                up[i] = up[i - 1] + 1;
            }
        }
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] > arr[i + 1]) {
                down[i] = down[i + 1] + 1;
            }
            if(up[i] > 0 && down[i] > 0) {
                res = Math.max(res, up[i] + down[i] + 1);
            }
        }
        
        return res;
    }

    // Method 2: constant space, one loop
    public int longestMountain2(int[] arr) {
        if(arr.length < 3) {
            return 0;
        }
        
        int up = 0;
        int down = 0;
        int res = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] == arr[i]) {
                up = 0;
                down = 0;
            }
            if(down > 0 && arr[i - 1] < arr[i]) {
                up = 0;
                down = 0;
            }
            if(arr[i - 1] < arr[i]) {
                up++;
            }
            if(arr[i - 1] > arr[i]) {
                down++;
            }
            if(up > 0 && down > 0) {
                res = Math.max(res, up + down + 1);
            }
        }
        
        return res;
    }
}