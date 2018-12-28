<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formURL" value="/building/list"></c:url>
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
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form method="get" action="${formURL}" modelAttribute="model" id="formSubmit">
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
                    <input type="hidden" id="page" name="page">
                    </form:form>
                </div>
            </div>
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