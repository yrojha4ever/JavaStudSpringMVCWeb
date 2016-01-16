Spring JSTL:
```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
```


============File Upload:=============
```
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
		
2. servlet-context.xml
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="20000000"/>
    </bean>

3. FileUpload.jsp

File Upload Example: 

	
	<form method="POST" action="upload" enctype="multipart/form-data" style="color:blue;border: 1px solid">
        File to upload: <input type="file" name="file">
        <br /> <br/>
        <input type="submit" value="Upload"/> Press here to upload the file!
    </form>
	
	<br/><br/>
	<label style="color:red">${successMsg}</label>
	
	4. In Controller:
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
```

===============Spring Rest API Call===============
```
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
```
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
```
4. Create /rest to go to rest testing jsp file:

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String restCall() {
		return "rest";
	}
	
```
5. create rest.jsp file like this:
```
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
