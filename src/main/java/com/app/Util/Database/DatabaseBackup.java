package com.app.Util.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseBackup {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void backupDatabase() {
        // Exécuter la requête SQL de sauvegarde
        jdbcTemplate.execute("BACKUP DATABASE my_database TO '/path/to/backup.sql'");
    }
}

