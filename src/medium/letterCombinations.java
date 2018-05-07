package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class letterCombinations {

	private static List<String> letterCombinations(String digits) {
		int len = digits.length();
		if(len < 1 || digits == null)
			return Collections.emptyList();
		List<String> result = new ArrayList<>();
		
		String[] map = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		combination(0, map, result, new StringBuffer(), digits);
		return result;
	}
	
	static private void combination(int level, String[] map, List<String> result, StringBuffer ans, String digits){
		if (level == digits.length()){
			result.add(ans.toString());
			return;
		}
		
		int num = Character.getNumericValue(digits.charAt(level));		
		for (int i = 0; i < map[num].length(); i++){
			ans.append(map[num].charAt(i));
			combination(level + 1, map, result, ans, digits);
			ans.deleteCharAt(ans.length() - 1);
		}
		
		return;
	}
	
    public static void main(String args[]){
	    	String number = "847944";
	    	System.out.println(letterCombinations(number));
	    	return;
    }
    
}





/*
private static List<String> letterCombinations(String digits) {
	int len = digits.length();
	if (len < 1  || digits == null)
		return Collections.emptyList();
	
	String[] map = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	List<String> result = new ArrayList<>();
	
	result.add("");
	for (int i = 0; i < digits.length(); i++){
		int index = Character.getNumericValue(digits.charAt(i));
		while (i == result.get(result.size()-1).length()){
			String temp = result.remove(result.size()-1);
			for (int j = 0; j < map[index].length(); j++)
				result.add(0, temp + map[index].charAt(j));
		}
	}        
	
    return result;
}
*/