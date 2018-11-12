package com.estate.utils;

import com.estate.dto.AbtractDTO;
import com.estate.dto.BuildingDTO;
import org.apache.commons.lang.StringUtils;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import javax.servlet.http.HttpServletRequest;

public class DisplayTagUtils {
	public static void of(HttpServletRequest request, AbtractDTO dto) {
		if (dto != null) {
			String sPage = request.getParameter(new ParamEncoder(dto.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE));
			Integer page = 1;
			if (StringUtils.isNotBlank(sPage)) {
				page = Integer.valueOf(sPage);
			}
			dto.setPage(page);
		}
	}

	public static void initSearchBean(HttpServletRequest request, BuildingDTO model) {
	}
}
