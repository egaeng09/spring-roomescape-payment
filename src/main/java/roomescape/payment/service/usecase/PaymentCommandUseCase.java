package roomescape.payment.service.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.payment.domain.Payment;
import roomescape.payment.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentCommandUseCase {

    private final PaymentRepository paymentRepository;

    public Payment create(final Payment payment) {
        return paymentRepository.save(payment);
    }
}
