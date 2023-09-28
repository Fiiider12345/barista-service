package sk.marekpecho.barista_service.enums;

public enum Coffee {
	LONG_BLACK("Long Black", 1.2), LATTE("Latte", 1.5), CAPPUCCINO("Cappuccino", 1.3), ESPRESSO("Espresso", 1.0);

	private String code;
	private Double price;

	private Coffee(String code, Double price) {
		this.code = code;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public String getCode() {
		return code;
	}

	public static Coffee getEnumFromCode(String dbData) {
		if (dbData.equalsIgnoreCase("Long Black")) {
			return LONG_BLACK;
		}

		if (dbData.equalsIgnoreCase("Latte")) {
			return LATTE;
		}

		if (dbData.equalsIgnoreCase("Cappuccino")) {
			return CAPPUCCINO;
		}

		if (dbData.equalsIgnoreCase("Espresso")) {
			return ESPRESSO;
		}

		throw new UnsupportedOperationException("For this " + dbData + " does not exist enum of type Coffee");
	}
}
