package com.avacado.model;

import javax.xml.bind.annotation.XmlElement;

import org.apache.jackrabbit.ocm.mapper.impl.annotation.Field;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.Node;

@Node(jcrMixinTypes = "mix:referenceable", jcrType = "referenceable")
public abstract class Model {
	@Field(uuid = true )
	private String id;

	@Field(path = true)
	private String path;

	@Field
	String title;

	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
