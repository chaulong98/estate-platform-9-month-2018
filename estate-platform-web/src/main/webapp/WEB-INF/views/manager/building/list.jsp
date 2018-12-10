<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<div id="sidebar" class="sidebar                  responsive">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li class="active">
            <a href="index.html">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text"> Quản lý sản phẩm </span>
            </a>

            <b class="arrow"></b>
        </li>

        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-desktop"></i>
                <span class="menu-text">
								Quản lý sản phẩm
							</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">

                <li class="">
                    <a href="<c:url value='/manager-product-list'/> ">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh mục sản phẩm
                    </a>

                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul><!-- /.nav-list -->

    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
    </script>
</div>
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
                    <div class="row">
                        <div class="col-xs-12">
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
                                                <c:url var="deliveryURL" value="/ajax-manager-building-delivery">
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>
                                                <a class="btn btn-sm btn-primary btn-add" data-toggle="tooltip"
                                                   title="Giao tòa nhà" url="${deliveryURL}" onclick="loadModal(this)"><i class="fa fa-pencil-square" aria-hidden="true"></i>
                                                </a>
                                                <c:if test="${!item.priority}">
                                                    <a class="btn btn-sm btn-primary btn-add" data-toggle="tooltip"
                                                       title="Thêm tòa nhà ưu tiên" onclick="priorityBuilding(this, ${item.id}, ${item.priority})"><span class="glyphicon glyphicon-plus"></span>
                                                    </a>
                                                </c:if>
                                                <c:if test="${item.priority}">
                                                    <a class="btn btn-sm btn-primary btn-add" data-toggle="tooltip"
                                                       title="Xóa tòa nhà ưu tiên" onclick="priorityBuilding(this, ${item.id}, ${item.priority})"><span class="glyphicon glyphicon-minus"></span>
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
                    console.log("sucess");
                },
                error: function(result){
                    console.log("fail");
                }
            });
        })
    }

    function priorityBuilding(btn, buildingId, priority){
        var priority = priority;
        if(priority){
            removePriority(btn, buildingId);
        }else{
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
                console.log("sucess");
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
                console.log("sucess");
            },
            error: function(result){
                console.log("fail");

            }
        });
    }
</script>
</body>
</html>