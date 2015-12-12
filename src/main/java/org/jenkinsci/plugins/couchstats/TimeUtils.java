package org.jenkinsci.plugins.couchstats;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;

public class TimeUtils {

	public static String timeStamp(long timeInMillis) {
		DateTime dt = new DateTime(timeInMillis);
		DateTime utc = dt.withZone(DateTimeZone.UTC);
		return ISODateTimeFormat.dateTime().print(utc);
	}

}
