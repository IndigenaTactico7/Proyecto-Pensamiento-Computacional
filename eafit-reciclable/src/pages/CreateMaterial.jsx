import React from 'react'
import { useForm } from 'react-hook-form'
export default function CreateMaterial() {
      let { register, handleSubmit, formState: { errors } } = useForm()

    return (
    <>
    <form onSubmit={handleSubmit((e)=>console.log(e))}>
        <label className='form-label'>Nombre del material</label>
        <input type="text" className='form-control' {...register("nombre",{required:"true"})}/>
        <label className='form-label'>Tipo de residuo</label>
        <input type="text" className='form-control' {...register("tipo",{required:"true"})}/>
        <label className='form-label'>Fecha de recolección</label>
        <input type="date" className='form-control' {...register("fecha",{required:"true"})}/>
        <label className='form-label'>Estado</label>
        <select name="" id="" className='form-control' {...register("estado")}>
            <option value="Limpio">Limpio</option>
            <option value="Contaminado">Contaminado</option>
        </select>
        <button type='submit'>Yes</button>
    </form>
    </>
  )
}
