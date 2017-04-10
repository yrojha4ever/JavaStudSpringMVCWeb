<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

					</div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
    <!-- /#wrapper -->
    
    <div id="footer" class="navbar navbar-fixed-bottom">
		<h5 class="text-center"> All Right Reserved, Copyright © <fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy"/> </h5>
	</div>
	
    <!-- Menu Toggle Script -->
    <script>
	    $("#menu-toggle").click(function(e) {
	        e.preventDefault();
	        $("#wrapper").toggleClass("toggled");
	    });
    </script>
</body>
</html>