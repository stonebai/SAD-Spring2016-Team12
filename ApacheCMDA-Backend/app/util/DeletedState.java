package models;

public class DeletedState implements WorkflowState {
	public String getStatus() {
		return "deleted";
	}

	public boolean isAvailable() {
		return false;
	}
}