package com.silenteight.rctask.pj.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.silenteight.rctask.pj.app.NameReader;
import com.silenteight.rctask.pj.utils.StringUtils;

public class GenderVerifier {

	public static String[] tokenizeCapitalizeName(String name) {
		if (name == null)
			return null;

		String[] t = StringUtils.trim(name).split("\\s+");
		for (int i = 0; i < t.length; i++) {
			t[i] = StringUtils.capitalize(t[i]);
		}
		return t;
	}

	public static String getGender(String names, boolean all) {
		String[] t = tokenizeCapitalizeName(names);
		if (!all && t.length > 0) {
			t = new String[] { t[0] };
		}

		return guessGenderFromTokens(t);
	}

	private static String guessGenderFromTokens(String[] tokens) {

		// adding the same token only once
		List<String> t = new ArrayList<String>(tokens.length);
		for (String n : tokens) {
			if (!t.contains(n)) {
				t.add(n);
			}
		}

		// opening name files
		NameReader mnr = new NameReader(true);
		NameReader fnr = new NameReader(false);

		// result score
		int male = getSingleFileScore(t, mnr);
		int female = getSingleFileScore(t, fnr);

		mnr.closeReader();
		fnr.closeReader();

		if (male > female) {
			return "MALE";
		} else if (male < female) {
			return "FEMALE";
		}
		return "INCONCLUSIVE";
	}

	private static int getSingleFileScore(List<String> t, NameReader nr) {
		int score = 0;

		while (t.size() > 0) {
			String name = nr.readName();
			if (name == null) {
				break;
			}
			if (t.contains(name)) {
				score++;
				t.remove(name);
			}
		}

		return score;
	}

}
