public class ReverseBits {
    
    public int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        int len = binaryString.length();
        
        long result = 0;
        int digitLocation = 0;
        for(int i = 32 - len; i < 32; i++) {
            result += Math.pow(2, i) * (binaryString.charAt(digitLocation++) - '0');
        }
        
        return (int) result;
    }
}
