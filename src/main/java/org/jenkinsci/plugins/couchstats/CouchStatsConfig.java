package org.jenkinsci.plugins.couchstats;

import hudson.Extension;
import hudson.util.FormValidation;
import hudson.util.Secret;
import java.util.logging.Logger;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

/** Global Configuration for Couch Stats. */
@Extension
public class CouchStatsConfig extends GlobalConfiguration {

  private static final Logger LOGGER = Logger.getLogger(CouchStatsConfig.class.getName());

  private String url;
  private String username;
  private Secret password;
  private String document;

  public CouchStatsConfig() {
    load();
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(Secret password) {
    this.password = password;
  }

  public Secret getPassword() {
    return password;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  @Override
  public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
    this.url = formData.getString("url");
    this.username = formData.getString("username");
    this.password = Secret.fromString(formData.getString("password"));
    this.document = formData.getString("document");

    LOGGER.info("Saving config data");
    save();
    return super.configure(req, formData);
  }

  public static CouchStatsConfig get() {
    return GlobalConfiguration.all().get(CouchStatsConfig.class);
  }

  public FormValidation doCheckUrl(@QueryParameter String url) {
    if (StringUtils.isEmpty(url)) {
      return FormValidation.error("Url must not be empty");
    }
    if (url.startsWith("http://") || url.startsWith("https://")) {
      return FormValidation.ok();
    }
    return FormValidation.error("Url must start with http:// or https://");
  }

  public FormValidation doCheckDocument(@QueryParameter String document) {
    if (StringUtils.isEmpty(document)) {
      return FormValidation.error("Document must not be empty");
    }
    return FormValidation.ok();
  }
}
