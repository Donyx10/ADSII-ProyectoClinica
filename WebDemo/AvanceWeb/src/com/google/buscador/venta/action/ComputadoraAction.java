package com.google.buscador.venta.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.google.buscador.venta.bean.ComputadoraBean;
import com.google.buscador.venta.bean.MarcaBean;
import com.google.buscador.venta.service.ComputadoraServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class ComputadoraAction extends ActionSupport{

	//Para la carga del combo
	private List<MarcaBean> lstMarca = new ArrayList<MarcaBean>();
	
	//Para el registro de computadora
	private ComputadoraBean computadora;
	
	//Para la consulta de computadora
	private List<ComputadoraBean> lstComputadora = new ArrayList<ComputadoraBean>();
	private String filtro;
	
	//Para la consulta de computadora múltiple
	private String[] opciones;
	
	
	@Action(value="/registraCompu",
			results={@Result(name="success",location="/registraComputadora.jsp")
	})
	public String registraComputadora(){
		ComputadoraServiceImpl service = new ComputadoraServiceImpl();
		try {
			service.insertaComputadora(computadora);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	
	@Action(value="/cargaMarca",results={@Result(name="success",type="json")})
	public String cargaMarca(){
		ComputadoraServiceImpl service = new ComputadoraServiceImpl();
		try {
			lstMarca = service.listaMarca();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
		
	}
	
	@Action(value="/consultaCompu",
			results={@Result(name="success",location="/listaComputadora.jsp")
	})
	public String consultaCompu(){
		ComputadoraServiceImpl service = new ComputadoraServiceImpl();
		try {
			lstComputadora = service.listaComputadora(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	
	@Action(value="/consultaXMarca",
			results={@Result(name="success",location="/listaComputadoraPorMarca.jsp")
	})
	public String consultaCompuXmarca(){
		ComputadoraServiceImpl service = new ComputadoraServiceImpl();
		try {
			lstComputadora = service.listaComputadoraXmarca(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	
	@Action(value="/consultaXMarcaMultiple",
			results={@Result(name="success",location="/listaComputadoraPorMarcaMultiple.jsp")
	})
	public String consultaCompuXmarcaMult(){
		ComputadoraServiceImpl service = new ComputadoraServiceImpl();
		try {
			lstComputadora = service.listaComputadoraXmarcaMultiple(opciones);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	

	@Action(value="/consultaXStock",
			results={@Result(name="success",location="/listaComputadoraPorStock.jsp")
	})
	public String consultaCompuXStock(){
		ComputadoraServiceImpl service = new ComputadoraServiceImpl();
		try {
			lstComputadora = service.listaComputadoraXStock(Integer.parseInt(filtro));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	public List<MarcaBean> getLstMarca() {
		return lstMarca;
	}

	public void setLstMarca(List<MarcaBean> lstMarca) {
		this.lstMarca = lstMarca;
	}

	public List<ComputadoraBean> getLstComputadora() {
		return lstComputadora;
	}

	public void setLstComputadora(List<ComputadoraBean> lstComputadora) {
		this.lstComputadora = lstComputadora;
	}

	public String getFiltro() {
		return filtro;
	}

	public ComputadoraBean getComputadora() {
		return computadora;
	}
	public void setComputadora(ComputadoraBean computadora) {
		this.computadora = computadora;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	
}
