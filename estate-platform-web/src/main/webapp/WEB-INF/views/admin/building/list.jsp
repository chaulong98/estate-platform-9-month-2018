<%@ page import="com.estate.controller.admin.BuildingController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formURL" value="/admin/building/list"></c:url>
<c:url var="deleteUrl" value="/api/admin/building"/>
<c:url var="APIurl" value="/api/admin/building"/>
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
            <div class="row">
                <div class="col-xs-12">
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
                    <form:form action="${formURL}" modelAttribute="model" id="formSubmit" method="get">
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

                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật bài viết" href='${editURL}'><i
                                                            class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>

                                                    <security:authorize ifAnyGranted="MANAGER">
                                                        <c:url var="assignmentURL" value="/admin/building/assignment">
                                                            <c:param name="id" value="${item.id}"/>
                                                        </c:url>

                                                        <a class="btn btn-xs btn-primary btn-edit"
                                                           type="button"
                                                           id="btngiaoPho"
                                                           title='Giao tòa nhà'
                                                           href="${assignmentURL}"
                                                           <%--data-toggle="modal" data-target="#myModal"--%>
                                                        >
                                                            <i class="fa fa-tasks"></i>
                                                        </a>
                                                    </security:authorize>
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


<%--hien giao toa nha--%>
<%--modal bootrap--%>
<!-- Modal -->
<%--<div class="modal fade" id="myModal" role="dialog">--%>
    <%--&lt;%&ndash;<div class="modal-dialog">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<!-- Modal content-->&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="modal-content">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="modal-header">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<button type="button" class="close" data-dismiss="modal">&times;</button>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<h4 class="modal-title">Danh sách nhân viên</h4>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="modal-body">&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<form:form modelAttribute="modal1">&ndash;%&gt;&ndash;%&gt;--%>
                    <%--&lt;%&ndash;&lt;%&ndash;<table class="table">&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;&lt;%&ndash;<tr>&ndash;%&gt;&ndash;%&gt;--%>
                            <%--&lt;%&ndash;&lt;%&ndash;<td>Chọn</td>&ndash;%&gt;&ndash;%&gt;--%>
                            <%--&lt;%&ndash;&lt;%&ndash;<td>Danh sách nhân viên</td>&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;&lt;%&ndash;</tr>&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;&lt;%&ndash;<c:forEach var="list" items="${listUser}">&ndash;%&gt;&ndash;%&gt;--%>
                            <%--&lt;%&ndash;&lt;%&ndash;<tr>&ndash;%&gt;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&lt;%&ndash;<th><input type="checkbox" value="${list.id}" ${list.check}/></th>&ndash;%&gt;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&lt;%&ndash;<th>${list.fullName}</th>&ndash;%&gt;&ndash;%&gt;--%>
                            <%--&lt;%&ndash;&lt;%&ndash;</tr>&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;&lt;%&ndash;</c:forEach>&ndash;%&gt;&ndash;%&gt;--%>
                    <%--&lt;%&ndash;&lt;%&ndash;</table>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;</form:form>&ndash;%&gt;&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="modal-footer">&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<input type="button" class="btn btn-white btn-warning btn-bold"&ndash;%&gt;&ndash;%&gt;--%>
                       <%--&lt;%&ndash;&lt;%&ndash;value="Giao phó tòa nhà" data-dismiss="modal" id="btnAssignmentBuilding"/>&ndash;%&gt;&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--</div>--%>

<script type="text/javascript">
    var totalPages = ${model.totalPages};
    var visiblePages = ${model.maxPageItems};
    var startPage = ${model.page};
    // var idBuilding = 0;
    // var url = window.location.href;

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

    <%--document.getElementById("btngiaoPho").onclick = function () {--%>
    <%--this.href += "/admin/building/list&id=" + ${item.id};--%>
    <%--alert(this.href);--%>
    <%--};--%>

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

        // $('#btngiaoPho').click(function (e) {
        //     idBuilding = $(this).closest('td').find('input').val();
        //     // window.location.href += "?id" + idBuilding;
        //     // response.
        //     // $('#myModal').modal('show');
        // });

    //     //giao pho toa nha
    //     $('#btnAssignmentBuilding').click(function (e) {
    //             e.preventDefault();
    //             var userIds = {};
    //             // var idBuilding = $('#idBuilding').val();
    //
    //             var userIds = $('body th input[type=checkbox]:checked').map(function () {
    //                 return $(this).val();
    //             }).get();
    //             userAssignmentBuilding(userIds, idBuilding);
    //         }
    //     );
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

    <%--//them user vao building--%>
    <%--function userAssignmentBuilding(userIds, idBuilding) {--%>
        <%--$.ajax({--%>
            <%--url: '${APIurl}/' + idBuilding,--%>
            <%--type: 'POST',--%>
            <%--data: JSON.stringify(userIds),--%>
            <%--contentType: 'application/json',--%>
            <%--dataType: 'json',--%>
            <%--success: function (result) {--%>
                <%--window.location.href = "<c:url value='/admin/building/list?message=delete_success'/>";--%>
            <%--},--%>
            <%--error: function (result) {--%>
                <%--window.location.href = "<c:url value='/admin/building/list?message=error_system'/>";--%>
            <%--},--%>
        <%--});--%>
    <%--}--%>
</script>
</body>
</html>
