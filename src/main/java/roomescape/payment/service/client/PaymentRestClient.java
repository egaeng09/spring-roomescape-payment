package roomescape.payment.service.client;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import roomescape.payment.service.dto.PaymentConfirmRequest;
import roomescape.payment.service.dto.PaymentClientResponse;

@RequiredArgsConstructor
public class PaymentRestClient implements PaymentClient {

    private final RestClient restClient;

    @Value("${payment.key}")
    private String SECRET_KEY;

    public PaymentClientResponse confirm(PaymentConfirmRequest paymentConfirmRequest) {
        return restClient.post().uri("/confirm")
            .contentType(MediaType.APPLICATION_JSON)
            .header("Authorization", "Basic " + Base64.getEncoder()
                .encodeToString((SECRET_KEY + ':').getBytes(StandardCharsets.UTF_8)))
            .body(paymentConfirmRequest)
            .retrieve()
//            .onStatus()
            //TODO: 예외 처리
            .body(PaymentClientResponse.class);
    }
}
