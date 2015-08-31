package com.avacado.repository;


import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.version.VersionException;
import java.util.ArrayList;
import java.util.List;

import com.avacado.model.DesignField;
import com.avacado.model.Garment;
import com.avacado.model.Model;
import org.apache.jackrabbit.core.TransientRepository;
import org.apache.jackrabbit.ocm.manager.ObjectContentManager;
import org.apache.jackrabbit.ocm.manager.impl.ObjectContentManagerImpl;
import org.apache.jackrabbit.ocm.mapper.Mapper;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.AnnotationMapperImpl;

public class JCRRepositoryImpl<T extends Model> implements Repository<T> {
	private javax.jcr.Repository repository;
	private ObjectContentManager ocm;
	private String nodeRootPath;
	private Session session;
	private SimpleCredentials credentials;
	private Mapper mapper;

	public JCRRepositoryImpl(String nodeRootPath) throws RepositoryException {
		this.nodeRootPath = nodeRootPath;
		repository = new TransientRepository();
		List<Class> classes = new ArrayList<>();
		classes.add(Model.class);
		classes.add(DesignField.class);
		classes.add(Garment.class);
		credentials = new SimpleCredentials("admin", "admin".toCharArray());
		mapper = new AnnotationMapperImpl(classes);
		initiateOCM();
		if (!session.nodeExists("/" + nodeRootPath)) {
			session.getRootNode().addNode(nodeRootPath);
		}
		session.save();
		session.logout();
	}

	private void initiateOCM() {
		try {
			session = repository.login(credentials);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		ocm = new ObjectContentManagerImpl(session, mapper);
	}

	@Override
	public void create(T entity) throws VersionException {
		initiateOCM();
		ocm.insert(entity);
		ocm.save();
		session.logout();
	}

	@Override
	public <T> T get(Class<T> className, String nodeSubPath) {
		initiateOCM();
		T model = (T) ocm.getObject(className, "/" + nodeRootPath + "/" + nodeSubPath);
		session.logout();
		return model;
	}

	@Override
	public void delete(String nodeSubPath) {
		initiateOCM();
		ocm.remove("/" + nodeRootPath + "/" + nodeSubPath);
		session.logout();
	}


}
