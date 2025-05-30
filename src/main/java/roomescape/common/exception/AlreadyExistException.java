package roomescape.common.exception;

public class AlreadyExistException extends CustomException {

    public AlreadyExistException(String message) {
        super(message, GeneralErrorCode.CONFLICT);
    }
}
