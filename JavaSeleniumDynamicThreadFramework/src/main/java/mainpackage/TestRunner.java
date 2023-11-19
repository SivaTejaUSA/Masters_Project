package mainpackage;

import java.util.concurrent.CountDownLatch;

import core.DynamicThreadManager;
import reporting.ReportManager;
import testcases.TestCaseExecutor;
import utils.DatabaseReader;

public class TestRunner {
	
	static String homeDir = System.getProperty("user.dir");
	static DatabaseReader databaseReader = new DatabaseReader();
	String[][] testCases = databaseReader.readTable("TestCases");
    static int testCasesSize;
    

	public static void main(String[] args) {
        try {
            TestRunner runner = new TestRunner();
            testCasesSize = runner.testCases.length; 

            ReportManager.initReport();
            CountDownLatch latch = new CountDownLatch(testCasesSize);
            long parallelStartTime = System.currentTimeMillis(); // Capture the start time before parallel execution

            for (String[] testCaseMethods : runner.testCases) {
                String testCaseName = testCaseMethods[1];
                for (int i = 2; i < testCaseMethods.length; i++) {
                    String methodName = testCaseMethods[i];
                    if (methodName != null && !methodName.isEmpty()) {
                        DynamicThreadManager.submitTask(testCaseName, methodName, () -> {
                            try {
                                long startTime = System.currentTimeMillis();
                                boolean passed=TestCaseExecutor.executeTestCase(methodName,testCaseName);
                                System.out.println(passed);
                                long endTime = System.currentTimeMillis();
                                long executionTime = (endTime - startTime)/1000;
                                String screenshotPath = homeDir+"\\src\\main\\resources\\screenshots\\" +testCaseName+ ".png";
                                ReportManager.addTestResult(testCaseName, passed, executionTime, screenshotPath);
                            } finally {
                                latch.countDown();  // Decrease the latch counter
                            }
                        });
                    }
                }
            }

            // Wait for all threads to complete
            latch.await();
            DynamicThreadManager.shutdown();
            long parallelEndTime = System.currentTimeMillis(); // Capture the end time after all threads have completed
            long actualexecutiontime=(parallelEndTime - parallelStartTime)/1000;
            System.out.println(runner.testCases);
            ReportManager.finalizeReport();
            ReportManager.addActualExecutionTime(actualexecutiontime);  // Add actual execution time
            ReportManager.saveReport(homeDir+"\\src\\main\\resources\\reports\\report.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String[][] getTestCases() {
		return this.testCases;
	}
    
    public static int getTestCasessize() {
		return testCasesSize;
	}
    
    public static DatabaseReader getDatabaseReader() {
		return databaseReader;
	}
}
