package com.ubs.opsit.interviews.junit;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.interviews.BerlinClockImpl;
import com.ubs.opsit.interviews.TimeConverter;

public class TimeConverterImplTest {
	private TimeConverter converter = new BerlinClockImpl();
	private final static String newLine = System.getProperty("line.separator");
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyTime() {
		converter.convertTime("");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testNullTime() {
		converter.convertTime(null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidFormatTime() {
		converter.convertTime("HH:mm:ss");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTime() {
		converter.convertTime("25:85:65");
	}
	/**
	 * Time Test for 00_00_00
	 */
	@Test
	public void testFor00_00_00() {
		final String match = new StringBuilder("Y").append(newLine)
				.append("OOOO").append(newLine)
				.append("OOOO").append(newLine)
				.append("OOOOOOOOOOO").append(newLine)
				.append("OOOO").toString();
		Assert.assertEquals(match, converter.convertTime("00:00:00"));
	}

	/**
	 * Time Test for 13_17_01
	 */
	@Test
	public void testFor13_17_01() {
		final String match = new StringBuilder("0").append(newLine)
				.append("RROO").append(newLine)
				.append("RRRO").append(newLine)
				.append("YYROOOOOOOO").append(newLine)
				.append("YYOO").toString();
		Assert.assertEquals(match, converter.convertTime("13:17:01"));
	}

	/**
	 * Time Test for 23:59:59
	 */
	@Test
	public void testFor23_59_59() {
		final String match = new StringBuilder("0").append(newLine)
				.append("RRRR").append(newLine)
				.append("RRRO").append(newLine)
				.append("YYRYYRYYRYY").append(newLine)
				.append("YYYY").toString();
		Assert.assertEquals(match, converter.convertTime("23:59:59"));
	}
}
