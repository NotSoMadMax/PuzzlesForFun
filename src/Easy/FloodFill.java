package Easy;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int floodColor = image[sr][sc];
        if (floodColor == newColor) {
            return image;
        }
        flow(image, floodColor, newColor, sr, sc);
        return image;
    }
    
    private void flow(int[][] image, int floodColor, int newColor, int row, int col) {

        image[row][col] = newColor;

        if (row + 1 < image.length && image[row + 1][col] == floodColor) {
            flow(image, floodColor, newColor, row + 1, col);
        }

        if (row - 1 >= 0 && image[row - 1][col] == floodColor) {
            flow(image, floodColor, newColor, row - 1, col);
        }

        if (col + 1 < image[0].length && image[row][col + 1] == floodColor) {
            flow(image, floodColor, newColor, row, col + 1);
        }

        if (col - 1 >= 0 && image[row][col - 1] == floodColor) {
            flow(image, floodColor, newColor, row, col - 1);
        }

    }
}
