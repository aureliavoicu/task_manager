package taskmanager;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public abstract class TaskManager {

    protected int maxCapacity = 0;
    protected static Map<Integer, Process> processes = new LinkedHashMap<Integer, Process>();

    public abstract void addProcess(Process process);

    public static Integer generatePid() {
        Integer pid = new Random().nextInt(999999);
        while (processes.containsKey(pid)) {
            pid = new Random().nextInt(999999);
        }
        return pid;
    }

    public void listByCreationTime() {
        System.out.println("All processes sorted by creation date:");
        processes.values().stream()
                .forEachOrdered(p -> System.out.println("\t" + p));
    }

    public void listByPriority() {
        System.out.println("All processes sorted by priority:");
        processes.values().stream()
                .sorted()
                .forEach(p -> System.out.println("\t" + p));
    }

    public void killProcess(Process process) {
        if (processes.containsKey(process.getPid())) {
            System.out.println("Killing process with pid " + process.getPid());
            processes.remove(process.getPid());
        }
    }

    public void killProcessesWithPriority(ProcessPriority priority) {
        System.out.println("Killing processes with priority: " + priority);
        Object[] list = processes.values().toArray();
        for (Object p : list) {
            if (((Process) p).getPriority().equals(priority)) {
                processes.remove(((Process) p).getPid());
            }
        }
    }

    public void killAll() {
        System.out.println("Killing all processes.");
        processes.clear();
    }
}
