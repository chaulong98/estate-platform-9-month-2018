<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/building"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
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
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <%--<c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>--%>
                    <form:form id="formSubmit"  modelAttribute="model" method="post">
                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Tên sản phẩm</label>
                            <div class="col-sm-9">
                                <form:input path="buildingName" cssClass="form-control" id="buildingName"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-12 control-label no-padding-right">Người quản lý sản phẩm</label>
                        </div>


                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Quận</label>
                            <div class="col-sm-9">
                                <form:select path="district">
                                    <form:option value="0" label="--Chọn quận--"/>
                                    <form:options items="${mapDistrict}"/>
                                </form:select>
                            </div>
                        </div>


                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Phường</label>
                            <div class="col-sm-9">
                                <form:input path="ward" cssClass="form-control" id="ward"></form:input>
                            </div>
                        </div>


                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Đường</label>
                            <div class="col-sm-9">
                                <form:input path="street" cssClass="form-control" id="street"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Số tầng hầm</label>
                            <div class="col-sm-9">
                                <form:input path="basementNumber" cssClass="form-control" id="basementNumber"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Hướng</label>
                            <div class="col-sm-9">
                                <form:input path="direction" cssClass="form-control" id="direction"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Hạng</label>
                            <div class="col-sm-9">
                                <form:input path="level" cssClass="form-control" id="level"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Diện tích thuê</label>
                            <div class="col-sm-9">
                                <form:input path="releasedArea" cssClass="form-control" id="releasedArea"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Diện tích sàn</label>
                            <div class="col-sm-9">
                                <form:input path="basementArea" cssClass="form-control" id="basementArea"></form:input>
                            </div>
                        </div>


                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Diện tích trống</label>
                            <div class="col-sm-9">
                                <form:input path="emptyArea" cssClass="form-control" id="emptyArea"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả diện tích</label>
                            <div class="col-sm-9">
                                <form:textarea path="descriptionArea" cssClass="form-control" id="descriptionArea"></form:textarea>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Giá thuê</label>
                            <div class="col-sm-9">
                                <form:input path="releasedCost" cssClass="form-control" id="releasedCost"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả giá</label>
                            <div class="col-sm-9">
                                <form:textarea path="descriptionCost" cssClass="form-control" id="descriptionCost"></form:textarea>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Phí dịch vụ</label>
                            <div class="col-sm-9">
                                <form:input path="feeService" cssClass="form-control" id="feeService"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Phí ô tô</label>
                            <div class="col-sm-9">
                                <form:input path="feeCar" cssClass="form-control" id="feeCar"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Phí xe máy</label>
                            <div class="col-sm-9">
                                <form:input path="feeMotor" cssClass="form-control" id="feeMotor"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Phí ngoài giờ</label>
                            <div class="col-sm-9">
                                <form:input path="feeOvertime" cssClass="form-control" id="feeOvertime"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Tiền điện</label>
                            <div class="col-sm-9">
                                <form:input path="feeElectric" cssClass="form-control" id="feeElectric"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Đặt cọc</label>
                            <div class="col-sm-9">
                                <form:input path="depositAmount" cssClass="form-control" id="depositAmount"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Thanh toán</label>
                            <div class="col-sm-9">
                                <form:input path="paymentAmount" cssClass="form-control" id="paymentAmount"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Thời hạn thuê</label>
                            <div class="col-sm-9">
                                <form:input path="releasedPeriod" cssClass="form-control" id="releasedPeriod"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Thời gian trang trí</label>
                            <div class="col-sm-9">
                                <form:input path="decoratedPeriod" cssClass="form-control" id="decoratedPeriod"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Tên quản lý</label>
                            <div class="col-sm-9">
                                <form:input path="managerName" cssClass="form-control" id="managerName"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">SĐT quản lý</label>
                            <div class="col-sm-9">
                                <form:input path="phoneNumber" cssClass="form-control" id="phoneNumber"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Phí môi giới</label>
                            <div class="col-sm-9">
                                <form:input path="feeBrokerRage" cssClass="form-control" id="feeBrokerRage"></form:input>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 control-label no-padding-right">Loại sản phẩm</label>
                            <div class="col-sm-9">
                                <table>
                                    <c:forEach items="${type}" var="item">
                                        <tr>
                                            <td><form:checkbox path="productType" value="${item.getKey()}"/></td>
                                            <td>${item.getValue()}</td>
                                        </tr>
                                    </c:forEach>
                                    <%--<tr>--%>
                                        <%--<form:checkboxes path="type" items="${type}" />--%>
                                    <%--</tr>--%>
                                </table>
                            </div>
                        </div>


                        <div class="form-group row">
                            <div class="col-sm-12">

                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật tòa nhà" id="btnAddOrUpdateNew"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm mới tòa nhà" id="btnAddOrUpdateNew"/>
                                </c:if>
                            </div>
                        </div>
                        <form:hidden path="id" id="buildingId"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
    <script>
        $(document).ready(function () {
            $('#btnAddOrUpdateNew').click(function (e) {
                e.preventDefault();
                var data = {};
                var productType = [];
                var formData = $('#formSubmit').serializeArray();
                $.each(formData, function (i, v) {
                    if(v.name == "productType"){
                        productType.push(v.value);
                    }else{
                        data[""+v.name+""] = v.value;
                    }
                })
                data["productType"] = productType;
                var buildingId = $('#buildingId').val();
                if(buildingId == ""){
                    addBuilding(data);
                }else{
                    updateBuilding(data);
                }
            });
        });

        function addBuilding(data){
            $.ajax({
                url: '${APIurl}',
                type: 'POST',
                data: JSON.stringify(data),
                contentType: 'application/json',
                dataType: 'json',
                success: function(result){
                    window.location.href = "<c:url value='/manager-building-list'/>";
                },
                error: function(result){
                    console.log("fail");

                }
            });
        }

        function updateBuilding(data){
            $.ajax({
                url: '${APIurl}',
                type: 'PUT',
                data: JSON.stringify(data),
                contentType: 'application/json',
                dataType: 'json',
                success: function(result){
                    window.location.href = "<c:url value='/manager-building-list'/>";
                },
                error: function(result){
                    console.log("fail");

                }
            });
        }
    </script>
</body>
</html>