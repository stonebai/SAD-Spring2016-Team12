package models;

import javax.persistence.*;

public class DeletedState implements WorkflowState {
	public String getStatus() {
		return "deleted";
	}
}
