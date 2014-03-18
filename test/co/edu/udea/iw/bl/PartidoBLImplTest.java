package co.edu.udea.iw.bl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.transaction.TransactionConfiguration;

import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PrPronostico;
import co.edu.udea.iw.dto.PrPronosticoId;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
/**
 * Prueba de las funcionalidades para partido
 * 
 * @author Fredy Miranda
 * 
 */
public class PartidoBLImplTest {
	@Autowired
	PartidoBL partidoBL;
	
	@Autowired
	PronosticoBL pronosticoBL;
	
	@Autowired
	PuntosMesBL puntosMesBL;

	/**
	 * Obtener todos los partidos existentes en la b.d
	 */
	@Test
	public void testObtenerPartidos() {
		try {
			List<PaPartido> partidos = null;
			partidos = partidoBL.obtenerPartidos();
			System.out.println("LISTA DE PARTIDOS");
			for (PaPartido partido : partidos) {
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
				assertTrue(true);

			}
		} catch (Exception e) {
			fail(e.getMessage());
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

			PaPartido partido = partidoBL.obtenerPartido(6, 2, fechaPartido);
			if (partido != null) {
				System.out.println("El partido quedo:\n" + "Local - "
						+ partido.getId().getPaEqIdLocal().getEqNombre() + ": "
						+ partido.getPaNroGolLoc() + "\nVisitante - "
						+ partido.getId().getPaEqIdVisitante().getEqNombre()
						+ ": " + partido.getPaNroGolVis()
						+ "\nHora del partido: " + partido.getPaHora()

				);
				Assert.assertTrue(true);

			} else {
				Assert.assertTrue(false);

			}
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Obtener la oferta de partido para un determinado mes
	 */
	@Test
	public void testObtenerOfertaDePartidos() {
		try {
			int mes = 7;

			List<PaPartido> listaPartidosMes = partidoBL.consultarOferta(mes);

			// Mostrar resultados en consola

			String mesNombre = new DateFormatSymbols().getMonths()[mes - 1];
			System.out.println("PARTIDOS DEL MES DE " + mesNombre + "\n");
			for (PaPartido partido : listaPartidosMes) {
				System.out.println("PARTIDO:\n"
						+ partido.getId().getPaEqIdLocal().getEqNombre()
						+ " - "
						+ partido.getId().getPaEqIdVisitante().getEqNombre()
						+ "\nHora partido: " + partido.getPaHora() + "\nFecha "
						+ partido.getId().getPaFecha() + "\nTorneo: "
						+ partido.getToTorneo().getToNombre() + "\n\n ");
			}
		} catch (IWDaoException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Prueba para la funcionalidad guardar usuario
	 * 
	 * @author Fredy Miranda
	 * 
	 */

	@Test
	public void testGuardar() {
		try {
			/**
			 * Estableciendo la fecha y hora
			 * 
			 */
			String startDateString = "2014-04-29";
			String hora = "10:30:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat df2 = new SimpleDateFormat("HH:mm:ss");

			Date fechaPartido = null;
			Date horaPartido = null;
			try {
				fechaPartido = df.parse(startDateString);
				horaPartido = df2.parse(hora);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			partidoBL.registrarNuevoPartido(3, 1, fechaPartido, horaPartido, 1);
			assertTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Prueba para la funcionalidad de registrar marcador
	 * 
	 * @author Fredy Miranda
	 * 
	 */

	@Test
	public void testRegistrarMarcador() {
		try {
			/**
			 * Estableciendo la fecha y hora
			 * 
			 */
			String startDateString = "2014-03-30";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaPartido = null;
			try {
				fechaPartido = df.parse(startDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			partidoBL.registrarMarcador(6, 2, fechaPartido, 5, 3);
			assertTrue(true);
		} catch (Exception e) {
			System.out.println(e);
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Prueba para la funcionalidad de actualizar los puntos de un jugador
	 * @author Alan Arboleda
	 * @throws IWBLException 
	 * @throws IWDaoException 
	 * 
	 */	
	@Test
	public void testActualizarJugadorPuntos() throws IWDaoException, IWBLException {

		String startDateString = "2014-03-30";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaPartido = null;
		try {
			fechaPartido = df.parse(startDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		PrPronostico pron = pronosticoBL.obtenerPronosticoPorId(2, 6, fechaPartido, "Alan");
	
			PaPartido partido = new PaPartido();
			partido = pron.getPaPartido();
			partidoBL.actualizarJugadorPuntos(partido, pron);
	}
}
