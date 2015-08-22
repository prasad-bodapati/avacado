package com.avacado.rest;

import static org.junit.Assert.*;

import java.util.List;

import com.avacado.rest.model.DesignFields;
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
		/*List<DesignFields> fields = designerService.getFields();
		assertNotNull(fields);
		assertFalse(fields.isEmpty());*/
	}
}