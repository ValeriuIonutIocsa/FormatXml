package com.personal.xml;

import org.junit.jupiter.api.Test;

import com.utils.io.PathUtils;

class AppStartFormatXmlTest {

	@Test
	void testMain() {

		final String inputFilePathString = PathUtils.computePath("test", "test.xml");
		AppStartFormatXml.main(new String[] { inputFilePathString });
	}
}
