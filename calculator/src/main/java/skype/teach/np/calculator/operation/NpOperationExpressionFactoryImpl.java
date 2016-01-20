package skype.teach.np.calculator.operation;

import java.util.*;

/**
 * @author NPrilepa
 */
public class NpOperationExpressionFactoryImpl implements NpOperationExpressionFactory {
    private Map<String, NpOperationExpressionItem> operationsFactory = new HashMap();
    private List<String> names = new ArrayList<String>();
    public NpOperationExpressionFactoryImpl() {
        NpAddOperation addOperation = new NpAddOperation();
        registerOperation(addOperation);
        NpMultiOperation multiOperation =  new NpMultiOperation();
        registerOperation(multiOperation);
        NpDivisionOperation divisionOperation = new NpDivisionOperation();
        registerOperation(divisionOperation);
        NpSubtractionOperation subtractionOperation =  new NpSubtractionOperation();
        registerOperation(subtractionOperation);
    }

    public final NpOperationExpressionItem getOperationByName(String name) {

        return operationsFactory.get(name);
    }

    public void registerOperation(NpOperationExpressionItem operation) {
        this.operationsFactory.put(operation.getName(), operation);
    }

    public Set<String> getNames()
    {
        return this.operationsFactory.keySet();

    }
}
