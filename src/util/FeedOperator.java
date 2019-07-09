package util;

import java.util.HashMap;
import java.util.Map;

import modules.Command;

/**The invoker for various commands**/ 
public class FeedOperator {
	Map<String, Command> operations = new HashMap<>();
	
	public void setCommamdForAction(String action, Command command){
		operations.put(action, command);
	}
	
	public void performOperation(String action){
		operations.get(action).execute();
	}

}
