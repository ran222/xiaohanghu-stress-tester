package org.xiaohanghu.stresstester;

/**
 * @author xiaohanghu
 */
public class StressTestUtils {

	private static StressTestEngine stressTestEngine = new StressTestEngine();
	private static SimpleResultFormater simpleResultFormater = new SimpleResultFormater();

	public static StressTestResult test(int concurrencyLevel,
			int totalRequests, StressTask stressTask) {
		return stressTestEngine.test(concurrencyLevel, totalRequests,
				stressTask);
	}

	public static StressTestResult test(int concurrencyLevel,
			int totalRequests, StressTask stressTask, int warmUpTime) {
		return stressTestEngine.test(concurrencyLevel, totalRequests,
				stressTask, warmUpTime);
	}

	public static void testAndPrint(int concurrencyLevel, int totalRequests,
			StressTask stressTask) {
		testAndPrint(concurrencyLevel, totalRequests, stressTask, null);
	}

	public static void testAndPrint(int concurrencyLevel, int totalRequests,
			StressTask stressTask, String testName) {
		StressTestResult stressTestResult = test(concurrencyLevel,
				totalRequests, stressTask);
		String str = simpleResultFormater.format(stressTestResult, testName);
		System.out.println(str);
	}

}
