package ir.pegahtech.saas.client.shared.models;

import ir.pegahtech.saas.client.shared.enums.UserDirection;
import ir.pegahtech.saas.client.shared.enums.UserSate;


public class ListOfRelationsRequest {

	private UserSate state;
	private UserDirection direction;
	
	
	public UserSate getState() {
		return state;
	}
	public void setState(UserSate state) {
		this.state = state;
	}
	public UserDirection getDirection() {
		return direction;
	}
	public void setDirection(UserDirection direction) {
		this.direction = direction;
	}

}
