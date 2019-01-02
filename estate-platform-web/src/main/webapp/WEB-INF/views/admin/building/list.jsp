<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/admin/building/assignment"/>
<c:url var="formURL" value="/admin/building/list"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách toà nhà</title>
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
                <li class="active">Danh sách toà nhà</li>
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
                                        <h4 class="widget-title">
                                            Tìm kiếm
                                        </h4>
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
                                                    <div class="col-sm-6">
                                                        <label>Tên toà nhà</label>
                                                        <div class="fg-line">
                                                            <form:input path="name" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Diện tích sàn</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="buildingArea" class="form-control input-sm"
                                                                   value="${model.floorArea}"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <label>Quận:</label>
                                                        <div class="fg-line">
                                                            <form:select path="district" id="district">
                                                                <form:option value="" label="--- Chọn quận ---"/>
                                                                <form:options items="${district}"/>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Phường</label>
                                                        <div class="fg-line">
                                                            <form:input path="ward" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Đường</label>
                                                        <div class="fg-line">
                                                            <form:input path="street" id="street" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <label>Số tầng hầm</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="basementNumber" class="form-control input-sm"
                                                                   value="${model.basement}"
                                                                   id="basementNumber"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Hướng</label>
                                                        <div class="fg-line">
                                                            <form:input path="direction" id="direction"
                                                                        cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Hạng</label>
                                                        <div class="fg-line">
                                                            <form:input path="grade" id="level" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                        <label>Diện tích từ</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="areaFrom" class="form-control input-sm"
                                                                   value="${model.areaFrom}" id="areaFrom"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <label>Diện tích đến</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="areaTo" class="form-control input-sm"
                                                                   value="${model.areaTo}" id="areaTo"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <label>Giá thuê từ</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="costFrom" class="form-control input-sm"
                                                                   value="${model.costFrom}" id="costFrom"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <label>Giá thuê đến</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="costTo" class="form-control input-sm"
                                                                   value="${model.costTo}" id="costTo"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <label>Tên quản lý</label>
                                                        <div class="fg-line">
                                                            <form:input path="managerName" id="managerName"
                                                                        cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Điện thoại quản lý</label>
                                                        <div class="fg-line">
                                                            <form:input path="managerPhone" id="phoneNumber"
                                                                        cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                        <div class="col-sm-4">
                                                            <label>Chọn nhân viên phụ trách</label>
                                                            <div class="fg-line">
                                                                <form:select path="staffName" id="staffName">
                                                                    <form:option value="" label="--- Chọn nhân viên phụ trách ---"/>
                                                                    <form:options items="${staffName}"/>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <div class="fg-line">
                                                            <form:checkboxes path="type" items="${type}"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <button id="btnSearch" type="button" class="btn btn-sm btn-success" onclick="searchBuilding()">
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
                                           data-toggle="tooltip" title="Thêm toà nhà mới" href='<c:url value="/admin/building/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                        </a>
                                        <button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" disabled
                                                data-toggle="tooltip" title="Xóa toà nhà">
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
                                            <th>Tên toà nhà</th>
                                            <th>Loại</th>
                                            <th>Giá thuê</th>
                                            <th>Diện tích thuê</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td><input type="checkbox" name="delete"  value='${item.id}' id="checkbox_${item.id}"/></td>
                                                <td>${item.name}</td>
                                                <td>${item.type}</td>
                                                <td>${item.rentFee}</td>
                                                <td>${item.rentArea}</td>
                                                <td>
                                                    <c:url var="editURL" value="/admin/building/edit">
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật toà nhà" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                    <a class="btn btn-sm btn-primary"  onclick="show(${item.id})"
                                                       title="Giao toà nhà" ><i class="fa fa-tasks" aria-hidden="true"></i>
                                                    </a>
                                                    <c:if test="${item.priority == false}">
                                                    <a class="btn btn-sm btn-primary"
                                                            id="btnAddToPriority" onclick="updatePriority(${item.id}, 'insert')"
                                                       title="Thêm vào danh sách ưu tiên" ><i class="fa fa-plus" aria-hidden="true"></i>
                                                    </a>
                                                    </c:if>
                                                    <c:if test="${item.priority == true}">
                                                        <a class="btn btn-sm btn-primary"
                                                           id="btnAddToPriority" onclick="updatePriority(${item.id}, 'remove')"
                                                           title="Xoá khỏi danh sách ưu tiên" ><i class="fa fa-minus" aria-hidden="true"></i>
                                                        </a>
                                                    </c:if>
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
                    <h4 class="modal-title">Giao toà nhà</h4>
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
                        <input type="hidden" id="buildingId">
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
            var buildingId = $("#buildingId").val();
            updateAssignment(staffIds,buildingId)
        });
    });
    function show(id) {
        $("#myModal").modal('show');
        $("#buildingId").val(id);
        var list = getStaffBuilding(id);
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
    function updatePriority(id, action) {
        $.ajax({
            url: '/api/admin/building/priority?buildingId=' + id + '&action=' + action,
            type: 'POST',
            contentType:'application/json',
            dataType:'json',
            success: function(result){
                if(action == 'insert'){
                    toastr.success("Thêm vào danh sách ưu tiên thành công")
                }else if(action == 'remove'){
                    toastr.success("Xoá khỏi danh sách ưu tiên thành công")
                }

            },
            error: function(result){
                if(action == 'insert'){
                    toastr.error("Thêm vào danh sách ưu tiên thất bại")
                }else if(action == 'remove'){
                    toastr.error("Xoá khỏi danh sách ưu tiên thất bại")
                }
            }
        });
    }
    function updateAssignment(assignList,buildingId) {
        var data = {
            userID : assignList,
            buildingId : buildingId
        }
        $.ajax({
            url: '${APIurl}?buildingId=' + buildingId ,
            type: 'POST',
            contentType:'application/json',
            dataType:'json',
            data: JSON.stringify(assignList),
            success: function(result){
                $("#myModal").modal('hide');
                $('input[name=staff]').each(function (){
                    $(this).prop("checked",false);
                });
                toastr.success("Giao toà nhà thành công")
            },
            error: function(result){
                toastr.error("Giao toà nhà thất bại")
            }
        });
    }
    function getStaffBuilding(buildingId) {
        var resultdata = [];
        var data = {
            buildingId : buildingId
        }
        $.ajax({
            url: '/api/admin/building/staffs?buildingId=' + buildingId ,
            type: 'GET',
            async : false,
            contentType:'application/json',
            dataType:'json',
            success: function(result){
                resultdata = result;
            },
            error: function(result){
                toastr.error("Giao toà nhà thất bại")
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
    })
    function searchBuilding() {
        $('#page').val(1);
        $('#formSubmit').submit();
    }

</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
</body>
</html>
