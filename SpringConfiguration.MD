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

		
