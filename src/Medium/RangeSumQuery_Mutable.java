package medium;

class NumArray {
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        if(nums == null || nums.length < 1)
            return;

        n = nums.length;
        tree = new int[n*2];

        // for leaves
        for(int i = 0; i < n; i++)
            tree[n + i] = nums[i];

        // for other nodes
        for(int i = n - 1; i > 0; i--)  // pos 0 is not used
            tree[i] = tree[2*i] + tree[2*i+1];
    }


    public void update(int i, int val) {
        i = i + n; // corresponding leaf
        tree[i] = val;
        while (i > 0){
            int left = i, right = i;
            if(i%2 == 0)    // i is a left child
                right = i + 1;
            else            // i is a right child
                left = i - 1;

            tree[left/2] = tree[left] + tree[right];
            i = i/2;
        }
    }

    public int sumRange(int i, int j) {
        i = i + n;
        j = j + n;
        int sum = 0;

        while (i <= j){
            if(i%2 == 1){   // if left boundary is a right child, don't need its whole parent value
                sum += tree[i];
                i++;
            }
            if(j%2 == 0){   // if right boundary is a left child
                sum += tree[j];
                j--;
            }

            i = i/2;
            j = j/2;
        }

        return sum;
    }
}

public class RangeSumQuery_Mutable {

}
