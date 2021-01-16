package com.ubisoft.task.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "property")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Property {

	@Id
	@Column(name="idProperty")
	@XmlTransient
	private Long idProperty;
	
	@Column(name="idItem")
	@XmlTransient
	private Long idItem;
	
	@Column(name="name")
	private String name;
	
	@Column(name="value")
	private String value;
	
}
