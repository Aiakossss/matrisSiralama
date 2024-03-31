package odev;

public class matris {
    public static void main(String[] args) {
        
        int row = 5;
        int col = 5;

        
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }

       
        System.out.println("Orijinal Matris:");
        printMatrix(matrix);

       
        int[] flatMatrix = flattenAndSort(matrix);

       
        System.out.println("\nSıralanmış Matris:");
        printMatrix(flatMatrix, row, col);
    }

   
    public static int[] flattenAndSort(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] flatMatrix = new int[rows * cols];

      
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatMatrix[k++] = matrix[i][j];
            }
        }

        
        for (int i = 0; i < flatMatrix.length - 1; i++) {
            for (int j = 0; j < flatMatrix.length - i - 1; j++) {
                if (flatMatrix[j] > flatMatrix[j + 1]) {
                    int temp = flatMatrix[j];
                    flatMatrix[j] = flatMatrix[j + 1];
                    flatMatrix[j + 1] = temp;
                }
            }
        }

        return flatMatrix;
    }

   
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    
    public static void printMatrix(int[] flatMatrix, int row, int col) {
        for (int i = 0; i < flatMatrix.length; i++) {
            System.out.print(flatMatrix[i] + "\t");
            if ((i + 1) % col == 0) {
                System.out.println();
            }
        }
    }
}
