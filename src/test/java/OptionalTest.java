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

    @DisplayName("보수적인 자세로 Null Pointer Exception 피하기2")
    @Test
    void null_pointer_exception2() {
        assertThat(getCarInsuranceName2(null)).isEqualTo("Unknown");
    }

    private String getCarInsuranceName(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    private String getCarInsuranceName2(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }
}
