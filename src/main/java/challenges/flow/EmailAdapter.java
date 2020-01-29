package challenges.flow;

import flow.ActionException;
import flow.AdapterException;
import flow.IAction;
import flow.IAdapter;
import flow.IEvent;

public class EmailAdapter implements IAdapter<IAction> {

	public IEvent adapt(IAction action) throws AdapterException, ActionException {

		Email email = (Email) action.execute();
		return new EmailEvent(email);

	}

}
