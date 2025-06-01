package roomescape.payment.service.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldNameConstants;
import roomescape.common.utils.Validator;

@FieldNameConstants(level = AccessLevel.PRIVATE)
public record PaymentClientResponse(
    String paymentKey,
    String orderId,
    Long totalAmount,
    String status,
    String requestedAt,
    String approvedAt
) {

}
