package cn.j3code.config.exception;


public class ldException extends RuntimeException {
    public ldException() {
    }
    public ldException(String message, Object... args) {
        super(String.format(message, args));
    }

    public ldException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }

    public ldException(Throwable cause) {
        super(cause);
    }

}
