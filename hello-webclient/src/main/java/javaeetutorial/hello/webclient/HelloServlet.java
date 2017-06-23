package javaeetutorial.hello.webclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import javaeetutorial.helloservice.endpoint.HelloService;

@WebServlet(name = "HelloServlet", urlPatterns = { "/HelloServlet" })
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			out.println("<html lang=\"en\">");
			out.println("<head>");
			out.println("<title>Servlet HelloServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
			out.println("<p>" + sayHello("world") + "</p>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	// doGet and doPost methods, which call processRequest, and
	// getServletInfo method
	private String sayHello(java.lang.String arg0) throws MalformedURLException {
		HelloService helloService = new HelloService();
		javaeetutorial.helloservice.endpoint.Hello port = helloService.getHelloPort();
		return port.sayHello(arg0);
	}
}