package skype.teach.np.calculator.expression;

import org.junit.Ignore;
import org.junit.Test;
import skype.teach.np.calculator.exception.NpInvalidExpressionCalculatorException;
import skype.teach.np.calculator.operation.NpOperationExpressionItem;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
@Ignore
public abstract class NpExpressionTest {

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_emptyString() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_space() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString(" ");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_spaceInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("( )");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_emptyInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("()");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_onlyGroupClose() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_onlyGroupOpen() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString(")");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_null() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString(null);
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorBetweenOperand() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5--6");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorBetweenOperandInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5--6)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_simpleOperatorAndSingleGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5(");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorBeforeOperand() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("++5");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorBeforeOperandInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(++5)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorAfterOperand() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5++");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorAfterOperandInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5++)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandLast() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5+");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandLastInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5+)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperands() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("-5+");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedLastOperandAndGroupOpen() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5+)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedFirstOperandAndGroupOpen() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("-5)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedFirstOperandAndGroupClose() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(-5");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedLastOperandAndGroupClose() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5+");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandsInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(-5-6+)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandsAndGroupClose() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(-5-6+");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandsAndGroupOpen() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("-5-6+)");
    }


    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedGroupOpen() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5+7))");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedGroupClose() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("((4+7)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedSimpleOperandGroupOpen() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedSimpleOperandGroupClose() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedSymbol() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("@");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedSymbolInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(@)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedOperator() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5@7");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedOperatorExpectedGroupClose() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5@7");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedOperatorExpectedGroupOpen() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5@7)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedOperatorInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5@7)");
    }

    private void assertOperand(String methodName, NpExpressionItem expressionItem, double assertValue) throws NpInvalidExpressionCalculatorException {
        assertTrue("item of expression with " + methodName + " instance of NpOperandExpressionItem", expressionItem instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem) expressionItem;
        assertEquals("value of item of expression with " + methodName + " equals operand.getValue()", assertValue, operand.getValue(), 0.000001);
    }

    private void assertGroupOpen(String method_name, NpExpressionItem expressionItem) {
        assertTrue("item of expression " + method_name + " instance of NpOperandExpressionItem", expressionItem instanceof NpGroupExpressionItem);
        assertTrue("item of expression " + method_name + " isOpen()=true", ((NpGroupExpressionItem) expressionItem).isOpen());
    }

    private void assertGroupClose(String method_name, NpExpressionItem expressionItem) {
        assertTrue("item of expression " + method_name + " instance of NpOperandExpressionItem", expressionItem instanceof NpGroupExpressionItem);
        assertTrue("item of expression " + method_name + " isClose()=true", ((NpGroupExpressionItem) expressionItem).isClose());
    }

    private NpExpression createInstanceAndAssertSameObjects(String methodName, String strExpression, int assertSize) throws NpInvalidExpressionCalculatorException {
        NpExpression npExpr = createInstance();
        NpExpression npExprResult = npExpr.parseExpressionString(strExpression);
        assertSame("parseExpressionString " + methodName + " returns reference to the same object which is used for calling the method", npExpr, npExprResult);
        assertEquals("parseExpressionString " + methodName + " return size=" + assertSize, assertSize, npExprResult.getExpressionItems().size());
        return npExprResult;
    }

    @Test
    public void parseExpressionString_simpleOperand() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprResult = createInstanceAndAssertSameObjects("simpleOperand", "5", 1);
        NpExpressionItem item = npExprResult.getExpressionItems().get(0);
        assertOperand("simpleOperand", item, 5);
    }

    @Test
    public void parseExpressionString_simpleOperandNegative() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprResult = createInstanceAndAssertSameObjects("simpleOperandNegative", "-5", 1);
        NpExpressionItem item = npExprResult.getExpressionItems().get(0);
        assertOperand("simpleOperandNegative", item, -5);
    }

    @Test
    public void parseExpressionString_simpleOperandNegativeWithGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprResult = createInstanceAndAssertSameObjects("simpleOperandNegativeWithGroup", "(-5)", 3);
        NpExpressionItem item0 = npExprResult.getExpressionItems().get(0);
        assertGroupOpen("simpleOperandNegativeWithGroup", item0);
        NpExpressionItem item1 = npExprResult.getExpressionItems().get(1);
        assertOperand("simpleOperandNegativeWithGroup", item1, -5);
        NpExpressionItem item2 = npExprResult.getExpressionItems().get(2);
        assertGroupClose("simpleOperandNegativeWithGroup", item2);
    }

    @Test
    public void parseExpressionString_simpleOperandFloat() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprResult = createInstanceAndAssertSameObjects("simpleOperandFloat", "5.1", 1);
        NpExpressionItem item = npExprResult.getExpressionItems().get(0);
        assertOperand("simpleOperandFloat", item, 5.1);
    }

    @Test
    public void parseExpressionString_simpleOperandWithSpace() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprResult = createInstanceAndAssertSameObjects("simpleOperandWithSpace", "5 ", 1);
        NpExpressionItem item = npExprResult.getExpressionItems().get(0);
        assertOperand("simpleOperandWithSpace", item, 5);
    }


    @Test
    public void parseExpressionString_simpleOperandInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprResult = createInstanceAndAssertSameObjects("simpleOperandInsideGroup", "(5)", 3);
        NpExpressionItem item0 = npExprResult.getExpressionItems().get(0);
        assertGroupOpen("simpleOperandInsideGroup", item0);
        NpExpressionItem item1 = npExprResult.getExpressionItems().get(1);
        assertOperand("simpleOperandNegative", item1, 5);
        NpExpressionItem item2 = npExprResult.getExpressionItems().get(2);
        assertGroupClose("simpleOperandInsideGroup", item2);
    }

    @Test
    public void parseExpressionString_simpleOperandInsideGroupWithSpace() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprResult = createInstanceAndAssertSameObjects("simpleOperandInsideGroupWithSpace", "(5 )", 3);
        NpExpressionItem item0 = npExprResult.getExpressionItems().get(0);
        assertGroupOpen("simpleOperandInsideGroupWithSpace", item0);
        NpExpressionItem item1 = npExprResult.getExpressionItems().get(1);
        assertOperand("simpleOperandInsideGroupWithSpace", item1, 5);
        NpExpressionItem item2 = npExprResult.getExpressionItems().get(2);
        assertGroupClose("simpleOperandInsideGroupWithSpace", item2);
    }

    private void assertOperation(String method_name, NpExpressionItem expressionItem, String assertName) {
        assertTrue("second item of expression with " + method_name + " instance of NpOperationExpressionItem", expressionItem instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation = (NpOperationExpressionItem) expressionItem;
        assertEquals("count of operands of item of expression with " + method_name + " equals operation.getOperandsNumber()", 2, operation.getOperandsNumber());
        assertEquals("name of operation of  item of expression with " + method_name + " equals operation.getName()", assertName, operation.getName());

    }

    @Test
    public void parseExpressionString_simpleOperation() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("simpleOperation", "5+7", 3);
        NpExpressionItem item = npExprRes.getExpressionItems().get(0);
        assertOperand("simpleOperation", item, 5);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(1);
        assertOperation("simpleOperation", item1, "+");
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(2);
        assertOperand("simpleOperation", item2, 7);
    }

    @Test
    public void parseExpressionString_simpleOperationNegative() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("simpleOperationNegative", "-5+7", 3);
        NpExpressionItem item = npExprRes.getExpressionItems().get(0);
        assertOperand("simpleOperationNegative", item, -5);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(1);
        assertOperation("simpleOperationNegative", item1, "+");
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(2);
        assertOperand("simpleOperationNegative", item2, 7);
    }

    @Test
    public void parseExpressionString_simpleOperationFloat() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("simpleOperationFloat", "5.1+7.1", 3);
        NpExpressionItem item = npExprRes.getExpressionItems().get(0);
        assertOperand("simpleOperationFloat", item, 5.1);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(1);
        assertOperation("simpleOperationFloat", item1, "+");
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(2);
        assertOperand("simpleOperationFloat", item2, 7.1);
    }

    @Test
    public void parseExpressionString_simpleOperationWithSpace() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("simpleOperationWithSpace", "5+7 ", 3);
        NpExpressionItem item = npExprRes.getExpressionItems().get(0);
        assertOperand("simpleOperationWithSpace", item, 5);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(1);
        assertOperation("simpleOperationWithSpace", item1, "+");
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(2);
        assertOperand("simpleOperationWithSpace", item2, 7);
    }


    @Test
    public void parseExpressionString_simpleOperationInsideGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("simpleOperationInsideGroup", "(5+7)", 5);
        NpExpressionItem item0 = npExprRes.getExpressionItems().get(0);
        assertGroupOpen("simpleOperationInsideGroup", item0);
        NpExpressionItem item = npExprRes.getExpressionItems().get(1);
        assertOperand("simpleOperationInsideGroup", item, 5);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(2);
        assertOperation("simpleOperationInsideGroup", item1, "+");
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(3);
        assertOperand("simpleOperationInsideGroup", item2, 7);
        NpExpressionItem item3 = npExprRes.getExpressionItems().get(4);
        assertGroupClose("simpleOperationInsideGroup", item3);

    }

    @Test
    public void parseExpressionString_simpleOperationInsideGroupWithSpace() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("simpleOperationInsideGroupWithSpace", "(5+7 )", 5);
        NpExpressionItem item0 = npExprRes.getExpressionItems().get(0);
        assertGroupOpen("simpleOperationInsideGroupWithSpace", item0);
        NpExpressionItem item = npExprRes.getExpressionItems().get(1);
        assertOperand("simpleOperationInsideGroupWithSpace", item, 5);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(2);
        assertOperation("simpleOperationInsideGroupWithSpace", item1, "+");
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(3);
        assertOperand("simpleOperationInsideGroupWithSpace", item2, 7);
        NpExpressionItem item3 = npExprRes.getExpressionItems().get(4);
        assertGroupClose("simpleOperationInsideGroupWithSpace", item3);
    }

    @Test
    public void parseExpressionString_SamePriorityOperations() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("SamePriorityOperations", "5+7+9", 5);
        NpExpressionItem item = npExprRes.getExpressionItems().get(0);
        assertOperand("SamePriorityOperations", item, 5);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(1);
        assertOperation("SamePriorityOperations", item1, "+");
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(2);
        assertOperand("SamePriorityOperations", item2, 7);
        NpExpressionItem item3 = npExprRes.getExpressionItems().get(3);
        assertOperation("SamePriorityOperations", item3, "+");
        NpExpressionItem item4 = npExprRes.getExpressionItems().get(4);
        assertOperand("SamePriorityOperations", item4, 9);

    }

    @Test
    public void parseExpressionString_2OperationsWithGroupLeft() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("2OperationsWithGroupLeft", "(5+7)/2", 7);
        NpExpressionItem item0 = npExprRes.getExpressionItems().get(0);
        assertGroupOpen("2OperationsWithGroupLeft", item0);
        NpExpressionItem item = npExprRes.getExpressionItems().get(1);
        assertOperand("2OperationsWithGroupLeft", item, 5);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(2);
        assertOperation("2OperationsWithGroupLeft", item1, "+");
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(3);
        assertOperand("2OperationsWithGroupLeft", item2, 7);
        NpExpressionItem item3 = npExprRes.getExpressionItems().get(4);
        assertGroupClose("2OperationsWithGroupLeft", item3);
        NpExpressionItem item4 = npExprRes.getExpressionItems().get(5);
        assertOperation("2OperationsWithGroupLeft", item4, "/");
        NpExpressionItem item5 = npExprRes.getExpressionItems().get(6);
        assertOperand("2OperationsWithGroupLeft", item5, 2);

    }

    @Test
    public void parseExpressionString_2OperationWithGroupRight() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("2OperationWithGroupRight", "2*(5+7)", 7);
        NpExpressionItem item = npExprRes.getExpressionItems().get(0);
        assertOperand("2OperationWithGroupRight", item, 2);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(1);
        assertOperation("2OperationWithGroupRight", item1, "*");
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(2);
        assertGroupOpen("2OperationWithGroupRight", item2);
        NpExpressionItem item3 = npExprRes.getExpressionItems().get(3);
        assertOperand("2OperationWithGroupRight", item3, 5);
        NpExpressionItem item4 = npExprRes.getExpressionItems().get(4);
        assertOperation("2OperationWithGroupRight", item4, "+");
        NpExpressionItem item5 = npExprRes.getExpressionItems().get(5);
        assertOperand("2OperationWithGroupRight", item5, 7);
        NpExpressionItem item6 = npExprRes.getExpressionItems().get(6);
        assertGroupClose("2OperationWithGroupRight", item6);
    }

    @Test
    public void parseExpressionString_2OperationWithGroupLeftNested() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("2OperationWithGroupLeftNested", "((5+7)/2)", 9);
        NpExpressionItem item0 = npExprRes.getExpressionItems().get(0);
        assertGroupOpen("2OperationWithGroupLeftNested", item0);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(1);
        assertGroupOpen("2OperationWithGroupLeftNested", item1);
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(2);
        assertOperand("2OperationWithGroupLeftNested", item2, 5);
        NpExpressionItem item3 = npExprRes.getExpressionItems().get(3);
        assertOperation("2OperationWithGroupLeftNested", item3, "+");
        NpExpressionItem item4 = npExprRes.getExpressionItems().get(4);
        assertOperand("2OperationWithGroupLeftNested", item4, 7);
        NpExpressionItem item5 = npExprRes.getExpressionItems().get(5);
        assertGroupClose("2OperationWithGroupLeftNested", item5);
        NpExpressionItem item6 = npExprRes.getExpressionItems().get(6);
        assertOperation("2OperationWithGroupLeftNested", item6, "/");
        NpExpressionItem item7 = npExprRes.getExpressionItems().get(7);
        assertOperand("2OperationWithGroupLeftNested", item7, 2);
        NpExpressionItem item8 = npExprRes.getExpressionItems().get(8);
        assertGroupClose("2OperationWithGroupLeftNested", item8);
    }

    @Test
    public void parseExpressionString_2OperationWithGroup() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("2OperationWithGroupRight", "(5+9)-(7+1)", 11);
        NpExpressionItem item0 = npExprRes.getExpressionItems().get(0);
        assertGroupOpen("2OperationWithGroup", item0);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(1);
        assertOperand("2OperationWithGroup", item1, 5);
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(2);
        assertOperation("2OperationWithGroup", item2, "+");
        NpExpressionItem item3 = npExprRes.getExpressionItems().get(3);
        assertOperand("2OperationWithGroup", item3, 9);
        NpExpressionItem item4 = npExprRes.getExpressionItems().get(4);
        assertGroupClose("2OperationWithGroup", item4);
        NpExpressionItem item5 = npExprRes.getExpressionItems().get(5);
        assertOperation("2OperationWithGroup", item5, "-");
        NpExpressionItem item6 = npExprRes.getExpressionItems().get(6);
        assertGroupOpen("2OperationWithGroup", item6);
        NpExpressionItem item7 = npExprRes.getExpressionItems().get(7);
        assertOperand("2OperationWithGroup", item7, 7);
        NpExpressionItem item8 = npExprRes.getExpressionItems().get(8);
        assertOperation("2OperationWithGroup", item8, "+");
        NpExpressionItem item9 = npExprRes.getExpressionItems().get(9);
        assertOperand("2OperationWithGroup", item9, 1);
        NpExpressionItem item10 = npExprRes.getExpressionItems().get(10);
        assertGroupClose("2OperationWithGroup", item10);
    }

    @Test
    public void parseExpressionString_difficultExpression() throws NpInvalidExpressionCalculatorException {
        NpExpression npExprRes = createInstanceAndAssertSameObjects("2OperationWithGroupRight", "(5+9)*6-18/9*3*(1+4)-12", 21);
        NpExpressionItem item0 = npExprRes.getExpressionItems().get(0);
        assertGroupOpen("2OperationWithGroup", item0);
        NpExpressionItem item1 = npExprRes.getExpressionItems().get(1);
        assertOperand("2OperationWithGroup", item1, 5);
        NpExpressionItem item2 = npExprRes.getExpressionItems().get(2);
        assertOperation("2OperationWithGroup", item2, "+");
        NpExpressionItem item3 = npExprRes.getExpressionItems().get(3);
        assertOperand("2OperationWithGroup", item3, 9);
        NpExpressionItem item4 = npExprRes.getExpressionItems().get(4);
        assertGroupClose("2OperationWithGroup", item4);
        NpExpressionItem item5 = npExprRes.getExpressionItems().get(5);
        assertOperation("2OperationWithGroup", item5, "*");
        NpExpressionItem item6 = npExprRes.getExpressionItems().get(6);
        assertOperand("2OperationWithGroup", item6, 6);
        NpExpressionItem item7 = npExprRes.getExpressionItems().get(7);
        assertOperation("2OperationWithGroup", item7, "-");
        NpExpressionItem item8 = npExprRes.getExpressionItems().get(8);
        assertOperand("2OperationWithGroup", item8, 18);
        NpExpressionItem item9 = npExprRes.getExpressionItems().get(9);
        assertOperation("2OperationWithGroup", item9, "/");
        NpExpressionItem item10 = npExprRes.getExpressionItems().get(10);
        assertOperand("2OperationWithGroup", item10, 9);
        NpExpressionItem item11 = npExprRes.getExpressionItems().get(11);
        assertOperation("2OperationWithGroup", item11, "*");
        NpExpressionItem item12 = npExprRes.getExpressionItems().get(12);
        assertOperand("2OperationWithGroup", item12, 3);
        NpExpressionItem item13 = npExprRes.getExpressionItems().get(13);
        assertOperation("2OperationWithGroup", item13, "*");
        NpExpressionItem item14 = npExprRes.getExpressionItems().get(14);
        assertGroupOpen("2OperationWithGroup", item14);
        NpExpressionItem item15 = npExprRes.getExpressionItems().get(15);
        assertOperand("2OperationWithGroup", item15, 1);
        NpExpressionItem item16 = npExprRes.getExpressionItems().get(16);
        assertOperation("2OperationWithGroup", item16, "+");
        NpExpressionItem item17 = npExprRes.getExpressionItems().get(17);
        assertOperand("2OperationWithGroup", item17, 4);
        NpExpressionItem item18 = npExprRes.getExpressionItems().get(18);
        assertGroupClose("2OperationWithGroup", item18);
        NpExpressionItem item19 = npExprRes.getExpressionItems().get(19);
        assertOperation("2OperationWithGroup", item19, "-");
        NpExpressionItem item20 = npExprRes.getExpressionItems().get(20);
        assertOperand("2OperationWithGroup", item20, 12);
    }

    protected abstract NpExpression createInstance();

}
