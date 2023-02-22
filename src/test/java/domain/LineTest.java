package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ExistLineGenerator;
import util.NonExistLineGenerator;
import util.RandomLineGenerator;

public class LineTest {

    @Test
    @DisplayName("참가자수-1만큼 status 생성")
    void makeLine() {
        int numberOfLine = 3;
        Line line = new Line(numberOfLine, new RandomLineGenerator());
        assertThat(line.getLine().size()).isEqualTo(numberOfLine);
    }

    @Test
    @DisplayName("다리가 존재하는 Line생성")
    void makeExistLine() {
        int numberOfLine = 1;
        Line line = new Line(numberOfLine, new ExistLineGenerator());

        assertThat(line.getLine().get(0)).isEqualTo(LineStatus.EXIST);
    }

    @Test
    @DisplayName("다리가 존재하지 않는 Line생성")
    void makeNonExistLine() {
        int numberOfLine = 1;
        Line line = new Line(numberOfLine, new NonExistLineGenerator());

        assertThat(line.getLine().get(0)).isEqualTo(LineStatus.NON_EXIST);
    }
}