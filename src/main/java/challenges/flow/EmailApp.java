package challenges.flow;


import java.util.LinkedList;
import java.util.Queue;

import flow.ActionException;
import flow.AppException;
import flow.EventException;
import flow.IApp;
import flow.IEvent;
import flow.ProtocolException;



public class EmailApp implements IApp<String> {
	private Queue<String> messages;

	public EmailApp() {
		this.messages = new LinkedList<String>();
	}

	

	public String popMessage() {
		String message = messages.remove();
		return message;
	}

	public String in(IEvent event) throws AppException, EventException, ActionException, ProtocolException {
		Email email = (Email) event.trigger();
		
		String message = email.getBody();		

		if (null == message )
			throw new ProtocolException();
		
		if (!message.contains("hello")) {
			throw new ProtocolException();
		}

		messages.add(message);
		return message;
	}
}