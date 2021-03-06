package com.silenteight.rctask.pj.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.silenteight.rctask.pj.utils.StringUtils;

public class NameReader {

	private static final Logger logger = LoggerFactory.getLogger(NameReader.class);

	private boolean male = true;
	private BufferedReader reader;

	public NameReader(boolean male) {
		this.male = male;

		try {
			reader = new BufferedReader(new FileReader(getFileName()));
		} catch (FileNotFoundException e) {
			logger.error("File (" + getFileName() + ") not found", e);
		}
	}

	public boolean isMaleGender() {
		return male;
	}

	public String getFileName() {
		if (male) {
			return "male.txt";
		} else {
			return "female.txt";
		}
	}

	public String readName() {
		try {
			if (reader != null) {
				String line = reader.readLine();
				// reading next line if current line is blank and not the end of the file
				while (line != null && line.isBlank()) {
					line = reader.readLine();
				}

				if (line != null && !line.isBlank()) {
					return StringUtils.capitalize(StringUtils.trim(line));
				}
			}
		} catch (IOException e) {
			logger.warn("Error reading file (" + getFileName() + ")", e);
		}

		closeReader();

		return null;
	}

	public void closeReader() {
		try {
			if (reader != null) {
				reader.close();
			}
		} catch (IOException e) {
			logger.warn("Error closing file (" + getFileName() + ")", e);
		}
	}

}
