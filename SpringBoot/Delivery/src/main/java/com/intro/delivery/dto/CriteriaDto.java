package com.intro.delivery.dto;

import lombok.Getter;

@Getter
public class CriteriaDto {
    String column;
    String value;
    String joinTable;
    Operation operation;

    public enum Operation {
        EQUAL, GREATER_THAN, LESS_THAN, BETWEEN, LIKE,INNER_JOIN,LEFT_JOIN,RIGHT_JOIN,CUST_ORDERS,IN,STARTS_WITH,ENDS_WITH
    };

    public void setColumn(String column) {
        this.column = column;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setJoinTable(String joinTable) {
        this.joinTable = joinTable;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "CriteriaDto{" +
                "column='" + column + '\'' +
                ", value='" + value + '\'' +
                ", joinTable='" + joinTable + '\'' +
                ", operation=" + operation +
                '}';
    }
}

