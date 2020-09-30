package org.jenkinsci.plugins.couchstats;

import hudson.Extension;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.model.listeners.RunListener;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

/** Send jenkins result and duration of Jenkins jobs to a couchdb/cloudant server */
@Extension
public class CouchStatsListener extends RunListener<Run> {

  private static final Logger LOGGER = Logger.getLogger(CouchStatsListener.class.getName());

  @Override
  public void onCompleted(final Run r, final TaskListener listener) {
    CouchStatsConfig config = CouchStatsConfig.get();

    if (config.getUrl() == null || config.getUrl().equals("")) {
      LOGGER.log(Level.WARNING, "CouchStats plugin not configured, skipping");
      return;
    }

    String jobName = r.getParent().getFullName();
    String result = "";
    if (r.getResult() != null) {
      result = String.format("%s", r.getResult());
    }
    long duration = r.getDuration();
    long timeInMillis = r.getTimeInMillis();
    String timeString = r.getTimestampString();
    String timeStamp = TimeUtils.timeStamp(timeInMillis);

    LOGGER.log(Level.INFO, "CouchStatsListener: config: " + config);
    LOGGER.log(
        Level.INFO,
        "CouchStatsListener: job: " + jobName + ", result: " + result + ", duration: " + duration);

    try {
      LOGGER.log(Level.INFO, "Sending stats to " + config.getUrl());
      final String username = config.getUsername();
      final String password = config.getPassword().getPlainText();
      HttpClient client =
          new StdHttpClient.Builder()
              .url(config.getUrl())
              .username(username)
              .password(password)
              .build();

      CouchDbInstance instance = new StdCouchDbInstance(client);
      CouchDbConnector connector = new StdCouchDbConnector(config.getDocument(), instance);

      StatsRecord record = new StatsRecord();
      record.setJobName(jobName);
      record.setStatus(result);
      record.setDuration(duration);
      record.setTimeInMillis(timeInMillis);
      record.setTimeString(timeString);
      record.setTimeStamp(timeStamp);

      LOGGER.log(Level.FINE, "Saving build record...");
      StatsRecordRepository repository = new StatsRecordRepository(connector);
      repository.add(record);
      LOGGER.log(Level.FINE, "Saving build record. Done");
    } catch (MalformedURLException e) {
      LOGGER.log(Level.SEVERE, "Unable to configure couchdb connector", e);
    }
  }
}
