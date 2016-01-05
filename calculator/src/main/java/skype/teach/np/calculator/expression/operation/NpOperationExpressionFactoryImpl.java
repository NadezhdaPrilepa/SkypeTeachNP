package skype.teach.np.calculator.expression.operation;

import java.util.Map;

/**
 * @author NPrilepa
 */
public class NpOperationExpressionFactoryImpl implements NpOperationExpressionFactory {
    private Map<String, NpOperationExpressionItem> operationsFactory;

    public NpOperationExpressionFactoryImpl() {
        NpAddOperation addOperation = new NpAddOperation();
        this.operationsFactory.put(addOperation.getName(), addOperation);
        NpMultiOperation multiOperation =  new NpMultiOperation();
        this.operationsFactory.put(multiOperation.getName(), new NpMultiOperation());
    }

    public NpOperationExpressionItem getOperationByName(String name) {
        return operationsFactory.get(name);
    }

    public void registerOperation(NpOperationExpressionItem operation) {
        this.operationsFactory.put(operation.getName(), operation);
    }
}
