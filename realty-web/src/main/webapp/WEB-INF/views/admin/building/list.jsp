<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/manager/building/list" />
<c:url var="formEdit" value=""/>
<c:url var="manager" value="/ajax/manager/building">
<%--     <c:param name="urlType" value="manager" /> --%>
</c:url>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="main-content">
    <form:form>
   
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
                        <c:if test="${messageResponse!=null}">
                            <div class="alert alert-block alert-success">
                                <button type="button" class="close" data-dismiss="alert">
                                    <i class="ace-icon fa fa-times"></i>
                                </button>
                                    ${messageResponse}
                            </div>
                        </c:if>
                        <!-- PAGE CONTENT BEGINS -->
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
                                                        <label class="col-sm-2 control-label">Tên tòa nhà :</label>
                                                        <div class="col-sm-8">
                                                            <div class="fg-line">
<%--                                                                 <form:input path="userName" cssClass="form-control input-sm"/> --%>
                                                            </div>
                                                        </div>
                                                    </div>                                                   
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label"></label>
                                                        <div class="col-sm-8">
                                                            <button id="btnSearch" class="btn btn-sm btn-success">
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
                                                    data-toggle="tooltip" title="Thêm bài viết mới" href='<c:url value="/manager/building/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                                </a>
                                                <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" id="btnDelete" disabled
                                                        data-toggle="tooltip" title="Xóa bài viết" onclick="warningBeforeDelete()">
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
                                        <display:table name="model.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                                       partialList="true" sort="external" size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                                                       id="tableList" pagesize="${model.maxPageItems}" export="false"
                                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                                       style="margin: 3em 0 1.5em;">
                                            <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell" headerClass="center select-cell">
                                                <fieldset>
                                                    <input type="checkbox" name="checkList" value="${tableList.id}" id="checkbox_${tableList.id}" class="check-box-element"/>
                                                </fieldset>                                              
                                            </display:column>
                                            <display:column headerClass="text-left" property="nameBuilding" title="Tên Tòa Nhà"/>
                                            <display:column headerClass="text-left" property="district" title="Quận"/>     
                                            <display:column headerClass="text-left" property="guild" title="Phường"/>   
                                            <display:column headerClass="text-left" property="numberBasement" title="Số Tầng"/> 
                                            <display:column headerClass="col-actions" title="Thao tác">                                               
                                                <a class="btn btn-sm btn-primary btn-edit" data-toggle= "tooltip" 
                                                	title="Cập nhật tòa nhà" href='<c:url value="/manager/building/${tableList.id}"/>'><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                                	<c:url var="editManager" value="/ajax/manager/building" >	
                                                	    <c:param name="idBuilding" value="${tableList.id}"></c:param>
                                                	</c:url>
                                                	<a id="btnBuilding" class="btn btn-sm btn-primary btn-edit" sc-url = "${editManager}" onclick="entrustBuilding(this)"><i class="fa fa-pencil-square-o"></i></a>
                                                	
                                                	
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

<!-- modal -->

  <div class="modal fade" id="myModal" role="dialog">
    
  </div>

<script type="text/javascript">	
  
   function entrustBuilding(btn) {
	
	   var url =  $(btn).attr('sc-url') ;
	   $('#myModal').load(url,'',function(){
		   $('#myModal').modal('toggle');
		   
	       });
}
	
</script>
</body>
</html>