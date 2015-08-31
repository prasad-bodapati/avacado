package com.avacado.model;

import javax.xml.bind.annotation.XmlElement;

public class Model {
	private String id;

	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
