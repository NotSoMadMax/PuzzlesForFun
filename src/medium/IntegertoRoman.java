package medium;

public class IntegertoRoman {
	private String intToRoman(int num) {
		// a single char can repeat at most 3 times eg: III, then IV
        String[] dict = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};	// combine to avoid special cases
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 13; i++){
        	if(num >= val[i]){
        		int quient = num/val[i];	// at most 3
        		num = num % val[i];
        		
        		for (int j = 0; j < quient; j++) {
					sb.append(dict[i]);
				}        		
        	}
        }
    	
    	return sb.toString();
    }
    
}
