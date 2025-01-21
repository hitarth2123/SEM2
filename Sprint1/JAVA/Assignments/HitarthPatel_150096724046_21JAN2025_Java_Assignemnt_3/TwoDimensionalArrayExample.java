class TwoDimensionalArrayExample {
    public static void main(String[] args) {
        int[][] matrix = new int[2][3]; 
        int[][] predefinedMatrix = {{1, 2, 3}, {4, 5, 6}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + j + 1); 
            }
        }

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("Predefined Matrix:");
        for (int[] row : predefinedMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

