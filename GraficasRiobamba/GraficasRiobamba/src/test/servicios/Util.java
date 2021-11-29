package servicios;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Util {

    public static long DiferenciaFechas(Date vinicio, Date vfinal) {

        String sinicio = null, sfinal = null;
        Date dinicio = null, dfinal = null;
        long milis1, milis2, diff;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        try {
            // PARSEO STRING A DATE
            sinicio = sdf.format(vinicio);
            sfinal = sdf.format(vfinal);
            dinicio = sdf.parse(sinicio);
            dfinal = sdf.parse(sfinal);

        } catch (ParseException e) {

            System.out.println("Se ha producido un error en el parseo");
        }

        //INSTANCIA DEL CALENDARIO GREGORIANO
        Calendar cinicio = Calendar.getInstance();
        Calendar cfinal = Calendar.getInstance();

        //ESTABLECEMOS LA FECHA DEL CALENDARIO CON EL DATE GENERADO ANTERIORMENTE
        cinicio.setTime(dinicio);
        cfinal.setTime(dfinal);

        milis1 = cinicio.getTimeInMillis();

        milis2 = cfinal.getTimeInMillis();

        diff = milis2 - milis1;

        return diff;
    }

    public static void exportar(String clase, String metodo, long duracion) {
        ArrayList<String> lststr = new ArrayList<>();
      /*  String sql = "SELECT * FROM information_schema.columns WHERE table_schema = 'public'";
        try {
            ConjuntoResultado rs = accesodatos.AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                lststr.add(rs.getString(2) + "." + rs.getString(3));
            }
        } catch (Exception e) {
            lststr = new ArrayList<>();
        }*/

        try {
            BufferedWriter writer = null;
            File logFile = new File("informe.txt");
            if (logFile.exists()) {
                writer = new BufferedWriter(new FileWriter(logFile, true));
                String resp = clase + " " + metodo + "," + duracion;
                for (String pivote : lststr) {
                    try {
                        int celda = 1;
                        int valor = 0;
                        try {
                            String tmp2 = clase.substring(1).toLowerCase();
                            if (pivote.contains(tmp2 + ".")) {
                                valor = 1;
                            }

                        } catch (Exception e) {
                            valor = 0;
                        }
                        resp = resp + "," + valor;
                    } catch (Exception e) {
                    }
                }
                resp = resp + "\n";
                writer.write(resp);
            } else {
                writer = new BufferedWriter(new FileWriter(logFile, true));
                String v1 = "caso de prueba, tiempo";
                for (String piv : lststr) {
                    v1 = v1 + "," + piv;
                }
                writer.write(v1 + "\n");
                String resp = clase + " " + metodo + "," + duracion;
                for (String pivote : lststr) {
                    try {
                        int celda = 1;
                        int valor = 0;
                        try {
                            String tmp2 = clase.substring(1).toLowerCase();
                            if (pivote.contains(tmp2 + ".")) {
                                valor = 1;
                            }

                        } catch (Exception e) {
                            valor = 0;
                        }
                        resp = resp + "," + valor;
                    } catch (Exception e) {
                    }
                }
                resp = resp + "\n";
                writer.write(resp);
            }
            writer.close();
        } catch (Exception e) {
        }
    }
}
