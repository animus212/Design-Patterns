package Registry.WorkerOperations;

import Employee.*;

public class DeleteWorker extends WorkerOperation {
    public DeleteWorker(Worker worker) {
        super(worker);
    }

    @Override
    protected void preOperation() {
        for (Worker storedWorker : registry.getWorkers()) {
            if (storedWorker.getId() == worker.getId()) {
                return;
            }
        }

        throw new IllegalArgumentException("Worker Does Not Exist!");
    }

    @Override
    protected void doOperation() {
        registry.removeWorker(worker);
    }
}
