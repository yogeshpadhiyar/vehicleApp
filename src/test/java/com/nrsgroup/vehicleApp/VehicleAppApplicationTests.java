package com.nrsgroup.vehicleApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrsgroup.vehicleApp.model.Vehicle;
import com.nrsgroup.vehicleApp.repository.VehicleRepository;
import com.nrsgroup.vehicleApp.service.VehicleService;
import com.nrsgroup.vehicleApp.service.VehicleServiceImpl;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleAppApplicationTests {

	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	MockMvc mockMvc;
	@MockBean
	VehicleServiceImpl vehicleServiceImpl;
	@InjectMocks
	VehicleServiceImpl vehicleServiceImplInject;
	@Mock
	VehicleRepository vehicleRepository;

	Vehicle vehicle;
	String vehicleStr;
	String url = "/nrs";
	@BeforeEach
	public void setup() throws JsonProcessingException {
		vehicle  = new Vehicle(1L,"splender","honda","Bike","petrol",50.00f,2009,"normal");
		vehicleStr = objectMapper.writeValueAsString(vehicle);
	}

	@Test
	public void addVehicleTest() throws Exception{
		Mockito.when(vehicleServiceImpl.insertVehicle(Mockito.any(Vehicle.class))).thenReturn(CompletableFuture.completedFuture(vehicle));
		mockMvc.perform(MockMvcRequestBuilders.post(url+"/addVehicle")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(vehicleStr).characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(vehicleServiceImpl).insertVehicle(Mockito.any());
	}

	@Test
	public void insertVehicleTest() throws Exception{
		Mockito.doReturn(vehicle).when(vehicleRepository).save(Mockito.any());
		Vehicle expected = vehicle;
		Vehicle actual =vehicleServiceImplInject.insertVehicle(vehicle).join();
		Assert.assertEquals(expected,actual);
		Mockito.verify(vehicleRepository).save(Mockito.any());
	}
}
