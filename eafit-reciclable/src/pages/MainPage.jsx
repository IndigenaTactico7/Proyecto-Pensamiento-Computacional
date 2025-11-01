import React from 'react'
import Card from '../components/Card'
import CardMaterial from '../components/CardMaterial'

let datos = [{
  "nombre":"botella pet",
  "material":"plastico",
  "descripcion":"Botellas de plástico transparente de agua y bebidas",
  "peso":"250"
},{"nombre":"botella pet",
  "material":"plastico",
  "descripcion":"Botellas de plástico transparente de agua y bebidas",
  "peso":"250"},{"nombre":"botella pet",
  "material":"plastico",
  "descripcion":"Botellas de plástico transparente de agua y bebidas",
  "peso":"250"},{"nombre":"botella pet",
  "material":"plastico",
  "descripcion":"Botellas de plástico transparente de agua y bebidas",
  "peso":"250"},{"nombre":"botella pet",
  "material":"plastico",
  "descripcion":"Botellas de plástico transparente de agua y bebidas",
  "peso":"250"},{"nombre":"botella pet",
  "material":"plastico",
  "descripcion":"Botellas de plástico transparente de agua y bebidas",
  "peso":"250"}


]



export default function MainPage() {
    return (
        <>
            <div className='container mainBackground'>

                <h1><i class="bi bi-recycle text-success" ></i> Bienvenido al gestor de materiales</h1>
                <p className='text-secondary fw-light fs-3'>Administra tus materiales </p>
                <div className='row row-cols-2 row-cols-md-3 justify-content-between'>
                    <div className='col mt-3'>
                        <Card />
                    </div>

                    {datos.map((i) => (
                        <div className='col mt-3' key={i}>
                            <CardMaterial />
                        </div>

                    ))}


                </div>

            </div>
        </>
    )
}
