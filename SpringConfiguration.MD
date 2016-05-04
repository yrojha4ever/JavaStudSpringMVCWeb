Spring JSTL:
```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
```


============File Upload:=============
```xml
1. pom.xml:
<!-- Common File Upload: -->
		<dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.2.2</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.4</version>
		</dependency>
```
```xml
2. servlet-context.xml
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="20000000"/>
    </bean>
```
```html
3. FileUpload.jsp

File Upload Example: 
	
	<form method="POST" action="upload" enctype="multipart/form-data" style="color:blue;border: 1px solid">
        File to upload: <input type="file" name="file">
        <br /> <br/>
        <input type="submit" value="Upload"/> Press here to upload the file!
    </form>
	
	<br/><br/>
	<label style="color:red">${successMsg}</label>
```
```java
	4. In Controller:
@Controller
@RequestMapping("/upload")
public class FileUploadController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "fileUpload";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		byte[] bytes;

		if (!file.isEmpty()) {
			bytes = file.getBytes();
			
			//Write in file.
			FileOutputStream out = new FileOutputStream( "D:\\temp\\"+ file.getOriginalFilename() );
			out.write(bytes);
			out.close();
		}

		System.out.println( "Received File:" + file.getOriginalFilename() );
		
		model.addAttribute("successMsg", "File upload Success: "+ file.getOriginalFilename());
		return "fileUpload";
	}
}
```

===============Spring Rest API Call===============
```xml
1. POM.xml : Need this for json to/from object: For SPRING REST Call
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-core</artifactId>
	<version>2.5.4</version>
</dependency>
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.5.4</version>
</dependency>
```
```java
2. Controller: @RestController 
@RestController
@RequestMapping("api/rest")
public class StudentRestController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> index() {
		ResponseEntity<List<Student>> studList = new ResponseEntity<List<Student>>( studentDao.getAll(), HttpStatus.OK);
		return studList;
	}
}
```
```
3. You need to have Jquery to send ajax rest call to server:
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
```
```java
4. Create /rest to go to rest testing jsp file:

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String restCall() {
		return "rest";
	}
	
```
   5. create rest.jsp file like this:
```html
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/resources/js/jquery-2.2.0.js"></script>
<!-- OR THIS
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
 -->
</head>
<body>

	<h3>Rest Call Example:</h3>  
	<a href="${pageContext.request.contextPath }/stud">Go To Student</a> <br/> <br/>
	
	<input type="button" value="Get All Students: JSON Data" onclick="showJsonData()" /> <hr/>
	<p id="displayJSON"></p>

</body>
<script type="text/javascript">
	function showJsonData() {
		/*AJAX GET*/
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "api/rest",
		}).then(function(data) {
			$('#displayJSON').html(JSON.stringify(data));
		});
	}
</script>

</html>

```
```
Where $.ajax is jquery Ajax server call method.
content type: application/json is to modify header information from text/html to json.
JSON.stringify is to convert JSON data to String.
$.ajax({
	type : "GET",
	contentType : "application/json",
	url : "api/rest",
	}).then(function(data) {
	$('#displayJSON').html(JSON.stringify(data));
});

It will care server api/rest url(that is rest usrl it only accept/resturn json data.
```

======================LOG4J=====================<br/>
log4j is a reliable, fast and flexible logging framework (APIs) written in Java. <br/>
log4j has three main components: <br/>
```
	loggers: Responsible for capturing logging information. 
	appenders: Responsible for publishing logging information to various preferred destinations.
	layouts: Responsible for formatting logging information in different styles.
It uses multiple levels, namely ALL, TRACE, DEBUG, INFO, WARN, ERROR and FATAL
```
****************
Log4j configuration in XML file format. (Create log4j.xml file in src/main/resources)
****************
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

	<!-- Appenders -->
	<appender name="console" class="org.apache.log4j.ConsoleAppender">
		<param name="Target" value="System.out" />
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="%-5p: %c - %m%n" />
		</layout>
	</appender>
	
	<appender name="file" class="org.apache.log4j.RollingFileAppender">
		<param name="file" value="C:\\log4j-application.log" />
		<param name="append" value="false" />
		<param name="maxFileSize" value="5MB"/>
		<param name="maxBackupIndex" value="10"/>
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="%-5p: %c - %m%n" />
		</layout>
	</appender>
	
	<!-- Application Loggers -->
	<logger name="com.javastud.springmvcweb">
		<level value="info" />
	</logger>
	
	<!-- 3rdparty Loggers -->
	<logger name="org.springframework.core">
		<level value="info" />
	</logger>
	
	<logger name="org.springframework.beans">
		<level value="info" />
	</logger>
	
	<logger name="org.springframework.context">
		<level value="info" />
	</logger>

	<logger name="org.springframework.web">
		<level value="info" />
	</logger>

	<!-- Root Logger -->
	<root>
		<priority value="warn" />
		<appender-ref ref="console" />
		<appender-ref ref="file" />
		<appender-ref ref="stdout" />
	</root>
	
</log4j:configuration>
```

OR> Log4j configuration in properties file format. (you can create log4j.properties file as well):

```
# Root logger option
log4j.rootLogger=DEBUG, stdout, file

# Redirect log messages to console
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

# Redirect log messages to a log file, support file rolling.
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File=C:\\log4j-application.log
log4j.appender.file.MaxFileSize=5MB
log4j.appender.file.MaxBackupIndex=10
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
```
