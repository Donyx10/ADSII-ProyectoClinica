package com.google.buscador.venta.daos;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.buscador.venta.bean.ComputadoraBean;
import com.google.buscador.venta.bean.FiltroBean;
import com.google.buscador.venta.bean.MarcaBean;


public class MySqlComputadoraDAO implements ComputadoraDAO{

	SqlSessionFactory sqlMapper = null;
	{
		String archivo = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archivo);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertaComputadora(ComputadoraBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_insertaComputadora",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally{
			session.close();
		}
		return salida;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MarcaBean> listaMarca() throws Exception {
		List<MarcaBean> salida =  new ArrayList<MarcaBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaMarca",null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return salida;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ComputadoraBean> listaComputadora(String filtro)
			throws Exception {
		List<ComputadoraBean> salida =  new ArrayList<ComputadoraBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaComputadora",filtro+"%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return salida;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ComputadoraBean> listaComputadoraXmarca(String filtro) throws Exception {
		List<ComputadoraBean> salida =  new ArrayList<ComputadoraBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			
			MarcaBean obj = new MarcaBean();
			obj.setIdMarca(Integer.parseInt(filtro));
			
			salida = session.selectList("SQL_listaComputadoraXmarca",obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return salida;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ComputadoraBean> listaComputadoraXStock(int filtro) throws Exception {
		List<ComputadoraBean> salida =  new ArrayList<ComputadoraBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaComputadoraXStock",filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return salida;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComputadoraBean> listaComputadoraXmarcaMultiple(String[] opciones) throws Exception {
		List<ComputadoraBean> salida =  new ArrayList<ComputadoraBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();

			FiltroBean obj = new FiltroBean();
			obj.setOpciones(opciones);
			
			salida = session.selectList("SQL_listaComputadoraXmarcaMultiple",obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return salida;
	}

	
	
}
