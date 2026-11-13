/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.wiki.web.internal.util;

import com.liferay.portal.kernel.util.PortalUtil;

/**
 * @author Debora Buriti
 */
public class WikiDisplayTemplateHelper {

	public String getUserName(String defaultUserName, long userId) {
		return PortalUtil.getUserName(userId, defaultUserName);
	}

}