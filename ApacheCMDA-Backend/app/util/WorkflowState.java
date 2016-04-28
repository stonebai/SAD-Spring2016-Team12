package models;

public interface WorkflowState {
	public String getStatus();

	public boolean isAvailable();
}