package skype.teach.np.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpMatrixTest {

    private NpMatrix<Double> createMatrixDouble2x2() {
        NpMatrix<Double> A = new NpMatrix<Double>(2, 2);
        A.setElement(0, 0, 1.2);
        A.setElement(0, 1, 2.3);
        A.setElement(1, 0, 4.2);
        A.setElement(1, 1, 6.3);
        return A;
    }

    private NpMatrix<Double> createMatrixDoubleWithNull2x2() {
        NpMatrix<Double> A = new NpMatrix<Double>(2, 2);
        A.setElement(0, 0, 1.2);

        A.setElement(1, 0, 4.2);
        A.setElement(1, 1, 6.3);
        return A;
    }

    private NpMatrix<Double> createMatrixDouble2x3() {
        NpMatrix<Double> A = new NpMatrix<Double>(2, 3);
        A.setElement(0, 0, 1.2);
        A.setElement(0, 1, 2.3);
        A.setElement(0, 2, 5.3);
        A.setElement(1, 0, 4.2);
        A.setElement(1, 1, 6.3);
        A.setElement(1, 2, 9.3);
        return A;
    }

    private NpMatrix<Double> createMatrixDouble3x2() {
        NpMatrix<Double> A = new NpMatrix<Double>(3, 2);
        A.setElement(0, 0, 1.2);
        A.setElement(0, 1, 2.3);
        A.setElement(1, 0, 5.3);
        A.setElement(1, 1, 4.2);
        A.setElement(2, 0, 6.3);
        A.setElement(2, 1, 9.3);
        return A;
    }

    private NpMatrix<Double> createMatrixDouble2x2_() {
        NpMatrix<Double> B = new NpMatrix<Double>(2, 2);
        B.setElement(0, 0, 5.2);
        B.setElement(0, 1, 3.3);
        B.setElement(1, 0, 7.2);
        B.setElement(1, 1, 1.3);
        return B;
    }

    @Test(expected = NpMatrixException.class)
    public void assertExceptionSumMatrix() throws NpMatrixException {
        NpMatrix<Double> A = createMatrixDouble2x2();
        NpMatrix<Double> B = createMatrixDouble2x3();
        NpMatrix<Double> C = A.sum(B, new NpDoubleOperation());
    }

    @Test(expected = NpMatrixException.class)
    public void assertExceptionSumMatrixWithNull() throws NpMatrixException {
        NpMatrix<Double> A = createMatrixDoubleWithNull2x2();
        NpMatrix<Double> B = createMatrixDouble2x2();
        NpMatrix<Double> C = A.sum(B, new NpDoubleOperation());
    }

    @Test(expected = NpMatrixException.class)
    public void assertExceptionMultMatrixWithNull() throws NpMatrixException {
        NpMatrix<Double> A = createMatrixDoubleWithNull2x2();
        NpMatrix<Double> B = createMatrixDoubleWithNull2x2();
        NpMatrix<Double> C = A.mult(B, new NpDoubleOperation());
    }

    @Test(expected = NpMatrixException.class)
    public void assertExceptionMultMatrix() throws NpMatrixException {
        NpMatrix<Double> A = createMatrixDouble2x2();
        NpMatrix<Double> B = createMatrixDouble3x2();
        NpMatrix<Double> C = A.mult(B, new NpDoubleOperation());
    }

    @Test
    public void assertSumDoubleMatrix() throws NpMatrixException {
        NpMatrix<Double> A = createMatrixDouble2x2();
        NpMatrix<Double> B = createMatrixDouble2x2_();
        NpMatrix<Double> C = A.sum(B, new NpDoubleOperation());

        assertTrue("", C instanceof NpMatrix);
        assertEquals("", C.getEl(0, 0), 6.4, 0.0001);
        assertEquals("", C.getEl(0, 1), 5.6, 0.0001);
        assertEquals("", C.getEl(1, 0), 11.4, 0.0001);
        assertEquals("", C.getEl(1, 1), 7.6, 0.0001);

    }
    @Test
    public void assertMultDoubleMatrix() throws NpMatrixException {
        NpMatrix<Double> A = createMatrixDouble2x2();
        NpMatrix<Double> B = createMatrixDouble2x3();
        NpMatrix<Double> C = A.mult(B, new NpDoubleOperation());

        assertTrue("", C instanceof NpMatrix);
        assertEquals("", C.getEl(0, 0), 11.1, 0.0001);
        assertEquals("", C.getEl(0, 1), 17.25, 0.0001);
        assertEquals("", C.getEl(0, 2), 27.75, 0.0001);
        assertEquals("", C.getEl(1, 0), 31.5, 0.0001);
        assertEquals("", C.getEl(1, 1), 49.35, 0.0001);
        assertEquals("", C.getEl(1, 2), 80.85, 0.0001);


    }
    @Test
    public void assertExpDoubleMatrix() throws NpMatrixException {
        NpMatrix<Double> A = createMatrixDouble2x2();
        NpMatrix<Double> B = createMatrixDouble2x2_();
        NpMatrix<Double> C = A.exp(new NpDoubleOperation());

        assertTrue("", C instanceof NpMatrix);
        assertEquals("", C.getEl(0, 0), 11.1, 0.0001);
        assertEquals("", C.getEl(0, 1), 17.25, 0.0001);
        assertEquals("", C.getEl(1, 0), 31.5, 0.0001);
        assertEquals("", C.getEl(1, 1), 49.35, 0.0001);

    }

    private NpMatrix<Integer> createMatrixInt2x2() {
        NpMatrix<Integer> A = new NpMatrix<Integer>(2, 2);
        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 4);
        A.setElement(1, 1, 6);
        return A;
    }

    private NpMatrix<Integer> createMatrixInt2x3() {
        NpMatrix<Integer> A = new NpMatrix<Integer>(2, 3);
        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(0, 2, 5);
        A.setElement(1, 0, 4);
        A.setElement(1, 1, 6);
        A.setElement(1, 2, 9);
        return A;
    }

    private NpMatrix<Integer> createMatrixInt3x2() {
        NpMatrix<Integer> A = new NpMatrix<Integer>(3, 2);
        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 5);
        A.setElement(1, 1, 4);
        A.setElement(2, 0, 6);
        A.setElement(2, 1, 9);
        return A;
    }

    private NpMatrix<Integer> createMatrixInt2x2_() {
        NpMatrix<Integer> B = new NpMatrix<Integer>(2, 2);
        B.setElement(0, 0, 5);
        B.setElement(0, 1, 3);
        B.setElement(1, 0, 7);
        B.setElement(1, 1, 1);
        return B;
    }

    @Test(expected = NpMatrixException.class)
    public void assertExceptionSumIntMatrix() throws NpMatrixException {
        NpMatrix<Integer> A = createMatrixInt2x2();
        NpMatrix<Integer> B = createMatrixInt2x3();
        NpMatrix<Integer> C = A.sum(B, new NpIntegerOperation());
    }

    @Test(expected = NpMatrixException.class)
    public void assertExceptionMultiIntMatrix() throws NpMatrixException {
        NpMatrix<Integer> A = createMatrixInt2x2();
        NpMatrix<Integer> B = createMatrixInt3x2();
        NpMatrix<Integer> C = A.mult(B, new NpIntegerOperation());
    }


    @Test
    public void assertSumIntMatrix() throws NpMatrixException {
        NpMatrix<Integer> A = createMatrixInt2x2();
        NpMatrix<Integer> B = createMatrixInt2x2_();
        NpMatrix<Integer> C = A.sum(B, new NpIntegerOperation());

        assertTrue("", C instanceof NpMatrix);
        assertEquals("", C.getEl(0, 0), 6, 0.001);
        assertEquals("", C.getEl(0, 1), 5, 0.0001);
        assertEquals("", C.getEl(1, 0), 11, 0.0001);
        assertEquals("", C.getEl(1, 1), 7, 0.0001);

    }
    @Test
    public void assertMultIntMatrix() throws NpMatrixException {
        NpMatrix<Integer> A = createMatrixInt2x2();
        NpMatrix<Integer> B = createMatrixInt2x3();
        NpMatrix<Integer> C = A.mult(B, new NpIntegerOperation());

        assertTrue("", C instanceof NpMatrix);
        assertEquals("", C.getEl(0, 0), 9, 0.0001);
        assertEquals("", C.getEl(0, 1), 14, 0.0001);
        assertEquals("", C.getEl(0, 2), 23, 0.0001);
        assertEquals("", C.getEl(1, 0), 28, 0.0001);
        assertEquals("", C.getEl(1, 1), 44, 0.0001);
        assertEquals("", C.getEl(1, 2), 74, 0.0001);


    }
    @Test
    public void assertExpIntMatrix() throws NpMatrixException {
        NpMatrix<Integer> A = createMatrixInt2x2();
        NpMatrix<Integer> B = createMatrixInt2x2_();
        NpMatrix<Integer> C = A.exp(new NpIntegerOperation());

        assertTrue("", C instanceof NpMatrix);
        assertEquals("", C.getEl(0, 0), 9, 0.0001);
        assertEquals("", C.getEl(0, 1), 14, 0.0001);
        assertEquals("", C.getEl(1, 0), 28, 0.0001);
        assertEquals("", C.getEl(1, 1), 44, 0.0001);

    }
}
