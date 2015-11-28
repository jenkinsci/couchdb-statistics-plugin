package org.jenkinsci.plugins.couchstats;

import hudson.model.Run;
import hudson.Extension;
import hudson.model.*;
import hudson.model.listeners.RunListener;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static hudson.model.Result.*;

/**
 * Send jenkins result and duration of Jenkins jobs to a couchdb/cloudant server
 */
@Extension
public class CouchStatsListener extends RunListener<Run> {

    private static final Logger LOGGER = Logger.getLogger(CouchStatsListener.class.getName());

    @Override
    public void onCompleted(final Run r, final TaskListener listener) {
        CouchStatsConfig config = CouchStatsConfig.get();

        if (config.getHost() == "") {
            // not configured
            return;
        }

        String host = config.getHost();

        String jobName = r.getParent().getFullName().toString();
        String result = r.getResult().toString();
        long duration = r.getDuration();

        LOGGER.log(Level.INFO, "CouchStatsListener: config: " + config);
        LOGGER.log(Level.INFO, "CouchStatsListener: job: " + jobName + ", result: " + result +
                               ", duration: " + duration);
		// TODO record result here
    }
}
