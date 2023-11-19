package reporting;

import mainpackage.TestRunner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ReportManager {
    private static final StringBuilder reportContent = new StringBuilder();
    private static final Map<String, TestResult> testResults = Collections.synchronizedMap(new LinkedHashMap<>());
    private static final List<String> testCaseOrder = new ArrayList<>();


    public static void initReport() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateAndTime = sdf.format(new Date());

        reportContent.append("<html><head><title>Test Report</title></head><body>");
        reportContent.append("<h1 style='text-align:center;'>Test Execution Report (" + currentDateAndTime + ")</h1>");
        reportContent.append("<table border='1'><tr><th><b>Test Case</b></th><th><b>Execution Time (Seconds)</b></th><th><b>Screenshot</b></th></tr>");
    }


    public synchronized static void addTestResult(String testCase, boolean passed, long time, String screenshotPath) {
        testResults.put(testCase, new TestResult(time, screenshotPath, passed));
        testCaseOrder.add(testCase);
    }

    public static void finalizeReport() {
        int passed = 0, failed = 0;
        long totalTime = 0;
        TestRunner runner=new TestRunner();
        String[][] testcases=runner.getTestCases();
        for(String[] testcasearray: testcases)
        {
        	String testCase=testcasearray[1];
            TestResult result = testResults.get(testCase);
            totalTime += result.time;
            if (result.passed) {
                passed++;
            } else {
                failed++;
            }

            addTestCase(testCase, result.time, result.screenshotPath, result.passed);
        }

        reportContent.append("</table>");
        reportContent.append("<h2>Summary</h2>");
        reportContent.append("Total Test Cases Passed: " + passed);
        reportContent.append("<br/>Total Test Cases Failed: " + failed);
        reportContent.append("<br/>Total Execution Time: " + totalTime + " Seconds");
        reportContent.append("</body></html>");
        
        System.out.println(reportContent);
        System.out.println(testResults);
        System.out.println(testCaseOrder);
    }

    public static void addActualExecutionTime(long time) {
        reportContent.append("<h2>Actual Execution Time</h2>");
        reportContent.append("Total Actual Execution Time: " + time + " Seconds");
    }

    private static void addTestCase(String testCaseName, long executionTime, String screenshotPath, boolean passed) {
        String color = passed ? "green" : "red";
        reportContent.append("<tr style='background-color:" + color + "'>");
        reportContent.append("<td style='text-align:center;' width='400' height='400'><b>" + testCaseName + "</b></td>");
        reportContent.append("<td style='text-align:center;' width='400' height='400'><b>" + executionTime + "</b></td>");
	    String screenshotHtml = screenshotPath.equals("No Screenshot")
	                             ? "No Screenshot"
	                             : "<img src='" + screenshotPath + "' width='700', height='400'/>";
	    reportContent.append("<td style='text-align:center;'>" + screenshotHtml + "</td>");
	    reportContent.append("</tr>");

    }

    private static class TestResult {
        long time;
        String screenshotPath;
        boolean passed;

        TestResult(long time, String screenshotPath, boolean passed) {
            this.time = time;
            this.screenshotPath = screenshotPath;
            this.passed = passed;
        }
    }

    public static void saveReport(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(reportContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
