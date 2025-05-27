package roomescape.payment.service.dto;

public record PaymentClientErrorResponse(
    String code,
    String message
) {

}
