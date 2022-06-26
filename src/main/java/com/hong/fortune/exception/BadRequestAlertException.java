package com.hong.fortune.exception;


import lombok.Getter;

/**
 * @author ZHANG
 */
@Getter
public class BadRequestAlertException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String errorKey;

    private final String message;

    public enum Type {
        /*
         * 错误码
         */
        F404("404", "resource not found");
        @Getter
        private final String code;

        @Getter
        private final String desc;

        Type(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    public BadRequestAlertException(Type type) {
        this(type.code, type.desc);
    }

    public BadRequestAlertException(String errorKey, String message) {
        this.errorKey = errorKey;
        this.message = message;
    }
}
