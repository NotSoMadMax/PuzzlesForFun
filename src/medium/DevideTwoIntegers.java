package medium;

public class DevideTwoIntegers {
	static private int divide(int dividend, int divisor) {
		if (divisor == 0)	return Integer.MAX_VALUE;
		if (dividend == 0)	return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) 	// abs(MIN_VALUE) -> overflow
    			return Integer.MAX_VALUE; 
    			
        int result = 0;
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		
		int max_times = 0;
		while (b<<(max_times + 1) <= a)	max_times++;
		
		while (a >= b){
			if (a >= b<<max_times){
				a -= b<<max_times;
				result += 1<<max_times;
			}
			max_times--;
		}
        
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
        		return 0 - result;
        return result;
    }
	
	public static void main(String args[]){
		int devidend = -112316;
		int devisor = -91;
		System.out.println("system: " + devidend/devisor);
		System.out.println("function: " + divide(devidend, devisor));
		
		return;
	}
}
