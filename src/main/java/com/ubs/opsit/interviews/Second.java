package com.ubs.opsit.interviews;

public class Second implements TimeConverter {

	@Override
	public String convertTime(final String secs){
		int seconds = Integer.parseInt(secs);
		if (0 == seconds%2) {
			return "Y";
		}
		return "O";
	}
}