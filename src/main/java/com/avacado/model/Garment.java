package com.avacado.model;


import java.util.Calendar;
import java.util.List;

import org.apache.jackrabbit.ocm.mapper.impl.annotation.Collection;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.Field;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.Node;

@Node()
public class Garment extends Model {
	@Field
	private Calendar season;

	@Collection
	private List<DesignField> designFields;

	public Calendar getSeason() {
		return season;
	}

	public void setSeason(Calendar season) {
		this.season = season;
		setPath("/garments" + "/" + season.get(Calendar.MONTH) + "-" + season.get(Calendar.YEAR));
	}

	public List<DesignField> getDesignFields() {
		return designFields;
	}

	public void setDesignFields(List<DesignField> designFields) {
		this.designFields = designFields;
	}
}
