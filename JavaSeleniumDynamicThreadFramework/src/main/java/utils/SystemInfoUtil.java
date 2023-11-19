package utils;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class SystemInfoUtil {

    private static long[] prevTicks = null;

    public synchronized static double getSystemCpuLoad() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor processor = hal.getProcessor();

        long[] ticks = processor.getSystemCpuLoadTicks();
        double cpuLoad = 0;

        if (prevTicks != null) {
            cpuLoad = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        }
        prevTicks = ticks;
        return cpuLoad;
    }

    public synchronized static double getMemoryUtilization() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        GlobalMemory memory = hal.getMemory();
        long totalMemory = memory.getTotal();
        long availableMemory = memory.getAvailable();

        return 100.0 - ((double) availableMemory / (double) totalMemory * 100);
    }
}

