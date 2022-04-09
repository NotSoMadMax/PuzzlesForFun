class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        int len = binaryString.length();
        
        int result = 0;
        for(int i = 0; i < len; i++) {
            if(binaryString.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

    public int hammingWeight2(int n) {
        
        int result = 0;
        while(n != 0) {
            result += (n & 1);
            n = n >>> 1; // since it's unsigned, don't keep the sign bit
        }

        return result;
    }
}
