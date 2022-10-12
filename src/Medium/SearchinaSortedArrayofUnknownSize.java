package medium;

class ArrayReader{	
	int get(int index){
		return 0;
	}	
}

class SearchinaSortedArrayofUnknownSize {
    private int search(ArrayReader reader, int target) {
        int l = 0, h = 2147483647;
        
        while(l <= h){
        	int m = (l + h)/2;
        	int am = reader.get(m);
        	
        	if(am == target)
        		return m;
        	if(am < target)
        		l = m + 1;
        	if(target < am)
        		h = m - 1;
        }
        
        return -1;
    }
}
