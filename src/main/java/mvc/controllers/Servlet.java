package mvc.controllers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.actions.Action;
import mvc.actions.ActionCreateTechno;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(name="servlet",urlPatterns="*.do",loadOnStartup=1)
public class Servlet extends HttpServlet {
	
	// hashmap
	
	HashMap<String, String> success = new HashMap<>();
	HashMap<String, String> errors = new HashMap<>();
	HashMap<String, Action> actions = new HashMap<>();
	
	
	@Override
	public void init() throws ServletException{
		super.init();
		try {
			ServletContext context = getServletContext();
			InputStream is = context.getResourceAsStream("/WEB-INF/conf.txt");
			if(is != null) {
				BufferedReader buffredReader = new BufferedReader(new InputStreamReader(is));
				for(String line = buffredReader.readLine(); line != null; line = buffredReader.readLine()) {
					if(line.trim().startsWith("#")) {
						continue;
					}
					String[] confLine = line.split(";");
						if(confLine.length == 4) {
							String actionName = confLine[0];
							success.put(actionName, confLine[1]);
							errors.put(actionName, confLine[2]);
							actions.put(actionName, (Action) Class.forName(confLine[3]).newInstance());
					}
				}
			}
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	/** * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String actionName = request.getParameter("action");
		if(null == actionName) {
			actionName = "login.do";
		}
		
		Action action = actions.get(actionName);
		RequestDispatcher rqd = null; 
		if(action.execute(request, response)) {
			rqd  = getServletContext().getRequestDispatcher(success.get(actionName));
		}else {
			rqd = getServletContext().getRequestDispatcher(errors.get(actionName));
		}
		
		if((rqd != null )) {
			rqd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}