/*******************************************************************************
 * Copyright (c) 1998, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Denise Smith - 2.3
 ******************************************************************************/ 
package org.eclipse.persistence.testing.jaxb.xmlattribute.unqualified;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class AttributeFormUnqualifiedTestCases extends JAXBWithJSONTestCases{
	private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlattribute/form_unqualified.xml";
	private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlattribute/form_unqualified.json";
	private final static String XSD_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlattribute/form_unqualified.xsd";
	
	public AttributeFormUnqualifiedTestCases(String name) throws Exception {
		super(name);
		setControlDocument(XML_RESOURCE);
		setControlJSON(JSON_RESOURCE);
		setClasses(new Class[]{TestObject.class});
	}

	protected Object getControlObject() {
		TestObject obj = new TestObject();
		obj.theTestString = "abc123";
		obj.theElementTestString = "def456";
		return obj;
	}
	
	public void testSchemaGen() throws Exception{
		List<InputStream> controlSchemas = new ArrayList<InputStream>();
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(XSD_RESOURCE);
		controlSchemas.add(is);
		super.testSchemaGen(controlSchemas);
	}

}
