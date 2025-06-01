package roomescape.common.exception;

import roomescape.common.exception.error.GeneralErrorCode;

public class InvalidInputException extends CustomException {

    public InvalidInputException(String message) {
        super(message, GeneralErrorCode.INVALID_INPUT);
    }
}
