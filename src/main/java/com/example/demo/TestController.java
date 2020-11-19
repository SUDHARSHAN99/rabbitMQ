package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
//@RequestMapping("/api/v1")
public class TestController {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	ControllerHelper ctlrHelper;
	@Autowired
	ServiceHelper serviceHelper;
	/*
	 * @Autowired TriggerEmailApiService triggerEmailApiService; EmailRequest emial;
	 */
	
	@Autowired
	private Person person;
	@Autowired
	private Person2 person2;
	@Autowired
	RequestContext reqContext;
	@Autowired
    private HttpServletRequest servletRequest;
	
	
	@RequestMapping(value = "/test/update",method = RequestMethod.POST)
	public String testAPI(@RequestBody String request,HttpServletRequest httpServletRequest, 
	        HttpServletResponse response) {
		try {
			System.out.println(httpServletRequest.getMethod()+httpServletRequest.getLocalPort());
			Person2 person = ctlrHelper.bindJsonToObj(request, Person2.class);
			reqContext.setRequestBody(servletRequest);
			serviceHelper.method(person);
			//triggerEmailApiService.triggerEmail(emailRequest)
			rabbitTemplate.convertAndSend("Mobile", person);
		}catch(Exception e) {
			e.printStackTrace();
			throw new APIRequestValidationException("test update method");
		}
		
		/*
		 * rabbitTemplate.convertAndSend("Direct-Exchange", "mobile", p);
		 * rabbitTemplate.convertAndSend("Fanout-Exchange", "", p);
		 * rabbitTemplate.convertAndSend("Topic-Exchange", "tv.mobile.ac", p);
		 */
		String resp = ctlrHelper.generateJsonFromObj(person);
		System.out.println("Response in method"+resp);
		return resp;
	}
	 
	 
	@RequestMapping(value = "/rf/update-employment",method = RequestMethod.POST)
	public String testAPI2(@RequestBody String request, WebRequest webRequest) {
		
			Person2 person = ctlrHelper.bindJsonToObj(request, Person2.class);
			//person.setRequestBody(person);
			serviceHelper.savePerson(person,webRequest);
			System.out.println("hello");
			serviceHelper.method(person);
			//rabbitTemplate.convertAndSend("Mobile", person);
		/*
		 * }catch(Exception e) { throw new
		 * APIRequestValidationException("testAPI2 update method"); }
		 */
		//Person person = ctlrHelper.bindJsonToObj(request, Person.class);
		/*
		 * rabbitTemplate.convertAndSend("Direct-Exchange", "mobile", p);
		 * rabbitTemplate.convertAndSend("Fanout-Exchange", "", p);
		 * rabbitTemplate.convertAndSend("Topic-Exchange", "tv.mobile.ac", p);
		 *///return "Success";
			String resp = ctlrHelper.generateJsonFromObj(person);
			//System.out.println("Response in method"+resp);
			return resp;
	}
	
	
	/*
	 * @GetMapping("/test/{name}") public String testAPI(@PathVariable("name")
	 * String name) throws IOException { Person p = new Person(1L, name);
	 * 
	 * ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out =
	 * new ObjectOutputStream(bos); out.writeObject(p); out.flush(); out.close();
	 * 
	 * byte[] byteMessage = bos.toByteArray(); bos.close();
	 * 
	 * Message message = MessageBuilder.withBody(byteMessage) .setHeader("item1",
	 * "mobile") .setHeader("item2", "television").build();
	 * 
	 * rabbitTemplate.send("Headers-Exchange", "", message);
	 * 
	 * return "Success"; }
	 */
}
