public class Aufgabe02 {
    public static int[][] matrix(int n, int m) {
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = (int)(Math.random() * 7 + 4);
            }
        }

        return mat;
    }

    public static void zeigeMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " \t");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] mat = matrix(10, 10);
        zeigeMatrix(mat);
    }
}
