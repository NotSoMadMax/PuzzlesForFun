package medium;

import java.util.*;

class EncodeandDecodeTinyURL {

    // Method 1: counter and map
    class EnDeCoder1{
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

    // Method 2: Java hashCode()
    // Note: The hashCode() doesn't generate unique codes for different string!!!
    class EnDeCoder2{
        Map<String, String> m = new HashMap<>();    // tiny -> url

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String tiny = "http://www.tinyurl.com/" + longUrl.hashCode();
            if(!m.containsKey(tiny))
                m.put(tiny, longUrl);

            return tiny;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return m.get(shortUrl);
        }
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
