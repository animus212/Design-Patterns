package Registry.WorkerOperations;

import Employee.Worker;
import Registry.Registry;

public abstract class WorkerOperation {
    protected final Worker worker;
    protected final Registry registry;

    public WorkerOperation(Worker worker) {
        this.registry = Registry.getInstance();

        this.worker = worker;
    }

    public final void execute() {
        preOperation();
        doOperation();
    }

    protected abstract void preOperation();

    protected abstract void doOperation();
}
