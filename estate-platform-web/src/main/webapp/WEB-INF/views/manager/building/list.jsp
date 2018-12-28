<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="formURL" value="/admin/building/list"></c:url>
<c:url var="APIurl" value="/api/building"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách sản phẩm</title>
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
                <li class="active">Danh sách sản phẩm</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <%--<div class="row">
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
            </div>--%>
            <form:form method="get" action="${formURL}" modelAttribute="model" id="formSubmit">
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="widget-box table-filter">
                                <div class="widget-header">
                                    <h4 class="widget-title">
                                        <spring:message code="label.search"/>
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
                                                    <label>Tên Sản phẩm</label>
                                                    <div class="fg-line">
                                                        <form:input path="buildingName"
                                                                    cssClass="form-control input-sm"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Diện tích sàn</label>
                                                    <div class="fg-line">
                                                        <input type="number" name="basementArea"
                                                               class="form-control input-sm"
                                                               value="${model.basementArea}"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label>Quận hiện có</label>
                                                    <div class="fg-line">
                                                        <form:select path="district">
                                                            <form:option value="" label="--Chọn quận--"/>
                                                            <form:options items="${mapDistrict}"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label>Phường</label>
                                                    <div class="fg-line">
                                                        <form:input path="ward" id="ward"
                                                                    cssClass="form-control input-sm"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label>Đường</label>
                                                    <div class="fg-line">
                                                        <form:input path="street" id="street"
                                                                    cssClass="form-control input-sm"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label>Số tầng hầm</label>
                                                    <div class="fg-line">
                                                        <input type="number" name="basementNumber"
                                                               class="form-control input-sm"
                                                               value="${model.basementNumber}"
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
                                                        <form:input path="level" id="level"
                                                                    cssClass="form-control input-sm"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label>Diện tích từ</label>
                                                    <div class="fg-line">
                                                        <input type="number" name="areaFrom"
                                                               class="form-control input-sm"
                                                               value="${model.areaFrom}" id="areaFrom"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label>Diện tích đến</label>
                                                    <div class="fg-line">
                                                        <input type="number" name="areaTo"
                                                               class="form-control input-sm"
                                                               value="${model.areaTo}" id="areaTo"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label>Giá thuê từ</label>
                                                    <div class="fg-line">
                                                        <input type="number" name="costFrom"
                                                               class="form-control input-sm"
                                                               value="${model.costFrom}" id="costFrom"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label>Giá thuê đến</label>
                                                    <div class="fg-line">
                                                        <input type="number" name="costTo"
                                                               class="form-control input-sm"
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
                                                        <form:input path="phoneNumber" id="phoneNumber"
                                                                    cssClass="form-control input-sm"/>
                                                    </div>
                                                </div>
                                                <security:authorize ifAnyGranted="MANAGER">
                                                    <div class="col-sm-4">
                                                        <label>Chọn nhân viên phụ trách</label>
                                                        <div class="fg-line">
                                                            <form:select path="staffName" id="staffName">
                                                                <form:option value="" label="--- Chọn nhân viên phụ trách ---"/>
                                                                <form:options items="${staffMaps}"/>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                </security:authorize>
                                            </div>
                                          <div class="form-group">
                                                <div class="col-sm-6">
                                                    <div class="fg-line">
                                                        <form:checkboxes path="productType" items="${type}"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <button id="btnSearch" type="button"
                                                            class="btn btn-sm btn-success">
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
                                           data-toggle="tooltip" title="Thêm tòa nhà mới mới" href='<c:url value="/admin/building/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                        </a>
                                        <button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" disabled
                                                data-toggle="tooltip" title="Xóa bài viết" onclick="warningBeforeDelete()">
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
                                        <th>Tên tòa nhà</th>
                                        <th>Địa chỉ</th>
                                        <th>Tên quản lý</th>
                                        <th>Số điện thoại</th>
                                        <th>D.T sàn</th>
                                        <th>D.T trống</th>
                                        <th>Giá thuê</th>
                                        <th>Phí dịch vụ</th>
                                        <th>Phí MG</th>
                                        <th>Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${model.listResult}">
                                        <tr>
                                            <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"/></td>
                                            <td>${item.buildingName}</td>
                                            <td>${item.district}</td>
                                            <td>${item.managerName}</td>
                                            <td>${item.phoneNumber}</td>
                                            <td>${item.basementArea}</td>
                                            <td>${item.emptyArea}</td>
                                            <td>${item.releasedCost}</td>
                                            <td>${item.feeService}</td>
                                            <td>${item.feeOvertime}</td>
                                            <td>
                                                <c:url var="editURL" value="/admin/building/edit">
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>
                                                <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                   title="Cập nhật tòa nhà" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                </a>
                                                <c:url var="deliveryURL" value="/ajax-manager-building-delivery">
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>
                                                <a class="btn btn-sm btn-primary btn-add" data-toggle="tooltip"
                                                   title="Giao tòa nhà" url="${deliveryURL}" onclick="loadModal(this)"><i class="fa fa-pencil-square" aria-hidden="true"></i>
                                                </a>
                                                <c:if test="${!item.priority}">
                                                    <a class="btn btn-sm btn-primary btn-add" data-toggle="tooltip"
                                                       title="Thêm tòa nhà ưu tiên" onclick="priorityBuilding(this, ${item.id})"><span class="glyphicon glyphicon-plus"></span>
                                                    </a>
                                                </c:if>
                                                <c:if test="${item.priority}">
                                                    <a class="btn btn-sm btn-primary btn-add" data-toggle="tooltip"
                                                       title="Xóa tòa nhà ưu tiên" onclick="priorityBuilding(this, ${item.id})"><span class="glyphicon glyphicon-minus"></span>
                                                    </a>
                                                </c:if>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <ul id="pagination-demo" class="pagination-sm">
                                </ul>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" id="page" name="page" value="${model.page}">

                </div>
            </div>
            </form:form>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog"></div>


<script type="text/javascript">
    var totalPages = ${model.totalPages};
    var visiblePages = ${model.maxPageItems};
    var startPage = ${model.page};
    $(document).ready(function () {
        $('#btnSearch').click(function () {
            $('#page').val(1);
            $('#formSubmit').submit();
        })
    });


    $('#pagination-demo').twbsPagination({
        totalPages: totalPages,
        visiblePages: visiblePages,
        startPage: startPage,
        next: 'Next',
        prev: 'Prev',
        onPageClick: function (event, page) {
            if(page != startPage){
                $('#page').val(page);
                $('#formSubmit').submit();
            }
        }
    });
    
    function loadModal(btn) {
        var url = $(btn).attr('url');
        $('#myModal').load(url, "", function() {
            $(this).modal('toggle');
            saveStaff();
        })
    }

    function saveStaff(){
        $('#save').click(function () {
            /*var userArrays = $('#userAssignTable').find('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();*/

            var userArrays = [];

            $('input[type=checkbox]:checked').each(function () {
                userArrays.push($(this).val());
            })

            var buildingId = $('#buildingId').val();
            $.ajax({
                url: '${APIurl}/' +  buildingId + "/assignment",
                type: 'POST',
                data: JSON.stringify(userArrays),
                contentType: 'application/json',
                dataType: 'json',
                success: function(result){
                    $('#myModal').modal('hide');
                    setTimeout(function() {
                        toastr.success("Giao tòa nhà thành công");
                    }, 1000);
                },
                error: function(result){
                    toastr.error("Giao toà nhà thất bại");
                }
            });
        })
    }

    function priorityBuilding(btn, buildingId){
        if($(btn).find('span').attr('class') == 'glyphicon glyphicon-minus' ){
            removePriority(btn, buildingId);
        }else if($(btn).find('span').attr('class') == 'glyphicon glyphicon-plus'){
            addPriority(btn, buildingId);
        }
    }

    function removePriority(btn, buildingId){
        $.ajax({
            url: '${APIurl}/' +  buildingId + "/priority",
            type: 'DELETE',
            contentType: 'application/json',
            dataType: 'json',
            success: function(result){
                    $(btn).find('span').removeClass("glyphicon glyphicon-minus").addClass("glyphicon glyphicon-plus");
                    $(btn).attr("title", "Thêm tòa nhà ưu tiên");
                    toastr.success("Xóa thành công");
            },
            error: function(result){
                console.log("fail");

            }
        });
    }

    function addPriority(btn, buildingId){
        $.ajax({
            url: '${APIurl}/' +  buildingId + "/priority",
            type: 'POST',
            contentType: 'application/json',
            dataType: 'json',
            success: function(result){
                    $(btn).find('span').removeClass("glyphicon glyphicon-plus").addClass("glyphicon glyphicon-minus");
                    $(btn).attr('title', 'Xóa tòa nhà ưu tiên');
                    toastr.success("Thêm thành công");
            },
            error: function(result){
                console.log("fail");

            }
        });
    }
</script>

</body>
</html>