import lambda.Apple;
import lambda.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaTest {

    private List<Apple> apples = new ArrayList<>();

    @BeforeEach
    void setUp() {
        apples.add(new Apple(Color.GREEN, 3));
        apples.add(new Apple(Color.RED, 5));
        apples.add(new Apple(Color.GREEN, 7));
        apples.add(new Apple(Color.RED, 8));
        apples.add(new Apple(Color.GREEN, 9));
    }

    @DisplayName("filter 1 step")
    @Test
    void filter_foreach_red_apple() {

        List<Apple> result = new ArrayList<>();

        for (Apple apple : apples) {
            if (apple.color == Color.RED) {
                result.add(apple);
            }
        }

        assertEquals(result.size(), 2);
    }
}
