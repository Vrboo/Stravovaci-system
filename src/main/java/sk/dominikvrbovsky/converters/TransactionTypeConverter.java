package sk.dominikvrbovsky.converters;

import sk.dominikvrbovsky.enums.TransactionType;
import javax.persistence.AttributeConverter;

/**
 * TransactionType[enum] converter for database (converting between TransactionType[enum] and String)
 */
public class TransactionTypeConverter implements AttributeConverter<TransactionType, String> {

    /**
     * Converting from enum TransactionType to text string
     * @param transactionType enum TransactionType
     * @return text string representing input enum TransactionType
     */
    @Override
    public String convertToDatabaseColumn(TransactionType transactionType) {
        if (transactionType == null) return null;

        return transactionType.getTransactionType();
    }

    /**
     * Converting from text string to enum TransactionType
     * @param s text string representing enum TransactionType
     * @return enum TransactionType
     */
    @Override
    public TransactionType convertToEntityAttribute(String s) {
        if (s == null) return null;

        return TransactionType.getEnumFromString(s);
    }
}
