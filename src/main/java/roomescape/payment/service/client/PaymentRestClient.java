package roomescape.payment.service.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import roomescape.payment.service.dto.PaymentClientErrorResponse;
import roomescape.payment.service.dto.PaymentClientResponse;
import roomescape.payment.service.dto.PaymentConfirmRequest;

@RequiredArgsConstructor
public class PaymentRestClient implements PaymentClient {

    private final RestClient restClient;

    @Value("${payment.key}")
    private String SECRET_KEY;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public PaymentClientResponse confirm(PaymentConfirmRequest paymentConfirmRequest) {
        return restClient.post().uri("/confirm")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Basic " + Base64.getEncoder()
                        .encodeToString((SECRET_KEY + ':').getBytes(StandardCharsets.UTF_8)))
                .body(paymentConfirmRequest)
                .retrieve()
                .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        (req, res) -> {
                            try {
                                byte[] body = res.getBody().readAllBytes();
                                PaymentClientErrorResponse error = objectMapper.readValue(body,
                                        PaymentClientErrorResponse.class);
                                throw new IllegalArgumentException(error.message());
                            } catch (Exception e) {
                                throw new RuntimeException("응답 바디 파싱 실패", e);
                            }
                        }
                )
                .body(PaymentClientResponse.class);
    }
}
