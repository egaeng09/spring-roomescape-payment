package roomescape.payment.domain;

import org.junit.jupiter.api.Test;
import roomescape.common.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.*;

class PaymentTest {

    @Test
    void createPayment() {
        // given
        final String paymentKey = "paymentKey123";
        final String orderId = "orderId123";
        final Long amount = 10000L;
        final String requestedAt = "2023-10-01T10:00:00Z";
        final String approvedAt = "2023-10-01T10:05:00Z";

        // when & then
        assertThatNoException()
                .isThrownBy(() -> Payment.withoutId(paymentKey, orderId, amount, requestedAt, approvedAt));
    }

    @Test
    void createPaymentWithNoPaymentKey() {
        // given
        final String orderId = "orderId123";
        final Long amount = 10000L;
        final String requestedAt = "2023-10-01T10:00:00Z";
        final String approvedAt = "2023-10-01T10:05:00Z";

        // when & then
        assertThatThrownBy(() -> Payment.withoutId(null, orderId, amount, requestedAt, approvedAt))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("Payment.paymentKey 은(는) null일 수 없습니다.");

    }
}
