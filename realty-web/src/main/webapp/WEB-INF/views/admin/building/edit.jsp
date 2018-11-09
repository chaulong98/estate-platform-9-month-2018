<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<c:url var="insertForm" value="/ajax/building"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa bài viết</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<h3 id="message" style="color: red;"></h3>
						<form:form id="formEdit" modelAttribute="model">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Quận
								</label>
								<div class="col-sm-9">
									<form:select path="district" id="district">
										<form:option value="NONE" label="--- Chọn Quận ---" />
										<form:options items="${model.mapDistrict}"/>
									</form:select>
								</div>
							</div>
							<br>
							<br>
							<div class="check_manager">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Người Quản Lý
								</label>
								<div class="col-sm-9">
								
									<c:forEach var="item" items="${model.listuser}" >
										<form:checkbox path="dependencies"  value="${item.id}" label="${item.fullName}"  />
									
<%-- 									  <label><input id="check_admin" type="checkbox" value="${item.id}">${item.fullName}</label> --%>
									</c:forEach>
								</div>
							</div>
							</div>
							
							<br/>
							<br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tên Sản Phẩm
									</label>
								<div class="col-sm-9">
									<form:input path="nameBuilding" id="nameBuilding" cssStyle="width:100% " />
								</div>
							</div>
							<br/>
							<br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Phường
									</label>
								<div class="col-sm-9">
									<form:input path="guild" id="guild"  cssStyle="width:100% " />
								</div>
							</div>
							<br />
							<br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Đường
									</label>
								<div class="col-sm-9">
									<form:input path="street" id="street" cssStyle="width:100% " />
								</div>
							</div>
							
							<br>
							<br>
							
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Số tầng
									</label>
								<div class="col-sm-9">
									<form:input path="numberBasement" id="numberBasement" cssStyle="width:100% "  />
								</div>
							</div>
							
							
							
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Diện tích sàn
									</label>
								<div class="col-sm-9">
									<form:input path="floorArea" id="floorArea"  cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Hướng
									</label>
								<div class="col-sm-9">
									<form:input path="direction" id="direction" cssStyle="width:100% "  />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Hạng
									</label>
								<div class="col-sm-9">
									<form:input path="rate" id="rate"  cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Diện tích Thuê
									</label>
								<div class="col-sm-9">
									<form:input path="rentArea" id="rentArea" cssStyle="width:100% "  />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô Tả Diện Tích
									</label>
								<div class="col-sm-9">
									<form:textarea path="descriptionArea" id="descriptionArea" cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Giá Thuê
									</label>
								<div class="col-sm-9">
									<form:input path="costRent" id="costRent" cssStyle="width:100% " />
								</div>
							</div>
							
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô tả giá
									</label>
								<div class="col-sm-9">
									<form:input path="priceDescription" id="priceDescription" cssStyle="width:100% " />
								</div>
							</div>
							
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Phí dịch vụ
									</label>
								<div class="col-sm-9">
									<form:input path="serviceCharge" id="serviceCharge" cssStyle="width:100% " />
								</div>
							</div>
							
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Phí oto
									</label>
								<div class="col-sm-9">
									<form:input path="chargeCar" id="chargeCar" cssStyle="width:100% " />
								</div>
							</div>
							
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Phí moto
									</label>
								<div class="col-sm-9">
									<form:input path="chargeMoto" id="chargeMoto" cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Phí Ngoài Giờ
									</label>
								<div class="col-sm-9">
									<form:input path="ChangeOutTime" id="ChangeOutTime" cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiền điện
									</label>
								<div class="col-sm-9">
									<form:input path="electricBill" id="electricBill" cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Đặt Cọc
									</label>
								<div class="col-sm-9">
									<form:input path="deposit" id="deposit" cssStyle="width:100% " />
								</div>
							</div>
							
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thanh Toán
									</label>
								<div class="col-sm-9">
									<form:input path="pay" id="pay" cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thời Hạn Thuê
									</label>
								<div class="col-sm-9">
									<form:input path="timeout" id="timeout" cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thời Gian Trang Trí
									</label>
								<div class="col-sm-9">
									<form:input path="decorateTime" id="decorateTime" cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tên Quản Lý
									</label>
								<div class="col-sm-9">
									<form:input path="managementName" id="managementName" cssStyle="width:100% " />
								</div>
							</div>
							<br>
							<br>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Số Điện thoại 
									</label>
								<div class="col-sm-9">
									<form:input path="managementPhone" id="managementPhone" cssStyle="width:100% " />
								</div>
							</div>
							
							<br>
							<br>
							<div class="checkcategory">
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Loại Sản Phẩm
									</label>
								<div class="col-sm-9">
								<form:checkbox path="productTypeModel"  value="Tang_Tret" label="Tầng Trệt" id="check_category" />
								<br>
									<form:checkbox path="productTypeModel"  value="Nguyen_Can" label="Nguyên Căn" id="check_category" />
										<br>
										<form:checkbox path="productTypeModel"  value="Noi_that" label="Nội Thất" id="check_category" />
									
								</div>
							</div>
							</div>
							  		
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id}">
										<input type="submit"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật sản phẩm" id="btnAddOrUpdateNews" />
									</c:if>
									<c:if test="${empty model.id}">
										<input type="submit"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm mới sản phẩm" id="btnAddOrUpdateNews" />
									</c:if>
								</div>
							</div>
						
							<form:hidden path="id" id="id" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
	$(document).ready(function () {
		$("input[name=rentArea]").keypress(function (e) {

			  if (/\d+|,+|[/b]+|-+/i.test(e.key) ){

			      console.log("character accepted: " + e.key)
			    } else {
			      console.log("illegal character detected: "+ e.key)
			      return false;
			  }

			});
	});
    

    $('#btnAddOrUpdateNews').click(function (e) {	
        e.preventDefault();
        var dataArray = {};
        var dependencies = $('.check_manager input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        var checkcategory = $('.checkcategory input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        
        dataArray['district'] = $('#district').val();
        dataArray['dependencies'] = dependencies;
        dataArray['nameBuilding'] = $('#nameBuilding').val();
        dataArray['guild'] = $('#guild').val();
        dataArray['street'] = $('#street').val();
        dataArray['numberBasement'] = $('#numberBasement').val();
        dataArray['floorArea'] = $('#floorArea').val();
        dataArray['direction'] = $('#direction').val();     
        dataArray['rate'] = $('#rate').val();
        dataArray['rentArea'] = $('#rentArea').val();
        dataArray['descriptionArea'] = $('#descriptionArea').val();
        dataArray['costRent'] = $('#costRent').val();
        dataArray['priceDescription'] = $('#priceDescription').val();
        dataArray['serviceCharge'] = $('#serviceCharge').val();
        dataArray['chargeCar'] = $('#chargeCar').val();
        dataArray['pay'] = $('#pay').val();
        dataArray['chargeMoto'] = $('#chargeMoto').val();
        dataArray['ChangeOutTime'] = $('#ChangeOutTime').val();
        dataArray['electricBill'] = $('#electricBill').val();
        dataArray['deposit'] = $('#deposit').val();
        dataArray['timeout'] = $('#timeout').val();
        dataArray['decorateTime'] = $('#decorateTime').val();
        dataArray['managementName'] = $('#managementName').val();
        dataArray['managementPhone'] = $('#managementPhone').val();
        dataArray['productTypeModel'] = checkcategory;
   
           
            if ($('#id').val() != "") {
            	updateBuilding(dataArray, $('#id').val());
            }
         else {    
                 insertBuilding(dataArray);
            }
    });

    function updateBuilding(data, id) {
        $.ajax ({
            url: '${insertForm}/'+id,
            type: 'PUT',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
            	 window.location.href = "<c:url value='/manager/building/list'/>";
            	
            },
            error: function(res) {
                console.log(res);                	
            }
        });
    }

    function insertBuilding(data) {
        $.ajax ({
            url: '${insertForm}',
            type: 'POST',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {	
            		 window.location.href = "<c:url value='/manager/building/list'/>";
               
            },
            error: function(res) {
                console.log(res);
            }
        });
    }
</script>
	
</body>
</html>