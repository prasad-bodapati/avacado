package com.avacado.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.avacado.model.DesignField;
import com.avacado.model.Garment;
import org.junit.Assert;
import org.junit.Test;

public class RepositoryImplTest {

	@Test
	public void can_perform_create_get_and_delete_on_a_simple_object() throws Exception {
		Repository<DesignField> repository = repository = new JCRRepositoryImpl<DesignField>("designFields");
		DesignField designField = new DesignField();
		designField.setName("example");
		designField.setType("notes");
		designField.setValue("value1");
		repository.create(designField);
		DesignField fromServer = repository.get(designField.getClass(), "example");
		Assert.assertEquals(designField.getTitle(), fromServer.getTitle());
		repository.delete("example");
	}

	@Test
	public void can_perform_create_get_and_delete_on_a_objects_with_inheritance_object() throws Exception {
		Repository<Garment> repository = new JCRRepositoryImpl<Garment>("garments");
		Garment garment = new Garment();
		List<DesignField> designFieldList = new ArrayList<DesignField>();

		DesignField designField = new DesignField();
		designField.setName("example");
		designField.setType("notes");
		designField.setValue("value1");
		designFieldList.add(designField);
		garment.setDesignFields(designFieldList);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		calendar.set(Calendar.YEAR, 2016);
		garment.setSeason(calendar);
		repository.create(garment);
		Garment fromServer = repository.get(garment.getClass(), "4-2016");
		Assert.assertEquals(designField.getTitle(), fromServer.getDesignFields().get(0).getName());
		repository.delete("4-2016");
	}
}
