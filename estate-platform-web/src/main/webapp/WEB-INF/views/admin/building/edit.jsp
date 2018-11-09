<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api/admin/building"/>

<html>
<head>
    <title>Chỉnh sửa bài viết</title>
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
                            <label class="col-sm-3 control-label no-padding-right">Tên sản phẩm</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="productName" cssClass="form-control" id="productName"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Quận</label>
                            <div class="col-sm-9">
                                <form:select path="districCode">
                                    <form:option value="" label="-- Chọn quận --"/>
                                    <form:options items="${districs}"/>
                                </form:select>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phường</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="ward" cssClass="form-control" id="ward"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Đường</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="street" cssClass="form-control" id="street"/>
                            </div>
                        </div>
                        <br/>
                        <br/>



                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Cấu trúc</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="structure" cssClass="form-control" id="structure"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <%--djsfnd--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Số tầng hầm</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="basementNumber" cssClass="form-control" id="basementNumber"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Diện tích sàn</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="buildingArea" cssClass="form-control" id="buildingArea"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hướng</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="direction" cssClass="form-control" id="direction"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hạng</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="rank" cssClass="form-control" id="rank"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Diện tích thuê</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="leasedArea" cssClass="form-control" id="leasedArea"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả diện tích</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="deciptionArea" cssClass="form-control" id="deciptionArea"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Giá thuê</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="rentCost" cssClass="form-control" id="rentCost"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả giá</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="deciptionCost" cssClass="form-control" id="deciptionCost"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí dịch vụ</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="feesService" cssClass="form-control" id="feesService"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí ô tô</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="feesCar" cssClass="form-control" id="feesCar"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí xe máy</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="feesMotorcycle" cssClass="form-control" id="feesMotorcycle"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí ngoài giờ</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="feesOvertime" cssClass="form-control" id="feesOvertime"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tiền điện</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="electricBill" cssClass="form-control" id="electricBill"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tiền đặt cọc</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="deposits" cssClass="form-control" id="deposits"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">thanh toán</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="pay" cssClass="form-control" id="pay"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">thời hạn thuê</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="rentTime" cssClass="form-control" id="rentTime"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thời gian trang trí</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="decorateTime" cssClass="form-control" id="decorateTime"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên quản lí</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="managerName" cssClass="form-control" id="managerName"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">sdt</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="phoneNumber" cssClass="form-control" id="phoneNumber"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí môi giới</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="brokeragefees" cssClass="form-control" id="brokeragefees"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Loại sản phẩm</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="productType" cssClass="form-control" id="productType"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">chú ý</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="note" cssClass="form-control" id="note"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Link</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="link" cssClass="form-control" id="link"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Map</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="map" cssClass="form-control" id="map"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Ảnh mô tả</label>
                            <div class="col-sm-9">
                                    <%--<input type="text" class="form-control" name="title" id="title"/>--%>
                                <form:input path="image" cssClass="form-control" id="image"/>
                            </div>
                        </div>
                        <br/>
                        <br/>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Cập nhật tòa nhà" id="btnAddOrUpdateBuilding"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Thêm mới tòa nhà" id="btnAddOrUpdateBuilding"/>
                                </c:if>
                            </div>
                        </div>
                        <form:hidden path="id" id="idBuilding"></form:hidden>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#btnAddOrUpdateBuilding').click(function (e) {
            e.preventDefault();
            var data = {};
            //cach 1 chuyen du leiu json vao data
            // data['title'] = $('#title').val();
            // data['content'] = $('#content').val();

            //cach 2 chuyen du lieu vao data
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (i, v) {
                data["" + v.name + ""] = v.value;
            });

            var idBuilding = $('#idBuilding').val();
            if (idBuilding == ""){
                addBuilding(data);
            }else{
                updateBuilding(data);
            }
        });
    });

    function addBuilding(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=insert_success'/>";
            },
            error: function (result) {
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=error_system'/>";
            },
        });
    }

    function updateBuilding(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=update_success'/>";
            },
            error: function (result) {
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=error_system'/>";
            },
        });
    }
</script>
</body>
</html>