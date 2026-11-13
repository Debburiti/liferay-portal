/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.site.navigation.site.map.web.internal.portlet.display.template;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * @author Debora Buriti
 */
public class SiteMapDisplayTemplateHelper {

	public String getLayoutURL(Layout layout, ThemeDisplay themeDisplay)
		throws PortalException {

		return PortalUtil.getLayoutURL(layout, themeDisplay);
	}

}