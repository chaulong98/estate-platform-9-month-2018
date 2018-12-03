<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formURL" value="/admin/building/list"/>
<c:url var="deleteUrl" value="/api/admin/building"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
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
                    <form:form action="${formURL}" modelAttribute="model" id="formSubmit" method="get">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="widget-box table-filter">
                                    <div class="widget-header">
                                        <h4 class="widget-title">Tìm kiếm</h4>
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
                                                    <label class="col-sm-2 control-label">Tên tòa nhà:</label>
                                                    <div class="col-sm-6">
                                                        <div class="fg-line">
                                                            <form:input path="buildingName" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>


                                                    <label class="col-sm-2 control-label">Diện tích sàn:</label>
                                                    <div class="col-sm-6">
                                                        <div class="fg-line">
                                                            <input type="number" name="buildingArea" class="form-control input-sm"
                                                                   value="${model.buildingArea}"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">Quận hiện có:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <form:select path="district" id="district">
                                                                <form:option value="" label="--- Chọn quận ---"/>
                                                                <form:options items="${districts}"/>
                                                            </form:select>
                                                        </div>
                                                    </div>



                                                    <label class="col-sm-2 control-label">Phường:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <form:input path="ward" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>



                                                    <label class="col-sm-2 control-label">Đường:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <form:input path="street" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">Số tầng hầm:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <div class="fg-line">
                                                                <input type="number" name="basementNumber" class="form-control input-sm"
                                                                       value="${model.basementNumber}"
                                                                       id="basementNumber"/>
                                                            </div>
                                                        </div>
                                                    </div>



                                                    <label class="col-sm-2 control-label">Hướng:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <form:input path="direction" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>



                                                    <label class="col-sm-2 control-label">Hạng:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <form:input path="level" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">Diện tích từ:</label>
                                                    <div class="col-sm-3">
                                                        <div class="fg-line">
                                                            <input type="number" name="areaFrom" class="form-control input-sm"
                                                                   value="${model.areaFrom}" id="areaFrom"/>
                                                        </div>
                                                    </div>



                                                    <label class="col-sm-2 control-label">Diện tích đến:</label>
                                                    <div class="col-sm-3">
                                                        <div class="fg-line">
                                                            <input type="number" name="areaTo" class="form-control input-sm"
                                                                   value="${model.areaTo}" id="areaTo"/>
                                                        </div>
                                                    </div>



                                                    <label class="col-sm-2 control-label">Giá thuê từ:</label>
                                                    <div class="col-sm-3">
                                                        <div class="fg-line">
                                                            <input type="number" name="costFrom" class="form-control input-sm"
                                                                   value="${model.costFrom}" id="costFrom"/>
                                                        </div>
                                                    </div>



                                                    <label class="col-sm-2 control-label">Giá thuê đến:</label>
                                                    <div class="col-sm-3">
                                                        <div class="fg-line">
                                                            <input type="number" name="costTo" class="form-control input-sm"
                                                                   value="${model.costTo}" id="costTo"/>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">Tên quản lý:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <form:input path="managerName" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>



                                                    <label class="col-sm-2 control-label">Điện thoại quản lý:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <form:input path="managerPhoneNumber" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>



                                                    <label class="col-sm-2 control-label">Chọn nhân viên phụ trách:</label>
                                                    <div class="col-sm-4">
                                                        <div class="fg-line">
                                                            <form:select path="staffs" id="staffName">
                                                                <form:option value="" label="--- Chọn nhân viên phụ trách ---"/>
                                                                <form:options items="${users}"/>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"></label>
                                                    <div class="col-sm-6">
                                                        <button type="button" class="btn btn-sm btn-success" id="btnSearch">
                                                            Tìm kiếm
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
                                            <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                               data-toggle="tooltip" title="Thêm tòa nhà mới" href='<c:url value="/admin/building/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                            </a>
                                            <button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" disabled
                                                    data-toggle="tooltip" title="Xóa tòa nhà">
                                                    <span>
                                                        <i class="fa fa-trash-o bigger-110 pink"></i>
                                                	</span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" value="" id="checkAll"/></th>
                                            <th>Ngày</th>
                                            <th>Tên tòa nhà</th>
                                            <th>Địa chỉ</th>
                                            <th>Tên quản lý</th>
                                            <th>Số điện thoại</th>
                                            <th>D.T Sàn</th>
                                            <th>D.T Trống</th>
                                            <th>Giá thuê</th>
                                            <th>Phí dịch vụ</th>
                                            <th>Phí MG</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"/></td>
                                                <td>${item.createdDate}</td>
                                                <td>${item.buildingName}</td>
                                                <td>${item.street},${item.ward},${item.district}</td>
                                                <td>${item.managerName}</td>
                                                <td>${item.managerPhoneNumber}</td>
                                                <td>${item.buildingArea}</td>
                                                <td>${item.descriptionArea}</td>
                                                <td>${item.rentCost}</td>
                                                <td>${item.serviceCost}</td>
                                                <td>${item.brokerageFees}</td>
                                                <td>
                                                    <c:url var="editURL" value="/admin/building/edit">
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật tòa nhà" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>




                                                </td>


                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                    <ul id="pagination-demo" class="pagination">
                                    </ul>
                                    <input type="hidden" name="page" id="page" value="${model.page}"/>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>



<script type="text/javascript">
    var totalPages = ${model.totalPages};
    var visiblePages = ${model.maxPageItems};
    var startPage = ${model.page};
    $(document).ready(function () {
        $('#btnSearch').click(function () {
            $('#formSubmit').submit();
        });


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
    });

    $(function () {
        var obj = $('#pagination-demo').twbsPagination({
            totalPages: totalPages,
            visiblePages: visiblePages,
            startPage: startPage,
            onPageClick: function (event, page) {
                if (page != startPage) {
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
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


</script>
</body>
</html>
