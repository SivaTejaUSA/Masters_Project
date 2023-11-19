package businessrequirementtesting;

import utils.DatabaseReader;

public class BusinessRequirementTestCase {
	
	public static boolean validateDataInDatabase(String expectedValue, String tableName, String testCaseName, String columnName) {
        DatabaseReader reader = new DatabaseReader();
        String value = reader.getValue(tableName, testCaseName, columnName);
        return value.equals(expectedValue);
    }

}
