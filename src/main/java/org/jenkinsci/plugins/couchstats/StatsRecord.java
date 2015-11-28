package org.jenkinsci.plugins.couchstats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsRecord {

	@JsonProperty("id")
	private String _id;
	@JsonProperty("revision")
	private String _rev;
	private String jobName;
	private String status;
	private long duration;

	public String getId() {
		return _id;
	}

	public void setId(String _id) {
		this._id = _id;
	}

	public String getRev() {
		return _rev;
	}

	public void setRev(String _rev) {
		this._rev = _rev;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

}
