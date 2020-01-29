package challenges.flow;

import java.util.List;

import flow.ActionException;
import flow.AgentException;
import flow.IAction;
import flow.IAgent;

public class EmailAction implements IAction {
	private Email email ;
	  
	public EmailAction(String value) {
		
		email = new Email(value);
		
	}

	public Email execute() throws ActionException {
		return email;
	}

	public String getType() {
		return "EMAIL";
	}

	

}
