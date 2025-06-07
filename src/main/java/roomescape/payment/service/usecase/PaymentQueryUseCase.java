package roomescape.payment.service.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.common.exception.NotFoundException;
import roomescape.payment.domain.Payment;
import roomescape.payment.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentQueryUseCase {

    private final PaymentRepository paymentRepository;

    public Payment get(final Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("id에 해당하는 결제 내역을 찾을 수 없습니다."));
    }
}
