package com.ubisoft.task.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
@Table(name = "item")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

	@Id
	@Column(name="idItem")
	@XmlTransient
	private Long idItem;
	
	@Column(name="idUser")
	@XmlTransient
	private Long idUser;
	
	@Column(name="name")
	private String name;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="expirationDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;
	
	@Column(name="game")
	private String game;
	
	@OneToMany
	@JoinColumn(name="idItem")
	@XmlElement(name="property")
	private List<Property> properties;
	
}
