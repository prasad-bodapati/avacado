package com.avacado.model;

import java.util.List;

import org.apache.jackrabbit.ocm.mapper.impl.annotation.Collection;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.Field;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.Node;

@Node()
public class Garment extends Model {
	@Field()
	private String season;

	@Collection
	private List<DesignField> designFields;

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
		setPath("/garments" + "/" + season);
	}

	public List<DesignField> getDesignFields() {
		return designFields;
	}

	public void setDesignFields(List<DesignField> designFields) {
		this.designFields = designFields;
	}
}
