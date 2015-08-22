package com.avacado.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.Response;

import com.avacado.rest.model.DesignFields;


public class ResourceContainer {
	private class MetaContainer {
		private int total;

		public MetaContainer total(int total) {
			this.setTotal(total);
			return this;
		}

		@SuppressWarnings("unused")
		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}
	}

	private MetaContainer meta;

	public DesignFields resource;

	public Collection<DesignFields> resources;

	public ResourceContainer resource(DesignFields resource) {
		setResource(resource);
		return this;
	}

	public ResourceContainer resources(Collection<DesignFields> resources) {
		setResources(resources);
		return this;
	}

	public ResourceContainer meta(MetaContainer meta) {
		this.setMeta(meta);
		return this;
	}

	public ResourceContainer(DesignFields resource) {
		setResource(resource);
	}

	public ResourceContainer(Collection<DesignFields> resources) {
		setResources(resources);
	}

	public MetaContainer getMeta() {
		return meta;
	}

	public void setMeta(MetaContainer meta) {
		this.meta = meta;
	}

	public DesignFields getResource() {
		return resource;
	}

	public void setResource(DesignFields resource) {
		if (resources != null) {
			throw new RuntimeException(
					"Can't set a singleValue for a multiValue");
		}
		this.resource = resource;
		this.meta(null);
	}

	public Collection<DesignFields> getResources() {
		return resources;
	}

	public void setResources(Collection<DesignFields> resources) {
		if (resource != null) {
			throw new RuntimeException(
					"Can't set a multivalue for a singleValue");
		}
		this.resources = resources;
		if (resources != null) {
			this.meta(new MetaContainer().total(this.getResources().size()));
		} else {
			this.meta(new MetaContainer().total(0));
		}
	}

	public boolean isSingleValue() {
		if (resource != null && resources == null) {
			return true;
		} else if (resource != null && resources != null) {
			throw new RuntimeException(
					"Single & mutlivalues are set in container!");
		}
		return false;
	}

	public boolean isNotSingleValue() {
		if (resource == null && resources != null) {
			return true;
		}
		return false;
	}

	public boolean isMultiValue() {
		if (resources != null && resource == null) {
			return true;
		}
		return false;
	}

	public boolean isNotMultiValue() {
		if (resources == null && resource != null) {
			return true;
		}
		return false;
	}

	public void addResources(DesignFields resource) {
		if (getResources() != null) {
			getResources().add(resource);
		} else {
			setResources(new ArrayList<DesignFields>());
			this.addResources(resource);
		}
	}

	public static Response ok(ArrayList<DesignFields> resources) {
		return Response.ok(new ResourceContainer(resources)).build();
	}

	public static Response ok(List<DesignFields> resources) {
		return Response.ok(new ResourceContainer(resources)).build();
	}

	public static Response ok(Collection<DesignFields> resources) {
		return Response.ok(new ResourceContainer(resources)).build();
	}

	public static Response ok(DesignFields resource) {
		return Response.ok(new ResourceContainer(resource)).build();
	}

	public static Response deleted() {
		return Response.noContent().build();
	}

	public static Response updated() {
		return Response.noContent().build();
	}

	public static Response updated(DesignFields resource) {
		return Response.ok(new ResourceContainer(resource)).build();
	}

	public static Response created(DesignFields resource) {
		return Response.status(Response.Status.CREATED).entity(new ResourceContainer(resource)).build();
	}
}