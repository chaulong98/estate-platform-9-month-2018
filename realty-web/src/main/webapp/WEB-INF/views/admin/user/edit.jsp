<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<%-- <c:url var="formUrl" value="/ajax/news"/> --%>
<c:url var="updateAPIUrl" value="/ajax/user" />
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>

	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa bài viết</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
<%-- 						<c:if test="${not empty messageResponse}"> --%>
<%-- 							<div class="alert alert-block alert-${alert}"> --%>
<!-- 								<button type="button" class="close" data-dismiss="alert"> -->
<!-- 									<i class="ace-icon fa fa-times"></i> -->
<!-- 								</button> -->
<%-- 								${messageResponse} --%>
<!-- 							</div> -->
<%-- 						</c:if> --%>
						
						<h3 id="message" style="color: red;"></h3>
						<form:form id="formEdit" commandName="model">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Vai Trò
								</label>
								<div class="col-sm-9">
									<form:select path="selectorRole" id="selectorRole">
										<form:option value="NONE" label="--- Chọn Vai Trò ---" />
										<form:options items="${model.mapRole}" />
									</form:select>
								</div>
							</div>
							<br />
							<br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tên Đăng Nhập
									</label>
								<div class="col-sm-9">
									<form:input path="userName" id="userName" />
								</div>
							</div>
							<br />
							<br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tên Đầy Đủ
									</label>
								<div class="col-sm-9">
									<form:input path="fullName" id="fullName" />
								</div>
							</div>
							<br />
							<br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Email
									</label>
								<div class="col-sm-9">
									<form:input path="email" id="email" />
								</div>
							</div>
							
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Điện Thoại 
									</label>
								<div class="col-sm-9">
									<form:input path="phoneNumber" id="phoneNumber" />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Status
									</label>
								<div class="col-sm-9">
									<form:input path="status" id="status" />
								</div>
							</div>
							<br>
							<br>
							<c:if test="${not empty model.password}">
										<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mật Khẩu
									</label>
								<div class="col-sm-9">
									<form:password path="password" id="password" />
								</div>
							    </div>
									</c:if>
									
									<c:if test="${empty model.password}">
									<form:hidden  path="password" id="password" />
									</c:if>
									
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id}">
										<input type="submit"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật bài viết" id="btnAddOrUpdateNews" />
									</c:if>
									<c:if test="${empty model.id}">
										<input type="submit"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm mới bài viết" id="btnAddOrUpdateNews" />
									</c:if>
								</div>
							</div>
							<form:hidden path="id" id="userId" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function () {
	});
    
    
    $('#btnAddOrUpdateNews').click(function (e) {	
        e.preventDefault();
        var dataArray = {};
        dataArray['userName'] = $('#userName').val();
        dataArray['fullName'] = $('#fullName').val();
        dataArray['email'] = $('#email').val();
        dataArray['phoneNumber'] = $('#phoneNumber').val();
        dataArray['selectorRole'] = $('#selectorRole').val();
        dataArray['status'] = $('#status').val();
        dataArray['password'] = $('#password').val();
        
           
            if ($('#userId').val() != "") {
                updateNews(dataArray, $('#userId').val());
            }
         else {    
                 insertNews(dataArray);
            }
    });

    function updateNews(data, id) {
        $.ajax ({
            url: '${updateAPIUrl}/'+id,
            type: 'PUT',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
            	if(res.checkUserAndEmail){
            		
            		$("#message").text("Chỉnh sửa thành công!");
           		
           		
           	}else{
           		$("#message").text("tên đăng nhập và email bi lỗi  !");
           	}
            	
            },
            error: function(res) {
                console.log(res);                	
            }
        });
    }

    function insertNews(data) {
        $.ajax ({
            url: '${updateAPIUrl}',
            type: 'POST',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
            	if(res.checkUserAndEmail){
            		 window.location.href = "<c:url value='/admin/user/list'/>";
            		
            		
            	}else{
            		$("#message").text("tên đăng nhập và email bi lỗi  !");
            	}
               
            },
            error: function(res) {
                console.log(res);
            }
        });
    }
</script>
</body>
</html>
