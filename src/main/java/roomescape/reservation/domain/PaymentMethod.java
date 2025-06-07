package roomescape.reservation.domain;

import java.util.Arrays;
import lombok.Getter;
import roomescape.common.exception.NotFoundException;

@Getter
public enum PaymentMethod {
    PENDING_PAYMENT("1"),
    PAID_PG("2"),
    PAID_ONSITE("3");

    private final String code;

    PaymentMethod(final String code) {
        this.code = code;
    }

    public static PaymentMethod ofCode(final String code) {
        return Arrays.stream(values())
                .filter(status -> status.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new NotFoundException("해당 코드에 대한 예약 상태가 존재하지 않습니다."));
    }

    public boolean isEqual(PaymentMethod status) {
        return this.equals(status);
    }
}
