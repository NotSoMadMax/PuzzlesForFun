package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PascalTriangleII {
    private List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0)
            return Collections.emptyList();

        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if(rowIndex == 0)
            return result;

        for (int i = 1; i <= rowIndex; i++){
            List<Integer> this_row = new ArrayList<Integer>();
            this_row.add(1);

            for (int j = 1; j < i; j++){
                this_row.add(result.get(j - 1) + result.get(j));
            }
            this_row.add(1);
            result = this_row;
        }

        return result;
    }
}
