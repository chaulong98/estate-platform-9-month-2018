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
                    <a href="#">Trang chủ</a>
                </li>
                <li>Sản phẩm</li>
                <li>Chỉnh sửa thông tin Sản phẩm</li>
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
                    <form:form id="formEdit" class="form-horizontal" commandName="model">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.name"/></label>
                            <div class="col-sm-9">
                                <form:input path="name" id="name" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.district"/></label>
                            <div class="col-sm-9">
                                <form:input path="district" id="district" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.province"/></label>
                            <div class="col-sm-9">
                                <form:input path="province" id="province" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.street"/></label>
                            <div class="col-sm-9">
                                <form:input path="street" id="street" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.structure"/></label>
                            <div class="col-sm-9">
                                <form:input path="structure" id="structure" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.numberofbasement"/></label>
                            <div class="col-sm-9">
                                <input type="number" name="numberOfBasement" class="form-control"
                                       value="${model.numberOfBasement}" id="numberOfBasement"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.buildingarea"/></label>
                            <div class="col-sm-9">
                                <input type="number" name="buildingArea" class="form-control" id="buildingArea"
                                       value="${model.buildingArea}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.direction"/></label>
                            <div class="col-sm-9">
                                <form:input path="direction" cssClass="form-control" id="direction"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.level"/></label>
                            <div class="col-sm-9">
                                <form:input path="level" cssClass="form-control" id="level"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.rentarea"/></label>
                            <div class="col-sm-9">
                                <input type="text" name="rentArea" class="form-control" id="rentArea"
                                       value="${model.rentArea}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.areadescription"/></label>
                            <div class="col-sm-9">
                                <form:textarea path="areaDescription" rows="5" cssClass="form-control"
                                               id="areaDescription"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.costrent"/></label>
                            <div class="col-sm-9">
                                <input type="number" name="costRent" class="form-control" id="costRent"
                                       value="${model.costRent}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.feeMG"/></label>
                            <div class="col-sm-9">
                                <form:input path="feesBrokerage" cssClass="form-control" id="feesBrokerage"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.costdescription"/></label>
                            <div class="col-sm-9">
                                <form:input path="costDescription" cssClass="form-control" id="costDescription"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.servicecost"/></label>
                            <div class="col-sm-9">
                                <form:input path="serviceCost" cssClass="form-control" id="serviceCost"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.carcost"/></label>
                            <div class="col-sm-9">
                                <form:input path="carCost" cssClass="form-control" id="carCost"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.motorbikecost"/></label>
                            <div class="col-sm-9">
                                <form:input path="motorbikeCost" cssClass="form-control" id="motorbikeCost"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.overtimecost"/></label>
                            <div class="col-sm-9">
                                <form:input path="overtimeCost" cssClass="form-control" id="overtimeCost"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.electricitycost"/></label>
                            <div class="col-sm-9">
                                <form:input path="electricityCost" cssClass="form-control" id="electricityCost"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.deposit"/></label>
                            <div class="col-sm-9">
                                <form:input path="deposit" cssClass="form-control" id="deposit"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.payment"/></label>
                            <div class="col-sm-9">
                                <form:input path="payment" cssClass="form-control" id="payment"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.timecontract"/></label>
                            <div class="col-sm-9">
                                <form:input path="timeContract" cssClass="form-control" id="timeContract"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.timedecorator"/></label>
                            <div class="col-sm-9">
                                <form:input path="timeDecorator" cssClass="form-control" id="timeDecorator"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.managername"/></label>
                            <div class="col-sm-9">
                                <form:input path="managerName" cssClass="form-control" id="managerName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.managerphone"/></label>
                            <div class="col-sm-9">
                                <form:input path="managerPhone" cssClass="form-control" id="managerPhone"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.commission"/></label>
                            <div class="col-sm-9">
                                <form:input path="commission" cssClass="form-control" id="commission"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.type"/></label>
                            <div class="col-sm-9">
                                <table>
                                    <td><form:checkboxes path="typeArrays" items="${mapTypes}" element="li"/></td>
                                </table>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.note"/></label>
                            <div class="col-sm-9">
                                <form:textarea path="note" cssClass="form-control" rows="5" id="commission"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.link"/></label>
                            <div class="col-sm-9">
                                <form:input path="link" cssClass="form-control" id="link"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.location"/></label>
                            <div class="col-sm-9">
                                <form:input path="location" cssClass="form-control" id="location"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><spring:message
                                    code="label.building.image"/></label>
                            <div class="col-sm-3">
                                <input type="file" name="file" id="uploadImage"/>
                            </div>
                            <div class="col-sm-6">
                                <c:if test="${not empty model.image}">
                                    <c:set var="image" value="/repository/${model.image}"/>
                                    <img src="${image}" id="viewImage" width="200px" height="300px">
                                </c:if>
                                <c:if test="${empty model.image}">
                                    <img src="<c:url value='/image/no-image.png'/>" id="viewImage" width="200px"
                                         height="300px">
                                </c:if>
                            </div>
                        </div>
                        <div class="space-4"></div>
                        </hr>
                        <div class="form-group pull-right">
                            <div class="col-sm-12">
                                <label class="col-sm-3 control-label no-padding-right message-info"></label>
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="<spring:message code='label.building.edit'/>"
                                           id="btnAddOrUpdateBuilding"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="<spring:message code='label.building.create'/>"
                                           id="btnAddOrUpdateBuilding"/>
                                </c:if>
                            </div>
                        </div>
                        <!--Btn-->
                        <form:hidden path="id" id="buildingId"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%--https://kamranahmed.info/toast--%>
<script>
    $(document).ready(function () {
        loadDistrictByName();
        $('#uploadImage').change(function () {
            openImage(this, "viewImage");
        });
    });

    function openImage(input, imageView) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' + imageView).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

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

    $("#btnAddOrUpdateBuilding").click(function (event) {
        event.preventDefault();
        addOrUpdate();
    });

    function addOrUpdate() {
        var formData = $("#formEdit").serializeArray();
        var files = $('#uploadImage')[0].files[0];
        var dataArray = {};
        var typeArray = [];
        $.each(formData, function (i, v) {
            if (v.name == 'typeArrays') {
                typeArray.push(v.value);
            } else {
                dataArray["" + v.name + ""] = v.value;
            }
        });
        dataArray["typeArrays"] = typeArray;
        if (files != undefined) {
            dataArray["imageName"] = files.name;
            var reader = new FileReader();
            reader.onload = function (e) {
                dataArray["thumbnailBase64"] = e.target.result;
                if ($('#buildingId').val() != "") {
                    editBuilding(dataArray, $('#buildingId').val());
                }
                else {
                    addBuilding(dataArray);
                }
            };
            reader.readAsDataURL(files);
        } else {
            if ($('#buildingId').val() != "") {
                editBuilding(dataArray, $('#buildingId').val());
            }
            else {
                addBuilding(dataArray);
            }
        }
    }

    $(document).keypress(function (e) {
        if (e.which == 13) {
            addOrUpdate();
            return false;
        }
    });

    function addBuilding(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                window.location.href = "<c:url value='/admin/building/list'/>";
            },
            error: function (res) {
                console.log(res);
            }
        });
    }

    function editBuilding(data, id) {
        $.ajax({
            url: '${formUrl}/' + id,
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                $.toast({
                    heading: 'Success',
                    text: 'Cập nhật thành công.',
                    showHideTransition: 'slide',
                    icon: 'success'
                })
                window.location.href = "<c:url value='/admin/building/list'/>";
            },
            error: function (res) {
                console.log(res);
                $.toast({
                    heading: 'Error',
                    text: 'Cập nhật thất bại.',
                    showHideTransition: 'slide',
                    icon: 'error'
                })
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

    $("#rentArea").keypress(function (e) {
        if ((e.keyCode < 48 || e.keyCode > 57)) {
            if (e.keyCode !== 44)
                e.preventDefault();
        }
    });
</script>
</body>
</html>