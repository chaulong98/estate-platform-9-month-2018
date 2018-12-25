<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formURL" value="/admin/building/list/priority"></c:url>

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
 </script>
</body>
</html>