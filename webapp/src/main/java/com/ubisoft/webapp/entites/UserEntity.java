package com.ubisoft.webapp.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "user")
public class UserEntity {

	@Id
	@Column(name = "idUser")
	private Long idUser;

	@Column(name = "username")
	private String username;

	
	@JsonIgnore
	@Column(name = "password")
	private String password;

	
	@OneToMany
	@JoinColumn(name = "idRole")
	private List<Role> roles;
}
