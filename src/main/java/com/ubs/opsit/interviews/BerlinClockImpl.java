package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BerlinClockImpl implements TimeConverter{

	/**
	 * This method accepts time in hh:mm:ss format
	 * and returns a the time in Berlin format
	 *
	 * @param time String time in hh:mm:ss format
	 * @return String in Berlin time
	 */
	@Override
	public String convertTime(String aTime) {
		String output = null;
		if(aTime != null && validateInput(aTime)){

			Hour hour = new Hour();
			Minute minute = new Minute();
			Second second = new Second();
			List<String> parts = Stream.of(aTime).map(w -> w.split(":")).flatMap(Arrays::stream).collect(Collectors.toList());
			String newLine = System.getProperty("line.separator");
			output = second.convertTime(parts.get(2)) + newLine +
					hour.convertTime(parts.get(0))+ newLine +
					minute.convertTime(parts.get(1));
		}else{
			throw new IllegalArgumentException("Time is required in the format HH:MM:SS");
		}
		return output;
	}
	/**
	 * This method will accept string and validate input  as time.
	 * @param aTime
	 * @return true if give time is in valid otherwise false
	 */
	private boolean validateInput(String aTime) {
		final Pattern pattern = Pattern.compile("^([0-1]\\d|2[0-4]):([0-5]\\d):([0-5]\\d)$");
		final Matcher matcher= pattern.matcher(aTime);
		return matcher.find();
	}
	public static void main(String[] args) {
		new BerlinClockImpl().convertTime(null);
	}
}
