package Registry.WorkerOperations;

import Employee.*;

import java.util.ArrayList;

public class EditWorker extends WorkerOperation {
    public EditWorker(ArrayList<String> workerData) {
        super(workerData);
    }

    @Override
    protected void doOperation() {
        Worker newWorker = new Worker(Integer.parseInt(workerData.getFirst()), workerData.get(1),
                workerData.get(2), workerData.get(3), Double.parseDouble(workerData.get(4)), workerData.get(5));

        registry.editWorker(workerIndex, newWorker);
    }
}
