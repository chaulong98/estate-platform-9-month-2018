<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/admin/customer/assignment"/>
<c:url var="formURL" value="/admin/customer/list"/>
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
                    <a href="<c:url value="/admin/home"/>">Trang chủ</a>
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
                                <div class="widget-box table-filter collapsed">
                                    <div class="widget-header">
                                        <h4 class="widget-title">Tìm kiếm</h4>
                                        <div class="widget-toolbar" >
                                            <a href="#" data-action="collapse" >
                                                <i class="ace-icon fa fa-chevron-down" ></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">Tên:</label>
                                                    <div class="col-sm-8">
                                                        <div class="fg-line">
                                                            <form:input path="fullName" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">SĐT:</label>
                                                    <div class="col-sm-8">
                                                        <div class="fg-line">
                                                            <form:input path="phone" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"></label>
                                                    <div class="col-sm-8">
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
                                            <button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" disabled
                                                    data-toggle="tooltip" title="Xóa khách hàng">
                                                    <span>
                                                        <i class="fa fa-trash-o bigger-110 pink"></i>
                                                	</span>
                                            </button>
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
                                            <th>Tên khách hàng</th>
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
                                                <td><input type="checkbox" name="delete"  value='${item.id}' id="checkbox_${item.id}"/></td>
                                                <td>${item.fullName}</td>
                                                <td>${item.phone}</td>
                                                <td>${item.email}</td>
                                                <td>${item.need}</td>
                                                <td>${item.createdBy}</td>
                                                <td>${item.createdDate}</td>
                                                <td>${item.status}</td>
                                                <td>
                                                    <c:url var="editURL" value="/admin/customer/edit">
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật thông tin khách hàng" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                    <a class="btn btn-sm btn-primary"  onclick="show(${item.id})"
                                                       title="Giao khách hàng" ><i class="fa fa-tasks" aria-hidden="true"></i>
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
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" id="close">&times;</button>
                    <h4 class="modal-title">Giao khách hàng</h4>
                </div>
                <div class="modal-body">
                    <table class="table" id="staffAssignList">
                        <thead>
                        <tr>
                            <th class="text-center">
                                Chọn nhân viên
                            </th>
                            <th class="text-center">
                                Tên nhân viên
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <input type="hidden" id="customerId">
                        <c:forEach var="item" items="${staff.listResult}">
                            <tr>
                                <th class="text-center"><input type="checkbox" name="staff" value="${item.id}" id="checkbox_${item.id}" /></th>
                                <th class="text-center">${item.userName}</th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"  id="btnCancel"data-dismiss="modal">Đóng</button>
                    <button type="button" class="btn btn-default" id="btnAssign">Giao</button>
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
        $('#btnCancel').click(function () {
            $("#myModal").modal('hide');
            $('input[name=staff]').each(function (){
                $(this).prop("checked",false);
            });
        });

        $('#close').click(function () {
            $("#myModal").modal('hide');
            $('input[name=staff]').each(function (){
                $(this).prop("checked",false);
            });
        });

        $('#btnAssign').click(function () {
            var staffIds = $('#staffAssignList').find('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            var customerId = $("#customerId").val();
            updateAssignment(staffIds,customerId)
        });
    });
    function show(id) {
        $("#myModal").modal('show');
        $("#customerId").val(id);
        var list = getStaffCustomer(id);
        $("input[name=staff]").each(function (){
            var e = $(this);
            list.forEach(function (value) {
                var e1 = $(this);
                if(e.val() == value){
                    e.prop("checked",true);
                }
            })
        });
    }
    function updateAssignment(assignList,customerId) {
        var data = {
            userID : assignList,
            customerId : customerId
        }
        $.ajax({
            url: '${APIurl}?customerId=' + customerId ,
            type: 'POST',
            contentType:'application/json',
            dataType:'json',
            data: JSON.stringify(assignList),
            success: function(result){
                $("#myModal").modal('hide');
                $('input[name=staff]').each(function (){
                    $(this).prop("checked",false);
                });
                toastr.success("Giao khách hàng thành công")
            },
            error: function(result){
                toastr.error("Giao khách hàng thất bại")
            }
        });
    }
    function getStaffCustomer(customerId) {
        var resultdata = [];
        var data = {
            customerId : customerId
        }
        $.ajax({
            url: '/api/admin/customer/staffs?customerId=' + customerId ,
            type: 'GET',
            async : false,
            contentType:'application/json',
            dataType:'json',
            success: function(result){
                resultdata = result;
            },
            error: function(result){
                toastr.error("Lỗi hệ thống")
            }
        });
        return resultdata;
    }
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

</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
</body>
</html>
