package sk.marekpecho.barista_service.enums;

public enum Size {
	SMALL('S', 0.0), MEDIUM('M', 0.3), LARGE('L', 0.5);

	private char code;
	private Double price;

	private Size(char code, Double price) {
		this.code = code;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public char getCode() {
		return code;
	}

	public static Size getEnumFromCode(Character dbData) {
		if (dbData.equals('S') || dbData.equals('s')) {
			return SMALL;
		}

		if (dbData.equals('M') || dbData.equals('m')) {
			return MEDIUM;
		}

		if (dbData.equals('L') || dbData.equals('l')) {
			return LARGE;
		}

		throw new UnsupportedOperationException("For this " + dbData + " does not exist enum of type Size");
	}
}
