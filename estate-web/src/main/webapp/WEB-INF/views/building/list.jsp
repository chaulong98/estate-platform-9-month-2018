<%@ page import="com.estate.security.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/admin/building/list"/>
<c:url var="buildingUrl" value="/api/building"/>
<c:url var="searchURL" value="${urlMapping}"/>
<c:set var="username" value="<%=SecurityUtils.getPrincipal().getUsername()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        <spring:message code="label.user.list"/>
    </title>

</head>

<body>
<style type="text/css">
    tr > td {
        word-wrap: break-word;
    }
    label {
        font-weight: bold;
    }
    .fg-line span {
        padding: 18px;
    }
</style>
<div class="main-content">
    <form:form commandName="model" action="" id="listForm" method="GET">
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
                    <a href="<c:url value="/admin/home"/>">
                        <spring:message code="label.home"/>
                    </a>
                </li>
                <li>
                    <spring:message code="label.building.manage"/>
                </li>
                <li>
                    <spring:message code="label.building.list"/>
                </li>
            </ul>
            <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${messageResponse!=null}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="row">
                        <div class="col-xs-12">
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
                                                                <form:input path="name"
                                                                            cssClass="form-control input-sm"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Diện tích sàn</label>
                                                            <div class="fg-line">
                                                                <input type="number" name="buildingArea"
                                                                       class="form-control input-sm"
                                                                       value="${model.buildingArea}"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                            <div class="fg-line">
                                                                <label>Quận hiện có</label>
                                                                <form:input path="district" id="district"
                                                                            cssClass="form-control input-sm"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label>Phường</label>
                                                            <div class="fg-line">
                                                                <form:input path="province" id="province"
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
                                                                <input type="number" name="numberOfBasement"
                                                                       class="form-control input-sm"
                                                                       value="${model.numberOfBasement}"
                                                                       id="numberOfBasement"/>
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
                                                                <form:input path="managerPhone" id="managerPhone"
                                                                            cssClass="form-control input-sm"/>
                                                            </div>
                                                        </div>
                                                        <c:if test="${urlMapping != '/admin/building/assignment'}">
                                                            <div class="col-sm-4">
                                                                <label>Chọn nhân viên phụ trách</label>
                                                                <div class="fg-line">
                                                                    <form:select path="staffName" id="staffName">
                                                                        <form:option value=""
                                                                                     label="--- Chọn nhân viên phụ trách ---"/>
                                                                        <form:options items="${staffMaps}"/>
                                                                    </form:select>
                                                                </div>
                                                            </div>
                                                        </c:if>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <div class="fg-line">
                                                                <form:checkboxes path="typeArrays" items="${mapTypes}"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <button id="btnSearch" type="button"
                                                                    class="btn btn-sm btn-success">
                                                                <spring:message code="label.search"/>
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
                                                <a flag="info"
                                                   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                                   data-toggle="tooltip"
                                                   title='<spring:message code="label.building.add"/>'
                                                   href='<c:url value="/admin/building/edit"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
                                                </a>
                                                <security:authorize ifAnyGranted="MANAGER">
                                                    <button id="btnDelete" type="button" disabled
                                                            class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                            data-toggle="tooltip"
                                                            title='<spring:message code="label.building.delete"/>'>
															<span>
																<i class="fa fa-trash-o bigger-110 pink"></i>
															</span>
                                                    </button>
                                                </security:authorize>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-responsive">
                                        <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                                                       requestURI="${searchURL}" partialList="true"
                                                       size="${model.totalItems}" defaultorder="ascending"
                                                       id="tableList" pagesize="${model.maxPageItems}"
                                                       export="false"
                                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                                       style="margin: 3em 0 1.5em;">
                                            <display:column style="width:2%" title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                                            headerClass="center select-cell">
                                                <fieldset>
                                                    <input type="checkbox" name="checkList" value="${tableList.id}"
                                                           id="checkbox_${tableList.id}" class="check-box-element"/>
                                                </fieldset>
                                            </display:column>
                                            <display:column headerClass="text-left" style="width:6%"
                                                            title="Ngày">
                                                <fieldset>
                                                    <c:set var="date" value="${fn:split(tableList.createdDate, ' ')}"/>
                                                    <span>${date[0]}</span>
                                                </fieldset>
                                            </display:column>

                                            <display:column headerClass="text-left" style="width:12%" property="name"
                                                            title="Tên Sản phẩm"/>
                                            <display:column headerClass="text-left" style="width:12%" property="address"
                                                            title="Địa chỉ"/>
                                            <display:column headerClass="text-left" style="width:11%"
                                                            property="managerName"
                                                            title="Tên quản lý"/>
                                            <display:column headerClass="text-left" style="width:6%"
                                                            property="managerPhone"
                                                            title="Số điện thoại"/>
                                            <display:column headerClass="text-left" style="width:5%"
                                                            property="buildingArea"
                                                            title="D.T sàn"/>
                                            <display:column headerClass="text-left" style="width:15%"
                                                            property="areaDescription"
                                                            title="D.T trống"/>
                                            <display:column headerClass="text-left" style="width:6%" property="costDescription"
                                                            title="Gía thuê"/>
                                            <display:column headerClass="text-left" style="width:6%"
                                                            property="serviceCost"
                                                            title="Phí dịch vụ"/>
                                            <display:column headerClass="text-left" style="width:6%"
                                                            property="feesBrokerage"
                                                            title="Phí MG"/>
                                            <display:column headerClass="col-actions" style="width:11%"
                                                            title="Thao tác">
                                                <div class="float-right">
                                                    <a class="btn btn-xs btn-primary btn-edit" data-toggle="tooltip"
                                                       title='<spring:message code="label.building.detail.view"/>'
                                                       href='<c:url value="/admin/building/${tableList.id}/view"/>'>
                                                        <i class="fa fa-eye" aria-hidden="true"></i>
                                                    </a>
                                                    <security:authorize ifAnyGranted="USER">
                                                        <c:if test="${tableList.editBuilding eq true}">
                                                            <a class="btn btn-xs btn-primary btn-edit"
                                                               data-toggle="tooltip"
                                                               title='<spring:message code="label.building.edit"/>'
                                                               href='<c:url value="/admin/building/edit?id=${tableList.id}"/>'>
                                                                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                            </a>
                                                        </c:if>
                                                    </security:authorize>
                                                    <security:authorize ifAnyGranted="MANAGER">
                                                        <a class="btn btn-xs btn-primary btn-edit" data-toggle="tooltip"
                                                           title='<spring:message code="label.building.edit"/>'
                                                           href='<c:url value="/admin/building/edit?id=${tableList.id}"/>'>
                                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                        </a>
                                                        <button class="btn btn-xs btn-primary btn-edit"
                                                                data-toggle="tooltip" type="button"
                                                                title='<spring:message code="label.building.assign.user"/>'
                                                                id="btnAssignBuilding" buildingId="${tableList.id}">
                                                            <i class="fa fa-tasks"></i>
                                                        </button>
                                                    </security:authorize>
                                                    <c:if test="${tableList.priority == false}">
                                                        <button class="btn btn-xs btn-primary btn-edit"
                                                                data-toggle="tooltip" type="button"
                                                                title='<spring:message code="label.building.priority.add"/>'
                                                                id="updatePriority" action="insert"
                                                                buildingId="${tableList.id}">
                                                            <i class="fa fa-plus" aria-hidden="true"></i>
                                                        </button>
                                                    </c:if>
                                                    <c:if test="${tableList.priority == true}">
                                                        <button class="btn btn-xs btn-primary btn-edit"
                                                                data-toggle="tooltip" type="button"
                                                                title='<spring:message code="label.building.priority.remove"/>'
                                                                id="updatePriority" action="remove"
                                                                buildingId="${tableList.id}">
                                                            <i class="fa fa-minus" aria-hidden="true"></i>
                                                        </button>
                                                    </c:if>
                                                </div>
                                            </display:column>
                                        </display:table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </form:form>
        </div>
    </div>

    <div class="modal fade" id="assignBuildingModal" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Danh sách nhân viên giao Sản phẩm</h4>
                </div>
                <div class="modal-body">
                    <table class="table" id="userAssignTable">
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
                        </tbody>
                    </table>
                    <div id="fieldHidden">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" id="btnAssignBuildingForUser"><spring:message
                            code="label.change"/></button>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            loadDistrictByName();
            $('#btnSearch').click(function (e) {
                e.preventDefault();
                $('#listForm').attr('action', '${searchURL}');
                $('#listForm').submit();
            });
            $('#btnAssignBuildingForUser').click(function (e) {
                e.preventDefault();
                var buildingId = $('#fieldHidden').find('#buildingId').val();
                var userArrays = $('#userAssignTable').find('tbody input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                assignUser(userArrays, buildingId);
            });
            $(document).keypress(function(e) {
                if (e.which == 13) {
                    $('#listForm').attr('action', '${searchURL}');
                    $('#listForm').submit();
                    return false;
                }
            });
        });
        function loadDistrictByName() {
            var availableWard = []
            var availableDistrict = [];
            $.ajax({
                url: '/api/district/dn/city/4/district',
                type: 'GET',
                dataType: 'json',
                contentType: 'application/json',
                success: function (res) {
                    availableDistrict = []
                    res.forEach(function (element) {
                        availableDistrict.push(element.Title);
                    });
                    $("#district").autocomplete({
                        source: availableDistrict,
                        select: function (event, ui) {
                            console.log('availableWard: ' + availableWard.length)
                            idDistrictSelected = 0;
                            for (var element of res) {
                                if (element.Title === ui.item.label) {
                                    idDistrictSelected = element.ID;
                                    break;
                                }
                            }
                            if (idDistrictSelected && idDistrictSelected !== 0)
                                loadWard(idDistrictSelected, function (ward) {
                                    availableWard = []
                                    ward.forEach(function (element) {
                                        availableWard.push(element.Title);
                                    });
                                    $("#province").autocomplete({
                                        source: availableWard
                                    })
                                })
                        }
                    });
                },
                error: function (res) {
                    console.log('ERR:' + res);
                }
            });
        }
        function loadWard(id, callback) {
            $.ajax({
                url: '/api/district/dn/district/' + id + '/ward',
                type: 'GET',
                dataType: 'json',
                contentType: 'application/json',
                success: function (res) {
                    callback(res)
                },
                error: function (res) {
                    console.log(res);
                }
            });
        }
        function openModalAssignBuilding() {
            $('#assignBuildingModal').modal();
        }
        function loadUserAssignForBuilding(buildingId) {
            var buildingIdHidden = '<input type="hidden" name="buildingId" value=' + buildingId + ' id="buildingId"></input>';
            $('#fieldHidden').html(buildingIdHidden);
            $.ajax({
                url: '${loadUser}?role=USER&buildingId=' + buildingId,
                type: 'GET',
                dataType: 'json',
                success: function (result) {
                    var row = '';
                    $.each(result, function (index, user) {
                        row += '<tr>';
                        row += '<td class="text-center"><input type="checkbox" name="checkList" value=' + user.id + ' id="checkbox_' + user.id + '" class="check-box-element" ' + user.checked + '/></td>';
                        row += '<td class="text-center">' + user.fullName + '</td>';
                        row += '</tr>';
                    });
                    $('#userAssignTable tbody').html(row);
                },
                error: function (res) {
                    console.log(res);
                }
            });
        }
        function assignUser(users, buildingId) {
            $.ajax({
                url: '${buildingUrl}/' + buildingId + '/users',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(users),
                success: function (res) {
                    window.location.href = "${formUrl}";
                },
                error: function (res) {
                    console.log(res);
                }
            });
        }
        function updatePriority(buildingId, action) {
            $.ajax({
                url: '${buildingUrl}/' + buildingId + '/priority?action=' + action,
                type: 'POST',
                success: function (res) {
                    window.location.href = "${formUrl}";
                },
                error: function (res) {
                    console.log(res);
                }
            });
        }
        $(function () {
            $(document).on("click", "#tableList button#btnAssignBuilding", function (e) {
                e.preventDefault();
                openModalAssignBuilding();
                loadUserAssignForBuilding($(this).attr('buildingId'));
            });
        });
        $(function () {
            $(document).on("click", "#tableList button#updatePriority", function (e) {
                e.preventDefault();
                var buildingId = $(this).attr('buildingId');
                var action = $(this).attr('action');
                updatePriority(buildingId, action);
            });
        });
    </script>
</body>

</html>