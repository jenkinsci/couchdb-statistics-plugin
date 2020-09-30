package org.jenkinsci.plugins.couchstats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TimeUtilsTest {

  @Test
  public void canCreateTimestamp() {
    String timeStamp = TimeUtils.timeStamp(0);
    assertNotNull(timeStamp);
    assertEquals("1970-01-01T00:00:00.000Z", timeStamp);
  }

  @Test
  public void canCreateTimestampFromRealTimestamp() {
    String timeStamp = TimeUtils.timeStamp(1449927167146L);
    assertNotNull(timeStamp);
    assertEquals("2015-12-12T13:32:47.146Z", timeStamp);
  }
}
