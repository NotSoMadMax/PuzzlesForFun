package Easy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(e -> e.id, e -> e));
        return getSum(employeeMap, id);
    }

    // DFS
    private int getSum(Map<Integer, Employee> employeeMap, int id) {
        int response = employeeMap.get(id).importance;
        if (employeeMap.get(id).subordinates == null || employeeMap.get(id).subordinates.isEmpty()) {
            return response;    // reduce recursion layers
        }

        for (int e : employeeMap.get(id).subordinates) {
            response += getSum(employeeMap, e);
        }
        return response;
    }
}
