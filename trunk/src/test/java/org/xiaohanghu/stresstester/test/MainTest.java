package org.xiaohanghu.stresstester.test;

import org.xiaohanghu.stresstester.StressTask;
import org.xiaohanghu.stresstester.StressTestUtils;

/**
 * @author xiaohanghu
 */
public class MainTest {

	public static void main(String[] args) {
		StressTestUtils.testAndPrint(100, 1000, new StressTask() {

			@Override
			public Object doTask() throws Exception {
				System.out.println("Do my task.");
				return null;
			}
		});
	}

}
