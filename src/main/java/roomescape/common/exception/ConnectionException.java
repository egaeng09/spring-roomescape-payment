package roomescape.common.exception;

import roomescape.common.exception.error.ErrorCode;
import roomescape.common.exception.error.GeneralErrorCode;

public class ConnectionException extends CustomException {

    public ConnectionException(String message) {
        super(message, GeneralErrorCode.EXTERNAL_SERVER_CONNECTION_ERROR);
    }

    public ConnectionException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
