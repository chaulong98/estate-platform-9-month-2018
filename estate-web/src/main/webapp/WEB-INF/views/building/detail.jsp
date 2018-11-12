<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="loadAllDistrict" value="/api/district"/>
<c:url var="formUrl" value="/api/building"/>
<html>
<head>
    <title>Chỉnh sửa thông tin Sản phẩm</title>
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
                    <a href="<c:url value="/admin/home"/>"><spring:message code="label.home"/></a>
                </li>
                <li><spring:message code="label.building.manage"/></li>
                <li><spring:message code="label.building.detail.view"/></li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-7">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form:form class="form-horizontal" commandName="model">
                        <table id="simple-table" class="table table-striped table-bordered table-hover">
                            <tbody>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.name"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.name}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.district"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.district}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.province"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.province}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.street"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.street}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.structure"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.structure}
                                </td>
                            </tr>
                            <td class="hidden-480">
                                <label class="control-label"><spring:message
                                        code="label.building.numberofbasement"/></label>
                            </td>

                            <td class="hidden-480">
                                    ${model.numberOfBasement}
                            </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.buildingarea"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.buildingArea}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.direction"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.direction}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.level"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.level}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.rentarea"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.rentArea}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.costdescription"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.costDescription}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.costrent"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.costRent}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.feeMG"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.feesBrokerage}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.servicecost"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.serviceCost}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.carcost"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.carCost}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.motorbikecost"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.motorbikeCost}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.overtimecost"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.overtimeCost}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.electricitycost"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.electricityCost}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.deposit"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.deposit}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.payment"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.payment}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.timecontract"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.timeContract}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.timedecorator"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.timeDecorator}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.managername"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.managerName}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.managerphone"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.managerPhone}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.commission"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.commission}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.commission"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.commission}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.type"/></label>
                                </td>

                                <td class="hidden-480">
                                    <table>
                                        <td><form:checkboxes path="typeArrays" items="${mapTypes}" element="li"
                                                             disabled="true"/></td>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.link"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.link}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.location"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.location}
                                </td>
                            </tr>
                            <tr>
                                <td class="hidden-480">
                                    <label class="control-label"><spring:message
                                            code="label.building.areafree"/></label>
                                </td>

                                <td class="hidden-480">
                                        ${model.areaFree}
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form:form>
                </div>
                <div class="col-xs-5">
                    <div class="row text-center">
                        <c:if test="${not empty model.image}">
                            <c:set var="image" value="/repository/${model.image}"/>
                            <img src="${image}" id="viewImage" width="400px" height="500px">
                        </c:if>
                        <c:if test="${empty model.image}">
                            <img src="<c:url value='/image/no-image.png'/>" id="viewImage" width="200px"
                                 height="300px">
                        </c:if>
                    </div>
                    <div class="hr hr-double hr-dotted hr18"></div>
                    <div class="row text-center padding-6">
                        <div class="form-group">
                            <label class="control-label pull-left"><spring:message
                                    code="label.note"/></label>
                            <div class="col-sm-9">
                                ${model.note}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="hr hr-double hr-dotted hr18"></div>
            <div class="row">
                <c:if test="${not empty model.location}">
                    <iframe width="100%" height="450" frameborder="0" style="border:0"
                            src="https://www.google.com/maps/embed/v1/place?q=${model.location}&amp;key=AIzaSyBOIBSBA3kGNZK6dHil5Kqh5j8puN9bScY"></iframe>
                </c:if>
            </div>
        </div>
    </div>
</div>
</div>


<!-- New York, NY, USA (40.7127837, -74.00594130000002) -->
<%--Find here: https://www.latlong.net/--%>

</body>
</html>
