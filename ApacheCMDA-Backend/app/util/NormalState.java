package models;

public class NormalState implements WorkflowState {
	public String getStatus() {
		return "normal";
	}

	public boolean isAvailable() {
		return true;
	}
}