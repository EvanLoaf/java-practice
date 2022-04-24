package com.gmail.evanloafakahaitao.hwk.hwk12;

public class ExceptionOfFire extends RuntimeException {

    public ExceptionOfFire() {
    }

    public ExceptionOfFire(String message) {
        super(message);
    }

    public ExceptionOfFire(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionOfFire(Throwable cause) {
        super(cause);
    }

    public ExceptionOfFire(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
