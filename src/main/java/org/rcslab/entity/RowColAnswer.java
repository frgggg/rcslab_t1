package org.rcslab.entity;

import lombok.Data;

@Data
public class RowColAnswer {
    private String row;
    private String col;
    private Integer val;

    public RowColAnswer(String row, String col, Integer val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
