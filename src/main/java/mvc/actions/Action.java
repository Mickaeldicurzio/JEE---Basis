package mvc.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {

	public abstract boolean execute(HttpServletRequest request, HttpServletResponse response); 
	
}
