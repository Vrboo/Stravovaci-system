package sk.dominikvrbovsky.enums;

public enum TransactionType {

    INPUT("vklad"),
    OUTPUT("vyber");

    private final String transactionType;

    TransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return transactionType;
    }
}
