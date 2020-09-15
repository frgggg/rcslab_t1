package org.rcslab.entity;

import lombok.Data;
import org.rcslab.validation.RowColRequestValidation;

@Data
@RowColRequestValidation
public class RowColRequest {

    private Character row;
    private Character col;

    public RowColRequest(){}

    public RowColRequest(Character row, Character col) {
        this.row = row;
        this.col = col;
    }
}
