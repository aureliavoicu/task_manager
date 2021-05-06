import taskmanager.Priority;
import taskmanager.Process;
import taskmanager.TaskManager;
import taskmanager.TaskManagerFIFO;

public class MainFifo {
    public static void main(String[] args) {

        TaskManager taskManagerFifo = new TaskManagerFIFO(3);
        Process chrome = new Process(Priority.LOW, "Chrome");
        Process calendar = new Process(Priority.MEDIUM, "Calendar");
        Process windows = new Process(Priority.HIGH, "Windows");
        Process antivirus = new Process(Priority.HIGH, "Antivirus");

        taskManagerFifo.addProcess(calendar);
        taskManagerFifo.addProcess(chrome);
        taskManagerFifo.addProcess(windows);
        taskManagerFifo.addProcess(antivirus);

        taskManagerFifo.listByCreationTime();
        taskManagerFifo.listByPriority();

        taskManagerFifo.killProcess(antivirus);

        taskManagerFifo.listByCreationTime();

        taskManagerFifo.killProcessesWithPriority(Priority.HIGH);

        taskManagerFifo.listByCreationTime();

        taskManagerFifo.killAll();

        taskManagerFifo.listByCreationTime();
    }
}
