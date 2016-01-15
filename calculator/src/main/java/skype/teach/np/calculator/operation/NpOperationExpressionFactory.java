package skype.teach.np.calculator.operation;

/**
 * Factory(List with operations instance of NpOperationExpressionItem) of arithmetic operations.
 * Factory contains default arithmetic operation {@link NpAddOperation},{@link NpMultiOperation},{@link NpDivisionOperation},{@link NpMultiOperation}
 * @author NPrilepa
 */
public interface NpOperationExpressionFactory {
    /**
     * Get operation object from operation factory
     * @param name name of operation
     * @return operation object instance of NpOperationExpressionItem
     */
    NpOperationExpressionItem getOperationByName(String name);

    /**
     * Add new operation to factory.
     * @param operation new operation
     */
    void registerOperation(NpOperationExpressionItem operation);

}
