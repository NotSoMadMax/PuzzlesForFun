package medium;

public class RLEIterator {
	int[] codes;
	int cur, poped;
	
    public RLEIterator(int[] A) {
        this.codes = A;
        cur = 0;
        poped = 0;
    }
    
    public int next(int n) {
        while(cur < codes.length){
        	if(n + poped > codes[cur])
        	{
        		n -= codes[cur] - poped;
        		cur += 2;
        		poped = 0;
        	}else {
				poped += n;
				return codes[cur + 1];
			}
        }     
        return -1;
    }
}
