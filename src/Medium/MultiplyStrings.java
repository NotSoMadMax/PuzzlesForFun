package medium;

public class MultiplyStrings {
	
	private static String multiply(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		if (len1 == 0 || len2 == 0) return "";
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		
		int[] result = new int[len1 + len2];
		
		for (int i = len1 - 1; i >= 0; i--){
			for (int j = len2 - 1; j >= 0; j--){
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');	//'0' = 48 in ascii
				mul += result[i + j + 1];	// [i+j+1]:carry-on from previous mul
				result[i + j] += mul/10;
				result[i + j + 1] = mul%10;
			}
		}
		
		StringBuilder product = new StringBuilder();
		for (int digit : result)		product.append(digit);
		product.toString();
		
		if (product.charAt(0) == '0')	return product.substring(1);
		else		return product.toString();
	}
	
	public static void main(String[] args){
		String a = "123";
		String b = "456";

		System.out.println(multiply(a,b));		
		return;
	}
}
