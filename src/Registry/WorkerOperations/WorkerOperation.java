package Registry.WorkerOperations;

import Employee.Worker;
import Registry.Registry;

import java.util.ArrayList;

public abstract class WorkerOperation {
    protected final ArrayList<String> WORKER_DATA;
    protected final Registry REGISTRY;
    protected int workerIndex;

    public WorkerOperation(ArrayList<String> WORKER_DATA) {
        this.REGISTRY = Registry.getInstance();

        this.WORKER_DATA = WORKER_DATA;
    }

    public final void execute() {
        preOperation();
        doOperation();
    }

    protected void preOperation() {
        int index = 0;

        for (Worker storedWorker : REGISTRY.getWorkers()) {
            if (storedWorker.getID() == Integer.parseInt(WORKER_DATA.getFirst())) {
                workerIndex = index;

                return;
            }

            index += 1;
        }

        throw new IllegalArgumentException("Worker Does Not Exist!");
    }

    protected abstract void doOperation();
}
