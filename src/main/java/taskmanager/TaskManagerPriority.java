package taskmanager;

import java.util.Comparator;
import java.util.Optional;

public class TaskManagerPriority extends TaskManager {

    private static TaskManagerPriority instance;

    private TaskManagerPriority(int capacity) {
        this.maxCapacity = capacity;
    }

    public static TaskManagerPriority getInstance(int capacity) {
        return (instance == null) ? new TaskManagerPriority(capacity) : instance;
    }

    public void addProcess(Process process) {
        if (maxCapacity <= processes.size()) {
            Optional<Process> processOptional = getProcessWithLowerPriority(process);
            if (processOptional.isPresent()) {
                killProcess(processOptional.get());
            } else {
                return;
            }
        }
        processes.put(process.getPid(), process);
    }

    private Optional<Process> getProcessWithLowerPriority(Process process) {
        Optional<Process> processLowerPriority = processes.values().stream()
                .filter(p -> p.getPriority().compareTo(process.getPriority()) > 0)
                .sorted(Comparator.reverseOrder())
                .findFirst();
        return processLowerPriority;
    }
}
