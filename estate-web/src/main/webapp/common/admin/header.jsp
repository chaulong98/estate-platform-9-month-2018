<%@ page import="com.estate.security.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="<c:url value='/admin/home'/>" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Quản lý Sản phẩm
                </small>
            </a>
        </div>

        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                    <a href="/admin/profile/<%=SecurityUtils.getPrincipal().getUsername()%>" class="dropdown-toggle">
                        Xin chào, <%=SecurityUtils.getPrincipal().getFullName()%>
                    </a>
                <li class="light-blue dropdown-modal">
                    <a href="<c:url value='/logout'/>">
                        <i class="ace-icon fa fa-power-off"></i>
                        Thoát
                    </a>
                </li>
                </li>
            </ul>
        </div>
        <!-- navigation menu top -->
        <nav role="navigation" class="navbar-menu pull-left collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="menu-icon fa fa-building"></i>
                        <span class="menu-text"><spring:message code="label.building.manage"/></span>
                        <b class="arrow fa fa-angle-down"></b>
                    </a>
                    <ul class="dropdown-menu dropdown-light-blue dropdown-caret">
                        <security:authorize ifAnyGranted="MANAGER,USER">
                            <li>
                                <a href='<c:url value='/admin/building/list'/>'>
                                    <spring:message code="label.building.list"/>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize ifAnyGranted="USER">
                            <li>
                                <a href='<c:url value="/admin/building/assignment"/>'>
                                    <spring:message code="label.building.assignment.list"/>
                                </a>
                            </li>
                        </security:authorize>
                    </ul>
                </li>
                <li class="">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="menu-icon fa fa-user"></i>
                        <span class="menu-text"><spring:message code="label.user.manageCustomer"/></span>
                        <b class="arrow fa fa-angle-down"></b>
                    </a>
                    <ul class="dropdown-menu dropdown-light-blue dropdown-caret">
                        <li>
                            <a href='<c:url value='/admin/customer/list'/>'>
                                <spring:message code="label.customer.list"/>
                            </a>
                        </li>
                    </ul>
                </li>
                <security:authorize ifAnyGranted="MANAGER,USER">
                    <li class="">
                        <a href='<c:url value='/admin/building/priority/list'/>'>
                            <i class="menu-icon fa fa-building-o"></i>
                            <span class="menu-text"> <spring:message code="label.building.priority.list"/></span>
                        </a>
                    </li>
                </security:authorize>
                <security:authorize ifAnyGranted="MANAGER">
                    <li class="">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="menu-icon fa fa-wrench"></i>
                            <span class="menu-text"><spring:message code="label.configuration.manage"/></span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-light-blue dropdown-caret">
                            <li class="">
                                <a href='<c:url value='/admin/configuration/list'/>'>
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    <spring:message code="label.configuration.list"/>
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>
                    <li class="">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="menu-icon fa fas fa-users"></i>
                            <span class="menu-text"><spring:message code="label.user.manage"/></span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="dropdown-menu dropdown-light-blue dropdown-caret">
                            <li class="">
                                <a href='<c:url value='/admin/user/list'/>'>
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    <spring:message code="label.user.list"/>
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>
                </security:authorize>
            </ul>
        </nav>
        <!-- /navigation menu top -->
    </div>
    <!-- /.navbar-container -->
</div>
