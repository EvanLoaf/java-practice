package com.gmail.evanloafakahaitao.hwk.hwk12;

public class ExceptionOfWater extends RuntimeException {

    public ExceptionOfWater() {
    }

    public ExceptionOfWater(String message) {
        super(message);
    }

    public ExceptionOfWater(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionOfWater(Throwable cause) {
        super(cause);
    }

    public ExceptionOfWater(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
