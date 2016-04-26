package models;

import javax.persistence.*;

public class NormalState implements WorkflowState {
	public String getStatus() {
		return "normal";
	}
}
