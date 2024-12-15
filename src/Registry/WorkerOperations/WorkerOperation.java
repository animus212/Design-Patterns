package Registry.WorkerOperations;

import Employee.Worker;
import Registry.Registry;

import java.util.ArrayList;

public abstract class WorkerOperation {
    protected final ArrayList<String> workerData;
    protected final Registry registry;
    protected int workerIndex;

    public WorkerOperation(ArrayList<String> workerData) {
        this.registry = Registry.getInstance();

        this.workerData = workerData;
    }

    public final void execute() {
        preOperation();
        doOperation();
    }

    protected void preOperation() {
        int index = 0;

        for (Worker storedWorker : registry.getWorkers()) {
            if (storedWorker.getId() == Integer.parseInt(workerData.getFirst())) {
                workerIndex = index;

                return;
            }

            index += 1;
        }

        throw new IllegalArgumentException("Worker Does Not Exist!");
    }

    protected abstract void doOperation();
}
