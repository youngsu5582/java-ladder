package domain.result;

import domain.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {
    @Test
    @DisplayName("문자열을 통해 보상을 생성한다.")
    public void createReward() {
        String value = "꽝";

        Result result = new Result(value);

        assertEquals(result.resultToString(), value);
    }
}