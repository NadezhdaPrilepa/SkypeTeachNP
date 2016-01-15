package skype.teach.np.calculator;

import com.google.common.collect.Lists;
import skype.teach.np.calculator.exception.NpCalculationOperationException;
import skype.teach.np.calculator.exception.NpCalculatorException;
import skype.teach.np.calculator.exception.NpInvalidSizeOfOperandsCalculatorException;
import skype.teach.np.calculator.exception.NpNullPointerOperatorCalculatorException;
import skype.teach.np.calculator.expression.*;
import skype.teach.np.calculator.operation.NpOperationExpressionItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Calculate incoming arithmetic expression.
 * Arithmetic expression contains unlimited number of operators, operands and grouping operators.
 * Operators can dynamically connect. Grouping operators can be nested. The order of
 * operations corresponds grouping and their priorities(Operators of equal priority
 * are performed one after the other. Grouping can change order of calculations)
 *
 * @author NPrilepa
 */
public class NpCalculatorImpl implements NpCalculator {

    private boolean isOperator(NpExpressionItem npExpressionItem) {
        return npExpressionItem instanceof NpOperationExpressionItem;
    }

    private boolean isGroupOpen(NpExpressionItem npExpressionItem) {
        if (npExpressionItem instanceof NpGroupExpressionItem)
            return ((NpGroupExpressionItem) npExpressionItem).isOpen();
        else
            return false;
    }

    private boolean isGroupClose(NpExpressionItem npExpressionItem) {
        if (npExpressionItem instanceof NpGroupExpressionItem)
            return ((NpGroupExpressionItem) npExpressionItem).isClose();
        else
            return false;
    }

    private int cmpPriority(NpOperationExpressionItem npExpressionItems1, NpOperationExpressionItem npExpressionItems2) {
        return npExpressionItems1.getPriority() - npExpressionItems2.getPriority();
    }

    private List<NpExpressionItem> parseReversePolishNotation(NpExpression npExpression) {

        List<NpExpressionItem> out = new ArrayList<NpExpressionItem>();
        Stack<NpExpressionItem> stack = new Stack<NpExpressionItem>();
        for (int i = 0; i < npExpression.getExpressionItems().size(); i++) {
            NpExpressionItem npExpressionItem = npExpression.getExpressionItems().get(i);
            if (isOperator(npExpressionItem)) {
                while (!stack.empty() && isOperator(stack.peek())) {
                    if (cmpPriority((NpOperationExpressionItem) npExpressionItem, (NpOperationExpressionItem) stack.peek()) <= 0) {
                        out.add(stack.pop());
                        continue;

                    }
                    break;
                }
                stack.push(npExpressionItem);
            } else if (isGroupOpen(npExpressionItem)) {
                stack.push(npExpressionItem);
            } else if (isGroupClose(npExpressionItem)) {
                while (!stack.empty() && !isGroupOpen(stack.peek())) {
                    out.add(stack.pop());
                }
                stack.pop();
            } else {
                out.add(npExpressionItem);
            }
        }
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        return out;
    }

    private NpResult doCalculateReversePolishNotation(List<NpExpressionItem> npExpressionReversePolishNotationList) throws NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException, NpNullPointerOperatorCalculatorException {

        Stack<NpExpressionItem> stack = new Stack<NpExpressionItem>();
        for (int i = 0; i < npExpressionReversePolishNotationList.size(); i++) {
            {

                if (!isOperator(npExpressionReversePolishNotationList.get(i))) {
                    stack.push(npExpressionReversePolishNotationList.get(i));
                } else {
                    NpOperationExpressionItem npOperationExpressionItem = (NpOperationExpressionItem) npExpressionReversePolishNotationList.get(i);
                    List<NpOperandExpressionItem> listOfOperandExpressionItem = new ArrayList();

                    for (int j = 0; j < npOperationExpressionItem.getOperandsNumber(); j++) {
                        listOfOperandExpressionItem.add((NpOperandExpressionItem) stack.pop());
                    }
                    List<NpOperandExpressionItem> listOfOperandExpressionItemReverse = Lists.reverse(listOfOperandExpressionItem);
                    stack.push(npOperationExpressionItem.doCalculate(listOfOperandExpressionItemReverse));
                }
            }
        }
        return new NpResultImpl(((NpOperandExpressionItem) stack.pop()).getValue());
    }

    public NpResult calculate(String inputException) throws NpCalculatorException {
        NpExpression npExpression = new NpExpressionImpl().parseExpressionString(inputException);
        List<NpExpressionItem> npExpressionReversePolishNotationList = parseReversePolishNotation(npExpression);
        return doCalculateReversePolishNotation(npExpressionReversePolishNotationList);
    }
}
