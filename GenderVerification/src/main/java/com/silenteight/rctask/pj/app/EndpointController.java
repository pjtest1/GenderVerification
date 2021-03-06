package com.silenteight.rctask.pj.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.silenteight.rctask.pj.algorithms.GenderVerifier;

@Controller
public class EndpointController {

	private static final Logger logger = LoggerFactory.getLogger(EndpointController.class);

	@RequestMapping("/gender")
	public void gender(final HttpServletResponse response,
			@RequestParam(name = "name", required = false, defaultValue = "") String name,
			@RequestParam(name = "ver", required = false, defaultValue = "all") String ver) {
		try {
			PrintWriter printWriter = response.getWriter();

			boolean all = true;
			if (ver.trim().toLowerCase().equals("single")) {
				all = false;
			}
			printWriter.write(GenderVerifier.getGender(name, all));

		} catch (IOException e) {
			logger.warn("Error in response", e);
		}
	}

	@RequestMapping("/names")
	public void names(final HttpServletResponse response,
			@RequestParam(name = "gender", required = false, defaultValue = "male") String gender) {

		try {
			PrintWriter printWriter = response.getWriter();

			boolean male = true;
			if (gender.trim().toLowerCase().equals("female")) {
				male = false;
			}
			NameReader nr = new NameReader(male);

			String n;
			while (true) {
				n = nr.readName();
				if (n == null) {
					break;
				} else {
					printWriter.write(n);
					printWriter.write("\n");
				}
			}
		} catch (IOException e) {
			logger.warn("Error in response", e);
		}
	}

}
