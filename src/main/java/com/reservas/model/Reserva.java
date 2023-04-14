package com.reservas.model;

import java.sql.Time;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	@OneToMany(mappedBy = "reserva",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Mesa> mesa;
	
	@Column(name = "date", length = 30,nullable = false)
	@DateTimeFormat(pattern="dd/MM/yyyy")   //(format dd/mm/aa)
	private Date fecha;
	
	@Column(name = "time", length = 30,nullable = false)
	private Time hora;
	
	@Column(name = "number_people", length = 10,nullable = false)
	private int cantidadDePersonas;
	
	@Column(name = "comment", length = 100,nullable = false)
	private String Comentario;

	public Reserva(Integer id, Cliente cliente, List<Mesa> mesa, Date fecha, Time hora, int cantidadDePersonas,
			String comentario) {
		this.id = id;
		this.cliente = cliente;
		this.mesa = mesa;
		this.fecha = fecha;
		this.hora = hora;
		this.cantidadDePersonas = cantidadDePersonas;
		Comentario = comentario;
	}

	public Reserva() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Mesa> getMesa() {
		return mesa;
	}

	public void setMesa(List<Mesa> mesa) {
		this.mesa = mesa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public int getCantidadDePersonas() {
		return cantidadDePersonas;
	}

	public void setCantidadDePersonas(int cantidadDePersonas) {
		this.cantidadDePersonas = cantidadDePersonas;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", cliente=" + cliente + ", mesa=" + mesa + ", fecha=" + fecha + ", hora=" + hora
				+ ", cantidadDePersonas=" + cantidadDePersonas + ", Comentario=" + Comentario + "]";
	}
	
	
}
