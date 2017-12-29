package com.iqmsoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iqmsoft.service.ListService;

@Controller
public class MainController {

	@Autowired
	private ListService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute("model") ModelMap model) {
		model.addAttribute("todoList", service.getItems());
		return "index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam("id") String idString, @RequestParam("text") String text) {
		Integer id = null;
		if (idString != null && !idString.isEmpty()) {
			try {
				id = Integer.parseInt(idString);
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
				id = null;
			}
		}

		if (id == null) {
			service.addItem(text);
		} else {
			service.editItem(id, text);
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("id"));
		service.removeItem(itemId);
		return "redirect:/";
	}

	@RequestMapping(value = "/set-done", method = RequestMethod.GET)
	public String toggle(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		boolean done = "1".equals(request.getParameter("done"));
		service.editDone(contactId, done);
		return "redirect:/";
	}
}
