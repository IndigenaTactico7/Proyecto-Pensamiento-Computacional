import React from 'react'

export default function CardMaterial({dato}) {
 console.log(dato);
  let {nombre,tipo,peso,destino,fecha} = dato
  
  return (
    <div className='rounded-3 d-flex flex-column shadow-lg container py-3 px-3' style={{ "width": "350px", "height": "250px", "backgroundColor": "#fefcff" }}>
      <div className='d-flex justify-content-between'>
        <h2 className='fs-4'>{nombre}</h2>
        <button className='btn btn-danger'><i class="bi bi-trash"></i></button>
      </div>
      <h3 className='fs-6 text-white text-start my-2 rounded-5 bg-primary p-1' style={{ "width": "fit-content" }}>{tipo}</h3>

      <p className='text-start'>Botellas de plástico transparente de agua y bebidas</p>
        <hr  className='m-0 mb-2 p-0'/>
        <div className='d-flex justify-content-around'>
          <h2 className='fs-5'>Peso:
          </h2>
          <h2 className='fs-4'>{peso} kg</h2>
        </div>
      
    </div >
  )
}



