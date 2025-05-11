ServletSession Question👇

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 

 
public class servlet1 extends HttpServlet { 

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	{ 
		try { 

			response.setContentType("text/html");  
			PrintWriter out = response.getWriter(); 

			String n = request.getParameter("userName");  
												
			out.print("Welcome " + n);  

			HttpSession session = request.getSession(); 

			session.setAttribute("uname", n); 
			

			out.print("<a href='Servlet2'>visit</a>");  

			out.close(); 
		} 
		catch (Exception e) { 
			System.out.println(e); 
		} 
	} 
} 



import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 

public class Servlet2 extends HttpServlet { 

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
                try { 
		/Declaration of the get method/
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 

		HttpSession session = request.getSession(false); 

		String n = (String)session.getAttribute("uname"); 
		out.print("Hello " + n); 

		out.close(); 
	} 
	catch (Exception e) { 
		System.out.println(e); 
	} 
} 
}


 <servlet>
        <servlet-name>servlet1</servlet-name>
        <servlet-class>servlet1</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>Servlet2</servlet-name>
        <servlet-class>Servlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>servlet1</servlet-name>
        <url-pattern>/servlet1</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>Servlet2</servlet-name>
        <url-pattern>/Servlet2</url-pattern>
    </servlet-mapping>


 <html> 
<head> 
    <title>Session Example</title>
<body> 
<form action="servlet1"> 
Name:<input type="text" name="userName"/><br/> 
<input type="submit" value="go"/> 
</form> 
</body> 
</html> 

 <------------------------------------------------------------------------------------------>
 ServletCookies Question👇


 import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class Servlet2 extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response){  
    try{  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
      
    Cookie ck[]=request.getCookies();  
    out.print("Hello "+ck[0].getValue());  
  
    out.close();  
  
         }catch(Exception e){
             System.out.println(e);
         }  
    }  
      
  import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
  
public class Servlet1 extends HttpServlet {  
  
  public void doGet(HttpServletRequest request, HttpServletResponse response){  
    try{  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  
    out.print("Welcome "+n);  
  
    Cookie ck=new Cookie("uname",n);//creating cookie object  
    response.addCookie(ck);//adding cookie in the response  
  
    //creating submit button  
    out.print("<form action='Servlet2'>"); 
  
    out.print("<input type='submit' value='go'>");  
    out.print("</form>");  
          
    out.close();  
  
        }catch(Exception e)
        {
            System.out.println(e);
        }  
  }  
}  
 

<html>
    <head>
        <title>Cookie Example</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
         <form action="Servlet1" method="get">  
Name:<input type="text" name="userName"/><br/>  
<input type="submit" value="go"/>  
</form> 
    </body>
</html>


<servlet>
        <servlet-name>Servlet1</servlet-name>
        <servlet-class>Servlet1</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>Servlet2</servlet-name>
        <servlet-class>Servlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Servlet1</servlet-name>
        <url-pattern>/Servlet1</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>Servlet2</servlet-name>
        <url-pattern>/Servlet2</url-pattern>
    </servlet-mapping>


<------------------------------------------------------------------------------------------>
Servlet Hidden Form Question👇

 import java.io.*;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;


public class Servlet2 extends HttpServlet{

public void doGet( HttpServletRequest request, HttpServletResponse response)
{
   try{
   
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       
       // getting the value from hidden form
       String n= request.getParameter("uname");
       out.print("hello" + n);
       
   
   out.close();
   }
   catch(Exception e)
   {
       System.out.println(e);
   }


}




}


 import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;


public class Servlet1 extends HttpServlet{

public void doGet(HttpServletRequest request, HttpServletResponse response){
    
   try {response.setContentType("text/html");
    PrintWriter out= response.getWriter();
    
    String n= request.getParameter("username");
    
    // creating hidden form
    
    out.print("<form action='Servlet2'>");
    out.print("hidden<input type='hidden' name='uname' value='"+n+"'>");
    out.print("<br/>");
    out.print("<input type='submit' value='go'>");
    out.print("</form>");
    
    
   out.close();
   }
   catch(Exception e)
   {
       System.out.println(e);
   }
   
}





}

 <servlet>
        <servlet-name>Servlet1</servlet-name>
        <servlet-class>Servlet1</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>Servlet2</servlet-name>
        <servlet-class>Servlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Servlet1</servlet-name>
        <url-pattern>/Servlet1</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>Servlet2</servlet-name>
        <url-pattern>/Servlet2</url-pattern>
    </servlet-mapping>

<html>
    <head>
        <title>Hidden Form Example</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="Servlet1" method="get"/>
        Name:<input type="text" name="username"/>
        <br/>
        <input type="submit" value="go"/>
            
            
            
            
            
        </form>
    </body>
</html>

<------------------------------------------------------------------------------------------>
Servlet Url Writing Question 👇👇

 import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UrlServlet2 extends HttpServlet
{
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String sql = request.getParameter("uname");
        out.println("Welcome " + sql);
        out.close();
    }
}

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UrlServlet1 extends HttpServlet
{
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
    {
      try{  response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String sql = request.getParameter("uaername");
        out.println("<a href = 'UrlServlet2?uname = "+sql+"'> Click here </a>");
        out.close();
      }
      catch(Exception e){
          System.out.println(e);
      }
    }
}

 <servlet>
        <servlet-name>UrlServlet1</servlet-name>
        <servlet-class>UrlServlet1</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>UrlServlet2</servlet-name>
        <servlet-class>UrlServlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>UrlServlet1</servlet-name>
        <url-pattern>/UrlServlet1</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>UrlServlet2</servlet-name>
        <url-pattern>/UrlServlet2</url-pattern>
    </servlet-mapping>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method = "Get" action = "UrlServlet1">
            username <input type ="text" name ="username" ><!-- comment -->
            <input type ="submit" value ="GO"><!-- comment -->
        </form>
    </body>
</html>

<------------------------------------------------------------------------------------------>
Send Redirect Question👇 

 import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class Servlet2 extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        String name=request.getParameter("name");  
        response.sendRedirect("https://www.google.co.in/#q="+name);  
    }  
}  

import java.io.*;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;


public class Servlet1 extends HttpServlet{

public void doGet(HttpServletRequest request, HttpServletResponse response)
{

try{
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
//      String n= request.getParameter("name");
      response.sendRedirect( "http://www.google.com");
      
      out.close();

}
catch(Exception e){
    System.out.println(e);
}

}

<html>
    <head>
        <title>SendRedirect Example</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="Servlet1">
            Name:<input type="text" name="name"/>
            <input type="submit" value="Google Search"/>
            
            
        </form>
    </body>
</html>

 <servlet>
        <servlet-name>Servlet1</servlet-name>
        <servlet-class>Servlet1</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>Servlet2</servlet-name>
        <servlet-class>Servlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Servlet1</servlet-name>
        <url-pattern>/Servlet1</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>Servlet2</servlet-name>
        <url-pattern>/Servlet2</url-pattern>
    </servlet-mapping>

RequestDispatcher Question👇 

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Servlet1 extends HttpServlet{

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
     response.setContentType("text/html");
     PrintWriter out=response.getWriter();
     
     String user=request.getParameter("username");
      String userpass=request.getParameter("userpass");
      
      
      if(userpass.equals("San123"))
      {
         RequestDispatcher rd=request.getRequestDispatcher("Servlet2");
         rd.forward(request, response);
      
      }
      else{
          out.print("Sorry UserName or Password Error!");  
          RequestDispatcher rd=request.getRequestDispatcher("/index.html");
          rd.include(request, response);
          
      }
      out.close();


}



}

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Servlet2 extends HttpServlet{

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
     response.setContentType("text/html");
     PrintWriter out=response.getWriter();
     
     String user1=request.getParameter("username");
     
     
     out.print("welcome  " + user1);
     
     
     out.close();
       
      }
     


}


<servlet>
        <servlet-name>Servlet1</servlet-name>
        <servlet-class>Servlet1</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>Servlet2</servlet-name>
        <servlet-class>Servlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Servlet1</servlet-name>
        <url-pattern>/Servlet1</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>Servlet2</servlet-name>
        <url-pattern>/Servlet2</url-pattern>
    </servlet-mapping>

<html>
    <head>
        <title>RequestDispatcher Example</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method="post" action="Servlet1">
            Username:<input type="text" name="username"/>
            <br>
            <br>
            Password:<input type="text" name="userpass"/>
            <br><!-- comment -->
            <br><!-- comment -->
            <input type="submit" value="login"/>
            
        
        </form>
    </body>
</html>