package com.jrestless.aws.examples;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "session")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Sessao {
	
	public Sessao() {
		super();
	}

	public Sessao(String id) {
		super();
		this.id = id;
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
