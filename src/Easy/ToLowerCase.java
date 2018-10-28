package Easy;

public class ToLowerCase {
    private String toLowerCase(String str) {
        if(str == null || str.isEmpty())
            return str;

        StringBuilder sb = new StringBuilder();
        for(char c:str.toCharArray()){
            if(c <= 'Z' && c >= 'A')     // is capital
                sb.append((char)(c + 'a' - 'A'));
            else
                sb.append(c);
        }

        return sb.toString();
    }
}
