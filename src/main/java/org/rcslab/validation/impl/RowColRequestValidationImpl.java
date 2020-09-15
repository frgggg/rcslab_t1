package org.rcslab.validation.impl;

import org.rcslab.entity.RowColRequest;
import org.rcslab.validation.RowColRequestValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

public class RowColRequestValidationImpl implements ConstraintValidator<RowColRequestValidation, RowColRequest> {

    public static final String NULL_ROW_MSG = "null row";
    public static final String NULL_COL_MSG = "null col";

    public static final String WRONG_ROW_MSG = "wrong row";
    public static final String WRONG_COL_MSG = "wrong col";

    public static final Set<Character> DB_COLS = Set.of('a', 'b', 'c', 'd', 'y', 'v');

    @Override
    public boolean isValid(RowColRequest value, ConstraintValidatorContext context) {
        Character row = value.getRow();
        if(row == null) {
            setContext(context, NULL_ROW_MSG);
            return false;
        }

        if(!DB_COLS.contains(row)) {
            setContext(context, WRONG_ROW_MSG);
            return false;
        }

        Character col = value.getCol();
        if(col == null) {
            setContext(context, NULL_COL_MSG);
            return false;
        }
        if(!DB_COLS.contains(col)) {
            setContext(context, WRONG_COL_MSG);
            return false;
        }
        return true;
    }

    private void setContext(ConstraintValidatorContext context, String msg) {
        context.disableDefaultConstraintViolation();
        context
                .buildConstraintViolationWithTemplate(msg)
                .addConstraintViolation();
    }
}
