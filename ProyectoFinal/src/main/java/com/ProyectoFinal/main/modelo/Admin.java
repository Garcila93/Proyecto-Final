package com.ProyectoFinal.main.modelo;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @EqualsAndHashCode(callSuper=true) @ToString(callSuper=true) @NoArgsConstructor
@Entity
public class Admin extends Empleados {

	
	
}
