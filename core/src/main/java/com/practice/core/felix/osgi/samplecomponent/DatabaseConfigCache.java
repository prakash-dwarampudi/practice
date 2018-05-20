package com.practice.core.felix.osgi.samplecomponent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;

@Component(name = "DB Config Cache", immediate = true, metatype = false)
@Service(value = DatabaseConfigCache.class)
public class DatabaseConfigCache {

	@Reference(referenceInterface = DatabaseConfig.class, cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC, name = "Database configs list")
	private List<DatabaseConfig> databaseConfigs;
	private static Map<String, DatabaseConfig> dbConfigCache;

	protected void bindDatabaseConfig(DatabaseConfig config) {
		if (dbConfigCache == null) {
			dbConfigCache = new HashMap<String, DatabaseConfig>();
		}
		dbConfigCache.put(config.getDbName(), config);
	}

	protected void unbindDatabaseConfig(DatabaseConfig config) {
		dbConfigCache.remove(config.getDbName());
	}

	public static DatabaseConfig getConfig(String dbName) {
		return dbConfigCache.get(dbName);
	}

}
