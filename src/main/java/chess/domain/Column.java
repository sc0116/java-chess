package chess.domain;

import java.util.Arrays;

public enum Column {
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8);

	private final int value;

	Column(int value) {
		this.value = value;
	}

	public static Column of(String value) {
		return Arrays.stream(values())
			.filter(column -> Integer.parseInt(value) == column.value)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 column 값입니다."));
	}
}
