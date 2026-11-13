/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.blogs.web.internal.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

import jakarta.portlet.PortletRequest;

/**
 * @author Debora Buriti
 */
public class BlogsDisplayTemplateHelper {

	public String getCanonicalURL(
			String completeURL, Layout layout, ThemeDisplay themeDisplay)
		throws PortalException {

		return PortalUtil.getCanonicalURL(completeURL, themeDisplay, layout);
	}

	public String getPathContext(PortletRequest portletRequest) {
		return PortalUtil.getPathContext(portletRequest);
	}

}