import optional.Car;
import optional.Insurance;
import optional.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalTest {

    @DisplayName("보수적인 자세로 Null Pointer Exception 피하기")
    @Test
    void null_pointer_exception() {
        assertThat(getCarInsuranceName(null)).isEqualTo("Unknown");
    }

    private String getCarInsuranceName(Person person) {
        Car car = person.getCar()
                .orElseThrow(IllegalArgumentException::new);

        Insurance insurance = car.getInsurance()
                .orElseThrow(IllegalArgumentException::new);

        return insurance.getName();

    }

}
