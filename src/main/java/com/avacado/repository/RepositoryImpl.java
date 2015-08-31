package com.avacado.repository;


import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import com.avacado.model.Model;
import org.codehaus.jackson.map.ObjectMapper;

public class RepositoryImpl implements Repository {

	public RepositoryImpl() {
	}

	@Override
	public String create(Model entity) {
		return"";
	}
}
