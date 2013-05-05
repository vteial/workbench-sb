package io.github.vteial.myworkbench.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractController {

	@Value("${applicationId}")
	private String applicationId;

	@Value("${applicationName}")
	private String applicationName;

	@Autowired
	ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Autowired
	ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String handleServerErrors(Exception t) {
		return t.getMessage();
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleClientErrors(Exception t) {
		return t.getMessage();
	}

	protected ModelAndView createDefaultModelAndView(String layoutName) {
		ModelAndView mav = new ModelAndView(layoutName);
		mav.addObject("applicationId", this.applicationId);
		mav.addObject("applicationName", this.applicationName);
		return mav;
	}

	protected ModelAndView createDefaultModelAndView() {
		ModelAndView mav = this.createDefaultModelAndView("wydLayout");
		return mav;
	}

	protected ModelAndView createDefaultModelAndView(String viewName,
			String viewTitle) {
		ModelAndView mav = this.createDefaultModelAndView();
		mav.addObject("viewName", viewName);
		mav.addObject("viewTitle", viewTitle);
		return mav;
	}

	protected ModelAndView createDefaultModelAndView(String layoutName,
			String viewName, String viewTitle) {
		ModelAndView mav = this.createDefaultModelAndView(layoutName);
		mav.addObject("viewName", viewName);
		mav.addObject("viewTitle", viewTitle);
		return mav;
	}
}
