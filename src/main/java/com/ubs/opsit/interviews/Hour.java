package com.ubs.opsit.interviews;

public class Hour implements TimeConverter {

	private static final String ALL_LIGHTS_OFF = "OOOO";
	private static final int FIVE_MULTIPLE = 5;
	private static final String LIGHT_RED = "R";


	@Override
	public String convertTime(final String hours) {
		int hrs = Integer.parseInt(hours);
		return getMinutesMultiples5(hrs) + System.getProperty("line.separator") + getHour(hrs);
	}

	public String getMinutesMultiples5(int hours) {

		final StringBuilder lights = new StringBuilder(ALL_LIGHTS_OFF);

		for (int i = 0; i < (hours / FIVE_MULTIPLE); i++) {
			lights.replace(i, i + 1, LIGHT_RED);
		}
		return lights.toString();
	}

	public String getHour(int hours) {

		final StringBuilder lights = new StringBuilder(ALL_LIGHTS_OFF);
		for (int i = 0; i < (hours % FIVE_MULTIPLE); i++) {
			lights.replace(i, i + 1, LIGHT_RED);
		}
		return lights.toString();
	}
}