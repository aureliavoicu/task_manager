import taskmanager.*;
import taskmanager.Process;

public class MainPriority {
    public static void main(String[] args) {

        TaskManager taskManagerPriority = TaskManagerPriority.getInstance(3);
        Process chrome = new Process(ProcessPriority.LOW, "Chrome");
        Process calendar = new Process(ProcessPriority.MEDIUM, "Calendar");
        Process windows = new Process(ProcessPriority.HIGH, "Windows");
        Process antivirus = new Process(ProcessPriority.HIGH, "Antivirus");

        taskManagerPriority.addProcess(calendar);
        taskManagerPriority.addProcess(chrome);
        taskManagerPriority.addProcess(windows);
        taskManagerPriority.addProcess(antivirus);

        taskManagerPriority.listByCreationTime();
        taskManagerPriority.listByPriority();

        taskManagerPriority.killProcess(antivirus);

        taskManagerPriority.listByCreationTime();

        taskManagerPriority.killProcessesWithPriority(ProcessPriority.HIGH);

        taskManagerPriority.listByCreationTime();

        taskManagerPriority.killAll();

        taskManagerPriority.listByCreationTime();
    }
}
