package com.ubs.opsit.interviews;

public class Minute implements TimeConverter {

	private static final String RED_LIGHT = "R";
	private static final String LIGHT_YELLOW = "Y";
	private static final String LIGHTS_OFF_FOUR = "OOOO";
	private static final String LIGHTS_OFF_ELEVEN = "OOOOOOOOOOO";

	@Override
	public String convertTime(final String mins) {
		int minutes = Integer.parseInt(mins);
		int minutesDividedBy5 = minutes / 5;
		int minutesModulus5 = minutes % 5;

		return getMinutesMultiples5(minutesDividedBy5) + System.getProperty("line.separator") + getMinute(minutesModulus5);
	}

	private String getMinutesMultiples5(int minutes) {

		StringBuilder lights = new StringBuilder(LIGHTS_OFF_ELEVEN);

		for (int i = 0; i < minutes; i++) {
			if (0 == (i + 1) % 3) {
				lights.replace(i, i + 1, RED_LIGHT);
			} else {
				lights.replace(i, i + 1, LIGHT_YELLOW);
			}
		}
		return lights.toString();
	}

	private String getMinute(int minutes) {

		StringBuilder lights = new StringBuilder(LIGHTS_OFF_FOUR);

		for (int i = 0; i < minutes; i++) {
			lights.replace(i, i + 1, LIGHT_YELLOW);
		}
		return lights.toString();
	}
	public static void main(String[] args) {
		new Minute().convertTime(null);
	}
}