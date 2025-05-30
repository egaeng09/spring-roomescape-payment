package roomescape.common.exception;

public class NotFoundException extends CustomException {

    public NotFoundException() {
        super("요청하신 자원을 찾을 수 없습니다.", GeneralErrorCode.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(message, GeneralErrorCode.NOT_FOUND);
    }

    public NotFoundException(String message, GeneralErrorCode generalErrorCode) {
        super(message, generalErrorCode);
    }
}
