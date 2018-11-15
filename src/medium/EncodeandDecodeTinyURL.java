package medium;

import java.util.*;

public class EncodeandDecodeTinyURL {
    String dic = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, Integer> long2num = new HashMap<>();
    Map<Integer, String> num2long = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(!long2num.containsKey(longUrl)){
            long2num.put(longUrl, long2num.size() + 1);
            num2long.put(long2num.size(), longUrl);
        }

        int n = long2num.size();
        StringBuilder sb = new StringBuilder();
        while (n > 0)
        {
            sb.append(dic.charAt(n % 62));  // the sequence of remainders will be unique
            n /= 62;
        }

        return sb.toString();
    }


    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int n = 0;
        for(int i = 0; i < shortUrl.length(); i++){
            n = n*62 + dic.indexOf(shortUrl.charAt(i));
        }

        return num2long.get(n);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
