package com.eafit.pensamiento.Service;

import com.eafit.pensamiento.Base.Residuos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResiduoService {


    public Residuos guardar(Residuos datosguardar) throws Exception{
        try{
            //Residuos nuevoResiduo = new Residuos(datosguardar.getVidaUtil(),datosguardar.getTipo(),datosguardar.getNombre(),datosguardar.getPeso(), datosguardar.getDestino(),datosguardar.getEstado(), datosguardar.getFechaDeRecoleccion());
Residuos nuevoResiduo = new Residuos();
            Residuos.guardarResiduos(datosguardar);

            return datosguardar;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    public List<Residuos> consultar()throws Exception
    {
        try{
            System.out.println(Residuos.consultar());
            return Residuos.consultar();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }



}
