package taskmanager;

public class TaskManagerFIFO extends TaskManager {

    private static TaskManagerFIFO instance;

    private TaskManagerFIFO(int capacity) {
        this.maxCapacity = capacity;
    }

    public static TaskManagerFIFO getInstance(int capacity) {
        return (instance == null) ? new TaskManagerFIFO(capacity) : instance;
    }

    public void addProcess(Process process) {
        if (maxCapacity <= processes.size()) {
            killProcess(getEldestProcess());
        }
        processes.put(process.getPid(), process);
    }

    private Process getEldestProcess() {
        return processes.entrySet().iterator().next().getValue();
    }
}
