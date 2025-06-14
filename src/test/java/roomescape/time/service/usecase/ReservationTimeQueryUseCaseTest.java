package roomescape.time.service.usecase;

import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import roomescape.time.domain.ReservationTime;
import roomescape.time.repository.FakeReservationTimeRepository;
import roomescape.time.repository.ReservationTimeRepository;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationTimeQueryUseCaseTest {

    private ReservationTimeQueryUseCase reservationTimeQueryUseCase;
    private ReservationTimeRepository reservationTimeRepository;

    private ReservationTime savedTime;

    @BeforeEach
    void setUp() {
        reservationTimeRepository = new FakeReservationTimeRepository();
        reservationTimeQueryUseCase = new ReservationTimeQueryUseCase(reservationTimeRepository);
        savedTime = reservationTimeRepository.save(ReservationTime.withoutId(LocalTime.of(23, 30)));
    }

    @Test
    @DisplayName("예약 시간을 조회할 수 있다")
    void getReservationTime() {
        // given
        final Long id = savedTime.getId();

        // when
        final ReservationTime reservationTime = reservationTimeQueryUseCase.get(id);

        // then
        assertThat(reservationTime.getStartAt()).isEqualTo(savedTime.getStartAt());
    }

    @Test
    @DisplayName("예약 시간을 전체 조회할 수 있다")
    void getAllReservationTimes() {
        // given
        ReservationTime target = reservationTimeRepository.save(
                ReservationTime.withoutId(savedTime.getStartAt().plusMinutes(15)));

        // when
        final List<ReservationTime> times = reservationTimeQueryUseCase.getAll();

        // then
        assertThat(times).contains(target);
    }
}
