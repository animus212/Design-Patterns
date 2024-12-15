package Registry.WorkerOperations;

import java.util.ArrayList;

public class DeleteWorker extends WorkerOperation {
    public DeleteWorker(ArrayList<String> workerData) {
        super(workerData);
    }

    @Override
    protected void doOperation() {
        registry.removeWorker(workerIndex);
    }
}
