package roomescape.common.exception;

public class ReferencedByOtherException extends CustomException {

    public ReferencedByOtherException(String message) {
        super(message, GeneralErrorCode.CONFLICT);
    }

    public ReferencedByOtherException(String message, GeneralErrorCode generalErrorCode) {
        super(message, generalErrorCode);
    }
}
