package roomescape.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.payment.domain.Payment;
import roomescape.payment.service.client.PaymentClient;
import roomescape.payment.service.converter.PaymentConverter;
import roomescape.payment.service.dto.PaymentClientResponse;
import roomescape.payment.service.dto.PaymentConfirmRequest;
import roomescape.payment.service.usecase.PaymentCommandUseCase;
import roomescape.payment.service.usecase.PaymentQueryUseCase;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentClient paymentClient;
    private final PaymentCommandUseCase paymentCommandUseCase;
    private final PaymentQueryUseCase paymentQueryUseCase;

    public Payment confirm(PaymentConfirmRequest paymentConfirmRequest) {
        PaymentClientResponse confirm = paymentClient.confirm(paymentConfirmRequest);
        return paymentCommandUseCase.create(PaymentConverter.toDomain(confirm));
    }

    public Payment get(Long id) {
        return paymentQueryUseCase.get(id);
    }
}
