package org.jenkinsci.plugins.couchstats;

import hudson.Extension;

import java.util.logging.Logger;

import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

/**
 * Global Configuration for Couch Stats.
 */
@Extension
public class CouchStatsConfig extends GlobalConfiguration {

	private static final Logger LOGGER = Logger.getLogger(CouchStatsConfig.class.getName());

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

		LOGGER.info("Saving config data");
		save();
		return super.configure(req, formData);
	}

	public static CouchStatsConfig get() {
		return GlobalConfiguration.all().get(CouchStatsConfig.class);
	}

	// @TODO: implement form validation
}
