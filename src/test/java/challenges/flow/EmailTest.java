package challenges.flow;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import flow.ActionException;
import flow.AdapterException;
import flow.AdapterNotFoundException;
import flow.AgentException;
import flow.AppException;
import flow.EmptyFlowException;
import flow.Engine;
import flow.EventException;
import flow.IAdapter;
import flow.IAgent;
import flow.IApp;
import flow.ProtocolException;

@RunWith(JUnit4.class)
public class EmailTest {

	@Test
	public void testRun_AdapterRespectsProtocol_AppHasHelloMessage() throws Exception {
		IAgent user = new UserAgent("hello");
		/*
		 * * this line should be modified, you need send something to be comparable
		 */

		Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
		adapters.put("EMAIL", new EmailAdapter());

		EmailApp app = new EmailApp();
		Engine engine = new Engine(user, adapters, app);
		engine.run();
		Assert.assertEquals("hello", app.popMessage());
	}
	
	
	
	@Test
	public void testRun_AdapterRespectsProtocol_AppHasHelloMessageAndMore() throws Exception {
		/*
		 * The Message server should contain the "hello" message in the queue"
		 */		
		IAgent user = new UserAgent("hello, this is the message");
		
		Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
		adapters.put("EMAIL", new EmailAdapter());

		EmailApp app = new EmailApp();
		Engine engine = new Engine(user, adapters, app);
		engine.run();
		Assert.assertEquals("hello, this is the message", app.popMessage());
	}
	
	
	
	@Test
	public void testRun_AdapterRespectsProtocol_AppHasManyHelloMessage() throws Exception {
		IAgent user = new UserAgent("hello", "hello", "hello");
		/*
		 * * this line should be modified, you need send something to be comparable
		 */

		Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
		adapters.put("EMAIL", new EmailAdapter());

		EmailApp app = new EmailApp();
		Engine engine = new Engine(user, adapters, app);
		engine.run();
		Assert.assertEquals("hello", app.popMessage());
	}

	@Test(expected = ProtocolException.class)
	public void test_cathProtocolException() throws AgentException, EmptyFlowException, AdapterNotFoundException, AdapterException, ActionException, EventException, ProtocolException, AppException {
		IAgent user = new UserAgent("Throw Protocol Exception");
		
		Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
		adapters.put("EMAIL", new EmailAdapter());

		EmailApp app = new EmailApp();
		Engine engine = new Engine(user, adapters, app);
		engine.run();

	}
	@Test(expected = EmptyFlowException.class)
	public void test_cathEmptyFlowException() throws AgentException, EmptyFlowException, AdapterNotFoundException, AdapterException, ActionException, EventException, ProtocolException, AppException {
		IAgent user = new UserAgent();
		
		Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
		adapters.put("EMAIL", new EmailAdapter());

		IApp app = new EmailApp();
		Engine engine = new Engine(user, adapters, app);
		engine.run();

	}
	@Test(expected = EmptyFlowException.class)
	public void test_cathEmptyFlowExceptionNull() throws AgentException, EmptyFlowException, AdapterNotFoundException, AdapterException, ActionException, EventException, ProtocolException, AppException {
		IAgent user = new UserAgent();
		
		Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
		

		EmailApp app = new EmailApp();
		Engine engine = new Engine(user, adapters, app);
		engine.run();

	}
	@Test(expected = AdapterNotFoundException.class)
	public void test_AdapterNotFoundException() throws AgentException, EmptyFlowException, AdapterNotFoundException, AdapterException, ActionException, EventException, ProtocolException, AppException {
		IAgent user = new UserAgent("hello");
		
		Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
		adapters.put("OTHER", new EmailAdapter());

		EmailApp app = new EmailApp();
		Engine engine = new Engine(user, adapters, app);
		engine.run();

	}
	
	
	
}