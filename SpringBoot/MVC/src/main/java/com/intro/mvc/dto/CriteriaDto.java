package com.intro.mvc.dto;

public class CriteriaDto {
    private String column;
    private String value;



    private Operation operation;
    public enum Operation{
        EQUAL,GREATER_THAN,LESS_THAN,BETWEEN,LIKE
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
