package com.car.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: CarType
 */
@Entity
@NamedQueries({
	@NamedQuery(
		name = CarType.QUERY_CARTYPE_DTO,
		query = "SELECT NEW com.car.domain.dto.CarTypeTO(ct.id, ct.name) FROM CarType ct ORDER BY ct.name")
})
public class CarType implements Serializable {
	
	public static final String QUERY_CARTYPE_DTO = "CarType.DTO.FindAll";

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "carType")
	private List<Car> cars;

	public CarType() {
		super();
	}
	
	public CarType(String name) {
		this();
		this.setName(name);
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Car> getCars() {
		return cars;
	}
}
