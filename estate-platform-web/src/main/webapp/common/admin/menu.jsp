<%@ page import="com.estate.constant.SystemConstant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar responsive ace-save-state">
    <script type="text/javascript">
        try {
            ace.settings.loadState('sidebar')
        } catch (e) {
        }
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text">Quản lý tòa nhà</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <security:authorize ifAnyGranted="MANAGER">
                    <li class="">
                        <a href='<c:url value="/admin/building/list"/>'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            Danh sách tòa nhà
                        </a>
                        <b class="arrow"></b>
                    </li>
                </security:authorize>
                <security:authorize ifAnyGranted="USER">
                    <%--neu la user thi mo cai nay--%>
                    <li class="">
                        <a href='<c:url value="/admin/building/assignment"/>'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            Danh sách tòa nhà phụ trách
                        </a>
                        <b class="arrow"></b>
                    </li>
                </security:authorize>

            </ul>
        </li>

        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text">Quản lý khách hàng</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">

                <security:authorize ifAnyGranted="MANAGER">
                    <li class="">
                        <a href='<c:url value="/admin/building/list"/>'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            Danh sách tòa nhà
                        </a>
                        <b class="arrow"></b>
                    </li>
                </security:authorize>
                <security:authorize ifAnyGranted="USER">
                    <%--neu la user thi mo cai nay--%>
                    <li class="">
                        <a href='<c:url value="/admin/building/assignment/list"/>'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            Danh sách tòa nhà phụ trách
                        </a>
                        <b class="arrow"></b>
                    </li>
                </security:authorize>

            </ul>
        </li>

        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text">My list</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <a href='<c:url value="/admin/building/priority"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách tòa nhà ưu tiên
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left"
           data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>