<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<html>
    <head></head>
    <body>
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Giao tòa nhà cho nhân viên</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="table-responsive">
                            <table class="table" id="userAssignTable">
                                <thead>
                                <tr>
                                    <th>Chọn nhân viên</th>
                                    <th>Tên nhân viên</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${model.listResult}">
                                    <tr>
                                        <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}" ${item.checked}/></td>
                                        <td>${item.fullName}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <ul id="pagination-demo" class="pagination-sm">
                            </ul>
                        </div>
                        <<input type="hidden" name="buildingId" value="${buildingId}" id="buildingId">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-default" value="Lưu thay đổi" id="save"/>
            </div>
        </div>
    </div>
    </body>
</html>

