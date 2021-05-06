package taskmanager;

public class Process implements Comparable<Process> {

    private Integer pid = -1;
    private final Priority priority;
    private final String description;

    public Process(Priority priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPid(Integer pid) {
        if (this.pid.equals(-1)) {
            this.pid = pid;
        }
    }

    public String getDescription() {
        return new String(this.description);
    }

    public Integer getPid() {
        return new Integer(pid);
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
