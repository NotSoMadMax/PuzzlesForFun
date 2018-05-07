

public class test {

	public static void main(String args[]) {
		String s = "/../abs//..";
		String[] p = s.split("/");
		
		for (String a:p){
			if (a.length()<1)
				continue;
			System.out.println(a);
		}
	}

}
