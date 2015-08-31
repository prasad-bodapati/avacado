package com.avacado.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.Field;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.Node;

@XmlRootElement
@Node
public class DesignField extends Model {
	@Field
	private String name;
	@Field
	private String type;
	private String example;
	@Field
	private String value;
	@Field
	private Date season;

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setPath("/designFields/" + name);
		setTitle(name);
	}

	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement
	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	@XmlElement
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XmlElement
	public Date getSeason() {
		return season;
	}

	public void setSeason(Date season) {
		this.season = season;
	}
}
