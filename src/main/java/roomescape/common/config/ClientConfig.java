package roomescape.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import roomescape.payment.service.client.PaymentClient;
import roomescape.payment.service.client.PaymentRestClient;

@Configuration
public class ClientConfig {

    @Bean
    public PaymentClient todoRestClient() {
        return new PaymentRestClient(
            RestClient.builder().baseUrl("https://api.tosspayments.com/v1/payments").build()
        );
    }
}
