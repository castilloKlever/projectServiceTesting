package servicios_20211124_222504;

import com.grafrio.GraficasRiobamba.entities.*;
import servicios.*;
import com.grafrio.GraficasRiobamba.test.service.*;
import java.util.List;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceMensajeTest {

    public ServiceMensajeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

@Test
    public void testinsertar() throws Exception {
        System.out.println("insertar");
        String metodo = "insertar";
        String clase = "ServiceMensaje";
        Date vinicio = new Date();
        Boolean expResult = true;
int  result = 0;
        try {
            result = ServiceMensaje.insertar();
        } catch (Exception e) {
        result = 0;
        }
        Boolean res = false;
        if (result == 0) {
            res = true;
        } else {
            res = false;
        }
        assertEquals(expResult, res);
        Date vfinal = new Date();
        long duracion = Util.DiferenciaFechas(vinicio, vfinal);
        Util.exportar(clase, metodo, duracion);
    }
@Test
    public void testlistar() throws Exception {
        System.out.println("listar");
        String metodo = "listar";
        String clase = "ServiceMensaje";
        Date vinicio = new Date();
        Boolean expResult = true;
        List<Mensaje> result = null;
        try {
            result = ServiceMensaje.listar();
        } catch (Exception e) {
        result = null;
        }
        Boolean res = false;
        if (result == null) {
            res = true;
        } else {
            res = false;
        }
        assertEquals(expResult, res);
        Date vfinal = new Date();
        long duracion = Util.DiferenciaFechas(vinicio, vfinal);
        Util.exportar(clase, metodo, duracion);
    }
@Test
    public void testeliminar() throws Exception {
        System.out.println("eliminar");
        String metodo = "eliminar";
        String clase = "ServiceMensaje";
        Date vinicio = new Date();
        Boolean expResult = true;
        int result = 0;
        try {
            result = ServiceMensaje.eliminar();
        } catch (Exception e) {
        result = 0;
        }
        Boolean res = false;
        if (result == 0) {
            res = true;
        } else {
            res = false;
        }
        assertEquals(expResult, res);
        Date vfinal = new Date();
        long duracion = Util.DiferenciaFechas(vinicio, vfinal);
        Util.exportar(clase, metodo, duracion);
    }}
