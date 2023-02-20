package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final String INVALID_HEIGHT_MESSAGE = "사다리의 높이는 참가자 수 이상이어야 합니다.";

    private final List<Line> ladder;

    public Ladder(int height, int personCount) {
        validate(height, personCount);
        ladder = generateLadder(height, personCount);
    }

    private static void validate(int height, int personCount) {
        if (height >= personCount) {
            return;
        }

        throw new IllegalArgumentException(INVALID_HEIGHT_MESSAGE);
    }

    private List<Line> generateLadder(int height, int personCount) {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(booleanGenerator, personCount));
        }

        return ladder;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}