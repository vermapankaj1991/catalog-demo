package com.demo.catalog.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.catalog.domain.Product;
import com.demo.catalog.domain.PurchaseRequest;
import com.demo.catalog.domain.User;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PurchaseResourceTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void init(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void purchaseWithNewUser() throws Exception{
		
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(1,"ABC Mutual Funds", "Finance", 1000.0, true));
		products.add(new Product(2,"XYZ Co Shares", "Finance", 200.0, false));
		products.add(new Product(3,"PQR Shares", "Finance", 3000.0, true));
		products.add(new Product(4,"123 Mutual Funds", "Capital Market", 100.0, false));
		products.add(new Product(5,"345 Mutual Funds", "Capital Market", 200.0, false));
		
		User user = new User(3, "Demo user 3");
		
		PurchaseRequest request = new PurchaseRequest();
		request.setProducts(products);
		request.setUser(user);
		
		Gson gsn = new Gson();
		String requestBody= gsn.toJson(request);
		
		ResultActions action = mockMvc.perform(post("/product/v1/purchase").contentType(MediaType.APPLICATION_JSON).content(requestBody));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(response);
		System.out.println(response);
		
		JSONObject jsonResponse = new JSONObject(response);		
		JSONObject totalJson = jsonResponse.optJSONObject("total");
		Assert.assertNotNull(totalJson);
		
		Double discountRate = totalJson.optDouble("discountRate");
		Assert.assertEquals(10.0, discountRate, 0.0);
		
	}
	
	@Test
	public void purchaseWithExistingUserAnd2PromoProducts() throws Exception{
		
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(1,"ABC Mutual Funds", "Finance", 1000.0, true));
		products.add(new Product(3,"PQR Shares", "Finance", 3000.0, true));
		
		User user = new User(1, "Demo user 1");
		
		PurchaseRequest request = new PurchaseRequest();
		request.setProducts(products);
		request.setUser(user);
		
		Gson gsn = new Gson();
		String requestBody= gsn.toJson(request);
		
		ResultActions action = mockMvc.perform(post("/product/v1/purchase").contentType(MediaType.APPLICATION_JSON).content(requestBody));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(response);
		System.out.println(response);
		
		JSONObject jsonResponse = new JSONObject(response);		
		JSONObject totalJson = jsonResponse.optJSONObject("total");
		Assert.assertNotNull(totalJson);
		
		Double discountRate = totalJson.optDouble("discountRate");
		Assert.assertEquals(10.0, discountRate, 0.0);
	}
	
	@Test
	public void purchaseWithExistingUserAnd3PromoProducts() throws Exception{
		
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(1,"ABC Mutual Funds", "Finance", 1000.0, true));
		products.add(new Product(2,"PQR Shares", "Finance", 3000.0, true));
		products.add(new Product(3,"PQR Shares", "Finance", 3000.0, true));
		
		User user = new User(1, "Demo user 1");
		
		PurchaseRequest request = new PurchaseRequest();
		request.setProducts(products);
		request.setUser(user);
		
		Gson gsn = new Gson();
		String requestBody= gsn.toJson(request);
		
		ResultActions action = mockMvc.perform(post("/product/v1/purchase").contentType(MediaType.APPLICATION_JSON).content(requestBody));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(response);
		System.out.println(response);
		
		JSONObject jsonResponse = new JSONObject(response);		
		JSONObject totalJson = jsonResponse.optJSONObject("total");
		Assert.assertNotNull(totalJson);
		
		Double discountRate = totalJson.optDouble("discountRate");
		Assert.assertEquals(20.0, discountRate, 0.0);
	}
	
	@Test
	public void purchaseWithExistingUserAnd2NonPromoProducts() throws Exception{
		
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(1,"ABC Mutual Funds", "Finance", 1000.0, true));
		products.add(new Product(2,"PQR Shares", "Finance", 3000.0, false));
		
		User user = new User(1, "Demo user 1");
		
		PurchaseRequest request = new PurchaseRequest();
		request.setProducts(products);
		request.setUser(user);
		
		Gson gsn = new Gson();
		String requestBody= gsn.toJson(request);
		
		ResultActions action = mockMvc.perform(post("/product/v1/purchase").contentType(MediaType.APPLICATION_JSON).content(requestBody));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(response);
		System.out.println(response);
		
		JSONObject jsonResponse = new JSONObject(response);		
		JSONObject totalJson = jsonResponse.optJSONObject("total");
		Assert.assertNotNull(totalJson);
		
		Double discountRate = totalJson.optDouble("discountRate");
		Assert.assertEquals(0.0, discountRate, 0.0);
	}
	@Test
	public void purchaseWithExistingUserAnd2DifferentPromoProducts() throws Exception{
		
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(1,"ABC Mutual Funds", "Finance", 1000.0, true));
		products.add(new Product(2,"PQR Shares", "Capital Market", 3000.0, true));
		
		User user = new User(1, "Demo user 1");
		
		PurchaseRequest request = new PurchaseRequest();
		request.setProducts(products);
		request.setUser(user);
		
		Gson gsn = new Gson();
		String requestBody= gsn.toJson(request);
		
		ResultActions action = mockMvc.perform(post("/product/v1/purchase").contentType(MediaType.APPLICATION_JSON).content(requestBody));
		MvcResult result = action.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		Assert.assertNotNull(response);
		System.out.println(response);
		
		JSONObject jsonResponse = new JSONObject(response);		
		JSONObject totalJson = jsonResponse.optJSONObject("total");
		Assert.assertNotNull(totalJson);
		
		Double discountRate = totalJson.optDouble("discountRate");
		Assert.assertEquals(0.0, discountRate, 0.0);
	}
	
	@Test
	public void purchaseWithInvalidUser() throws Exception{
		
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(1,"ABC Mutual Funds", "Finance", 1000.0, true));
		products.add(new Product(2,"PQR Shares", "Capital Market", 3000.0, true));
		
		User user = new User(0, "Demo user 1");
		
		PurchaseRequest request = new PurchaseRequest();
		request.setProducts(products);
		request.setUser(user);
		
		Gson gsn = new Gson();
		String requestBody= gsn.toJson(request);
		
		ResultActions action = mockMvc.perform(post("/product/v1/purchase").contentType(MediaType.APPLICATION_JSON).content(requestBody));
		action.andExpect(status().isBadRequest()).andReturn();
	}
	
	@Test
	public void purchaseWithNoProduct() throws Exception{
		
		List<Product> products = new ArrayList<>();
		
		User user = new User(0, "Demo user 1");
		
		PurchaseRequest request = new PurchaseRequest();
		request.setProducts(products);
		request.setUser(user);
		
		Gson gsn = new Gson();
		String requestBody= gsn.toJson(request);
		
		ResultActions action = mockMvc.perform(post("/product/v1/purchase").contentType(MediaType.APPLICATION_JSON).content(requestBody));
		action.andExpect(status().isBadRequest()).andReturn();
	}
}
