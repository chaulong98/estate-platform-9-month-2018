<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formURL" value="/admin/building/list"></c:url>
<%@ page import="com.estate.utils.SecurityUtils" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">

            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Danh sách bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <%--<c:if test="${not empty messageResponse}">--%>
                    <%--<div class="alert alert-block alert-${alert}">--%>
                    <%--<button type="button" class="close" data-dismiss="alert">--%>
                    <%--<i class="ace-icon fa fa-times"></i>--%>
                    <%--</button>--%>
                    <%--${messageResponse}--%>
                    <%--</div>--%>
                    <%--</c:if>--%>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip" title="Thêm bài viết mới"
                                           href='<c:url value="/admin/building/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                        </a>
                                        <%--<button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" disabled--%>
                                        <%--data-toggle="tooltip" title="Xóa bài viết" onclick="warningBeforeDelete()">--%>
                                        <%--<span>--%>
                                        <%--<i class="fa fa-trash-o bigger-110 pink"></i>--%>
                                        <%--</span>--%>
                                        <%--</button>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <form:form action="${formURL}" modelAttribute="model" id="formSubmit" method="get">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>Ngày</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Địa chỉ</th>
                                            <th>Tên quản lí</th>
                                            <th>Số điện thoại</th>
                                            <th>D.T sàn</th>
                                            <th>D.T trống</th>
                                            <th>Giá thuê</th>
                                            <th>Phí dịch vụ</th>
                                            <th>Phí môi giới</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td>${item.createdDate}</td>
                                                <td>${item.productName}</td>
                                                <td>${item.ward}</td>
                                                <td>${item.managerName}</td>
                                                <td>${item.phoneNumber}</td>
                                                <td>${item.buildingArea}</td>
                                                <td>${item.deciptionArea}</td>
                                                <td>${item.rentCost}</td>
                                                <td>${item.rentCost}</td>
                                                <td>${item.rentCost}</td>
                                                <td>
                                                    <c:url var="editURL" value="/admin/building/edit">
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật bài viết" href='${editURL}'><i
                                                            class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul style="margin-left: 400px;" id="pagination-demo" class="pagination">

                                    </ul>
                                        <%--
                                        trong spring:form
                                        thì thẻ input không cần giá trị value
                                        để có thể lấy page của AbstractDTO
                                        chỉ cần name = "page" thì có thể lấy giá trị của nó rồi
                                        --%>
                                    <input type="hidden" name="page" id="page"/>
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

    });
    $(function () {
        var obj = $('#pagination-demo').twbsPagination({
            totalPages: totalPages,
            visiblePages: visiblePages,
            startPage: startPage,
            next: 'Next',
            prev: 'Prev',
            onPageClick: function (event, page) {
                //fetch content and render here
                $('#page-content').text('Page ' + page) + ' content here';
                //trang submit lien tuc
                if (page != startPage) {
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>
</body>
</html>
