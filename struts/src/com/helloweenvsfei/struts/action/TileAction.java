/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.helloweenvsfei.struts.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.helloweenvsfei.struts.bean.Person;
import com.helloweenvsfei.struts.dao.PersonDAO;
import com.helloweenvsfei.struts.form.TileForm;

/**
 * MyEclipse Struts Creation date: 05-05-2008
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/tile" name="tileForm" input="/form/tile.jsp"
 *                scope="request" validate="true"
 */
public class TileAction extends Action {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws SQLException
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException {

		TileForm tileForm = (TileForm) form;

		if ("add".equals(tileForm.getAction())) {

			Person person = tileForm.getPerson();

			PersonDAO personDAO = new PersonDAO();
			personDAO.addPerson(getDataSource(request).getConnection(), person);

			return mapping.findForward("success");
		}

		return mapping.getInputForward();
	}
}