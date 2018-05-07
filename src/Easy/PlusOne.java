package Easy;

public class PlusOne {
    private int[] plusOne(int[] digits) {
        int length = digits.length;
        if (length < 1 || digits == null)
            return digits;
        
        int cin = 1;
        for (int i = length - 1; i >= 0; i--){
            int newdigit = digits[i] + cin;
            if (newdigit >= 10){
                digits[i] = newdigit % 10;                
            }                
            else{
                cin = 0; 
                digits[i] = newdigit;
                break;
            }               
        }
        
        if (cin == 0){
            return digits;
        } else {
            int[] ans = new int[length + 1];
            ans[0] = 1;
            for (int i = 0; i < length; i++)
                ans[1+i] = digits[i];
            return ans;
        }        
    }
}
