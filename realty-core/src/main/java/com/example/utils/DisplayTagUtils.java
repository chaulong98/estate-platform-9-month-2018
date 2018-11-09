package com.example.utils;

import com.example.model.AbstractModel;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import javax.servlet.http.HttpServletRequest;

public class DisplayTagUtils {

	private static final Logger log = Logger.getLogger(DisplayTagUtils.class);

	public static void initSearchBean(HttpServletRequest request, AbstractModel bean) {
		if (bean != null){
			String sortExpression = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_SORT));
			String sortDirection = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_ORDER));
			String sPage = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE));
			Integer page = 1;
			if (StringUtils.isNotBlank(sPage)) {
				try {
					page = Integer.valueOf(sPage);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
			bean.setPage(page);
			bean.setSortExpression(sortExpression);
			bean.setSortDirection(sortDirection);
		}
	}
	public static void initSearchBeanManual(AbstractModel commmand) {
		if (commmand != null) {
			Integer page = 1;
			if (commmand.getPage() != 0) {
				page = commmand.getPage();
			}
			commmand.setPage(page);
			commmand.setFirstItem((commmand.getPage() - 1) * commmand.getMaxPageItems());
		}
	}
}
