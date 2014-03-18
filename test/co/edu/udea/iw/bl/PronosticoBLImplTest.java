package co.edu.udea.iw.bl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.impl.PronosticoDaoImpl;
import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PrPronostico;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;
import co.edu.udea.iw.dao.PartidoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
/**
 * Prueba de las funcionalidades para los pronosticos otorgados por los usuarios
 * @author Maicol Giraldo
 * 
 */
public class PronosticoBLImplTest {

	@Autowired
	PronosticoBL pronosticoBL;
	EquipoBL equipoBL;
	PronosticoDaoImpl pr;
	PartidoBL partidoBL;

	@Test
	public void consultarPronosticosUsuario() throws IWBLException {
		try {
			String nombre = "Maicol";
			List<PrPronostico> listaPronosticos = pronosticoBL
					.consultarPronosticosUsuario(nombre);
			System.out
					.println("Estos son los pronosticos realizados por el usuario: "
							+ nombre);
			for (PrPronostico pron : listaPronosticos) {
				System.out.println("Partido: "
						+ pron.getPaPartido().getId().getPaEqIdLocal()
								.getEqNombre()
						+ " VS "
						+ pron.getPaPartido().getId().getPaEqIdVisitante()
								.getEqNombre());
				System.out.println("Pronostico: " + pron.getPrNroGolLoc()
						+ " - " + pron.getPrNroGolVis());
				System.out
						.println("*******************************************************************");
			}

		} catch (IWDaoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void consultarPronosticosPartido() throws IWBLException {
		try {
			String startDateString = "2014-03-30";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaPartido = null;
			try {
				fechaPartido = df.parse(startDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			List<PrPronostico> listaPronosticos = pronosticoBL
					.consultarPronosticosPartido(fechaPartido,6,2);
			
			for (PrPronostico pron : listaPronosticos) {
				System.out.println("partido:"+ pron.getPaPartido().getId().getPaEqIdLocal().getEqNombre()
						+ " VS "+pron.getPaPartido().getId().getPaEqIdVisitante().getEqNombre());
				System.out.println("Usuario: "
						+ pron.getUsUsuario().getUsNombre());
				System.out.println("Pronostico: " + pron.getPrNroGolLoc()
						+ " - " + pron.getPrNroGolVis());
				System.out
						.println("*******************************************************************");
			}

		} catch (IWDaoException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	@Test
	public void consultarPronosticosPorId() throws IWBLException {
		try {
			String startDateString = "2014-03-30";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaPartido = null;
			try {
				fechaPartido = df.parse(startDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			PrPronostico pron = pronosticoBL.obtenerPronosticoPorId(2, 6, fechaPartido, "Alan");
				System.out.println("partido:"+ pron.getPaPartido().getId().getPaEqIdLocal().getEqNombre()
						+ " VS "+pron.getPaPartido().getId().getPaEqIdVisitante().getEqNombre());
				System.out.println("Usuario: "
						+ pron.getUsUsuario().getUsNombre());
				System.out.println("Pronostico: " + pron.getPrNroGolLoc()
						+ " - " + pron.getPrNroGolVis());
				System.out
						.println("*******************************************************************");
		

		} catch (IWDaoException e) {
			e.printStackTrace();
		}
	}
}
