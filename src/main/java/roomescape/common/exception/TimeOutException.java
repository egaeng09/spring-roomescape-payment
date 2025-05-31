package roomescape.common.exception;

public class TimeOutException extends ConnectionException {

    public TimeOutException(String message) {
        super(message);
    }

    public TimeOutException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
