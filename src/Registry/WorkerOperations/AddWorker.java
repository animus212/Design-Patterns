package Registry.WorkerOperations;

import Employee.*;

import java.util.ArrayList;

public class AddWorker extends WorkerOperation {
    public AddWorker(ArrayList<String> workerData) {
        super(workerData);
    }

    @Override
    protected void preOperation() {
        for (Worker storedWorker : registry.getWorkers()) {
            if (storedWorker.getId() == Integer.parseInt(workerData.getFirst())) {
                throw new IllegalArgumentException("Worker Already Exists!");
            }
        }
    }

    @Override
    protected void doOperation() {
        Worker newWorker = new Worker(Integer.parseInt(workerData.getFirst()), workerData.get(1),
                workerData.get(2), workerData.get(3), Double.parseDouble(workerData.get(4)), workerData.get(5));

        registry.addWorker(newWorker);
    }
}
