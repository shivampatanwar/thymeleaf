package com.jsp.thymeleaf.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String loadHome() {
		return "home.html";
	}
	
	@GetMapping("/path/{name}")
	@ResponseBody
	public String pathVar(@PathVariable String name) {
		return "<h1>" + name + "</h1>";
	}
	
	
	@GetMapping("/otp")
	public String otp(ModelMap map) {
		
		int otp = new Random().nextInt(1000, 10000);
		map.put("otp", otp);
		
		return "home.html";
	}
	
	
	@PostMapping("/check")
	public String ckeck(@RequestParam int otp, ModelMap map) {
		
		if(otp%2==0) {
			map.put("msg", "Even Number");
			map.put("color", "Green");
		}else {
			map.put("msg", "Odd Number");
			map.put("color", "Red");
		}
		map.put("otp", otp);
		return "home.html";
	}
	
	
	@GetMapping("/otp1")
	public String otp1(ModelMap map) {
		
		int otp = new Random().nextInt(1000, 10000);
		map.put("otp1", "OTP is : " + otp);
		
		return "home.html";
	}
	
	
	@GetMapping("/toss")
	public String toss(ModelMap map) {
		String[] coin = {"HEAD", "TAIL"};
		int r = new Random().nextInt(0, 2);
		map.put("toss", coin[r]);
		
		return "home.html";
	}
	
	@GetMapping("/box")
	public String box(ModelMap map) {
		String[] box = {"red", "green", "blue", "purple"};
		int r = new Random().nextInt(0, 4);
		map.put("box", box[r]);
		
		return "home.html";
	}
	
	@PostMapping("/colorbox")
	public String colorbox(@RequestParam String color, ModelMap map) {
		map.put("colorbox", color);
		return "home.html";
	}
	
	
	@PostMapping("/colorname")
	public String colorname(@RequestParam String name, @RequestParam String color,  ModelMap map) {
		map.put("colorname", color);
		map.put("name", name);
		return "home.html";
	}
	
	
	@PostMapping("/calculator")
	public String calculator(@RequestParam double ip1, @RequestParam double ip2, @RequestParam String op,  ModelMap map) {
		map.put("ip1", ip1);
		map.put("ip2", ip2);
		
		switch (op) {
		case "add": {
			map.put("result", ip1+ip2);
			break;
			
		}
		case "sub": {
			
			map.put("result", ip1-ip2);
			break;
		}
		case "mul": {
			map.put("result", ip1*ip2);
			break;
			
		}
		case "div": {
			
			map.put("result", ip1/ip2);
			break;
		}
		default:
			
		}
		
		
		return "home.html";
	}

}
