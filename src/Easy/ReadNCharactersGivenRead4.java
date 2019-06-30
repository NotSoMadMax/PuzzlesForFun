package Easy;

class ReadNCharactersGivenRead4 {
	private int read4(char[] buf){
		return 0;
	}
	
    private int read(char[] buf, int n) {
        if (n < 1)
        	return 0;
        
        char[] temp_buf = new char[4];
        int count = 0;
        
        while(count < n){
        	int read = read4(temp_buf);
        	
        	if(count + read <= n){
            	for(int i = 0; i < read; i++)
            		buf[count + i] = temp_buf[i];
            	count += read;
        	}else{
            	for(int i = 0; i < n - count; i++)
            		buf[count + i] = temp_buf[i];
            	count += n - count;
        	}
        	
        	if(read < 4)
        		break;
        }        	
        
        return count;
    }
}
