package Utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class JSFunction {

	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = "";
			script += "<script>";
			script += "alert('" + msg + "');";
			script += "location.href = '" + url + "';";
			script += "</script>";
			out.println(script);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "";
			script += "<script>";
			script += "alert('" + msg + "');";
			script += "history.back();";
			script += "</script>";
			out.println(script);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void alertLocation(String msg, String url, HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String script = "";
			script += "<script>";
			script += "alert('" + msg + "');";
			script += "location.href = '" + url + "';";
			script += "</script>";			
			writer.println(script);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void alertBack(String msg, HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter write = response.getWriter();
			String script = "";
			script += "<script>";
			script += "alert('" + msg + "');";
			script += "history.back();";
			script += "</script>";
			write.println(script);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
