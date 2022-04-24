package com.gmail.evanloafakahaitao.hwk.hwk12;

public class ExceptionOfWind extends RuntimeException {

    public ExceptionOfWind() {
    }

    public ExceptionOfWind(String message) {
        super(message);
    }

    public ExceptionOfWind(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionOfWind(Throwable cause) {
        super(cause);
    }

    public ExceptionOfWind(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
