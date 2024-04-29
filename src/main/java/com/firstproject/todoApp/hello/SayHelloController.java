package com.firstproject.todoApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("sayHello")
	@ResponseBody
	public String sayHello() {
		return "Complicate Pannadheenga da!";
	}
	
	@RequestMapping("sayHelloHtml")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>HTML Page</title>");
		sb.append("<head>");
		sb.append("<body>");
		sb.append("Vanakkam da maapla HTML la irundhu");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@RequestMapping("sayHelloJsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
