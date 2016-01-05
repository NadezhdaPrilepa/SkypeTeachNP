package skype.teach.np.calculator.expression.operation;

import java.util.Map;

/**
 * @author NPrilepa
 */
public class NpOperationExpressionFactoryImpl implements NpOperationExpressionFactory {
    private Map<String, NpOperationExpressionItem> operationsFactory;

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

    public NpOperationExpressionItem getOperationByName(String name) {
        return operationsFactory.get(name);
    }

    public void registerOperation(NpOperationExpressionItem operation) {
        this.operationsFactory.put(operation.getName(), operation);
    }
}
