package CTCI;

public class Matrix {
    private int dimension;
    private int [][] matrix;

    public Matrix (int dimension) {
        this.dimension = dimension;
        matrix = new int[dimension][dimension];
    }

}
