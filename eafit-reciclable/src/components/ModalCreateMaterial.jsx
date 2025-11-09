import axios from 'axios';
import React from 'react'
import { useForm } from 'react-hook-form'

export default function ModalCreateMaterial({ isOpen, onClose, children }) {
    let { register, handleSubmit, formState: { errors } } = useForm()
    if (!isOpen) return null;

    let CreateMaterial = async (e) => {
        let nuevoMaterial = {
            "estado": e.estado,
            "tipo": e.tipo,
            "nombre": e.nombre,
            "destino": e.destino,
            "fechaDeRecoleccion": e.fecha,
            "peso": e.peso,
            "vidaUtil": 2
            
        }
        try {
            let response = await axios.post("http://localhost:8080/residuo", nuevoMaterial,{
                headers: {
                    "Content-Type": "application/json"
                }
            })
            if(response.status==200){
                onClose()
            }
        } catch (error) {
            console.log(error.message);
        }
    }


    return (
        <>
            <div className='position-fixed top-0 start-0 w-100 h-100 bg-dark bg-opacity-50' style={{ zIndex: "100" }} onClick={onClose}>

            </div>
            <div className='position-fixed top-50 start-50 bg-white translate-middle p-4 rounded-4 ' style={{ zIndex: "1001", "width": "500px" }}>
                <form onSubmit={handleSubmit((e) => CreateMaterial(e))}>
                    <h2>Crear un material</h2>
                    <label className='form-label'>Nombre del material</label>
                    <input type="text" className='form-control' {...register("nombre", { required: "true" })} />
                    {errors.nombre ? <p className='text-start text-danger mt-1'>Es obligatorio escribir el nombre del material</p> : ""}
                    <label className='form-label'>Tipo de residuo</label>
                    <select name="" id="" className='form-control'  {...register("tipo")}>
                        <option value="electronico">Electronicos</option>
                        <option value="inorganico">Inorganicos</option>
                        <option value="noAprovechable">No aprovechable</option>
                        <option value="organico">Organico</option>
                        <option value="peligroso">Peligroso</option>
                        <option value="reciclable">Reciclable</option>
                    </select>
                    {errors.tipo ? <p className='text-start text-danger mt-1'>Es obligatorio seleccionar el tipo de residuo</p> : ""}

                    <label className='form-label'>Fecha de recolección</label>
                    <input type="date" className='form-control' {...register("fecha", { required: "true" })} />
                    {errors.fecha ? <p className='text-start text-danger mt-1'>Es obligatorio colocar una fecha</p> : ""}

                    <label className='form-label'>Estado</label>
                    <select name="" id="" className='form-control' {...register("estado")}>
                        <option value="Limpio">Limpio</option>
                        <option value="Contaminado">Contaminado</option>
                    </select>
                    {errors.estado ? <p className='text-start text-danger mt-1'>Es obligatorio seleccionar el estado</p> : ""}

                    <label className='form-label'>Peso</label>
                    <input type="number" className='form-control' {...register("peso", { required: "true" })} />
                    {errors.peso ? <p className='text-start text-danger mt-1'>Es obligatorio ingresar el peso</p> : ""}

                    <label className='form-label'>Destino</label>
                    <input type="text" className='form-control' {...register("destino", { required: "true" })} />
                    {errors.destino ? <p className='text-start text-danger mt-1'>Es obligatorio escribir el destino</p> : ""}

                    <div className='mt-2 d-flex gap-2 justify-content-end'>
                        <button className='btn btn-primary' type='submit'>Crear</button>
                        <button className='btn btn-danger' onClick={onClose}>Cancelar</button>
                    </div>

                </form>
            </div>
        </>
    )
}
{/**protected int vidaUtil;
   
    protected double peso;
    protected String destino;
    */}
