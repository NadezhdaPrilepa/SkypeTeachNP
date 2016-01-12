package skype.teach.np.calculator.expression;


import skype.teach.np.calculator.exception.NpInvalidExpressionCalculatorException;
import skype.teach.np.calculator.expression.operation.NpOperationExpressionFactoryImpl;
import skype.teach.np.calculator.expression.operation.NpOperationExpressionItem;

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

    public NpExpression parseExpressionString(String inputExpressionStr) throws NpInvalidExpressionCalculatorException {
        int countOperators = 0;
        int countOperands = 0;
        if (inputExpressionStr == null)
            throw new NpInvalidExpressionCalculatorException();
        if (inputExpressionStr.trim().equals(""))
            throw new NpInvalidExpressionCalculatorException();
        if (!groupHasPair(inputExpressionStr)) {
            throw new NpInvalidExpressionCalculatorException();
        }
        // String[] arr = inputExpressionStr.split("(\\*|-|\\+|/|(|))");
        StringTokenizer tokenizer = new StringTokenizer(inputExpressionStr, "(\\*|-|\\+|/|(|))", true);
        List<NpExpressionItem> out = new ArrayList<NpExpressionItem>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals(" ")) {
                continue;
            }
            if (isOperation(token)) {
                if (!tokenizer.hasMoreTokens()) {
                    throw new NpInvalidExpressionCalculatorException();
                }
                countOperators++;
                NpOperationExpressionItem npOperationExpressionItem = getOperationExpressionItem(token);
                out.add(npOperationExpressionItem);
            } else if (token.equals("(")) {
                out.add(new NpGroupExpressionItemImpl("("));
            } else if (token.equals(")")) {
                out.add(new NpGroupExpressionItemImpl(")"));
            } else {
                if (isOperand(token)) {
                    countOperands++;
                    out.add(new NpOperandExpressionItemImpl(new Double(token)));
                }
            }
        }
        if (countOperands == 0) {
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

    private boolean groupHasPair(String input) {
        char charArray[] = input.toCharArray();
        int countOpen = 0;
        int countClose = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ('(')) {
                countOpen++;
            } else if (charArray[i] == (')')) {
                countClose++;
            }
        }
        boolean output = (countOpen == countClose) ? true : false;
        return (output);
    }
}
