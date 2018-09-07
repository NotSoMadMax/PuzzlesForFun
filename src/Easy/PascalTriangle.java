package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PascalTriangle {
    private List<List<Integer>> generate(int numRows) {
        if(numRows < 1)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> temp = new ArrayList<>();
        temp.add(1);

        result.add(new ArrayList<>(temp));
        if (numRows == 1)
            return result;

        temp.add(1);
        result.add(new ArrayList<>(temp));
        if (numRows == 2)
            return result;

        for (int i = 3; i <= numRows; i++){
            List<Integer> this_row = new ArrayList<Integer>();
            for(int j = 0; j < i; j++){
                if(j == 0 || j == i - 1)
                    this_row.add(1);
                else
                    this_row.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
            }
            result.add(this_row);
        }

        return result;
    }
}
