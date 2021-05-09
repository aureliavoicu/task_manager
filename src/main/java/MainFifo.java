import taskmanager.ProcessPriority;
import taskmanager.Process;
import taskmanager.TaskManager;
import taskmanager.TaskManagerFIFO;

public class MainFifo {
    public static void main(String[] args) {

        TaskManager taskManagerFifo = TaskManagerFIFO.getInstance(3);
        Process chrome = new Process(ProcessPriority.LOW, "Chrome");
        Process calendar = new Process(ProcessPriority.MEDIUM, "Calendar");
        Process windows = new Process(ProcessPriority.HIGH, "Windows");
        Process antivirus = new Process(ProcessPriority.HIGH, "Antivirus");

        taskManagerFifo.addProcess(calendar);
        taskManagerFifo.addProcess(chrome);
        taskManagerFifo.addProcess(windows);
        taskManagerFifo.addProcess(antivirus);

        taskManagerFifo.listByCreationTime();
        taskManagerFifo.listByPriority();

        taskManagerFifo.killProcess(antivirus);

        taskManagerFifo.listByCreationTime();

        taskManagerFifo.killProcessesWithPriority(ProcessPriority.HIGH);

        taskManagerFifo.listByCreationTime();

        taskManagerFifo.killAll();

        taskManagerFifo.listByCreationTime();
    }
}
