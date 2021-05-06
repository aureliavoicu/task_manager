package taskmanager;

import java.util.Comparator;
import java.util.Optional;

public class TaskManagerPriority extends TaskManager {

    public TaskManagerPriority(int capacity) {
        this.maxCapacity = capacity;
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
        Integer generatePid = generatePid();
        processes.put(generatePid, process);
        process.setPid(generatePid);
    }

    private Optional<Process> getProcessWithLowerPriority(Process process) {
        Optional<Process> processLowerPriority = processes.values().stream()
                .filter(p -> p.getPriority().compareTo(process.getPriority()) > 0)
                .sorted(Comparator.reverseOrder())
                .findFirst();
        return processLowerPriority;
    }
}
