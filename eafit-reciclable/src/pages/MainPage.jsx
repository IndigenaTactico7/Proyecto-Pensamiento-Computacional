import React, { useEffect, useState } from "react";

import Card from '../components/Card'
import CardMaterial from '../components/CardMaterial'
import ModalCreateMaterial from '../components/ModalCreateMaterial'
import axios from "axios";


export default function MainPage() {
    const [showModal, setShowModal] = useState(false)
let [datos,setDatos] = useState([])

let getDatos = async () => {
try{
    let response = await axios.get("http://localhost:8080/residuo")
    setDatos(response.data)
}
catch(error){
    console.log(error.message);
}
}

useEffect(()=>{
    getDatos()
},[showModal])
    return (
        <>
            <div className='container '>
                <h1><i class="bi bi-recycle text-success" ></i> Bienvenido al gestor de materiales</h1>
                <p className='text-secondary fw-light fs-3'>Administra tus materiales </p>
                <div className='row row-cols-2 row-cols-md-3'>
                    <div className='col mt-3' onClick={()=>setShowModal(true)}>
                        <Card/>
                    </div>

                    {datos.map((dato,i) => (
                        <div className='col mt-3' key={i}>
                            <CardMaterial dato={dato}/>
                        </div>

                    ))}

                </div>

            </div>
                    <ModalCreateMaterial isOpen={showModal} onClose={(()=>setShowModal(false))}/>
 
        </>
    )
}
