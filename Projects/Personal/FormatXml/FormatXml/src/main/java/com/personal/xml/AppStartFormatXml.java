package com.personal.xml;

import org.w3c.dom.Document;

import com.utils.io.PathUtils;
import com.utils.log.Logger;
import com.utils.xml.dom.XmlDomUtils;

final class AppStartFormatXml {

	private AppStartFormatXml() {
	}

	public static void main(
			final String[] args) {

		Logger.setDebugMode(true);
		try {
			if (args.length == 0) {

				final String helpMessage = createHelpMessage();
				Logger.printError("insufficient arguments" + System.lineSeparator() + helpMessage);
				System.exit(-1);
			}

			if ("--help".equals(args[0])) {

				final String helpMessage = createHelpMessage();
				Logger.printLine(helpMessage);
				System.exit(0);
			}

			String inputFilePathString = args[0];
			String outputFilePathString = computeOutputFilePathString(inputFilePathString);

			inputFilePathString = PathUtils.computePath(inputFilePathString);
			if (inputFilePathString != null) {

				outputFilePathString = PathUtils.computePath(outputFilePathString);
				if (outputFilePathString != null) {

					final Document document = XmlDomUtils.openDocument(inputFilePathString);
					XmlDomUtils.saveXmlFile(document, false, 4, outputFilePathString);
				}
			}

		} catch (final Exception exc) {
			Logger.printError("failed to format XML file");
			Logger.printException(exc);
		}
	}

	private static String createHelpMessage() {
		return "usage: format_xml XML_FILE_PATH";
	}

	private static String computeOutputFilePathString(
			final String inputFilePathString) {

		final String inputFilePathStringWoExt = PathUtils.computePathWoExt(inputFilePathString);
		final String extension = PathUtils.computeExtension(inputFilePathString);
		return inputFilePathStringWoExt + "_FORMATTED." + extension;
	}
}
