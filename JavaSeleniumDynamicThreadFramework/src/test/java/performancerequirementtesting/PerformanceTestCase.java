package performancerequirementtesting;

import testcases.TestMethods;

public class PerformanceTestCase {
	
	public static boolean validateTestcaseExecutionTime(String TestcaseName, long expectedTimeMillis) {
        long start = System.currentTimeMillis();
        TestMethods methods=new TestMethods();
        methods.method1(TestcaseName);
        long end = System.currentTimeMillis();
        return (end - start) <= expectedTimeMillis;
    }

}
