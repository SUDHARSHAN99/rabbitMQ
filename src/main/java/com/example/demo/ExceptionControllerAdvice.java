/*
 * package com.example.demo;
 * 
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStream; import java.io.InputStreamReader; import
 * java.lang.reflect.Type;
 * 
 * import javax.inject.Inject; import javax.servlet.http.HttpServletRequest;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.core.MethodParameter; import
 * org.springframework.http.HttpInputMessage; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.converter.HttpMessageConverter; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.bind.annotation.ResponseStatus; import
 * org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
 * import org.springframework.web.servlet.mvc.method.annotation.
 * ResponseEntityExceptionHandler;
 * 
 * @ControllerAdvice(assignableTypes = TestController.class) public class
 * ExceptionControllerAdvice extends ResponseEntityExceptionHandler implements
 * RequestBodyAdvice {
 * 
 * private final Logger LOG =
 * LoggerFactory.getLogger(ExceptionControllerAdvice.class);
 * 
 * @Autowired private ControllerHelper controllerHelper;
 * 
 * @Inject RequestContext requestContext;
 * 
 * @Inject private Person person;
 * 
 * @Autowired
 * 
 * @Inject private Person2 person2;
 * 
 * @ExceptionHandler(Exception.class)
 * 
 * @ResponseStatus(HttpStatus.BAD_REQUEST)
 * 
 * @ResponseBody public String
 * handleAPIRequestValidationException(HttpServletRequest req, Exception e) {
 * System.out.println("Hello3"); // LOG.info("Exception --> " + e.getClass(),
 * e); System.out.println("req:"+ getBody(req)); //Person2 p = (Person2)
 * req.getAttribute("person", RequestAttributes.SCOPE_REQUEST); // String p =
 * (String)obj; System.out.println("person object in"+ p.getName());
 * ServiceStatus serviceStatus = new ServiceStatus(); serviceStatus.setId(998);
 * //serviceStatus.setValue(p.toString());
 * //serviceStatus.setOptionalValue(p.toString()); ServiceStatusResponse
 * response = new ServiceStatusResponse(serviceStatus); String responseJson =
 * controllerHelper.generateJsonFromObj(response);
 * System.out.println(responseJson); return responseJson;//
 * ResponseEntity.status(998).body(responseJson);//HttpStatus BAD_REQUEST }
 * 
 * @Override public boolean supports(MethodParameter methodParameter, Type
 * targetType, Class<? extends HttpMessageConverter<?>> converterType) {
 * System.out.println("support1"); return false; }
 * 
 * @Override public HttpInputMessage beforeBodyRead(HttpInputMessage
 * inputMessage, MethodParameter parameter, Type targetType, Class<? extends
 * HttpMessageConverter<?>> converterType) throws IOException {
 * System.out.println("beforeBodyRead"); return inputMessage; }
 * 
 * @Override public Object afterBodyRead(Object body, HttpInputMessage
 * inputMessage, MethodParameter parameter, Type targetType, Class<? extends
 * HttpMessageConverter<?>> converterType) {
 * System.out.println("afterBodyRead"); if (body instanceof Person) { Person
 * question = (Person) body; return question; } else if (body instanceof
 * Person2) { person2 = (Person2) body; System.out.println(person2); return
 * person2; }
 * 
 * return body; }
 * 
 * @Override public Object handleEmptyBody(Object body, HttpInputMessage
 * inputMessage, MethodParameter parameter, Type targetType, Class<? extends
 * HttpMessageConverter<?>> converterType) {
 * System.out.println("handleEmptyBody"); return body; }
 * 
 * 
 * String getDESystemId() { return config.getEnvId().equals("A") ? " [DE BOX1]"
 * : "  [DE BOX2]"; }
 * 
 * public static String getBody(HttpServletRequest request){
 * 
 * 
 * 
 * String body = null; StringBuilder stringBuilder = new StringBuilder();
 * BufferedReader bufferedReader = null;
 * 
 * 
 * 
 * try { InputStream inputStream = request.getInputStream(); if (inputStream !=
 * null) { bufferedReader = new BufferedReader(new
 * InputStreamReader(inputStream)); char[] charBuffer = new char[128]; int
 * bytesRead = -1; while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
 * stringBuilder.append(charBuffer, 0, bytesRead); } } else {
 * stringBuilder.append(""); } } catch (IOException ex) { // throw ex; } finally
 * { if (bufferedReader != null) { try { bufferedReader.close(); } catch
 * (IOException ex) { // throw ex; } } }
 * 
 * 
 * 
 * body = stringBuilder.toString(); return body; } }
 */