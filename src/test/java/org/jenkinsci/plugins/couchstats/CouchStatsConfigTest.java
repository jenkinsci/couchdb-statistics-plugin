package org.jenkinsci.plugins.couchstats;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import hudson.util.Secret;
import java.io.IOException;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

public class CouchStatsConfigTest {

  @Rule public final JenkinsRule r = new JenkinsRule();

  @Test
  public void canLoadAndSaveConfig() throws IOException {
    CouchStatsConfig config = CouchStatsConfig.get();
    assertThat(config, is(notNullValue()));

    config.setUsername("username");
    config.setDocument("document");
    config.setPassword(Secret.fromString("password"));
    config.setUrl("http://localhost");
    config.save();

    CouchStatsConfig reloaded = CouchStatsConfig.get();
    assertThat(reloaded, is(notNullValue()));
    assertThat(reloaded.getUsername(), is("username"));
    assertThat(reloaded.getDocument(), is("document"));
    assertThat(reloaded.getUrl(), is("http://localhost"));
    assertThat(reloaded.getPassword().getPlainText(), is("password"));
  }
}
