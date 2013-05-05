package io.github.vteial.myworkbench.web;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;

@Controller
public class WydController extends AbstractController {
	
	@RequestMapping("/")
	public ModelAndView home() {
		return this.index();
	}

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = this.createDefaultModelAndView("wydIndex", "Home");

		return mav;
	}

	@RequestMapping(value = "/about/request", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody
	Set<Entry<String, String>> aboutRequest(HttpServletRequest request) {
		Iterator<String> iterator = Iterators.forEnumeration(request
				.getHeaderNames());

		Map<String, String> requests = Maps.newHashMap();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String val = request.getHeader(key);
			requests.put(key, val);
		}
		requests.put("Context Path", request.getContextPath());
		requests.put("Path Info", request.getPathInfo());
		requests.put("Request URI", request.getRequestURI());
		requests.put("Request URL", request.getRequestURL().toString());
		requests.put("Servlet Path", request.getServletPath());
		requests.put("Remote User", request.getRemoteUser());
		requests.put("Remote Host", request.getRemoteHost());
		requests.put("Remote IP", request.getRemoteAddr());
		requests.put("Remote Port", request.getRemotePort() + "");

		return requests.entrySet();
	}

	@RequestMapping(value = "/about/context", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody
	Set<Entry<String, Object>> aboutContext() {
		Iterator<String> iterator = Iterators
				.forEnumeration(this.servletContext.getAttributeNames());

		Map<String, Object> contexts = Maps.newHashMap();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object val = this.servletContext.getAttribute(key);
			contexts.put(key, val);
		}

		return contexts.entrySet();
	}

	@RequestMapping(value = "/about/system", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody
	Set<Entry<String, String>> aboutSystemt() {

		return System.getenv().entrySet();

	}

	@RequestMapping(value = "/about/jvm", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody
	Set<Entry<Object, Object>> aboutJvm() {

		return System.getProperties().entrySet();

	}

	@RequestMapping("/t/ping.java")
	public @ResponseBody
	String ping() {
		return "ping pong!";
	}
}
