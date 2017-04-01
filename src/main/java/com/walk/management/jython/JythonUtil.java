package com.walk.management.jython;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;
public class JythonUtil {

	@SuppressWarnings("resource")
	public static String getSummary(String content){
		Properties props = new Properties();
		props.put("python.home","path to the Lib folder");
		props.put("python.console.encoding", "UTF-8"); // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
		props.put("python.security.respectJavaAccessibility", "false"); //don't respect java accessibility, so that we can access protected members on subclasses
		props.put("python.import.site","false");

		Properties preprops = System.getProperties();
				
		PythonInterpreter.initialize(preprops, props, new String[0]);
		PythonInterpreter inter = new PythonInterpreter();
		
		PySystemState sys = Py.getSystemState();
		sys.path.add("D:\\pytyon2.7\\Lib");
		sys.path.add("D:\\pytyon2.7\\Lib\\textrank4zh-0.3");
		sys.path.add("D:\\pytyon2.7\\Lib\\site-packages");
		inter.execfile(getIOStream("summaryUtil.py"),"summaryUtil.py");
		PyFunction func = (PyFunction)inter.get("getSummary",PyFunction.class);
		PyObject pyObj = func.__call__(new PyString(content));
		System.out.println("test");
		System.out.println(pyObj);
		return null;
	}
	
	public static InputStream getIOStream(String fileName){
		InputStream is = JythonUtil.class.getResourceAsStream("./summaryUtil.py");
		return is;
	}
	public static void main(String[] args){
		String test = "一切都比较平淡，想做的事现在正做着，这两年的计划基本上定了，如果能这样静静的走下去，也不会特别在乎是否是一个人:)";
		//String test = "testtttttttttttttttttttasdflkasjdf;aslkdfjas;dfljf;kdsafds";
		getSummary(test);
	}
}
