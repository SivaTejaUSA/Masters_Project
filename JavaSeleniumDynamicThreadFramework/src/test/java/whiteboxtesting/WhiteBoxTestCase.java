package whiteboxtesting;

import utils.DatabaseReader;

public class WhiteBoxTestCase {
	
	 public static boolean validateDatabaseReader(int expectedRow, String tableName) {
	        DatabaseReader reader = new DatabaseReader();
	        String[][] data = reader.readTable(tableName);
	        	if(data.length == expectedRow)
	        	{
	                    return true;
	            }
	        return false;
	    }

}
