package Registry.WorkerOperations;

import Employee.*;

public class EditWorker extends WorkerOperation {
    public EditWorker(Worker worker) {
        super(worker);
    }

    @Override
    protected void preOperation() {
        for (Worker storedWorker : registry.getWorkers()) {
            if (storedWorker.getId() == worker.getId()) {
                registry.removeWorker(storedWorker);  // Remove storedWorker here because worker is edited

                return;
            }
        }

        throw new IllegalArgumentException("Worker Does Not Exist!");
    }

    @Override
    protected void doOperation() {
        registry.addWorker(worker);
    }
}
