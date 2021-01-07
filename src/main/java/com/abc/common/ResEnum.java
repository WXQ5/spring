package com.abc.common;

public enum ResEnum {
    //统一异常处理
    SUCCESS(200,"success"),
    SUCCESS_USER_EXIST(201,"user exist success"),
    SUCCESS_DEL_BATCH(202,"delete batch success"),
    ERROR_USER_EXIST(501,"user exist error"),
    ERROR(500,"error"),
    ERROR_PARAMS_IN_DELBATCH(501,"param can't be null"),
    ERROR_PARAMS_IN_SAVEBATCH(502,"param can't be null"),
    ERROR_MONEY_NOT_ENOUGH(503,"账户余额不足"),
    ERROR_NO_ACCOUNT(504,"无此账户");

    private int status;
    private String msg;

    ResEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
