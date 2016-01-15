package skype.teach.np.calculator.expression;


import skype.teach.np.calculator.exception.NpInvalidExpressionCalculatorException;
import skype.teach.np.calculator.operation.NpOperationExpressionFactoryImpl;
import skype.teach.np.calculator.operation.NpOperationExpressionItem;
import skype.teach.np.calculator.operation.NpSubtractionOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author NPrilepa
 */
public class NpExpressionImpl implements NpExpression {

    private List<NpExpressionItem> npExpressionItems;

    public List<NpExpressionItem> getExpressionItems() {
        return npExpressionItems;
    }

    private static boolean isOperation(String token) {
        return new NpOperationExpressionFactoryImpl().getOperationByName(token) != null;
    }

    private static NpOperationExpressionItem getOperationExpressionItem(String token) {
        return new NpOperationExpressionFactoryImpl().getOperationByName(token);
    }

    private void checkInvalidExpressionCalculator(boolean mustBeUnary) throws NpInvalidExpressionCalculatorException
    {
        if (mustBeUnary) {
            throw new NpInvalidExpressionCalculatorException();
        }
    }

    private boolean checkOperationOnUnary(List<NpExpressionItem> out, String token) {
        if (out.isEmpty() || ((out.get(out.size() - 1) instanceof NpGroupExpressionItemImpl) && ((NpGroupExpressionItemImpl) out.get(out.size() - 1)).isOpen())) {
            if (getOperationExpressionItem(token) instanceof NpSubtractionOperation) {
                return true;
            }
        }
        return false;
    }

    public NpExpression parseExpressionString(String inputExpressionStr) throws NpInvalidExpressionCalculatorException {
        int countOperators = 0;
        int countOperands = 0;
        int countOpen = 0;
        int countClose = 0;
        boolean mustBeUnary = false;
        if (inputExpressionStr == null)
            throw new NpInvalidExpressionCalculatorException();
        if (inputExpressionStr.trim().equals(""))
            throw new NpInvalidExpressionCalculatorException();

        String joinedNames = String.join("|", new NpOperationExpressionFactoryImpl().getNames());
        StringTokenizer tokenizer = new StringTokenizer(inputExpressionStr, "(" + joinedNames + "|" + NpGroupExpressionItemImpl.getSymbolOpen() + "|" + NpGroupExpressionItemImpl.getSymbolClose() + ")", true);
        // StringTokenizer tokenizer = new StringTokenizer(inputExpressionStr, "(\\*|-|\\+|/|(|))", true);
        List<NpExpressionItem> out = new ArrayList<NpExpressionItem>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals(" ")) {
                continue;
            }
            if (isOperation(token)) {
                checkInvalidExpressionCalculator(mustBeUnary);
                if (checkOperationOnUnary(out, token)) {
                    mustBeUnary = true;
                    continue;
                }
                if (!tokenizer.hasMoreTokens()) {
                    throw new NpInvalidExpressionCalculatorException();
                }
                countOperators++;
                out.add(getOperationExpressionItem(token));
                //} else if (token.equals("(")) {
            } else if ((new NpGroupExpressionItemImpl(token)).isOpen()) {
                countOpen++;
                checkInvalidExpressionCalculator(mustBeUnary);
                out.add(new NpGroupExpressionItemImpl(token));
            } else if ((new NpGroupExpressionItemImpl(token)).isClose()) {
                countClose++;
                checkInvalidExpressionCalculator(mustBeUnary);
                out.add(new NpGroupExpressionItemImpl(token));
            } else if (isOperand(token)) {
                countOperands++;
                if (mustBeUnary) {
                    out.add(new NpOperandExpressionItemImpl(new Double(new NpSubtractionOperation().getName() + token)));
                    mustBeUnary = false;
                } else {
                    out.add(new NpOperandExpressionItemImpl(new Double(token)));
                }
            }
        }
        if (countOperands == 0) {
            throw new NpInvalidExpressionCalculatorException();
        }
        if (countOpen != countClose) {
            throw new NpInvalidExpressionCalculatorException();
        }
        if (countOperators >= countOperands) {
            throw new NpInvalidExpressionCalculatorException();
        }
        this.npExpressionItems = out;
        return this;
    }

    private boolean isOperand(String token) throws NpInvalidExpressionCalculatorException {
        try {
            new Double(token);
            return true;
        } catch (NumberFormatException e) {
            throw new NpInvalidExpressionCalculatorException();
        }
    }
}
