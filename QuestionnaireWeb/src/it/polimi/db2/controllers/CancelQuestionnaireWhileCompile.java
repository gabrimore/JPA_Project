package it.polimi.db2.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import javax.ejb.EJB;

import it.polimi.db2.questionnaire.entities.Questionnaire;
import it.polimi.db2.questionnaire.entities.User;
import it.polimi.db2.questionnaire.services.QuestionnaireService;
import it.polimi.db2.questionnaire.services.ScoreService;



@WebServlet("/CancelQuestionnaireWhileCompile")
public class CancelQuestionnaireWhileCompile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TemplateEngine templateEngine;
	@EJB(name = "it.polimi.db2.questionnaire.services/ScoreService")
	private ScoreService sService;
	

	public CancelQuestionnaireWhileCompile() {
		super();
	}

	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		this.templateEngine = new TemplateEngine();
		this.templateEngine.setTemplateResolver(templateResolver);
		templateResolver.setSuffix(".html");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
	User user = (User) request.getSession().getAttribute("user");
	
	sService.insertCancelledQuestionnaireTuple(user.getId());
	
	String path = getServletContext().getContextPath() + "/GoToHomePage";
	response.sendRedirect(path);
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void destroy() {
	}
	
	
}