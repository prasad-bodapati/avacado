package com.avacado.rest;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

public class DesignerServiceTest {
	private DesignerService designerService;

	@Before
	public void setUp() throws Exception {
		designerService = new DesignerService();
	}

	@Test
	public void canGetFieldsFromJsonFile() {
		Response response = designerService.getFields();
		assertTrue(response.hasEntity());
	}
}