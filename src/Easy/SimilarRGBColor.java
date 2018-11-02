package Easy;

public class SimilarRGBColor {
    private String similarRGB(String color) {
        if(color == null || color.length() < 1)
            return color;

        return "#" + round(color.substring(1,3)) + round(color.substring(3,5)) + round(color.substring(5,7));
    }

    // round number to closest shorthand number (closest multiples of 17)
    private static String round(String num){
        int n = Integer.parseInt(num, 16);  // convert to octal
        n = n / 17 + (n%17>8?1:0);   // shorthands multiples of 11, which is 17 in octal

        String hex = Integer.toHexString(n*17);     // if is 0, should return "00"

        return hex.length()==1?hex+hex:hex;
    }
}
