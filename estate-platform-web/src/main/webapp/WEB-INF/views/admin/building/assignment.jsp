<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api/admin/building"/>
<html>
<head>
    <title>Giao phó tòa nhà</title>
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
                <li class="active">Giao phó tòa nhà</li>
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
                    <form:form id="formSubmit" modelAttribute="model">
                        <table class="table">
                            <tr>
                                <td>Chọn</td>
                                <td>Danh sách nhân viên</td>
                            </tr>
                            <c:forEach var="list" items="${listUser}">
                                <tr>
                                        <%--<td><form:checkbox path="users" value="${list.id}"></form:checkbox></td>--%>
                                    <th><input type="checkbox" value="${list.id}"  ${list.check}/></th>
                                    <th>${list.fullName}</th>
                                </tr>
                            </c:forEach>
                        </table>

                        <input type="button" class="btn btn-white btn-warning btn-bold"
                               value="Giao phó tòa nhà" id="btnAssignmentBuilding"/>
                        <%--hien id cua toa nha--%>
                        <form:hidden path="id" id="idBuilding"></form:hidden>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#btnAssignmentBuilding').click(function (e) {
                e.preventDefault();
                var userIds = {};
                var idBuilding = $('#idBuilding').val();

                var userIds = $('body input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                userAssignmentBuilding(userIds, idBuilding);
            }
        );
    });

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
</script>
</body>
</html>