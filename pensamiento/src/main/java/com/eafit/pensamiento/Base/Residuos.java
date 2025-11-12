package com.eafit.pensamiento.Base;

import com.eafit.pensamiento.Herederos.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo")

@JsonSubTypes({
        @JsonSubTypes.Type(value = Peligrosos.class, name = "peligroso"),
        @JsonSubTypes.Type(value = Reciclables.class, name = "reciclable"),
        @JsonSubTypes.Type(value = Electronicos.class, name = "electronico"),
        @JsonSubTypes.Type(value = NoAprovechables.class, name = "noAprovechable"),
        @JsonSubTypes.Type(value = Organico.class, name = "organico"),
        @JsonSubTypes.Type(value = Inorganico.class, name = "inorganico")
})
public class Residuos {
    public static ArrayList<Residuos> listaDeResiduos = new ArrayList<>();
    protected int vidaUtil;
    protected String tipo;
    protected String nombre;
    protected double peso;
    protected String destino;
    protected String estado;
    protected String fechaDeRecoleccion;


    public Residuos() {
    }

    public Residuos(int vidaUtil, String tipo, String nombre, double peso, String destino, String estado) {
        this.vidaUtil = vidaUtil;
        this.tipo = tipo;
        this.nombre = nombre;
        this.peso = peso;
        this.destino = destino;
        this.estado = estado;
    }

    public static void guardarResiduos(Residuos residuos) {
        listaDeResiduos.add(residuos);
    }

    public static HashMap<String,Double> devolverPromedio(){
        HashMap<String,Double> promedios = new HashMap<String,Double>();
        double electronico = 0;
        double inorganico = 0;
        double noAprovechable = 0;
        double organico = 0;
        double peligroso = 0;
        double reciclable = 0;
        int contElectronico = 0,contInorganico = 0,contNoAprov = 0,contOrganico = 0,contPeligroso =0,contReciclable = 0;
        for (Residuos residuos:listaDeResiduos)
        {
            if (residuos.getTipo().equals("electronico")){
                electronico+=residuos.getPeso();
                contElectronico++;
            }else if(residuos.getTipo().equals("inorganico")){
                electronico+=residuos.getPeso();
                contInorganico++;
            }else if(residuos.getTipo().equals("noAprovechable")){
                electronico+=residuos.getPeso();
                contNoAprov++;
            }else if(residuos.getTipo().equals("organico")){
                electronico+=residuos.getPeso();
                contOrganico++;
            }else if(residuos.getTipo().equals("peligroso")){
                electronico+=residuos.getPeso();
                contPeligroso++;
            }else if(residuos.getTipo().equals("reciclable")){
                electronico+=residuos.getPeso();
                contReciclable++;
            }
        }

        promedios.put("electronico",electronico/contElectronico);
        promedios.put("inorganico",inorganico/contInorganico);
        promedios.put("noAprovechable",noAprovechable/contNoAprov);
        promedios.put("organico",organico/contOrganico);
        promedios.put("peligroso",peligroso/contPeligroso);
        promedios.put("reciclable",reciclable/contReciclable);

        return promedios;
    }



    public static ArrayList<Residuos> consultar() {

        return listaDeResiduos;
    }

    public static boolean eliminarResiduo(int idResiduo) throws Exception{
        try{
            listaDeResiduos.remove(idResiduo);
            return true;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    public static void editarResiduo(Residuos residuo, int idResiduo) throws Exception{
        try{
            listaDeResiduos.set(idResiduo,residuo);
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    public static void guardarReporte( /*Para esta parte de aca si se uso chat gpt para saber como crear el archivo de txt en java*/
            int total, int reciclados, int reutilizados, int eliminados,
            double porcReciclado, double porcReutilizado, double porcEliminado,
            HashMap<String, Double> pesoPorTipo, HashMap<String, Integer> cantidadPorTipo) {

        try (PrintWriter writer = new PrintWriter(new FileWriter("reporte_residuos.txt", true))) {
            writer.println("Reporte generado el " + LocalDate.now());
            writer.println("Total residuos recolectados: " + total);
            writer.printf("Reciclados: %.2f%% (%d)\n", porcReciclado, reciclados);
            writer.printf("Reutilizados: %.2f%% (%d)\n", porcReutilizado, reutilizados);
            writer.printf("Eliminados: %.2f%% (%d)\n", porcEliminado, eliminados);
            writer.println("\nPromedio de peso por tipo de residuo:");
            for (String tipo : pesoPorTipo.keySet()) {
                double promedio = pesoPorTipo.get(tipo) / cantidadPorTipo.get(tipo);
                writer.printf("%s: %.2f kg\n", tipo, promedio);
            }
            writer.println("---------------------------------------------");
            System.out.println("Reporte guardado en 'reporte_residuos.txt'");
        } catch (Exception e) {
            System.out.println("Error al guardar el reporte: " + e.getMessage());
        }
    }


//Metodos get


    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaDeRecoleccion() {
        return fechaDeRecoleccion;
    }

    public void setFechaDeRecoleccion(String fechaDeRecoleccion) {
        this.fechaDeRecoleccion = fechaDeRecoleccion;
    }
}

