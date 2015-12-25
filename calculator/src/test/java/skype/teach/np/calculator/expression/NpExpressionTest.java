package skype.teach.np.calculator.expression;

import org.junit.Ignore;
import org.junit.Test;
import skype.teach.np.calculator.exception.NpInvalidExpressionCalculatorException;
import skype.teach.np.calculator.expression.operation.NpOperationExpressionItem;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
@Ignore
public abstract class NpExpressionTest {
    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_emptyString() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_space() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString(" ");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_spaceInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("( )");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_emptyInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("()");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_onlyGroupClose() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_onlyGroupOpen() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString(")");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_null() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString(null);
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorBetweenOperand() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5--6");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorBetweenOperandInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5--6)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorBeforeOperand() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("++5");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorBeforeOperandInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(++5)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorAfterOperand() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5++");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_doubleOperatorAfterOperandInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5++)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandLast() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5+");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandLastInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5+)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandFirst() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("-5");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandFirstInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(-5)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperands() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("-5+");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedLastOperandAndGroupOpen() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5+)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedFirstOperandAndGroupOpen() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("-5)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedFirstOperandAndGroupClose() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(-5");
    }
    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedLastOperandAndGroupClose() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5+");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandsInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(-5-6+)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandsAndGroupClose() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(-5-6+");
    }
    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedOperandsAndGroupOpen() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("-5-6+)");
    }


    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedGroupOpen() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5+7))");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedGroupClose() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("((4+7)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedSimpleOperandGroupOpen() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedSimpleOperandGroupClose() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedSymbol() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("@");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedSymbolInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(@)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedOperator() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5@7");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedOperatorExpectedGroupClose() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5@7");
    }
    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedOperatorExpectedGroupOpen() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("5@7)");
    }

    @Test(expected = NpInvalidExpressionCalculatorException.class)
    public void parseExpressionString_expectedNotDefinedOperatorInsideGroup() throws Exception {
        NpExpression npexpr = createInstance();
        npexpr.parseExpressionString("(5@7)");
    }

    @Test
    public void parseExpressionString_simpleOperand() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprResult =npExpr.parseExpressionString("5");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprResult);
        assertEquals("parseExpressionString simple operand return size=1", 1, npExprResult.getExpressionItems().size());
        NpExpressionItem item =  npExprResult.getExpressionItems().get(0);
        assertTrue("first item of expression with simple operand instance of NpOperandExpressionItem",item instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item;
        assertEquals("value of first item of expression with simple operand equals operand.getValue()", 5, operand.getValue(), 0.000001);
    }

    @Test
    public void parseExpressionString_simpleOperandWithSpace() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprResult =npExpr.parseExpressionString("5 ");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprResult);
        assertEquals("parseExpressionString simple operand with space return size=1", 1, npExprResult.getExpressionItems().size());
        NpExpressionItem item =  npExprResult.getExpressionItems().get(0);
        assertTrue("first item of expression with simple operand with space instance of NpOperandExpressionItem",item instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item;
        assertEquals("value of first item of expression with simple operand with space equals operand.getValue()", 5, operand.getValue(), 0.000001);
    }

    @Test
    public void parseExpressionString_simpleOperandInsideGroup() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprResult =npExpr.parseExpressionString("(5)");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprResult);
        assertEquals("parseExpressionString simple operand inside group return size=3", 3, npExprResult.getExpressionItems().size());
        NpExpressionItem item0 =  npExprResult.getExpressionItems().get(0);
        assertTrue("0 item of expression with simple operand inside group instance of NpOperandExpressionItem", item0 instanceof NpGroupExpressionItem);
        assertTrue("0 item of expression with simple operand inside group isOpen()=true", ((NpGroupExpressionItem) item0).isOpen());
        NpExpressionItem item1 =  npExprResult.getExpressionItems().get(1);
        assertTrue("1 item of expression with simple operand inside group instance of NpOperandExpressionItem", item1 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item1;
        assertEquals("value of first item of expression with simple operand inside group equals operand.getValue()", 5, operand.getValue(), 0.000001);
        NpExpressionItem item2 =  npExprResult.getExpressionItems().get(2);
        assertTrue("2 item of expression with simple operand inside group instance of NpOperandExpressionItem", item2 instanceof NpGroupExpressionItem);
        assertTrue("2 item of expression with simple operand inside group isOpen()=true", ((NpGroupExpressionItem) item2).isClose());
    }

    @Test
    public void parseExpressionString_simpleOperandInsideGroupWithSpace() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprResult =npExpr.parseExpressionString("( 5)");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprResult);
        assertEquals("parseExpressionString simple operand inside group with space return size=3", 3, npExprResult.getExpressionItems().size());
        NpExpressionItem item0 =  npExprResult.getExpressionItems().get(0);
        assertTrue("0 item of expression with simple operand inside group with space instance of NpGroupExpressionItem", item0 instanceof NpGroupExpressionItem);
        assertTrue("0 item of expression with simple operand inside group with space isOpen()=true", ((NpGroupExpressionItem) item0).isOpen());
        NpExpressionItem item1 =  npExprResult.getExpressionItems().get(1);
        assertTrue("1 item of expression with simple operand inside group with space instance of NpOperandExpressionItem", item1 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item1;
        assertEquals("value of first item of expression with simple operand inside group with space equals operand.getValue()", 5, operand.getValue(), 0.000001);
        NpExpressionItem item2 =  npExprResult.getExpressionItems().get(2);
        assertTrue("2 item of expression with simple operand inside group with space instance of NpGroupExpressionItem", item2 instanceof NpGroupExpressionItem);
        assertTrue("2 item of expression with simple operand inside group with space isOpen()=true", ((NpGroupExpressionItem) item2).isClose());
    }

    @Test
    public void parseExpressionString_simpleOperation() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprRes =npExpr.parseExpressionString("5+7");

        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprRes);
        assertEquals("parseExpressionString simple operation return size=3", 3, npExprRes.getExpressionItems().size());
        NpExpressionItem item =  npExprRes.getExpressionItems().get(0);
        assertTrue("first item of expression with simple operation instance of NpOperandExpressionItem", item instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item;
        assertEquals("value of first item of expression with simple operation equals operand.getValue()", 5, operand.getValue(), 0.000001);
        NpExpressionItem item1 =  npExprRes.getExpressionItems().get(1);
        assertTrue("second item of expression with simple operation instance of NpOperationExpressionItem", item1 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation = (NpOperationExpressionItem)item;
        assertEquals("count of operands of second item of expression with simple operation equals operation.getOperandsNumber()", 2, operation.getOperandsNumber());
        assertEquals("name of operation of second item of expression with simple operation equals operation.getName()", "+", operation.getName());
        NpExpressionItem item2 =  npExprRes.getExpressionItems().get(2);
        assertTrue("third item of expression with simple operation instance of NpOperandExpressionItem", item2 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand1 = (NpOperandExpressionItem)item2;
        assertEquals("value of third item of expression with simple operation equals operand.getValue()", 7, operand1.getValue(), 0.000001);
       }
    @Test
    public void parseExpressionString_simpleOperationWithSpace() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprRes =npExpr.parseExpressionString("5+7 ");

        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprRes);
        assertEquals("parseExpressionString simple operation with space return size=3", 3, npExprRes.getExpressionItems().size());
        NpExpressionItem item =  npExprRes.getExpressionItems().get(0);
        assertTrue("first item of expression with simple operation with space instance of NpOperandExpressionItem", item instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item;
        assertEquals("value of first item of expression with simple operation with space equals operand.getValue()", 5, operand.getValue(), 0.000001);
        NpExpressionItem item1 =  npExprRes.getExpressionItems().get(1);
        assertTrue("second item of expression with simple operation with space instance of NpOperationExpressionItem", item1 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation = (NpOperationExpressionItem)item;
        assertEquals("count of operands of second item of expression with simple operation with space equals operation.getOperandsNumber()", 2, operation.getOperandsNumber());
        assertEquals("name of operation of second item of expression with simple operation  equals operation.getName()", "+", operation.getName());
        NpExpressionItem item2 =  npExprRes.getExpressionItems().get(2);
        assertTrue("third item of expression with simple operation with space instance of NpOperandExpressionItem", item2 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand1 = (NpOperandExpressionItem)item2;
        assertEquals("value of third item of expression with simple operation with space equals operand.getValue()", 7, operand1.getValue(), 0.000001);
    }


    @Test
    public void parseExpressionString_simpleOperationInsideGroup() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprRes =npExpr.parseExpressionString("(5+7)");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprRes);
        assertEquals("parseExpressionString simple operation inside group return size=5", 5, npExprRes.getExpressionItems().size());
        NpExpressionItem item0 =  npExprRes.getExpressionItems().get(0);
        assertTrue("0 item of expression with simple operation inside group instance of NpGroupExpressionItem", item0 instanceof NpGroupExpressionItem);
        assertTrue("0 item of expression with simple operation inside group isOpen()=true", ((NpGroupExpressionItem) item0).isOpen());
        NpExpressionItem item1 =  npExprRes.getExpressionItems().get(1);
        assertTrue("1 item of expression with simple operation inside group instance of NpOperandExpressionItem", item1 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item1;
        assertEquals("value of first item of expression with simple operation inside group equals operand.getValue()", 5, operand.getValue(), 0.000001);
        NpExpressionItem item2 =  npExprRes.getExpressionItems().get(2);
        assertTrue("2 item of expression with simple operation inside group instance of NpOperationExpressionItem", item2 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation = (NpOperationExpressionItem)item2;
        assertEquals("count of operands of second item of expression with simple operation inside group equals operation.getOperandsNumber()", 2, operation.getOperandsNumber());
        assertEquals("name of operation of second item of expression with simple operation inside group equals operation.getName()", "+", operation.getName());
        NpExpressionItem item3 =  npExprRes.getExpressionItems().get(3);
        assertTrue("3 item of expression with simple operation inside group instance of NpOperandExpressionItem", item3 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand1 = (NpOperandExpressionItem)item3;
        assertEquals("value of third item of expression with simple operation inside group equals operand.getValue()", 7, operand1.getValue(), 0.000001);
        NpExpressionItem item4 =  npExprRes.getExpressionItems().get(4);
        assertTrue("0 item of expression with simple operation inside group instance of NpGroupExpressionItem", item4 instanceof NpGroupExpressionItem);
        assertTrue("0 item of expression with simple operation inside group isClose()=true", ((NpGroupExpressionItem) item4).isClose());

    }

    @Test
    public void parseExpressionString_simpleOperationInsideGroupWithSpaces() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprRes =npExpr.parseExpressionString("(5+7 )");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprRes);
        assertEquals("parseExpressionString simple operation inside group with space return size=5", 5, npExprRes.getExpressionItems().size());
        NpExpressionItem item0 =  npExprRes.getExpressionItems().get(0);
        assertTrue("0 item of expression with simple operation inside group with space instance of NpGroupExpressionItem", item0 instanceof NpGroupExpressionItem);
        assertTrue("0 item of expression with simple operation inside group with space isOpen()=true", ((NpGroupExpressionItem) item0).isOpen());
        NpExpressionItem item1 =  npExprRes.getExpressionItems().get(1);
        assertTrue("1 item of expression with simple operation inside group with space instance of NpOperandExpressionItem", item1 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item1;
        assertEquals("value of first item of expression with simple operation inside group with space equals operand.getValue()", 5, operand.getValue(), 0.000001);
        NpExpressionItem item2 =  npExprRes.getExpressionItems().get(2);
        assertTrue("2 item of expression with simple operation inside group with space instance of NpOperationExpressionItem", item2 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation = (NpOperationExpressionItem)item2;
        assertEquals("count of operands of second item of expression with simple operation inside group with space equals operation.getOperandsNumber()", 2, operation.getOperandsNumber());
        assertEquals("name of operation of second item of expression with simple operation inside group with space equals operation.getName()", "+", operation.getName());
        NpExpressionItem item3 =  npExprRes.getExpressionItems().get(3);
        assertTrue("3 item of expression with simple operation inside group with space instance of NpOperandExpressionItem", item3 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand1 = (NpOperandExpressionItem)item3;
        assertEquals("value of third item of expression with simple operation inside group with space equals operand.getValue()", 7, operand1.getValue(), 0.000001);
        NpExpressionItem item4 =  npExprRes.getExpressionItems().get(4);
        assertTrue("4 item of expression with simple operation inside group with space instance of NpGroupExpressionItem", item4 instanceof NpGroupExpressionItem);
        assertTrue("4 item of expression with simple operation inside group with space isClose()=true", ((NpGroupExpressionItem) item4).isClose());
    }

    @Test
    public void parseExpressionString_2OperationsWithGroupLeft() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprRes =npExpr.parseExpressionString("(5+7)/2");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprRes);
        assertEquals("parseExpressionString 2 operations with group left return size=7", 7, npExprRes.getExpressionItems().size());
        NpExpressionItem item0 =  npExprRes.getExpressionItems().get(0);
        assertTrue("0 item of expression with 2 operations with group left instance of NpGroupExpressionItem", item0 instanceof NpGroupExpressionItem);
        assertTrue("0 item of expression with 2 operations with group left isOpen()=true", ((NpGroupExpressionItem) item0).isOpen());
        NpExpressionItem item1 =  npExprRes.getExpressionItems().get(1);
        assertTrue("1 item of expression with 2 operations with group left instance of NpOperandExpressionItem", item1 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item1;
        assertEquals("value of first item of expression with 2 operations with group left equals operand.getValue()", 5, operand.getValue(), 0.000001);
        NpExpressionItem item2 =  npExprRes.getExpressionItems().get(2);
        assertTrue("2 item of expression with 2 operations with group left instance of NpOperationExpressionItem", item2 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation = (NpOperationExpressionItem)item2;
        assertEquals("count of operands of second item of expression with 2 operations with group left equals operation.getOperandsNumber()", 2, operation.getOperandsNumber());
        assertEquals("name of operation of second item of expression with 2 operations with group left equals operation.getName()", "+", operation.getName());
        NpExpressionItem item3 =  npExprRes.getExpressionItems().get(3);
        assertTrue("3 item of expression with 2 operations with group left instance of NpOperandExpressionItem", item3 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand1 = (NpOperandExpressionItem)item3;
        assertEquals("value of third item of expression with 2 operations with group left equals operand.getValue()", 7, operand1.getValue(), 0.000001);
        NpExpressionItem item4 =  npExprRes.getExpressionItems().get(4);
        assertTrue("4 item of expression with 2 operations with group left instance of NpGroupExpressionItem", item4 instanceof NpGroupExpressionItem);
        assertTrue("4 item of expression with 2 operations with group left isClose()=true", ((NpGroupExpressionItem) item4).isClose());
        NpExpressionItem item5 =  npExprRes.getExpressionItems().get(5);
        assertTrue("5 item of expression with 2 operations with group left instance of NpOperationExpressionItem", item5 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation1 = (NpOperationExpressionItem)item5;
        assertEquals("count of operands of second item of expression with 2 operations with group left equals operation.getOperandsNumber()", 2, operation1.getOperandsNumber());
        assertEquals("name of operation of second item of expression with 2 operations with group left equals operation.getName()", "/", operation1.getName());
        NpExpressionItem item6 =  npExprRes.getExpressionItems().get(6);
        assertTrue("6 item of expression with 2 operations with group left instance of NpOperandExpressionItem", item6 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand2 = (NpOperandExpressionItem)item6;
        assertEquals("value of third item of expression with 2 operations with group left equals operand.getValue()", 2, operand2.getValue(), 0.000001);

    }

    @Test
    public void parseExpressionString_2OperationWithGroupRight() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprRes =npExpr.parseExpressionString("2*(5+7)");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprRes);
        assertEquals("parseExpressionString 2 operations with group right return size=7", 7, npExprRes.getExpressionItems().size());
        NpExpressionItem item0 =  npExprRes.getExpressionItems().get(0);
        assertTrue("0 item of expression with 2 operations with group right instance of NpOperandExpressionItem", item0 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand0 = (NpOperandExpressionItem)item0;
        assertEquals("value of first item of expression with 2 operations with group right equals operand.getValue()", 2, operand0.getValue(), 0.000001);
        NpExpressionItem item1 =  npExprRes.getExpressionItems().get(1);
        assertTrue("1 item of expression with 2 operations with group right instance of NpOperationExpressionItem", item1 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation0 = (NpOperationExpressionItem)item1;
        assertEquals("count of operands of second item of expression with 2 operations with group right equals operation.getOperandsNumber()", 2, operation0.getOperandsNumber());
        assertEquals("name of operation of second item of expression with 2 operations with group right equals operation.getName()", "*", operation0.getName());
        NpExpressionItem item2 =  npExprRes.getExpressionItems().get(2);
        assertTrue("2 item of expression with 2 operations with group right instance of NpGroupExpressionItem", item2 instanceof NpGroupExpressionItem);
        assertTrue("2 item of expression with 2 operations with group right isOpen()=true", ((NpGroupExpressionItem) item2).isOpen());
        NpExpressionItem item3 =  npExprRes.getExpressionItems().get(3);
        assertTrue("3 item of expression with 2 operations with group right instance of NpOperandExpressionItem", item3 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand = (NpOperandExpressionItem)item3;
        assertEquals("value of first item of expression with 2 operations with group right equals operand.getValue()", 5, operand.getValue(), 0.000001);
        NpExpressionItem item4 =  npExprRes.getExpressionItems().get(4);
        assertTrue("4 item of expression with 2 operations with group right instance of NpOperationExpressionItem", item4 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation = (NpOperationExpressionItem)item4;
        assertEquals("count of operands of second item of expression with 2 operations with group right equals operation.getOperandsNumber()", 2, operation.getOperandsNumber());
        assertEquals("name of operation of second item of expression with 2 operations with group right equals operation.getName()", "+", operation.getName());
        NpExpressionItem item5 =  npExprRes.getExpressionItems().get(5);
        assertTrue("5 item of expression with 2 operations with group right instance of NpOperandExpressionItem", item5 instanceof NpOperandExpressionItem);
        NpOperandExpressionItem operand1 = (NpOperandExpressionItem)item5;
        assertEquals("value of third item of expression with 2 operations with group right equals operand.getValue()", 7, operand1.getValue(), 0.000001);
        NpExpressionItem item6 =  npExprRes.getExpressionItems().get(6);
        assertTrue("6 item of expression with 2 operations with group right instance of NpGroupExpressionItem", item6 instanceof NpGroupExpressionItem);
        assertTrue("6 item of expression with 2 operations with group right isClose()=true", ((NpGroupExpressionItem) item6).isClose());
    }

    @Test
    public void parseExpressionString_2OperationWithGroupLeftNested() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprRes =npExpr.parseExpressionString("((5+8)/2)");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprRes);
        assertEquals("parseExpressionString 2 operation with group left nested return size=9", 9, npExprRes.getExpressionItems().size());
        NpExpressionItem item0 =  npExprRes.getExpressionItems().get(0);
        assertTrue("0 item of expression with 2 operation with group left nested instance of NpGroupExpressionItem", item0 instanceof NpGroupExpressionItem);
        assertTrue("0 item of expression with 2 operation with group left nested isOpen()=true", ((NpGroupExpressionItem) item0).isOpen());
        NpExpressionItem item1 =  npExprRes.getExpressionItems().get(1);
        assertTrue("1 item of expression with 2 operation with group left nested instance of NpGroupExpressionItem", item1 instanceof NpGroupExpressionItem);
        assertTrue("1 item of expression with 2 operation with group left nested isOpen()=true", ((NpGroupExpressionItem) item1).isOpen());
        NpExpressionItem item2 =  npExprRes.getExpressionItems().get(2);
        assertTrue("2 item of expression with 2 operation with group left nested instance of NpOperandExpressionItem", item2 instanceof NpOperandExpressionItem);
        assertEquals("value of first item of expression with 2 operation with group left nested equals operand.getValue()", 5, ((NpOperandExpressionItem) item2).getValue(), 0.000001);
        NpExpressionItem item3 =  npExprRes.getExpressionItems().get(3);
        assertTrue("3 item of expression with 2 operation with group left nested instance of NpOperationExpressionItem", item3 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation = (NpOperationExpressionItem)item3;
        assertEquals("count of operands of second item of expression with 2 operation with group left nested equals operation.getOperandsNumber()", 2, operation.getOperandsNumber());
        assertEquals("name of operation of second item of expression with 2 operation with group left nested equals operation.getName()", "+", operation.getName());
        NpExpressionItem item4 =  npExprRes.getExpressionItems().get(4);
        assertTrue("4 item of expression with 2 operation with group left nested instance of NpOperandExpressionItem", item4 instanceof NpOperandExpressionItem);
        assertEquals("value of first item of expression with 2 operation with group left nested equals operand.getValue()", 8, ((NpOperandExpressionItem) item4).getValue(), 0.000001);
        NpExpressionItem item5 =  npExprRes.getExpressionItems().get(5);
        assertTrue("5 item of expression with 2 operation with group left nested instance of NpGroupExpressionItem", item5 instanceof NpGroupExpressionItem);
        assertTrue("5 item of expression with 2 operation with group left nested isClose()=true", ((NpGroupExpressionItem) item5).isClose());
        NpExpressionItem item6 =  npExprRes.getExpressionItems().get(6);
        assertTrue("6 item of expression with 2 operation with group left nested instance of NpOperationExpressionItem", item6 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation1 = (NpOperationExpressionItem)item6;
        assertEquals("count of operands of second item of expression with 2 operation with group left nested equals operation.getOperandsNumber()", 2, operation1.getOperandsNumber());
        assertEquals("name of operation of second item of expression with 2 operation with group left nested equals operation.getName()", "/", operation1.getName());
        NpExpressionItem item7 =  npExprRes.getExpressionItems().get(7);
        assertTrue("7 item of expression with 2 operation with group left nested instance of NpOperandExpressionItem", item7 instanceof NpOperandExpressionItem);
        assertEquals("value of first item of expression with 2 operation with group left nested equals operand.getValue()", 2, ((NpOperandExpressionItem) item7).getValue(), 0.000001);
        NpExpressionItem item8 =  npExprRes.getExpressionItems().get(8);
        assertTrue("8 item of expression with 2 operation with group left nested instance of NpGroupExpressionItem", item8 instanceof NpGroupExpressionItem);
        assertTrue("8 item of expression with 2 operation with group left nested isClose()=true", ((NpGroupExpressionItem) item8).isClose());
    }

    @Test
    public void parseExpressionString_2OperationWithGroupRightNested() throws Exception {
        NpExpression npExpr = createInstance();
        NpExpression npExprRes =npExpr.parseExpressionString("(2*(5+8))");
        assertSame("parseExpressionString returns reference to the same object which is used for calling the method", npExpr, npExprRes);
        assertEquals("parseExpressionString 2 operation with group right nested return size=9", 9, npExprRes.getExpressionItems().size());
        NpExpressionItem item0 =  npExprRes.getExpressionItems().get(0);
        assertTrue("0 item of expression with 2 operation with group right nested instance of NpGroupExpressionItem", item0 instanceof NpGroupExpressionItem);
        assertTrue("0 item of expression with 2 operation with group right nested isOpen()=true", ((NpGroupExpressionItem) item0).isOpen());
        NpExpressionItem item1 =  npExprRes.getExpressionItems().get(1);
        assertTrue("1 item of expression with 2 operation with group right nested instance of NpOperandExpressionItem", item1 instanceof NpOperandExpressionItem);
        assertEquals("value of first item of expression with 2 operation with group right nested equals operand.getValue()", 2, ((NpOperandExpressionItem) item1).getValue(), 0.000001);
        NpExpressionItem item2 =  npExprRes.getExpressionItems().get(2);
        assertTrue("6 item of expression with 2 operation with group right nested instance of NpOperationExpressionItem", item2 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation = (NpOperationExpressionItem)item2;
        assertEquals("count of operands of second item of expression with 2 operation with group right nested equals operation.getOperandsNumber()", 2, operation.getOperandsNumber());
        assertEquals("name of operation of second item of expression with 2 operation with group right nested equals operation.getName()", "*", operation.getName());
        NpExpressionItem item3 =  npExprRes.getExpressionItems().get(3);
        assertTrue("3 item of expression with 2 operation with group right nested instance of NpGroupExpressionItem", item3 instanceof NpGroupExpressionItem);
        assertTrue("3 item of expression with 2 operation with group right nested isOpen()=true", ((NpGroupExpressionItem) item3).isOpen());
        NpExpressionItem item4 =  npExprRes.getExpressionItems().get(4);
        assertTrue("4 item of expression with 2 operation with group right nested instance of NpOperandExpressionItem", item4 instanceof NpOperandExpressionItem);
        assertEquals("value of first item of expression with 2 operation with group right nested equals operand.getValue()", 5, ((NpOperandExpressionItem) item4).getValue(), 0.000001);
        NpExpressionItem item5 =  npExprRes.getExpressionItems().get(5);
        assertTrue("3 item of expression with 2 operation with group right nested instance of NpOperationExpressionItem", item5 instanceof NpOperationExpressionItem);
        NpOperationExpressionItem operation1 = (NpOperationExpressionItem)item5;
        assertEquals("count of operands of second item of expression with 2 operation with group right nested equals operation.getOperandsNumber()", 2, operation1.getOperandsNumber());
        assertEquals("name of operation of second item of expression with 2 operation with group right nested equals operation.getName()", "+", operation1.getName());
        NpExpressionItem item6 =  npExprRes.getExpressionItems().get(6);
        assertTrue("6 item of expression with 2 operation with group right nested instance of NpOperandExpressionItem", item6 instanceof NpOperandExpressionItem);
        assertEquals("value of first item of expression with 2 operation with group right nested equals operand.getValue()", 8, ((NpOperandExpressionItem) item6).getValue(), 0.000001);
        NpExpressionItem item7 =  npExprRes.getExpressionItems().get(7);
        assertTrue("5 item of expression with 2 operation with group right nested instance of NpGroupExpressionItem", item7 instanceof NpGroupExpressionItem);
        assertTrue("5 item of expression with 2 operation with group right nested isClose()=true", ((NpGroupExpressionItem) item7).isClose());
        NpExpressionItem item8 =  npExprRes.getExpressionItems().get(8);
        assertTrue("8 item of expression with 2 operation with group right nested instance of NpGroupExpressionItem", item8 instanceof NpGroupExpressionItem);
        assertTrue("8 item of expression with 2 operation with group right nested isClose()=true", ((NpGroupExpressionItem) item8).isClose());
    }

    protected abstract NpExpression createInstance();

}
