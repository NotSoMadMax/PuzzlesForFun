package medium;

public class FruitIntoBaskets {
    private int totalFruit(int[] tree) {
        if(tree == null || tree.length < 1)
            return 0;
        
        int left = 0, right = -1;
        int res = 0;
        for(int i = 1; i < tree.length; i++){
            if(tree[i] != tree[i-1]){
                if(right > -1 && tree[right] != tree[i]){
                    res = Math.max(res, i - left);
                    left = right + 1;
                }
                right = i - 1;
            }
        }
        return Math.max(res, tree.length - left);
    }
}
