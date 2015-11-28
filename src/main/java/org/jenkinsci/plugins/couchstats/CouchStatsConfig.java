package org.jenkinsci.plugins.couchstats;

import hudson.Extension;
import hudson.Util;
import hudson.model.*;
import hudson.model.labels.LabelAtom;
import hudson.util.LogTaskListener;
import jenkins.model.GlobalConfiguration;
import jenkins.model.Jenkins;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Global Configuration for Couch Stats.
 */
@Extension
public class CouchStatsConfig extends GlobalConfiguration {

    private static final Logger LOGGER = Logger.getLogger(Descriptor.class.getName());

    private String host;
    private String username;
	private String password;
	private String document;

    public CouchStatsConfig() {
        load();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
        this.host = formData.getString("host");
        this.username = formData.getString("username");
        this.password = formData.getString("password");
        this.document = formData.getString("document");

        save();
        return super.configure(req,formData);
    }

    public static CouchStatsConfig get() {
        return GlobalConfiguration.all().get(CouchStatsConfig.class);
    }

    // @TODO: implement form validation
}
