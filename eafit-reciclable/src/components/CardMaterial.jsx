import React from 'react'
import { useModals } from '../context/ModalsContext';

export default function CardMaterial({ dato, id }) {

  console.log(dato);
  let { nombre, tipo, peso, destino, fechaDeRecoleccion, estado, vidaUtil } = dato
  let { setShowModalDelete, setIdCard, setShowModalEdit, setFormInfo } = useModals()
  

  return (
    <div className='rounded-3 d-flex flex-column shadow-lg container py-3 px-3 overflow-auto text-break' style={{ "width": "350px", "height": "250px", "backgroundColor": "#fefcff" }}>
      <div className='d-flex justify-content-between'>
        <h2 className='fs-4'>{nombre}</h2>
        <div className='d-flex flex-row gap-2'>
          <button className='btn btn-warning' onClick={(() => { setShowModalEdit(true); setFormInfo(dato); setIdCard(id); })}><i className="bi bi-pencil-square"></i></button>
          <button className='btn btn-danger' onClick={(() => { setShowModalDelete(true); setIdCard(id) })}><i className="bi bi-trash"></i></button>
        </div>

      </div>
      {

        tipo == "electronico" ?
          <h3 className='fs-6 text-white text-start my-2 rounded-5 bg-primary p-1' style={{ "width": "fit-content" }}>Electronico</h3>
          : tipo == "inorganico" ? <h3 className='fs-6 text-white text-start my-2 rounded-5 bg-warning p-1' style={{ "width": "fit-content" }}>Inorganico</h3>
            : tipo == "noAprovechable" ? <h3 className='fs-6 text-white text-start my-2 rounded-5 bg-secondary p-1' style={{ "width": "fit-content" }}>No aprovechable</h3>
              : tipo == "organico" ? <h3 className='fs-6 text-white text-start my-2 rounded-5 bg-success p-1' style={{ "width": "fit-content" }}>Organico</h3>
                : tipo == "peligroso" ? <h3 className='fs-6 text-white text-start my-2 rounded-5 bg-danger p-1' style={{ "width": "fit-content" }}>Peligroso</h3>
                  : tipo == "reciclable" ? <h3 className='fs-6 text-white text-start my-2 rounded-5 bg-info p-1' style={{ "width": "fit-content" }}>Reciclable</h3>
                    : ""
      }

    
      <hr className='m-0 mb-2 p-0' />
      <div className='d-flex justify-content-between mt-3 mb-1'>
        <h2 className='fs-6'>Peso: {peso} kg
        </h2>
        <h2 className='fs-6'>Destino: {destino}
        </h2>
      </div>
      <div className='d-flex justify-content-between mb-1'>
        {estado == "Limpio" ? <h2 className='fs-6 bg-success text-white rounded-5 p-1'>Estado: {estado} </h2> : <h2 className='fs-6 bg-danger text-white rounded-5 p-1'>Estado: {estado} </h2>}

     
      
      </div>

      <div className='d-flex'>
        <h2 className='fs-6'>Fecha de recoleccion: {fechaDeRecoleccion}
        </h2>

      </div>

    </div >
  )
}



