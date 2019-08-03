package com.jd.ninjagoldproject.money;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	@Autowired
	private HttpSession session;
	private ArrayList<String> dates = new ArrayList<String>();

	@RequestMapping("/")
	public String index(Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}

	@PostMapping("/process-money")
	public String processMoney(@RequestParam("building") String user_guess, Model model) {

		Random random = new Random();

		Integer gold = (Integer) session.getAttribute("gold");

		LocalDate ld = LocalDate.now();

		Month month = ld.getMonth();
		DayOfWeek dow = ld.getDayOfWeek();
		int dayOfMonth = ld.getDayOfMonth();
		int year = ld.getYear();
		String date = String.format("(%s, the %dst of %s,  %d)", dow, dayOfMonth, month, year);

		if (user_guess.equals("farm")) {
			Integer earn = random.nextInt((20 - 10) + 1) + 10;
			gold += earn;
			String info = "You entered a " + user_guess + " and earned " + earn + "." + date;
			session.setAttribute("gold", gold);
			dates.add(info);
			Collections.reverse(dates);
			session.setAttribute("dates", dates);
		}
		
		if (user_guess.equals("cave")) {
			Integer earn = random.nextInt((10 - 5) + 1) + 5;
			gold += earn;
			String info = "You entered a " + user_guess + " and earned " + earn + "." + date;
			session.setAttribute("gold", gold);
			dates.add(info);
			Collections.reverse(dates);
			session.setAttribute("dates", dates);
		}
		
		if (user_guess.equals("house")) {
			Integer earn = random.nextInt((5 - 2) + 1) + 2;
			gold += earn;
			String info = "You entered a " + user_guess + " and earned " + earn + "." + date;
			session.setAttribute("gold", gold);
			dates.add(info);
			Collections.reverse(dates);
			session.setAttribute("dates", dates);
		}
		
		if (user_guess.equals("casino")) {
			Integer earn = random.nextInt((50 - 0) + 1) + 0;
			gold += earn;
			String info = "You entered a " + user_guess + " and earned " + earn + "." + date;
			session.setAttribute("gold", gold);
			dates.add(info);
			Collections.reverse(dates);
			session.setAttribute("dates", dates);
		}

		return "redirect:/";
	}
	
	@PostMapping("/reset")
	public String reset() {
		session.invalidate();
		dates.clear();
		return "redirect:/";	
	}

}
