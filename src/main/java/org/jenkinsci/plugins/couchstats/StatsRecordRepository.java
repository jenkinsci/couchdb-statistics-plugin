package org.jenkinsci.plugins.couchstats;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

public class StatsRecordRepository extends CouchDbRepositorySupport<StatsRecord> {

	public StatsRecordRepository(CouchDbConnector connector) {
		super(StatsRecord.class, connector, true);
	}

}
