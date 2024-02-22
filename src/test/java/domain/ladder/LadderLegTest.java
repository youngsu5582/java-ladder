package domain.ladder;

import domain.ladder.common.Direction;
import domain.ladder.LadderLeg;
import domain.ladder.LadderLegPiece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LadderLegTest {
    @Test
    @DisplayName("사다리 조각을 통해 사다리 다리를 만든다.")
    public void createLadderLeg() {
        List<Direction> directions = List.of(Direction.LEFT, Direction.RIGHT);
        List<LadderLegPiece> ladderLegPieces = 사다리_조각들_생성(directions);

        LadderLeg ladderLeg = new LadderLeg(ladderLegPieces);

        assertInstanceOf(LadderLeg.class, ladderLeg);
    }

    @Test
    @DisplayName("가지고 있는 특정 사다리 조각의 방향이 오른쪽인지 확인한다.")
    public void checkLadderPieceDirection() {
        List<Direction> directions = List.of(Direction.RIGHT, Direction.LEFT);
        List<LadderLegPiece> ladderLegPieces = 사다리_조각들_생성(directions);

        LadderLeg ladderLeg = new LadderLeg(ladderLegPieces);

        assertTrue(ladderLeg.hasRightDirectionAtIndex(0));
        assertFalse(ladderLeg.hasRightDirectionAtIndex(1));
    }
    @Test
    @DisplayName("가지고 있는 특정 사다리 조각의 방향을 알려준다.")
    public void getDirectionAtIndex(){
        List<Direction> directions = List.of(Direction.RIGHT, Direction.LEFT);
        List<LadderLegPiece> ladderLegPieces = 사다리_조각들_생성(directions);

        LadderLeg ladderLeg = new LadderLeg(ladderLegPieces);

        assertEquals(ladderLeg.getDirectionAtIndex(0),Direction.RIGHT);
        assertEquals(ladderLeg.getDirectionAtIndex(1),Direction.LEFT);
    }

    private List<LadderLegPiece> 사다리_조각들_생성(List<Direction> directions) {
        return directions.stream()
                         .map(LadderLegPiece::new)
                         .toList();
    }
}