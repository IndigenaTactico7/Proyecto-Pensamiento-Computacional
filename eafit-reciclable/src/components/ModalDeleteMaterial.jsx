import React from 'react'
import { useModals } from '../context/ModalsContext';
import axios from 'axios';

export default function ModalDeleteMaterial({ isOpen, onClose}) {
    if (!isOpen) return null;
    let {idCard} = useModals()
    
    let eliminarResiduo = async (id)=>{
        try{
            let response = await axios.delete(`http://localhost:8080/residuo/${id}`,{
                headers: {
                    "Content-Type": "application/json"
                }    
            })

            console.log(response);
        }catch(error){
            console.log(error.message);
        }
    }

    return (
        <>
            <div className='position-fixed top-0 start-0 w-100 h-100 bg-dark bg-opacity-50' style={{ zIndex: "100" }} onClick={onClose}></div>
                <div className='position-fixed top-50 start-50 translate-middle bg-white w-25 p-2 rounded-3' style={{zIndex:"1000"}}>
                    <h2 className='text-black text-break mt-3'>¿Esta seguro que quiere eliminar este residuo?</h2>
                    <div className='d-flex flex-row gap-3 justify-content-center my-3'>
                        <button className='btn btn-danger text-white' onClick={()=>eliminarResiduo(idCard)}>Eliminar</button>
                        <button className='btn btn-primary text-white' onClick={onClose}>Cancelar</button>
                    </div>

                </div>
            
        </>
    )
}
