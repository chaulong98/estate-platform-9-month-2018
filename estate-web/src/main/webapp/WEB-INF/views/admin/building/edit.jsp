<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/admin/building"/>
<html>
<head>
    <title>Chỉnh sửa căn hộ</title>
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
                    <a href="/admin/home">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
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
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Chọn quận:</label>
                            <div class="col-sm-9">
                                <form:select path="district" cssClass="form-control" cssStyle="width: auto">
                                    <form:option value="" label="-- Chọn quận --"/>
                                    <form:options items="${district}" />
                                </form:select>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Loại</label>
                            <div class="col-sm-9">
                               <form:checkboxes path="type" items="${type}" id="checkType" ></form:checkboxes>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Tên</label>
                            <div class="col-sm-9">
                                    <form:input path="name" cssClass="form-control" id="name"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Phường</label>
                            <div class="col-sm-9">
                                <form:input path="ward" cssClass="form-control" id="ward"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Đường</label>
                            <div class="col-sm-9">
                                <form:input path="street" cssClass="form-control" id="street"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Kết cấu</label>
                            <div class="col-sm-9">
                                <form:input path="structure" cssClass="form-control" id="structure"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Số tầng hầm</label>
                            <div class="col-sm-9">
                                <form:input path="basement" cssClass="form-control" id="basement"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Diện tích sàn</label>
                            <div class="col-sm-9">
                                <form:input path="floorArea" cssClass="form-control" id="floorArea"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Hướng</label>
                            <div class="col-sm-9">
                                <form:input path="direction" cssClass="form-control" id="direction"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Hạng</label>
                            <div class="col-sm-9">
                                <form:input path="grade" cssClass="form-control" id="grade"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Diện tích thuê</label>
                            <div class="col-sm-9">
                                <form:input path="rentArea" cssClass="form-control" id="rentArea"/>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Mô tả diện tích</label>
                                <div class="col-sm-9">
                                    <form:textarea path="description" id="description" cssStyle="width: 821px;height: 197px"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Giá thuê</label>
                            <div class="col-sm-9">
                                <form:input path="rentFee" cssClass="form-control" id="rentFee"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Mô tả giá</label>
                            <div class="col-sm-9">
                                <form:input path="feeDescription" cssClass="form-control" id="feeDescription"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Phí dịch vụ</label>
                            <div class="col-sm-9">
                                <form:input path="serviceFee" cssClass="form-control" id="serviceFee"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Phí ô tô</label>
                            <div class="col-sm-9">
                                <form:input path="carFee" cssClass="form-control" id="carFee"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Phí xe máy</label>
                            <div class="col-sm-9">
                                <form:input path="motorbikeFee" cssClass="form-control" id="motorbikeFee"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Phí quá giờ</label>
                            <div class="col-sm-9">
                                <form:input path="outTimeFee" cssClass="form-control" id="outTimeFee"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Tiền điện</label>
                            <div class="col-sm-9">
                                <form:input path="electricBill" cssClass="form-control" id="electricBill"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Đặt cọc</label>
                            <div class="col-sm-9">
                                <form:input path="deposit" cssClass="form-control" id="deposit"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Thanh toán</label>
                            <div class="col-sm-9">
                                <form:input path="paymentMethod" cssClass="form-control" id="paymentMethod"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Thời hạn thuê</label>
                            <div class="col-sm-9">
                                <form:input path="rentDuration" cssClass="form-control" id="rentDuration"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Thời gian trang trí</label>
                            <div class="col-sm-9">
                                <form:input path="decorateTime" cssClass="form-control" id="decorateTime"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Tên quản lý</label>
                            <div class="col-sm-9">
                                <form:input path="managerName" cssClass="form-control" id="managerName"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">SĐT quản lý</label>
                            <div class="col-sm-9">
                                <form:input path="managerPhone" cssClass="form-control" id="managerPhone"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Phí môi giới</label>
                            <div class="col-sm-9">
                                <form:input path="agencyFee" cssClass="form-control" id="agencyFee"/>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Ghi chú</label>
                                <div class="col-sm-9">
                                    <form:textarea path="note" id="note" cssStyle="width: 821px;height: 197px"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Link sản phẩm</label>
                            <div class="col-sm-9">
                                <form:input path="link" cssClass="form-control" id="link"/>
                            </div>
                            <br/>
                            <br/>
                            <label class="col-sm-3 control-label no-padding-right">Bản đồ</label>
                            <div class="col-sm-9">
                                <form:input path="map" cssClass="form-control" id="map"/>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Chọn hình đại diện</label>
                                <div class="col-sm-9">
                                        <input type="file" name="file" id="uploadImg"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật toà nhà" id="btnAddOrUpdateBuilding"/>
                                    </c:if>
                                    <c:if test="${empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm mới toà nhà" id="btnAddOrUpdateBuilding"/>
                                    </c:if>
                                </div>
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
    var base64 = '';
    var imgName='';
    $(document).ready(function () {
        $('#uploadImg').change(function (event) {
            var reader = new FileReader();
            var file = $(this)[0].files[0];
            reader.onload = function(e){
                base64 = e.target.result;
                imgName = file.name;
            };
            reader.readAsDataURL(file);
        });
        var checkedTypes = '${model.type}'.split(',');
        $("input[type='checkbox']").each(function (){
            var e = $(this);
            checkedTypes.forEach(function (value) {
                if(e.val() == value){
                    e.prop("checked",true);
                }
            })
        });
        $('#btnAddOrUpdateBuilding').click(function (e) {
            e.preventDefault();
            var data = {};
            var formData = $('#formSubmit').serializeArray();
            var type = [];
            $.each(formData, function (i,v) {
                data[""+v.name+""] = v.value;
                if(v.name == "type"){
                    type.push(v.value);
                }
            });
            data["type"] = type.join(",");
            if( base64 != ''){
                data['base64'] = base64;
                data['imgName'] = imgName;
            }
            var buildingId = $('#buildingId').val();
            if(buildingId == ""){
                addBuilding(data);
            }
            else {
                updateBuilding(data);
            }
        });

    });
    function addBuilding(data) {
            $.ajax({
                url: '${APIurl}',
                type: 'POST',
                data: JSON.stringify(data),
                contentType:'application/json',
                dataType:'json',
                success: function(result){
                    window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=insert_success'/> ";
                },
                error: function(result){
                    window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=error_system'/> ";
                }
            });
    }
    function updateBuilding(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            data: JSON.stringify(data),
            contentType:'application/json',
            dataType:'json',
            success: function(result){
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=update_success'/> ";
            },
            error: function(result){
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=error_system'/> ";
            }
        });
    }
</script>
</body>
</html>
