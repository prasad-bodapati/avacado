package com.avacado.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DesignFieldsList {
	private List<DesignFields> designFieldsList;

	public List<DesignFields> getDesignFieldsList() {
		return designFieldsList;
	}

	public void setDesignFieldsList(List<DesignFields> designFieldsList) {
		this.designFieldsList = designFieldsList;
	}
}
