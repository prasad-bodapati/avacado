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

import com.avacado.repository.Repository;
import com.avacado.model.DesignFields;
import org.codehaus.jackson.map.ObjectMapper;

@Produces({MediaType.APPLICATION_JSON})
@Path("/design")
public class DesignerService {

	Repository repository;
	@POST
	public String create(List<DesignFields> designFields) {

		return "";
	}

	@Path("/fields")
	@GET
	public Response getFields() {
		List<DesignFields> designFields = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			designFields = objectMapper.readValue(this.getClass().getResourceAsStream("/DesignFields.json"),
					objectMapper.getTypeFactory().constructCollectionType(List.class, DesignFields.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.ok(designFields).header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
}
