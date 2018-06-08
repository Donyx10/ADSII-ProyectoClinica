package com.google.buscador.venta.service;

import java.util.List;

import com.google.buscador.venta.bean.ComputadoraBean;
import com.google.buscador.venta.bean.MarcaBean;

public interface ComputadoraService {

	public int insertaComputadora(ComputadoraBean obj) throws Exception;
	
	public List<MarcaBean> listaMarca() throws Exception;
	
	public List<ComputadoraBean> listaComputadora(String filtro) throws Exception;
	
	public List<ComputadoraBean> listaComputadoraXmarca(String filtro) throws Exception;
	
	public List<ComputadoraBean> listaComputadoraXmarcaMultiple(String[] opciones) throws Exception;
		
	
	public List<ComputadoraBean> listaComputadoraXStock(int filtro) throws Exception;
	
	
}
