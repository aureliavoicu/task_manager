import taskmanager.*;
import taskmanager.Process;

public class MainPriority {
    public static void main(String[] args) {

        TaskManager taskManagerPriority = new TaskManagerPriority(3);
        Process chrome = new Process(Priority.LOW, "Chrome");
        Process calendar = new Process(Priority.MEDIUM, "Calendar");
        Process windows = new Process(Priority.HIGH, "Windows");
        Process antivirus = new Process(Priority.HIGH, "Antivirus");

        taskManagerPriority.addProcess(calendar);
        taskManagerPriority.addProcess(chrome);
        taskManagerPriority.addProcess(windows);
        taskManagerPriority.addProcess(antivirus);

        taskManagerPriority.listByCreationTime();
        taskManagerPriority.listByPriority();

        taskManagerPriority.killProcess(antivirus);

        taskManagerPriority.listByCreationTime();

        taskManagerPriority.killProcessesWithPriority(Priority.HIGH);

        taskManagerPriority.listByCreationTime();

        taskManagerPriority.killAll();

        taskManagerPriority.listByCreationTime();
    }
}
