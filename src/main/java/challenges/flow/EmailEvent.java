package challenges.flow;

import flow.ActionException;
import flow.EventException;
import flow.IEvent;

public class EmailEvent implements IEvent<Email> {

	
	private Email email;
	
	public EmailEvent(Email email) {
			this.email = email;
	}

	public Email trigger() throws EventException, ActionException {
		return email;
	}

}
