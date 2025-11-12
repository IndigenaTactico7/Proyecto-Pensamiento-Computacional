import axios from 'axios';
import React, { useState } from 'react'
import { useForm } from 'react-hook-form'
import { useSearchParams } from 'react-router-dom';
import { usePeticiones } from '../context/PeticionesContext';

export default function ModalCreateMaterial({ isOpen, onClose, children }) {
    let { register, handleSubmit, formState: { errors }, unregister, setValue, reset } = useForm()
    let [tipo, setTipo] = useState("electronico")
    let {getData,getPromedios,getPorcentajes} = usePeticiones()
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
        if (e.tipo == "electronico") {
            if (e.datoAdicional == "true") {
                nuevoMaterial.necesitaTratamientoEspecial = true
            } else {
                nuevoMaterial.necesitaTratamientoEspecial = false
            }

        } else if (e.tipo == "combustible") {
            if (e.datoAdicional == "true") {
                nuevoMaterial.Combustible = true
            } else {
                nuevoMaterial.Combustible = false
            }

        } else if (e.tipo == "noAprovechable") {
            nuevoMaterial.razonNoAprovechable = e.datoAdicional
        } else if (e.tipo == "organico") {
            nuevoMaterial.nivelBiodegradacion = e.datoAdicional
        } else if (e.tipo == "peligroso") {
            nuevoMaterial.nivelPeligrosidad = e.datoAdicional
        } else if (e.tipo == "reciclable") {
            nuevoMaterial.tipoDeMaterial = e.datoAdicional
        }
        console.log(nuevoMaterial);
        try {
            let response = await axios.post("http://localhost:8080/residuo", nuevoMaterial, {
                headers: {
                    "Content-Type": "application/json"
                }
            })
            if (response.status == 200) {
                getData()
                getPromedios()
                getPorcentajes()
                onClose()
                reset()
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
                    <select className='form-control' {...register("tipo", { onChange: (e) => { setTipo(e.target.value); unregister("datoAdicional"); setValue("datoAdicional", "") } })}>
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

                    {
                        tipo == "electronico" ?
                            <div>
                                <label className='form-label'>¿Necesita tratamiento especial?</label>
                                <select className='form-control' {...register("datoAdicional", { required: "true" })}>
                                    <option value="true">Si</option>
                                    <option value="false">No</option>
                                </select>
                                {errors.datoAdicional ? <p className='text-start text-danger mt-1'>Es obligatorio este campo</p> : ""}
                            </div>
                            : tipo == "inorganico" ? <div>
                                <label className='form-label'>¿Es un combustible?</label>
                                <select className='form-control' {...register("datoAdicional", { required: "true" })}>
                                    <option value="true">Si</option>
                                    <option value="false">No</option>
                                </select>
                                {errors.datoAdicional ? <p className='text-start text-danger mt-1'>Es obligatorio este campo</p> : ""}

                            </div> : tipo == "noAprovechable" ? <div>
                                <label className='form-label'>¿Por que no es aprovechable?</label>
                                <input type="text" className='form-control' {...register("datoAdicional", { required: "true" })} />
                                {errors.datoAdicional ? <p className='text-start text-danger mt-1'>Es obligatorio este campo</p> : ""}
                            </div> : tipo == "organico" ? <div>
                                <label className='form-label'>Nivel de biodegradabilidad</label>
                                <input type="number" className='form-control' {...register("datoAdicional", { required: "true" })} />
                                {errors.datoAdicional ? <p className='text-start text-danger mt-1'>Es obligatorio este campo</p> : ""}
                            </div> : tipo == "peligroso" ? <div>
                                <label className='form-label'>Nivel de peligrosidad</label>
                                <input type="number" className='form-control' {...register("datoAdicional", { required: "true" })} />
                                {errors.datoAdicional ? <p className='text-start text-danger mt-1'>Es obligatorio este campo</p> : ""}
                            </div> : tipo == "reciclable" ? <div>
                                <label className='form-label'>Escribe de que material esta hecho</label>
                                <input type="text" className='form-control' {...register("datoAdicional", { required: "true" })} />
                                {errors.datoAdicional ? <p className='text-start text-danger mt-1'>Es obligatorio este campo</p> : ""}
                            </div> : ""
                    }

                    <label className='form-label'>Estado</label>
                    <select name="" id="" className='form-control' {...register("estado")}>
                        <option value="Limpio">Limpio</option>
                        <option value="Contaminado">Contaminado</option>
                    </select>
                    {errors.estado ? <p className='text-start text-danger mt-1'>Es obligatorio seleccionar el estado</p> : ""}

                    <label className='form-label'>Peso</label>
                    <input type="number" className='form-control' step={0.01} {...register("peso", { required: "true" })} />
                    {errors.peso ? <p className='text-start text-danger mt-1'>Es obligatorio ingresar el peso</p> : ""}

                    <label className='form-label'>Destino</label>
                    <select className='form-control' {...register("destino", { required: "true" })}>
                        <option value="reciclaje">Reciclaje</option>
                        <option value="compostaje">Compostaje</option>
                        <option value="disposicionEspecial">Disposicion especial</option>
                    </select>
                    {errors.destino ? <p className='text-start text-danger mt-1'>Es obligatorio escribir el destino</p> : ""}

                    <div className='mt-2 d-flex gap-2 justify-content-end'>
                        <button className='btn btn-primary' type='submit'>Crear</button>
                        <button className='btn btn-danger' type='button' onClick={() => { onClose(); reset(); }}>Cancelar</button>
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
