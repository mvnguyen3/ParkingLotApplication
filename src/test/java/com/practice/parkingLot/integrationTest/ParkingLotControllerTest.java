package com.practice.parkingLot.integrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.practice.parkingLot.service.ParkingServiceImpl;

@WebMvcTest
public class ParkingLotControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ParkingServiceImpl parkingService;

	private String filePath = "src/main/resources/command";

	@Test
	public void testProcessCommand() throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/api/v1/process-command?filePath=" + this.filePath)).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

}
