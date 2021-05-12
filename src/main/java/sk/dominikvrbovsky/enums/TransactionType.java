package sk.dominikvrbovsky.enums;

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

    public static TransactionType getEnumFromString(String string) {
        for (TransactionType transactionType : TransactionType.values()) {
            if (transactionType.getTransactionType().equals(string)) {
                return transactionType;
            }
        }

        throw new UnsupportedOperationException("Zadali ste chybný názov transakcie");
    }
}
