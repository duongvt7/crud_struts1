package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import model.Person;
import model.PersonDB;
import services.PersonService;

public class PersonAction extends MappingDispatchAction {
	public ActionForward getListPerson(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PersonService personService = new PersonService();
		List<PersonDB> listPerson = personService.getListPerson();
		request.setAttribute("listPerson", listPerson);
		return mapping.findForward("getListPerson");
	}

	public ActionForward addPerson(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		return mapping.findForward("addPerson");
	}
	
	public ActionForward excuteAddPerson(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Person person = (Person)form;
		PersonService personService = new PersonService();
		PersonDB personDB = new PersonDB( person.getName(), Integer.valueOf(person.getAge()), person.getAddress(), person.getEmail());
		int result = personService.createPerson(personDB);
		personService = new PersonService();
		List<PersonDB> listPerson = personService.getListPerson();
		request.setAttribute("listPerson", listPerson);
		
		return mapping.findForward("excuteAddPerson");
	}
	
	public ActionForward deletePerson(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		int idProduct = Integer.valueOf(request.getParameter("idPerson"));
		PersonService personService = new PersonService();
		personService.deletePerson(idProduct);
		personService = new PersonService();
		List<PersonDB> listPerson = personService.getListPerson();
		request.setAttribute("listPerson", listPerson);
		return mapping.findForward("deletePerson");
	}
	
	public ActionForward editPerson(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		int idPerson = Integer.valueOf(request.getParameter("idPerson"));
		PersonService personService = new PersonService();
		PersonDB person = personService.getPersonById(idPerson);
		request.setAttribute("person", person);
		return mapping.findForward("editPerson");
	}
	
	public ActionForward excuteEditPerson(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Person person = (Person) form;
		PersonService personService = new PersonService();
		PersonDB personDB = new PersonDB(person.getName(), Integer.valueOf(person.getAge()), person.getAddress(), person.getEmail());
		personService.updatePerson(personDB);
		personService = new PersonService();
		List<PersonDB> listPerson = personService.getListPerson();
		request.setAttribute("listPerson", listPerson);
		return mapping.findForward("excuteEditPerson");
	}
	
}
