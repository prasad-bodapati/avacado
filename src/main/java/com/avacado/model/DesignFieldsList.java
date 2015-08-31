package com.avacado.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DesignFieldsList {
	private List<DesignField> designFieldsList;

	public List<DesignField> getDesignFieldsList() {
		return designFieldsList;
	}

	public void setDesignFieldsList(List<DesignField> designFieldsList) {
		this.designFieldsList = designFieldsList;
	}
}
