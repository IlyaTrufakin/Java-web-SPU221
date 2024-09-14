package itstep.learning.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbModule extends AbstractModule {
    private Connection currentConnection = null;
    private Driver mySqlDriver = null;



    @Provides //методы провайдеры определяют инжекцию по типу возврата
    private Connection getConnection() throws SQLException {
        if (currentConnection == null) {
            Map<String, String> ini = new HashMap<>();
            try (InputStream iniStream = this.getClass().getClassLoader().getResourceAsStream("db.ini")) {
                String iniContent = readStream(iniStream);
                String[] lines = iniContent.split("\n");

                for (String line : lines) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        ini.put(parts[0].trim(), parts[1].trim());
                    }

                }
                //currentConnection = DriverManager.getConnection(iniContent);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

            try {
                mySqlDriver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(mySqlDriver);
                currentConnection = DriverManager.getConnection(
                        ini.get("connectionString"),
                        ini.get("user"),
                        ini.get("password")
                       );

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                //req.setAttribute("dbError", ex.getMessage());
            }
        }
        return currentConnection;
    }

public void closeConnection() {
        try {
            if (currentConnection != null) {
                currentConnection.close();
            }
            if (mySqlDriver != null) {
                DriverManager.deregisterDriver(mySqlDriver);
            }
        }
        catch (Exception ignore) {

        }

    }


    private String readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuilder = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 16];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            byteBuilder.write(buffer, 0, length);
        }
        return byteBuilder.toString(StandardCharsets.UTF_8.name());
    }
}

/*
инжекция через методы провайдеры - управляемая инжекция
 */