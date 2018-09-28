package com.axatrikx.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.axatrikx.controller.RestExecutor;

public class TestScript {

	private static final String URL = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";

	private static RestExecutor executor;

	@BeforeClass
	public static void setUp() {
		/*
		 * Initialize RestExecutor object using the end point URL
		 */
		executor = new RestExecutor(URL);
	}

	@Test
	public void testGETMethod() {
		/*
		 * Performs GET operation on https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false/posts.
		 * Note that we give only the path in the get method as we use 
		 * the domain part while initializing the RestExecutor object
		 */
		
		/*
		 * GET for a specific item
		 */
		executor.get("/posts")
			.expectCode(200)
			.expectMessage("OK")
			.expectInBody("Name\":\"Carbon credits\"")			
			.expectInBody("CanRelist\":true");
	
		
		executor.get("/posts")
			.expectCode(200)
			.expectMessage("OK")
			.expectInBody("Name\":\"Gallery\"")			
			.expectInBody("2x larger image");	
	}
}
