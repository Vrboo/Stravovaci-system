package sk.dominikvrbovsky.enums;

/**
 * Type of transaction
 */
public enum TransactionType {

    INPUT("Vklad"),
    OUTPUT("Výber");

    private final String transactionType;

    TransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    /**
     * From input text string to enum value
     * @param string text representing enum value
     * @return enum value
     */
    public static TransactionType getEnumFromString(String string) {
        for (TransactionType transactionType : TransactionType.values()) {
            if (transactionType.getTransactionType().equals(string)) {
                return transactionType;
            }
        }

        throw new UnsupportedOperationException("Zadali ste chybný názov transakcie");
    }
}
