package medium;

import java.util.Arrays;

class directory{
	protected int[] numbers;
	protected boolean[] avaliability;
	protected int next;
	protected int maxNumber;
	
	public directory(int maxNum){
		maxNumber = maxNum;
		next = 0;
		numbers = new int[maxNum];
		avaliability = new boolean[maxNum];
		Arrays.fill(avaliability, true);
		for (int i = 0; i < maxNum; i++){
			numbers[i] = i;			
		}		
	}
	
	
	public int get(){	//Provide a number which is not assigned to anyone
		if (next != -1)
			return numbers[next];
		else{
			System.out.println("no numbers left");
			return -1;
		}
	}
	
	public boolean check(int num){	//Check if a number is available or not
		if (num > maxNumber){
			System.out.println("number out of range");
			return false;
		}
		
		return avaliability[num];
	}
	
	public void release(int num){		// Recycle or release a number
		if (avaliability[num]){
			System.out.println("currently avaliable");
			return;
		}
		
		avaliability[num] = true;
		next = num;
		return;
	}
	
	
	
}

public class DesignPhoneDirectory {

}
