<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formURL" value="/admin/building/list"></c:url>
<c:url var="deleteUrl" value="/api/admin/building"/>
<c:url var="APIurl" value="/api/admin/building"/>
<c:url var="Priorityurl" value="/api/admin/building/priority"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách tòa nhà</title>
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
                <li class="active">Danh sách tòa nhà</li>
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
                                            <label>Tên Sản phẩm</label>
                                            <div class="fg-line">
                                                <form:input path="productName" cssClass="form-control input-sm"/>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>Diện tích sàn</label>
                                            <div class="fg-line">
                                                <input type="number" name="buildingArea" class="form-control input-sm"
                                                       value="${model.buildingArea}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label>Quận hiện có</label>
                                            <div class="fg-line">
                                                <form:select path="district" id="district">
                                                    <form:option value="" label="--- Chọn quận ---"/>
                                                    <form:options items="${districts}"/>
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
                                                <form:input path="level" id="level" cssClass="form-control input-sm"/>
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
                                                <form:checkboxes path="typeBuilding" items="${buildingTypes}"/>
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
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <security:authorize ifAnyGranted="MANAGER">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <a flag="info"
                                               class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                               data-toggle="tooltip" title="Thêm bài viết mới"
                                               href='<c:url value="/admin/building/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                            </a>
                                            <button id="btnDelete" type="button"
                                                    class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                    disabled
                                                    data-toggle="tooltip" title="Xóa bài viết">
                                                    <span>
                                                        <i class="fa fa-trash-o bigger-110 pink"></i>
                                                	</span>
                                            </button>
                                        </div>
                                    </security:authorize>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="c-xs-12">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <td><input type="checkbox" value="" id="checkAll"/></td>
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
                                            <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"/>
                                            </td>
                                            <td>${item.createdDate}</td>
                                            <td>${item.productName}</td>
                                            <td>${item.ward}</td>
                                            <td>${item.managerName}</td>
                                            <td>${item.phoneNumber}</td>
                                            <td>${item.buildingArea}</td>
                                            <td>${item.descriptionArea}</td>
                                            <td>${item.rentCost}</td>
                                            <td>${item.feesService}</td>
                                            <td>${item.brokeragefees}</td>
                                            <td>
                                                <c:url var="editURL" value="/admin/building/edit">
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>

                                                <a class="btn btn-xs btn-primary btn-edit"
                                                   type="button"
                                                   title="Cập nhật bài viết"
                                                   href='${editURL}'>

                                                        <%--<i class="fa fa-pencil-square-o" aria-hidden="true"></i>--%>
                                                    <i class="fa fa-edit"></i>
                                                </a>

                                                <security:authorize ifAnyGranted="MANAGER">
                                                    <%--<c:url var="assignmentURL" value="/admin/building/assignment">--%>
                                                    <%--<c:param name="id" value="${item.id}"/>--%>
                                                    <%--</c:url>--%>

                                                    <a class="btn btn-xs btn-primary btn-edit"
                                                       type="button"
                                                       id="btngiaoPho"
                                                       title='Giao tòa nhà'
                                                        <%--href="${assignmentURL}"--%>
                                                       value="${item.id}"
                                                       data-toggle="modal" data-target="#myModal"
                                                    >
                                                        <i class="fa fa-tasks"></i>
                                                    </a>
                                                </security:authorize>
                                                <c:if test="${item.checkPriority == false}">
                                                    <a class="btn btn-xs btn-primary btn-edit"
                                                       type="button"
                                                       id="btnPriority"
                                                       value = "${item.id}"
                                                       title='Sự ưu tiên'
                                                    >
                                                        <i class="fa fa-plus-square"></i>
                                                    </a>
                                                </c:if>
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
                </div>
                </form:form>
            </div>
        </div>
    </div>
</div>


<%--hien giao toa nha--%>
<%--modal bootrap--%>
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <%--<form:form modelAttribute="modal1">--%>
                <table class="table">
                    <tr>
                        <td>Chọn</td>
                        <td>Danh sách nhân viên</td>
                    </tr>
                    <c:forEach var="list" items="${listUser}">
                        <tr>
                            <th><input type="checkbox" value="${list.id}" ${list.check}/></th>
                            <th>${list.fullName}</th>
                        </tr>
                    </c:forEach>
                </table>
                <%--</form:form>--%>
            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-white btn-warning btn-bold"
                       value="Giao phó tòa nhà" data-dismiss="modal" id="btnAssignmentBuilding"/>
            </div>
        </div>

    </div>
</div>

<script type="text/javascript">
    var totalPages = ${model.totalPages};
    var visiblePages = ${model.maxPageItems};
    var startPage = ${model.page};
    var idBuilding = 0;

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

    $(document).ready(function () {
        $('#btnDelete').click(function (e) {
                e.preventDefault();

                var data = {};

                var data = $('body td input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();

                if (data[0] == "") {
                    data.splice(0, 1);
                }

                deleteBuilding(data);
            }
        );

        //giao pho toa nha
        $('#formSubmit a#btngiaoPho').click(function (e) {
            e.preventDefault();
            idBuilding = $(this).attr('value');
        });

        //giao pho toa nha
        $('#btnAssignmentBuilding').click(function (e) {
                e.preventDefault();
                var userIds = {};

                var userIds = $('body th input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                userAssignmentBuilding(userIds, idBuilding);
            }
        );

        //toa nha uu tien
        $('#formSubmit a#btnPriority').click(function (e) {
            e.preventDefault();
            idBuilding = $(this).attr('value');
            buildingPriority(idBuilding);
        });
    });

    //xoa bai viet
    function deleteBuilding(data) {
        $.ajax({
            url: '${deleteUrl}',
            type: 'DELETE',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                window.location.href = "<c:url value='/admin/building/list?message=delete_success'/>";
            },
            error: function (result) {
                window.location.href = "<c:url value='/admin/building/list?message=error_system'/>";
            },
        });
    }

    //them user vao building
    function userAssignmentBuilding(userIds, idBuilding) {
        $.ajax({
            url: '${APIurl}/' + idBuilding,
            type: 'POST',
            data: JSON.stringify(userIds),
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                window.location.href = "<c:url value='/admin/building/list?message=delete_success'/>";
            },
            error: function (result) {
                window.location.href = "<c:url value='/admin/building/list?message=error_system'/>";
            },
        });
    }

    //them su uu tien building
    function buildingPriority(idBuilding) {
        $.ajax({
            url: '${Priorityurl}/' + idBuilding,
            type: 'POST',
            data: JSON.stringify(idBuilding),
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                window.location.href = "<c:url value='/admin/building/list?message=delete_success'/>";
            },
            error: function (result) {
                window.location.href = "<c:url value='/admin/building/list?message=error_system'/>";
            },
        });
    }
</script>
</body>
</html>
