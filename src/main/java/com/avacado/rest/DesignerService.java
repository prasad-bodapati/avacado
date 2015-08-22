package com.avacado.rest;

import javax.sql.rowset.serial.SerialStruct;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.avacado.rest.model.Design;
import com.avacado.rest.model.DesignFields;
import org.codehaus.jackson.map.ObjectMapper;

@Produces({MediaType.APPLICATION_JSON})
@Path("/design")
public class DesignerService {

	@POST
	public String create(Design design) {
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
