package skype.teach.np.calculator.expression;

/**
 * @author NPrilepa
 */
public class NpGroupExpressionItemImpl implements NpGroupExpressionItem {
    private String groupStr;



    public NpGroupExpressionItemImpl(String str) {
        groupStr = str;

    }

    public boolean isOpen() {
        return groupStr.equals("(");
    }

    public boolean isClose() {
        return groupStr.equals(")");
    }

    public static String getSymbolOpen() {
        return "(";
    }

    public static String getSymbolClose() {
        return ")";
    }
}
