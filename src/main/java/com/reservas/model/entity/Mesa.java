package com.reservas.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mesas")
public class Mesa {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name",nullable = false)
	    private String nombre_completo;


	    @Column(name = "capacity",nullable = false)
	    private String capacidad;

	    @Column(name = "location",nullable = false)
	    private String ubicacion;

	    @Column(name = "comment",nullable = false)
	    private String comentario;

		public Mesa(Long id, String nombre_completo, String capacidad, String ubicacion, String comentario) {
			this.id = id;
			this.nombre_completo = nombre_completo;
			this.capacidad = capacidad;
			this.ubicacion = ubicacion;
			this.comentario = comentario;
		}

		public Mesa() {
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre_completo() {
			return nombre_completo;
		}

		public void setNombre_completo(String nombre_completo) {
			this.nombre_completo = nombre_completo;
		}

		public String getCapacidad() {
			return capacidad;
		}

		public void setCapacidad(String capacidad) {
			this.capacidad = capacidad;
		}

		public String getUbicacion() {
			return ubicacion;
		}

		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}

		public String getComentario() {
			return comentario;
		}

		public void setComentario(String comentario) {
			this.comentario = comentario;
		}

		@Override
		public String toString() {
			return "Mesa [id=" + id + ", nombre_completo=" + nombre_completo + ", capacidad=" + capacidad
					+ ", ubicacion=" + ubicacion + ", comentario=" + comentario + "]";
		}

	    
}
