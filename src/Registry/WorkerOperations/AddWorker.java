package Registry.WorkerOperations;

import Employee.*;

public class AddWorker extends WorkerOperation {
    public AddWorker(Worker worker) {
        super(worker);
    }

    @Override
    protected void preOperation() {
        for (Worker storedWorker : registry.getWorkers()) {
            if (storedWorker.getId() == worker.getId()) {
                throw new IllegalArgumentException("Worker Already Exists!");
            }
        }
    }

    @Override
    protected void doOperation() {
        registry.addWorker(worker);
    }
}
