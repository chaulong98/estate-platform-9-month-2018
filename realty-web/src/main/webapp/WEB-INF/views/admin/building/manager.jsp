<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
    <c:url var="manager" value="/ajax/building/manager"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>

<div class="modal-dialog">



    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Giao tòa nhà</h4>
        </div>
        <div class="modal-body">
         <form:form id="formSubmit"  modelAttribute="model">
         <form:hidden path="id" id="id" />

               	<div class="check_manager">
     	         <table>
     	            <tr>
				    <th>Chọn</th>
				     <th>Tên</th>
				    </tr>
				    <c:forEach var="item" items="${model.listuser}" >
				    <tr>
				    
									<td><form:checkbox path="dependencies"  value="${item.id}" id="dependencies"  /></td>
									<td>${item.fullName}</td>
				    </tr>
										
					</c:forEach>
				</table>
				</div>
		 </form:form>
        </div>	
         <div class="modal-footer">
          <button id="btnSubmit" type="button" class="btn btn-default" data-dismiss="modal">Submit</button>
        </div>				
       
      </div>
      
    </div>
    
    <script type="text/javascript">
    $('#btnSubmit').click(function (e) {	
        e.preventDefault();
        var dependencies = $('.check_manager input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        
        var dataArray = {};
        
        
        dataArray['dependencies'] =  dependencies;
        var id =  $('#id').val();
        $.ajax ({
            url: '${manager}/'+id,
            type: 'POST',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(dataArray),
            success: function(res) {
            	 window.location.href = "<c:url value='/manager/building/list'/>";
            	
            },
            error: function(res) {
                console.log(res);                	
            }
        });
        
    });
    
    </script>
</body>
</html>