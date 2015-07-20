# This is a simple java util for stress test #

A simple example(java):
```
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
```
Run the above code will output:
```
 Concurrency Level:	100
 Time taken for tests:	8.723116 ms
 Complete Tasks:	1000
 Failed Tasks:		0
 Tasks per second:	184747.27
 Time per task:		0.54128 ms
 Time per task:		0.0054128 ms (across all concurrent tasks)
 Shortest task:		0.00499 ms
 Percentage of the tasks served within a certain time (ms)
  50%	0.005703
  66%	0.007236
  75%	0.008948
  80%	0.011462
  90%	2.509905
  95%	3.897114
  98%	6.203276
  99%	7.148442
 100%	8.079426 (longest task)
```

download：[xiaohanghu-stress-tester-1.0.0-SNAPSHOT.jar](http://xiaohanghu-stress-tester.googlecode.com/files/xiaohanghu-stress-tester-1.0.0-SNAPSHOT.jar)