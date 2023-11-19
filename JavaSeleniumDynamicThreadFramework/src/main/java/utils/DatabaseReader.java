package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReader {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/QATestingDatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public String[][] readTable(String tableName) {
        List<String[]> dataList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + tableName);
             ResultSet resultSet = statement.executeQuery()) {

            int colCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                String[] rowData = new String[colCount];
                for (int i = 1; i <= colCount; i++) {
                    rowData[i - 1] = resultSet.getString(i);
                }
                dataList.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataList.toArray(new String[dataList.size()][]);
    }

    public String getValue(String tableName, String testcase, String columnName) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement("SELECT " + columnName + " FROM " + tableName + " WHERE TestCaseName = ?")) {

            statement.setString(1, testcase);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString(columnName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void updateValue(String tableName, String testcase, String columnName, String value) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement("UPDATE " + tableName + " SET " + columnName + " = ? WHERE TestCaseName = ?")) {

            statement.setString(1, value);
            statement.setString(2, testcase);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
