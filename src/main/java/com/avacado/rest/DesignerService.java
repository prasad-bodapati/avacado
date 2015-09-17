package com.avacado.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.avacado.model.Garment;
import com.avacado.repository.Repository;
import com.avacado.model.DesignField;
import org.codehaus.jackson.map.ObjectMapper;

@Produces({MediaType.APPLICATION_JSON})
@Path("/design")
public class DesignerService {

	private Repository<Garment> repository;

	public DesignerService() {
	}

	public DesignerService(Repository<Garment> repository) {
		this.repository = repository;
	}

	@POST
	public String create(Garment garment) {
		String id = repository.create(garment);
		return id;
	}

	@Path("/fields")
	@GET
	public Response getFields() {
		List<DesignField> designFields = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			designFields = objectMapper.readValue(this.getClass().getResourceAsStream("/DesignFields.json"),
					objectMapper.getTypeFactory().constructCollectionType(List.class, DesignField.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.ok(designFields).header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
}
