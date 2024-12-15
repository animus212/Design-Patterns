package Registry.ResidentOperations;

import java.util.ArrayList;

public class DeleteResident extends ResidentOperation {
    public DeleteResident(ArrayList<String> residentData) {
        super(residentData);
    }

    @Override
    protected void doOperation() {
        registry.removeResident(residentIndex);
    }
}
