package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {
    private String makeLargestSpecial(String S) {
        if(S == null || S.isEmpty())
            return S;

        int special_state = 0;
        int start = 0;
        List<String> nums = new ArrayList<>();

        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '1')
                special_state++;
            else
                special_state--;

            if(special_state == 0){     // find a special substring
                nums.add("1" + makeLargestSpecial(S.substring(start + 1, i)) + "0"); // every special string must start with "1" and end with "0"
                start = i + 1;
            }
        }

        Collections.sort(nums, Collections.reverseOrder()); // larger number first
        StringBuilder sb = new StringBuilder();
        for(String s:nums)
            sb.append(s);

        return sb.toString();
    }
}
