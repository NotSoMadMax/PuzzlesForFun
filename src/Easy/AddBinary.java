package Easy;

public class AddBinary {
    private String addBinary(String a, String b) {
	    int la = a.length();
	    int lb = b.length();	
		if (la < 1 || a == null)
				return b;
		if (lb < 1 || b == null)
				return a;
	    
		int cin = 0;
		StringBuffer sb = new StringBuffer();
		la--;
		lb--;
		while(la >= 0 || lb >= 0){
			int na = 0, nb = 0;
			if (la >= 0)
				na = a.charAt(la) - 48; // faster than Character.getNumericalValue
			if (lb >= 0)
				nb = b.charAt(lb) - 48;
			
			int cur = na + nb + cin;
			cin = cur / 2;
			cur = cur % 2;
			sb.append(cur);
			la--;
			lb--;
		}
		if (cin != 0)
			sb.append(cin);
		
		sb.reverse();
		return sb.toString();             
    }
}





