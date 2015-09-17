package com.avacado.repository;

import javax.jcr.version.VersionException;

import com.avacado.model.Model;

public interface Repository<T extends Model> {
	public String create(T entity) ;

	public <T> T get(String id);

	public void delete(String path);
}
