package com.avacado.repository;

import com.avacado.model.Model;

public interface Repository<T extends Model> {
	public String create(T entity);
}
