package taskmanager;

public class Process implements Comparable<Process> {

    private final Integer pid;
    private final ProcessPriority priority;
    private final String description;

    public Process(ProcessPriority priority, String description) {
        this.pid = TaskManager.generatePid();
        this.priority = priority;
        this.description = description;
    }

    public ProcessPriority getPriority() {
        return this.priority;
    }

    public Integer getPid() {
        return this.pid;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Process{" +
                "pid=" + pid +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(Process o) {
        return getPriority().compareTo(o.getPriority());
    }
}
