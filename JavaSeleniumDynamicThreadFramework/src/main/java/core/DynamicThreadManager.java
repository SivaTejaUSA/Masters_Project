package core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import utils.SystemInfoUtil;

public class DynamicThreadManager {

    private static final Semaphore semaphore = new Semaphore(5);
    private static  ExecutorService executor = Executors.newCachedThreadPool();

    public static void submitTask(String testCaseName, String methodName, Runnable task) {
        executor.submit(() -> {
            try {
                semaphore.acquire();  // Acquire a permit
                
                boolean taskExecuted = false;
                while (!taskExecuted)
                {
                // Check CPU and Memory load before running the task
                double cpuLoad = SystemInfoUtil.getSystemCpuLoad();
                double memoryUtilization = SystemInfoUtil.getMemoryUtilization();
                System.out.println("cpuLoad:  " + cpuLoad);
                System.out.println("memoryUtilization:  " + memoryUtilization);

                if (cpuLoad < 80 && memoryUtilization < 95) {
                    task.run();
                    taskExecuted = true;
                } else if (cpuLoad >= 80 || memoryUtilization >= 95) {
                    Thread.sleep(5000);
                    System.out.println("high cpu and memoryUtilization, waiting for 5 seconds");
                }
                }

            } catch (InterruptedException e) {
                // Handle the exception
                e.printStackTrace();
            } finally {
                semaphore.release();  // Release the permit
            }
        });
    }
    
    public static void shutdown() {
        executor.shutdown();  // Shutdown the executor
    }

}

