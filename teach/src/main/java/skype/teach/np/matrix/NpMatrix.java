package skype.teach.np.matrix;

/**Parameterized square matrix
 * Row - number of matrix rows
 * Col - number of matrix columns
 * el[][] - elements of matrix
 * T - type of elements
 * @author NPrilepa
 */
public class NpMatrix<T> {
    private int row, col;
    private T el[][];


    public T getEl(int row, int col) {
        return el[row][col];
    }

    public NpMatrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.el=(T[][])new Object[row][col];
    }

    public void setElement(int row, int col, T value) {
        this.el[row][col] = value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    /**
     * Multiplication of two matrix. Can only multiply matrix whose number of rows and columns, each match
     * @param matrix
     * @param operation NpOperation<T> class, which implements operation of multiplication elements  T type
     * @return NpMatrix number of rows equal rows of original matrix  and number of columns equal columns
     * of <code>matrix</code>
     * @throws NpMatrixException if some elements is null or number of rows and columns each matrix not equals
     */
    public NpMatrix<T> mult(NpMatrix<T> matrix, NpOperation<T> operation) throws NpMatrixException {
        NpMatrix<T> res = new NpMatrix<T>(getRow(), matrix.getCol());
        if (getCol() == matrix.getRow()) {
            for (int i = 0; i < getRow(); i++)
                for (int k = 0; k < matrix.getCol(); k++)
                    for (int j = 0; j < matrix.getRow(); j++) {
                        if ((getEl(i, j) != null) && (matrix.getEl(j, k) != null)) {
                            res.setElement(i, k, operation.add(res.getEl(i, k), operation.multi(getEl(i, j), matrix.getEl(j, k))));
                        } else {
                            throw new NpMatrixException();
                        }
                    }
            return res;
        } else {
            throw new NpMatrixException();
        }

    }

    /**
     * The sum of the two matrices. Can only add matrix whose number of
     * rows and columns are equal of number rows and columns <code> matrix </code>
     * @param matrix
     * @param operation NpOperation<T> class, which implements operation of add elements  T type
     * @return NpMatrix number of rows and columns are equal rows and columns of original matrix
     * @throws NpMatrixException if some elements is null or number of rows or columns each matrix not equals
     */
    public NpMatrix<T> sum(NpMatrix<T> matrix, NpOperation<T> operation) throws NpMatrixException {
        if (matrix.getCol() != getCol())
            throw new NpMatrixException();
        if (matrix.getRow() != getRow())
            throw new NpMatrixException();
        NpMatrix<T> res = new NpMatrix<T>(getRow(), getCol());
        for (int i = 0; i < getRow(); i++)
            for (int k = 0; k < getCol(); k++) {
                if ((getEl(i, k) != null) && (matrix.getEl(i, k) != null)) {
                    res.setElement(i, k, operation.add(getEl(i, k), matrix.getEl(i, k)));
                } else {
                    throw new NpMatrixException();
                }
            }
        return res;
    }

    /**
     *
     * @param operation
     * @return
     * @throws NpMatrixException
     */

    public NpMatrix<T> exp(NpOperation<T> operation) throws NpMatrixException {

        NpMatrix<T> res ;
        res = this.mult(this, operation);
        return res;
    }


}

interface NpOperation<T> {
    public T add(T t1, T t2);

    public T multi(T t1, T t2);
}

class NpDoubleOperation implements NpOperation<Double> {
    public Double add(Double value1, Double value2) {
        if (value1==null) {
            value1 = 0.0;
        }
        if (value2==null) {
            value2 = 0.0;
        }
        return value1 + value2;
    }

    public Double multi(Double value1, Double value2) {
        return value1 * value2;
    }

}

class NpIntegerOperation implements NpOperation<Integer> {
    public Integer add(Integer value1, Integer value2) {
        if (value1==null) {
            value1 = 0;
        }
        if (value2==null) {
            value2 = 0;
        }
        return value1 + value2;
    }

    public Integer multi(Integer value1, Integer value2) {
        return value1 * value2;
    }

}

class NpMatrixException extends Exception {

}

