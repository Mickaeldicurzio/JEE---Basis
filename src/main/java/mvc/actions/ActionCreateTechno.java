package mvc.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionCreateTechno extends Action {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		
		String Name = request.getParameter("name");
		String Description = request.getParameter("description");
		String imagePath = request.getParameter("image_path");
		String Status = request.getParameter("status");
		
		if( !(Name == "") && !(Description =="") && !(imagePath=="")) {
			return true;
		}
		else {
			return false;
		}
	}
}
