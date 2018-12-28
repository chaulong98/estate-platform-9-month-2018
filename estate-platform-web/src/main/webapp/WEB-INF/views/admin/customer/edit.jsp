<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/admin/customer"/>
<html>
<head>
    <title>Chỉnh sửa thông tin khách hàng</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="/admin/home">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa thông tin khách hàng</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form:form id="formSubmit" modelAttribute="model">

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Tên</label>
                        <div class="col-sm-9">
                            <form:input path="fullName" cssClass="form-control" id="fullName"/>
                        </div>
                    </div>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">SĐT</label>
                        <div class="col-sm-9">
                            <form:input path="phone" cssClass="form-control" id="phone"/>
                        </div>
                    </div>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Email</label>
                        <div class="col-sm-9">
                            <form:input path="email" cssClass="form-control" id="email"/>
                        </div>
                    </div>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Tên công ty</label>
                        <div class="col-sm-9">
                            <form:input path="companyName" cssClass="form-control" id="companyName"/>
                        </div>
                    </div>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Nhu cầu</label>
                        <div class="col-sm-9">
                            <form:input path="need" cssClass="form-control" id="need"/>
                        </div>
                    </div>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Ghi chú</label>
                        <div class="col-sm-9">
                            <form:input path="note" cssClass="form-control" id="note"/>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <c:if test="${not empty model.id}">
                                <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật khách hàng" id="btnAddOrUpdateCustomer"/>
                            </c:if>
                            <c:if test="${empty model.id}">
                                <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm mới khách hàng" id="btnAddOrUpdateCustomer"/>
                            </c:if>
                        </div>
                    </div>
                </div>
                <form:hidden path="id" id="customerId"/>
                </form:form>
            </div>
        </div>
    </div>
</div>
</div>
<script>
    $(document).ready(function () {
        $('#btnAddOrUpdateCustomer').click(function (e) {
            e.preventDefault();
            var data = {};
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (i,v) {
                data[""+v.name+""] = v.value;
            });
            var customerId = $('#customerId').val();
            if(customerId == ""){
                addCustomer(data);
            }
            else {
                updateCustomer(data);
            }
        });

    });
    function addCustomer(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            data: JSON.stringify(data),
            contentType:'application/json',
            dataType:'json',
            success: function(result){
                window.location.href = "<c:url value='/admin/customer/edit?id="+result.id+"&message=insert_success'/> ";
            },
            error: function(result){
                window.location.href = "<c:url value='/admin/customer/edit?id="+result.id+"&message=error_system'/> ";
            }
        });
    }
    function updateCustomer(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            data: JSON.stringify(data),
            contentType:'application/json',
            dataType:'json',
            success: function(result){
                window.location.href = "<c:url value='/admin/customer/edit?id="+result.id+"&message=update_success'/> ";
            },
            error: function(result){
                window.location.href = "<c:url value='/admin/customer/edit?id="+result.id+"&message=error_system'/> ";
            }
        });
    }
</script>
</body>
</html>
