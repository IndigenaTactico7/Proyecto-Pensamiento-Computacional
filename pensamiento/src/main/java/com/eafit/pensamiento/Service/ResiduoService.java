package com.eafit.pensamiento.Service;

import com.eafit.pensamiento.Base.Residuos;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ResiduoService {


    public Residuos guardar(Residuos datosguardar) throws Exception{
        try{
            Residuos.guardarResiduos(datosguardar);
            return datosguardar;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    public List<Residuos> consultar()throws Exception
    {
        try{
            return Residuos.consultar();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public HashMap<String,Double> promedios()throws Exception
    {
        try{
            return Residuos.devolverPromedio();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarResido(int idResiduo)throws Exception
    {
        try{
            return Residuos.eliminarResiduo(idResiduo);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Residuos editar(Residuos datosguardar, int idResiduo) throws Exception{
        try{
            Residuos.editarResiduo(datosguardar,idResiduo);
            return datosguardar;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

}
