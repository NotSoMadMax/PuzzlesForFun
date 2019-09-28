package Easy;

class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
    	if (n < 1)
    		return "";
    	n--;
    	return convertToTitle(n / 26) + (char) (n % 26 + 'A');   	    
    }
    
    public static void main(String[] args) {
    	System.out.print(convertToTitle(52));
    }
}
