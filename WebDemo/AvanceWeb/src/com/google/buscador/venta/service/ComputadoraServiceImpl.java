package com.google.buscador.venta.service;

import java.util.List;

import com.google.buscador.venta.bean.ComputadoraBean;
import com.google.buscador.venta.bean.MarcaBean;
import com.google.buscador.venta.daos.MySqlComputadoraDAO;

public class ComputadoraServiceImpl implements ComputadoraService{

	MySqlComputadoraDAO dao = new MySqlComputadoraDAO();
	
	@Override
	public int insertaComputadora(ComputadoraBean obj) throws Exception {
		return dao.insertaComputadora(obj);
	}

	@Override
	public List<MarcaBean> listaMarca() throws Exception {
		return dao.listaMarca();
	}

	@Override
	public List<ComputadoraBean> listaComputadora(String filtro)	throws Exception {
		return dao.listaComputadora(filtro);
	}

	@Override
	public List<ComputadoraBean> listaComputadoraXmarca(String filtro) throws Exception {
		return dao.listaComputadoraXmarca(filtro);
	}

	@Override
	public List<ComputadoraBean> listaComputadoraXStock(int filtro) throws Exception {
		return dao.listaComputadoraXStock(filtro);
	}

	@Override
	public List<ComputadoraBean> listaComputadoraXmarcaMultiple(String[] opciones) throws Exception {
		return dao.listaComputadoraXmarcaMultiple(opciones);
	}

	
}
