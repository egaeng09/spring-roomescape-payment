package roomescape.common.exception;

public class AuthenticationException extends CustomException {

    public AuthenticationException(String message) {
        super(message, GeneralErrorCode.UNAUTHORIZED);
    }

    public AuthenticationException(String message, GeneralErrorCode generalErrorCode) {
        super(message, generalErrorCode);
    }
}
