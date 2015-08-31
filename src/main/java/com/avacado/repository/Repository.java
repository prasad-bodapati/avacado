package com.avacado.repository;

import javax.jcr.version.VersionException;

import com.avacado.model.Model;

public interface Repository<T extends Model> {
	public void create(T entity) throws VersionException;

	public <T> T get(Class<T> className, String id);

	public void delete(String path);
}
