package com.mb.skuldyree.spring.be.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;

public class HibernateAwareObjectMapper extends ObjectMapper {
	public HibernateAwareObjectMapper() {
		Hibernate5Module mod = new Hibernate5Module();
		mod.configure(Feature.USE_TRANSIENT_ANNOTATION, false);
        registerModule(mod);
    }
}
