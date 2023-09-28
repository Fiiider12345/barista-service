package sk.marekpecho.barista_service.enums;

public enum Milk {
	COW("Cow", 0.5), SOY("Soy", 1.0), ALMOND("Almond", 1.0), NONE("None", 0.0);

	private String code;
	private Double price;

	private Milk(String code, Double price) {
		this.code = code;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public String getCode() {
		return code;
	}

	public static Milk getEnumFromCode(String dbData) {
		if (dbData.equalsIgnoreCase("Cow")) {
			return COW;
		}

		if (dbData.equalsIgnoreCase("Soy")) {
			return SOY;
		}

		if (dbData.equalsIgnoreCase("Almond")) {
			return ALMOND;
		}

		if (dbData.equalsIgnoreCase("None")) {
			return NONE;
		}

		throw new UnsupportedOperationException("For this " + dbData + " does not exist enum of type Milk");
	}
}
