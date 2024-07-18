package com.technicaltest.transaction.processing.system.controller.dto;

public enum ResponseCode {
    LCC000(500, "Ocurrio un error inesperado, por favor intenta mas tarde."),
    LCC001(200, "Operacion exitosa.");

    private final int status;
    private final String htmlMessage;
    ResponseCode(int status, String htmlMessage) {
        this.status = status;
        this.htmlMessage = htmlMessage;
    }

    public int getStatus() {
        return this.status;
    }

    public String getHtmlMessage() {
        return this.htmlMessage;
    }
}
