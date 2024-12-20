package Registry.WorkerOperations;

import Employee.Worker;

import java.util.ArrayList;

public class AddWorker extends WorkerOperation {
    public AddWorker(ArrayList<String> workerData) {
        super(workerData);
    }

    @Override
    protected void preOperation() {
        for (Worker storedWorker : REGISTRY.getWorkers()) {
            if (storedWorker.getID() == Integer.parseInt(WORKER_DATA.getFirst())) {
                throw new IllegalArgumentException("Worker Already Exists!");
            }
        }
    }

    @Override
    protected void doOperation() {
        Worker newWorker = new Worker(Integer.parseInt(WORKER_DATA.getFirst()), WORKER_DATA.get(1),
                WORKER_DATA.get(2), WORKER_DATA.get(3), Double.parseDouble(WORKER_DATA.get(4)), WORKER_DATA.get(5));

        REGISTRY.addWorker(newWorker);
    }
}
