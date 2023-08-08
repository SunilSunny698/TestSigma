package com.intro.delivery.dto;

import java.util.List;

public class RequestDto {
    private List<CriteriaDto> criteriaDtoList;


    private BooleanOperator boolOp;
    public enum BooleanOperator{
        AND,OR
    }








    public List<CriteriaDto> getCriteriaDtoList() {
        return criteriaDtoList;
    }

    public void setCriteriaDtoList(List<CriteriaDto> criteriaDtoList) {
        this.criteriaDtoList = criteriaDtoList;
    }

    public BooleanOperator getBoolOp() {
        return boolOp;
    }

    public void setBoolOp(BooleanOperator boolOp) {
        this.boolOp = boolOp;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "criteriaDtoList=" + criteriaDtoList.toString() +
                ", boolOp=" + boolOp +
                '}';
    }
}
