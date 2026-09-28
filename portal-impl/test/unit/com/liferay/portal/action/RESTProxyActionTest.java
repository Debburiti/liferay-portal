/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.action;

import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.PropsValues;
import com.liferay.portal.test.rule.LiferayUnitTestRule;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author Debora Buriti
 */
public class RESTProxyActionTest {

	@ClassRule
	public static LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Test
	public void testValidate() {
		String[] restProxyURLPrefixesAllowed =
			PropsValues.REST_PROXY_URL_PREFIXES_ALLOWED;

		try {
			String urlPrefix = "http://" + RandomTestUtil.randomString();

			ReflectionTestUtil.setFieldValue(
				PropsValues.class, "REST_PROXY_URL_PREFIXES_ALLOWED",
				new String[] {urlPrefix});

			RESTProxyAction restProxyAction = new RESTProxyAction();

			Assert.assertTrue(
				restProxyAction.validate(
					urlPrefix + "/" + RandomTestUtil.randomString()));

			Assert.assertFalse(
				restProxyAction.validate(
					urlPrefix + "@" + RandomTestUtil.randomString()));
			Assert.assertFalse(
				restProxyAction.validate(
					urlPrefix + "." + RandomTestUtil.randomString()));
		}
		finally {
			ReflectionTestUtil.setFieldValue(
				PropsValues.class, "REST_PROXY_URL_PREFIXES_ALLOWED",
				restProxyURLPrefixesAllowed);
		}
	}

	@Test
	public void testValidateWithSchemeOnlyURLPrefix() {
		String[] restProxyURLPrefixesAllowed =
			PropsValues.REST_PROXY_URL_PREFIXES_ALLOWED;

		try {
			ReflectionTestUtil.setFieldValue(
				PropsValues.class, "REST_PROXY_URL_PREFIXES_ALLOWED",
				new String[] {"https://"});

			RESTProxyAction restProxyAction = new RESTProxyAction();

			Assert.assertTrue(
				restProxyAction.validate(
					"https://" + RandomTestUtil.randomString()));
			Assert.assertTrue(
				restProxyAction.validate(
					"HTTPS://" + RandomTestUtil.randomString()));

			Assert.assertFalse(
				restProxyAction.validate(
					"http://" + RandomTestUtil.randomString()));

			ReflectionTestUtil.setFieldValue(
				PropsValues.class, "REST_PROXY_URL_PREFIXES_ALLOWED",
				new String[] {"https:///"});

			Assert.assertFalse(
				restProxyAction.validate(
					"https:///@" + RandomTestUtil.randomString()));

			ReflectionTestUtil.setFieldValue(
				PropsValues.class, "REST_PROXY_URL_PREFIXES_ALLOWED",
				new String[] {"https://:443"});

			Assert.assertFalse(
				restProxyAction.validate(
					"https://:443@" + RandomTestUtil.randomString()));
		}
		finally {
			ReflectionTestUtil.setFieldValue(
				PropsValues.class, "REST_PROXY_URL_PREFIXES_ALLOWED",
				restProxyURLPrefixesAllowed);
		}
	}

}