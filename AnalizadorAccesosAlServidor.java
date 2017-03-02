import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AnalizadorAccesosAlServidor
{
    // instance variables - replace the example below with your own
    private ArrayList<Acceso> accesos;
    private ArrayList<Integer> enteros;
    private int horaConMasAccesos;
    /**
     * Constructor for objects of class AnalizadorAccesosAlServidor
     */
    public AnalizadorAccesosAlServidor()
    {
        accesos = new ArrayList<Acceso>();
        enteros = new ArrayList<Integer>();
        horaConMasAccesos = -1;
    }

    public void analizarArchivoDeLog(String nombreArchivo){
        try{
            File archivo = new File(nombreArchivo);
            Scanner sc = new Scanner(archivo);
            int contador = 0;
            while(contador < 24){
                enteros.add(0);
                contador++;
            }
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
                String[] cadenaAPartir = sc.nextLine().split(" ");
                int año = Integer.parseInt(cadenaAPartir[0]);
                int mes = Integer.parseInt(cadenaAPartir[1]);
                int dia =Integer.parseInt(cadenaAPartir[2]);
                int hora =Integer.parseInt(cadenaAPartir[3]);
                int minuto =Integer.parseInt(cadenaAPartir[4]);
                Acceso nuevoAcceso = new Acceso(año,mes,dia,hora,minuto);
                accesos.add(nuevoAcceso);
                enteros.set(hora ,enteros.get(hora) + 1);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Archivo no encotrado");
        }
    }

    /**
     * 
     */
    public int obtenerHoraMasAccesos(){
        int posicionMaxima = -1;
        horaConMasAccesos = -1;
        for(int contador = 0;contador < enteros.size();contador++){
            if(enteros.get(contador) > horaConMasAccesos){
                horaConMasAccesos = enteros.get(contador);
                posicionMaxima = contador;
            }
            else{
            }
        }
        return posicionMaxima;
    }
}