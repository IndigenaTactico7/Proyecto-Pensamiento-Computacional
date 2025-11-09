package com.eafit.pensamiento.Base;

import com.eafit.pensamiento.Herederos.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;


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

    public static ArrayList<Residuos> consultar() {
        return listaDeResiduos;
    }

    public static void guardarReporte( /*Para esta parte de aca si se uso chat gpt para saber como crear el archivo de txt en java*/
            int total, int reciclados, int reutilizados, int eliminados,
            double porcReciclado, double porcReutilizado, double porcEliminado,
            java.util.HashMap<String, Double> pesoPorTipo, java.util.HashMap<String, Integer> cantidadPorTipo) {

        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter("reporte_residuos.txt", true))) {
            writer.println("Reporte generado el " + java.time.LocalDate.now());
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

