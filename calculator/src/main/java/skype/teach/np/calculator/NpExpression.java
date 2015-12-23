package skype.teach.np.calculator;

import skype.teach.np.calculator.operator.*;

import java.util.Map;
import java.util.Vector;

/**
 * @author NPrilepa
 */
public class NpExpression  implements INpExpression {
    private int posFirstClose;
    private int posFirstOpen;
    private int posOperator;
    private Vector expression;
    private Map<Character, INpOperator> operations;


    public NpExpression(String inputExpression) {
        operations.put('+', new NpAddition(1));
        operations.put('-', new NpSubstruction(1));
        operations.put('*', new NpMultiplication(2));
        operations.put('/', new NpDivision(2));
        this.expression = parseExpression(inputExpression);
    }

    private Vector parseExpression(String inputString) {
        return null;
    }

    public int getPosFirstClose() {
        return 0;
    }

    public int getPosFirstOpen(int posFirstClose) {

        return 0;
    }

    public INpOperator getOperator(int posFirstOpen, int posFirstClose) {

        return null;
    }

    public double getOperatorResult(INpNumber number,INpOperator operator) {

        return 0;
    }

    public INpNumber getOperands(int posOperator){
        return null;
    }

    public void removeExpression(int posOperator, int posOperator_1) {

    }

    public INpExpression setResultOperator(double resultOperator, int posFirstOpen) {
        return null;
    }

    public boolean isValid() {
        return false;
    }


    public double getResult() {
        return 0;
    }


}
