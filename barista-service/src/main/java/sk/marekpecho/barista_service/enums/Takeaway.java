package sk.marekpecho.barista_service.enums;

public enum Takeaway {
	ON_SITE("ON SITE"), TAKEAWAY("TAKEAWAY");

	private String code;

	private Takeaway(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static Takeaway getEnumFromCode(String dbData) {
		if (dbData.equalsIgnoreCase("ON SITE")) {
			return ON_SITE;
		}

		if (dbData.equalsIgnoreCase("TAKEAWAY")) {
			return TAKEAWAY;
		}

		throw new UnsupportedOperationException("For this " + dbData + " does not exist enum of type Takeaway");
	}
}
