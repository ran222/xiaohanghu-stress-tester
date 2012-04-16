package org.xiaohanghu.stresstester;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 测试工作线程
 * 
 * @author xiaohanghu
 * */
class StressThreadWorker implements Runnable {

	private StressTask service;
	private CyclicBarrier threadStartBarrier;
	private CountDownLatch threadEndLatch;
	private AtomicInteger failedCounter = null;
	private int count;
	private static Log log = LogFactory.getLog(StressThreadWorker.class);

	private List<Long> everyTimes;

	public StressThreadWorker(StressTestContext stressTestContext, int count) {
		super();
		this.threadStartBarrier = stressTestContext.getThreadStartBarrier();
		this.threadEndLatch = stressTestContext.getThreadEndLatch();
		this.failedCounter = stressTestContext.getFailedCounter();
		this.count = count;

		everyTimes = new ArrayList<Long>(count);

		this.service = stressTestContext.getTestService();
	}

	public List<Long> getEveryTimes() {
		return everyTimes;
	}

	@Override
	public void run() {
		try {
			threadStartBarrier.await();
			doRun();
		} catch (Exception e) {
			log.error("Test exception", e);
		}
	}

	protected void doRun() throws Exception {
		// 记录单词调用时间
		// 10000次测试工具耗时2ms
		for (int i = 0; i < count; i++) {
			long start = System.nanoTime();
			try {
				// Object result = service.test();
				service.doTask();
			} catch (Throwable e) {
				failedCounter.incrementAndGet();
				// throw e;
			} finally {
				long stop = System.nanoTime();
				long limit = stop - start;
				everyTimes.add(limit);
			}
		}
		threadEndLatch.countDown();
	}

}
