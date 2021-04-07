package sk.dominikvrbovsky.converters;

import sk.dominikvrbovsky.enums.TransactionType;

import javax.persistence.AttributeConverter;

public class TransactionTypeConverter implements AttributeConverter<TransactionType, String> {

    @Override
    public String convertToDatabaseColumn(TransactionType transactionType) {
        if (transactionType == null) return null;

        return transactionType.getTransactionType();
    }

    @Override
    public TransactionType convertToEntityAttribute(String s) {
        if (s == null) return null;

        return TransactionType.getEnumFromString(s);
    }
}
