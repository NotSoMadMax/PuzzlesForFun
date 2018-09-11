package Easy;

class ValidPalindrome {
    private boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;

        int front = 0;
        int end = s.length() - 1;
        char[] temp = s.toLowerCase().toCharArray();

        while(front < end){
            if(!(Character.isDigit(temp[front])  || Character.isLetter(temp[front]))){
                front++;
                continue;
            }

            if(!(Character.isDigit(temp[end]) || Character.isLetter(temp[end]))){
                end--;
                continue;
            }

            if(temp[front] != temp[end])
                return false;

            front++;
            end--;
        }

        return true;
    }
}
