package com.silenteight.rctask.pj;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.silenteight.rctask.pj.app.GenderVerificationApplication;

@SpringBootTest(classes = GenderVerificationApplication.class)
@AutoConfigureMockMvc
class GenderVerificationEndpointTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void requests() throws Exception {
		mockMvc.perform(get("/gender?name=Jan Maria Rokita")).andExpect(status().isOk())// .andDo(print())
				.andExpect(content().string(equalTo("INCONCLUSIVE")));

		mockMvc.perform(get("/gender?name=Jan Maria Rokita&ver=single")).andExpect(status().isOk())// .andDo(print())
				.andExpect(content().string(equalTo("MALE")));

		mockMvc.perform(get("/gender?name=Anna Zbigniew Gertruda")).andExpect(status().isOk())// .andDo(print())
				.andExpect(content().string(equalTo("FEMALE")));

		mockMvc.perform(get("/gender?name=Anna Zbigniew Gertruda&ver=single")).andExpect(status().isOk())// .andDo(print())
				.andExpect(content().string(equalTo("FEMALE")));
	}

}
