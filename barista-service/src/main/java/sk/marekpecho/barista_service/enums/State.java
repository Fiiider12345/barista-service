package sk.marekpecho.barista_service.enums;

public enum State {
	WAITING("Waiting"), IN_PREPARATION("In preparation"), FINISHED("Finished"), PICKED_UP("Picked up");

	private String code;

	private State(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static State getEnumFromCode(String dbData) {
		if (dbData.equalsIgnoreCase("Waiting")) {
			return WAITING;
		}

		if (dbData.equalsIgnoreCase("In preparation")) {
			return IN_PREPARATION;
		}

		if (dbData.equalsIgnoreCase("Finished")) {
			return FINISHED;
		}

		if (dbData.equalsIgnoreCase("Picked up")) {
			return PICKED_UP;
		}

		throw new UnsupportedOperationException("For this " + dbData + " does not exist enum of type State");
	}

}
