package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public List<String> readNames() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n", DELIMITER);
        return getValidResult(readLine());
    }

    private List<String> getValidResult(String input) {
        validateDelimiter(input);
        List<String> result = toNames(input);
        validateDuplicate(result);
        return result;
    }

    private String readLine() {
        return scanner.nextLine();
    }

    private void validateDelimiter(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(String.format("%s로 끝날 수 없습니다", DELIMITER));
        }
    }

    private List<String> toNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toList());
    }


    private void validateDuplicate(List<String> result) {
        if (result.size() != result.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다");
        }
    }

    public int readLadderHeightAndTransform() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return toNumber(readLine());
    }

    private int toNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.", exception);
        }
    }
}