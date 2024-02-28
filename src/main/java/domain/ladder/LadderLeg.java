package domain.ladder;

import domain.ladder.attribute.Direction;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLeg {
    private final List<LadderLegPiece> ladderLegPieces;
    private static final Supplier<Direction> downDirectionSupplier = () -> Direction.DOWN;

    public LadderLeg(final List<LadderLegPiece> ladderLegPieces) {
        this.ladderLegPieces = ladderLegPieces;
    }

    public static LadderLeg downLadderLeg(int height) {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height)
                                                                     .mapToObj(index -> downDirectionSupplier.get())));
    }

    public static LadderLeg fromPreviousWithDynamicDirection(LadderLeg previousLadderLeg, int height, Supplier<Direction> directionSupplier) {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height)
                                                                     .mapToObj(previousLadderLeg::hasRightDirectionAtIndex)
                                                                     .map(flag -> determineDirection(flag, directionSupplier.get()))));
    }

    public static LadderLeg fromPreviousWithDownDirection(LadderLeg previousLadderLeg, int height) {
        return fromPreviousWithDynamicDirection(previousLadderLeg, height, downDirectionSupplier);
    }

    private static Direction determineDirection(boolean prevRightDirectionFlag, Direction direction) {
        if (prevRightDirectionFlag) {
            return Direction.LEFT;
        }
        return direction;
    }

    private static List<LadderLegPiece> convertDirectionToLegPieceList(Stream<Direction> directionStream) {
        return directionStream.map(LadderLegPiece::new)
                              .toList();
    }

    public boolean hasRightDirectionAtIndex(int index) {
        return ladderLegPieces.get(index)
                              .isRightDirection();
    }

    public Direction getDirectionAtIndex(int index) {
        return ladderLegPieces.get(index)
                              .getDirection();
    }
}
