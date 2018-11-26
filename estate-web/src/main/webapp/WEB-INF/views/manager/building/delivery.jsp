<div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Danh sách nhân viên</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th><input type="checkbox" value="" id="checkAll"/></th>
                                <th>Tên tòa nhà</th>
                                <th>Địa chỉ</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${model.listResult}">
                                <tr>
                                    <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"/></td>
                                    <td>${item.buildingName}</td>
                                    <td>${item.district}</td>
                                    <td>${item.managerName}</td>
                                    <td>${item.phoneNumber}</td>
                                    <td>${item.basementArea}</td>
                                    <td>${item.emptyArea}</td>
                                    <td>${item.releasedCost}</td>
                                    <td>${item.feeService}</td>
                                    <td>${item.feeOvertime}</td>
                                    <td>
                                        <c:url var="editURL" value="/manager-building-edit">
                                            <c:param name="id" value="${item.id}"/>
                                        </c:url>
                                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                           title="Cập nhật tòa nhà" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                        </a>
                                        <c:url var="deliveryURL" value="/ajax-manager-building-delivery">
                                            <c:param name="id" value="${item.id}"/>
                                        </c:url>
                                        <a class="btn btn-sm btn-primary btn-add" data-toggle="tooltip"
                                           title="Giao tòa nhà" url="${deliveryURL}" onclick="loadModal(this)"><i class="fa fa-pencil-square" aria-hidden="true"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <ul id="pagination-demo" class="pagination-sm">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </div>

</div>