package taskmanager;

public class TaskManagerFIFO extends TaskManager {

    public TaskManagerFIFO(int capacity) {
        this.maxCapacity = capacity;
    }

    public void addProcess(Process process) {
        if (maxCapacity <= processes.size()) {
            killProcess(getEldestProcess());
        }
        Integer generatePid = generatePid();
        processes.put(generatePid, process);
        process.setPid(generatePid);
    }


    private Process getEldestProcess() {
        return processes.entrySet().iterator().next().getValue();
    }
}
