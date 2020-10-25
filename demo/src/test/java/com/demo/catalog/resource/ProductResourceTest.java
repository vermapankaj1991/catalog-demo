package com.demo.catalog.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ProductResourceTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void init(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testGetAllProducts() throws Exception{
		ResultActions action = mockMvc.perform(get("/product/v1/products"));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		
		Assert.assertNotNull(result.getResponse());
		Assert.assertEquals(result.getResponse().getContentType(), "application/json");

	}
	
	@Test
	public void testGetAllFinanceProducts() throws Exception{
		ResultActions action = mockMvc.perform(get("/product/v1/products?productType=finance"));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(result.getResponse());
		Assert.assertEquals(result.getResponse().getContentType(), "application/json");
		System.out.println(response);
		JSONArray json =  new JSONArray(response);
		Assert.assertEquals(3, json.length());
	}
	
	@Test
	public void testGetAllCapitalProducts() throws Exception{
		ResultActions action = mockMvc.perform(get("/product/v1/products?productType=capital market"));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(result.getResponse());
		Assert.assertEquals(result.getResponse().getContentType(), "application/json");
		System.out.println(response);
		JSONArray json =  new JSONArray(response);
		Assert.assertEquals(2, json.length());
	}
	
	@Test
	public void testGetPromoApplicableProducts() throws Exception{
		ResultActions action = mockMvc.perform(get("/product/v1/products?isPromoApplicable=true"));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(result.getResponse());
		Assert.assertEquals(result.getResponse().getContentType(), "application/json");
		System.out.println(response);
		JSONArray json =  new JSONArray(response);
		Assert.assertEquals(2, json.length());
	}
	
	@Test
	public void testGetPromoNotApplicableProducts() throws Exception{
		ResultActions action = mockMvc.perform(get("/product/v1/products?isPromoApplicable=false"));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(result.getResponse());
		Assert.assertEquals(result.getResponse().getContentType(), "application/json");
		System.out.println(response);
		JSONArray json =  new JSONArray(response);
		Assert.assertEquals(3, json.length());
	}
	
	@Test
	public void testGetPromoApplicableAndFinanceProducts() throws Exception{
		ResultActions action = mockMvc.perform(get("/product/v1/products?productType=finance&isPromoApplicable=true"));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(result.getResponse());
		Assert.assertEquals(result.getResponse().getContentType(), "application/json");
		System.out.println(response);
		JSONArray json =  new JSONArray(response);
		Assert.assertEquals(2, json.length());
	}
	
	@Test
	public void testInvalidProductType() throws Exception{
		ResultActions action = mockMvc.perform(get("/product/v1/products?productType=finanssssce&isPromoApplicable=true"));
		action.andExpect(status().isBadRequest()).andReturn();
	}
	

	
	
	
}
