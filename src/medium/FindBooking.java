package medium;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class FindBooking {
	private static boolean check(int a, int c,int[] guest) {
		if (a < guest[0] || c < guest[1])
			return false;
		else
			return true;
	}
	
	private static void search(int[][] rooms, int[] guest, int[] results){
		for (int i = 0; i < rooms.length; i++){
			if(check(rooms[i][0],rooms[i][1], guest)){
				results[i] = 1;
			}
		}
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);		
		String s = input.next();
		int NofType= Integer.parseInt(s);
		
		int[][] rooms = new int[NofType][3];
		
		for (int i = 0; i < NofType && input.hasNext(); i++){
			String[] room = input.next().split("\\s+");
			for (int j = 0; j < 3; j++){
				rooms[i][j] = Integer.parseInt(room[j]);
			}
		}
		
		String[] g = input.nextLine().split("\\s+");
		int[] guest = new int[3];
		guest[0] = Integer.parseInt(g[0]);
		guest[1] = Integer.parseInt(g[1]);
		guest[2] = Integer.parseInt(g[2]);
		
		int[] results = new int[NofType];
		search(rooms, guest, results);
		
		for (int i = 0; i < NofType; i++){
			System.out.println(i + "," + results[i] + "," + guest[2]*rooms[i][2]);
		}
	}
}
