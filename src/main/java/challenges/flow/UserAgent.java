package challenges.flow;

import java.util.LinkedList;
import java.util.List;

import flow.AgentException;
import flow.IAction;
import flow.IAgent;

public class UserAgent implements IAgent {

	private String[] values;
	 
	public List<IAction> act() throws AgentException {
		  List<IAction> flow = new LinkedList<IAction>();
		    for (String value : values) {
		      flow.add(new EmailAction(value));
		    }
		    return flow;
	}

	public UserAgent(String... msg) {
		this.values = msg;
	}
	

}
