package roomescape.common.exception;

import roomescape.common.exception.error.ErrorCode;

public class TimeOutException extends ConnectionException {

    public TimeOutException(String message) {
        super(message);
    }

    public TimeOutException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
