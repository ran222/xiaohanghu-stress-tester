package org.xiaohanghu.stresstester.core;

/**
 * 
 * 需要执行的测试任务
 * 
 * @author xiaohanghu
 */
public interface StressTask {

	public Object doTask() throws Exception;

}
