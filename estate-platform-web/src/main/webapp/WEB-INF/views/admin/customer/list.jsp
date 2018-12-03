<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formURL" value="/admin/customer/list"/>
<c:url var="deleteUrl" value="/api/admin/customer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách khách hàng</title>
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
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Danh sách khách hàng</li>
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
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form action="${formURL}" modelAttribute="model" id="formSubmit" method="get">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="widget-box table-filter">
                                    <div class="widget-header">
                                        <h4 class="widget-title">Tìm kiếm</h4>
                                        <div class="widget-toolbar">
                                            <a href="#" data-action="collapse">
                                                <i class="ace-icon fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div class="form-horizontal">
                                                <div class="form-group">

                                                    <label class="col-sm-2 control-label">Tên khách hàng:</label>
                                                    <div class="col-sm-3">
                                                        <div class="fg-line">
                                                            <form:input path="fullName"  value="${model.fullName}"
                                                                        cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>


                                                    <label class="col-sm-2 control-label">Di động:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <form:input path="phoneNumber"  value="${model.phoneNumber}"
                                                                        cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">Email:</label>
                                                    <div class="col-sm-3">
                                                        <div class="fg-line">
                                                            <form:input path="email"  value="${model.email}"
                                                                        cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>




                                                <c:if test="${permission == 'ADMIN'}">


                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">Chọn nhân viên phụ trách:</label>
                                                        <div class="col-sm-4">
                                                            <div class="fg-line">
                                                                <form:select path="staffs" id="staffs">
                                                                    <form:option value="" label="--- Chọn nhân viên phụ trách ---"/>
                                                                    <form:options items="${users}"/>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </c:if>





                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"></label>
                                                    <div class="col-sm-6">
                                                        <button type="button" class="btn btn-sm btn-success" id="btnSearch">
                                                            Tìm kiếm
                                                            <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-btn-controls">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                               data-toggle="tooltip" title="Thêm khách hàng mới" href='<c:url value="/admin/customer/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                            </a>
                                            <c:if test="${permission == 'ADMIN'}">
                                            <button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" disabled
                                                    data-toggle="tooltip" title="Xóa khách hàng">
                                                    <span>
                                                        <i class="fa fa-trash-o bigger-110 pink"></i>
                                                	</span>
                                            </button>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" value="" id="checkAll"/></th>
                                            <th>Tên</th>
                                            <th>Di động</th>
                                            <th>Email</th>
                                            <th>Nhu cầu</th>
                                            <th>Người nhập</th>
                                            <th>Ngày nhập</th>
                                            <th>Tình trạng</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"/></td>
                                                <td>${item.fullName}</td>
                                                <td>${item.phoneNumber}</td>
                                                <td>${item.email}</td>
                                                <td>${item.exigenxy}</td>
                                                <td>${item.createdBy}</td>
                                                <td>${item.createdDate}</td>
                                                <td>

                                                   <c:if test="${item.status == false}">
                                                       <p>Chưa xử lý</p>
                                                   </c:if>
                                                    <c:if test="${item.status == true}">
                                                        <p>Đang xử lý</p>
                                                    </c:if>

                                                </td>

                                                <c:if test="${permission == 'ADMIN'}">

                                                <td>
                                                    <c:url var="editURL" value="/admin/customer/edit">
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật khách hàng" href='${editURL}'>
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                                </c:if>

                                                <c:if test="${permission == 'USER'}">
                                                <c:if test="${item.status == false}">
                                                    <td>

                                                        <a class="btn btn-xs btn-primary btn-edit" data-toggle="tooltip"
                                                           title="Xử lý" href='#' >
                                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                        </a>
                                                    </td>

                                                </c:if>
                                                <c:if test="${item.status == true}">
                                                    <td>
                                                        <a class="btn btn-xs btn-primary btn-edit" data-toggle="tooltip"
                                                           title="Cập nhật tiến trình"
                                                           href='<c:url value="/admin/customer/edit/${item.id}"/>'>
                                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                        </a>

                                                    </td>

                                                </c:if>
                                                </c:if>
                                                <td>
                                                    <a class="btn btn-xs btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Xem"
                                                       href='#'>
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>

                                                </td>




                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                    <ul id="pagination-demo" class="pagination">
                                    </ul>
                                    <input type="hidden" name="page" id="page" value="${model.page}"/>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var totalPages = ${model.totalPages};
    var visiblePages = ${model.maxPageItems};
    var startPage = ${model.page};
    $(document).ready(function () {
        $('#btnSearch').click(function () {
            $('#formSubmit').submit();
        });


        $('#btnDelete').click(function (e) {
                e.preventDefault();

                var data = {};

                var data = $('body td input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();

                if (data[0] == "") {
                    data.splice(0, 1);
                }

                deleteCustomer(data);
            }
        );
    });
    $(function () {
        var obj = $('#pagination-demo').twbsPagination({
            totalPages: totalPages,
            visiblePages: visiblePages,
            startPage: startPage,
            onPageClick: function (event, page) {
                if (page != startPage) {
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
        });
    });

    //xoa bai viet
    function deleteCustomer(data) {
        $.ajax({
            url: '${deleteUrl}',
            type: 'DELETE',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                window.location.href = "<c:url value='/admin/customer/list?message=delete_success'/>";
            },
            error: function (result) {
                window.location.href = "<c:url value='/admin/customer/list?message=error_system'/>";
            },
        });
    }


</script>
</body>
</html>
