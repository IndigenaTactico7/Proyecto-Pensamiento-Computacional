import React from 'react'
import { useForm } from 'react-hook-form'

export default function ModalCreateMaterial({ isOpen, onClose, children }) {
    let { register, handleSubmit, formState: { errors } } = useForm()
    if (!isOpen) return null;
    return (
        <>
            <div className='position-fixed top-0 start-0 w-100 h-100 bg-dark bg-opacity-50' style={{zIndex:"100"}} onClick={onClose}>

            </div>
            <div className='position-fixed top-50 start-50 bg-white translate-middle p-4 rounded-4 ' style={{zIndex:"1001","width":"500px"}}>
                <form onSubmit={handleSubmit((e) => console.log(e))}>
                    <h2>Crear un material</h2>
                    <label className='form-label'>Nombre del material</label>
                    <input type="text" className='form-control' {...register("nombre", { required: "true" })} />
                    <label className='form-label'>Tipo de residuo</label>
                    <input type="text" className='form-control' {...register("tipo", { required: "true" })} />
                    <label className='form-label'>Fecha de recolección</label>
                    <input type="date" className='form-control' {...register("fecha", { required: "true" })} />
                    <label className='form-label'>Estado</label>
                    <select name="" id="" className='form-control' {...register("estado")}>
                        <option value="Limpio">Limpio</option>
                        <option value="Contaminado">Contaminado</option>
                    </select>
                    <div className='mt-2 d-flex gap-2 justify-content-end'>
                       <button className='btn btn-primary' type='submit'>Crear</button>
                    <button className='btn btn-danger' onClick={onClose}>Cancelar</button>  
                    </div>
                   
                </form>
            </div>
        </>
    )
}

