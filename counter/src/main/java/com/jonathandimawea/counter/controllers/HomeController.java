package com.jonathandimawea.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class HomeController {
	
	@GetMapping("")
	public String setCount(HttpSession session) {
		if (session.getAttribute("count") == null) { // no count, create count in session
			session.setAttribute("count", 0);
		} else { // count is available, increment count
			Integer count = (Integer) session.getAttribute("count");
			count++;
			
			session.setAttribute("count", count);
		}
		return "counterWelcome.jsp";
	}
	
	@GetMapping("/counter")
	public String getCount() {
		return "counterVisit.jsp";
	}
	
}
