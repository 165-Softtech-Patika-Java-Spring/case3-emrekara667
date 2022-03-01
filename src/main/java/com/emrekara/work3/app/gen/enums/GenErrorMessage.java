package com.emrekara.work3.app.gen.enums;

public enum GenErrorMessage implements BaseErrorMessage{

    ITEM_NOT_FOUND("Item not found!"),
    FILE_ALREADY_EXIST("Phone or name or email already exist")
    ;

    private String message;

    GenErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

}
