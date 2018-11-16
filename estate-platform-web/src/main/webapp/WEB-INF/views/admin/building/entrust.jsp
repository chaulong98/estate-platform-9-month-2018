<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

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

                        <table>
                            <tr>
                                <td></td>
                                <td>Danh sách nhân viên</td>
                            </tr>
                            <c:forEach var="list" items="${listUser}">
                                <tr>
                                    <%--<input type="checkbox" value="${list.id}" id="checkbox_${list.id}"/>--%>
                                    <td><form:checkbox path="users" value="${list.id}"></form:checkbox> </td>
                                    <td>${list.fullName}</td>
                                </tr>
                            </c:forEach>
                        </table>

                        <input type="button" class="btn btn-white btn-warning btn-bold"
                               value="Giao phó tòa nhà" id="btnEntrustBuilding"/>
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
        $('#btnEntrustBuilding').click(function (e) {
            e.preventDefault();
            var data = {};
            var idUsers = [];
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (i, v) {
                idUsers.push(v.value);
            });
            data["users"] = idUsers;
        });
    });
</script>
</body>
</html>