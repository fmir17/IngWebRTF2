package co.edu.udea.iw.dao.hibernate;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import co.edu.udea.iw.dao.PartidoDao;
import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PaPartidoId;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Prueba de las funcionalidades para partido
 * 
 * @author Fredy Miranda
 * 
 */
public class PartidoDaoHibernateTest {

	/**
	 * Obtener todos los partidos ingresados
	 */
	@Test
	public void testObtenerTodosLosPartidos() {
		try {
			PartidoDao dao = new PartidoDaoHibernate();
			List<PaPartido> listaPartidos = dao.obtenerPartidos();
			System.out.println("LISTA DE PARTIDOS");
			for (PaPartido partido : listaPartidos) {
				System.out.println("PARTIDO:\n"
						+ partido.getId().getPaEqIdLocal().getEqNombre()
						+ " - "
						+ partido.getId().getPaEqIdVisitante().getEqNombre()
						+ "\nMarcador : " + partido.getPaNroGolLoc() + " - "
						+ partido.getPaNroGolVis() + "\nFecha "
						+ partido.getId().getPaFecha() + "\nHora partido: "
						+ partido.getPaHora() + "\nTorneo: "
						+ partido.getToTorneo().getToNombre() + "\nMes: "
						+ partido.getPaMes() + "\n\n ");
			}
		} catch (IWDaoException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Obtener un partido especifico con su id
	 */
	@Test
	public void testObtenerPartido() {
		try {
			
			
			/**
			 * Estableciendo la fecha
			 */
			String startDateString = "2014-03-30";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaPartido = null;
			try {
				fechaPartido = df.parse(startDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			/**
			 * Creamos los objetos para hacer el id del partido
			 */
			PartidoDao dao = new PartidoDaoHibernate();
			EquipoDaoHibernate daoLocal = new EquipoDaoHibernate();
			EquipoDaoHibernate daoVis = new EquipoDaoHibernate();
			
			EqEquipo paEqIdLocal = new EqEquipo();
			EqEquipo paEqIdVisitante = new EqEquipo();

			int idLocal=6;
			int idVis=2;
			
			/**
			 * Obtenemos los equipos
			 */
			paEqIdLocal=daoLocal.obtenerEquipoPorId(idLocal);
			paEqIdVisitante=daoVis.obtenerEquipoPorId(idVis);
			

			PaPartidoId id = new PaPartidoId();
			id.setPaEqIdLocal(paEqIdLocal);
			id.setPaEqIdVisitante(paEqIdVisitante);
			id.setPaFecha(fechaPartido);

			PaPartido partido = dao.obtenerPartido(id);

			if (partido != null) {
				System.out.println("El partido quedo:\n"
						+"Local - "+ partido.getId().getPaEqIdLocal().getEqNombre()+ ": "
						+ partido.getPaNroGolLoc() + 
						"\nVisitante - " + partido.getId().getPaEqIdVisitante().getEqNombre() + ": "
						+ partido.getPaNroGolVis() + "\nHora del partido: " +partido.getPaHora()
				    	
						
						);
				Assert.assertTrue(true);
				
			} else{
				Assert.assertTrue(false);
				
			}
		} catch (IWDaoException e) {
			e.printStackTrace();
			
		}
	}

	/**
	 * Prueba para consultar la oferta de un mes
	 */
	@Test
	public void testObtenerOfertaDePartidos() {
		try {
			int mes = 7;
			PartidoDao dao = new PartidoDaoHibernate();
			List<PaPartido> listaPartidosMes = dao.consultarOferta(mes);
			String mesNombre = new DateFormatSymbols().getMonths()[mes - 1];
			System.out.println("PARTIDOS DEL MES DE " + mesNombre + "\n");
			for (PaPartido partido : listaPartidosMes) {
				System.out.println("PARTIDO:\n"
						+ partido.getId().getPaEqIdLocal().getEqNombre()
						+ " - "
						+ partido.getId().getPaEqIdVisitante().getEqNombre()
						+ "\nFecha " + partido.getId().getPaFecha()
						+ "\nHora partido: " + partido.getPaHora()
						+ "\nTorneo: " + partido.getToTorneo().getToNombre()
						+ "\n\n ");
			}
		} catch (IWDaoException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
