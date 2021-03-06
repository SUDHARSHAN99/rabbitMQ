/*
 * package com.example.demo;
 * 
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStream; import java.io.InputStreamReader;
 * 
 * import javax.inject.Inject; import javax.servlet.http.HttpServletRequest;
 * import javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.servlet.ModelAndView; import
 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 * 
 * @Component public class DemoInterceptor extends HandlerInterceptorAdapter {
 * 
 * @Override public boolean preHandle(HttpServletRequest request,
 * HttpServletResponse response, Object handler) throws Exception {
 * ///requestContext.setRequestBody(request);
 * System.out.println("Inside pre handle"); return true; }
 * 
 * @Override public void postHandle(HttpServletRequest request,
 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
 * throws Exception { System.out.println("Inside post handle"); }
 * 
 * @Override public void afterCompletion(HttpServletRequest request,
 * HttpServletResponse response, Object handler, Exception exception) throws
 * Exception {
 * 
 * System.out.println("Inside after completion:"+ getBody(request));
 * System.out.println("=======================");
 * System.out.println("Inside after completion exception:"+ exception); } public
 * static String getBody(HttpServletRequest request) throws IOException {
 * 
 * String body = null; StringBuilder stringBuilder = new StringBuilder();
 * BufferedReader bufferedReader = null;
 * 
 * try { InputStream inputStream = request.getInputStream(); if (inputStream !=
 * null) { bufferedReader = new BufferedReader(new
 * InputStreamReader(inputStream)); char[] charBuffer = new char[128]; int
 * bytesRead = -1; while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
 * stringBuilder.append(charBuffer, 0, bytesRead); } } else {
 * stringBuilder.append(""); } } catch (IOException ex) { throw ex; } finally {
 * if (bufferedReader != null) { try { bufferedReader.close(); } catch
 * (IOException ex) { throw ex; } } }
 * 
 * body = stringBuilder.toString(); return body; } }
 */