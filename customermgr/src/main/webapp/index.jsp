<%@ page import="com.sishuok.architecture1.customermgr.Customer1" %>
<%@ page import="com.mysql.cj.conf.BooleanPropertyDefinition" %>
<html>
<body>
<h2>Hello World!Customermgr===</h2>
<%

    System.out.println("now in Customermgr index.jsp");
    new Customer1().c1();
    //BooleanPropertyDefinition.class;
%>
</body>
</html>
