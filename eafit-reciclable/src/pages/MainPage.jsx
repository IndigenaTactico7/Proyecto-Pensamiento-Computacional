import React, { useContext, useEffect, useState } from "react";

import Card from '../components/Card'
import CardMaterial from '../components/CardMaterial'
import ModalCreateMaterial from '../components/ModalCreateMaterial'
import axios from "axios";
import ModalDeleteMaterial from "../components/ModalDeleteMaterial";
import { useModals } from "../context/ModalsContext";
import ModalEditMaterial from "../components/ModalEditMaterial";

export default function MainPage() {

    let [datos, setDatos] = useState([])
    let { showModalCreate, setShowModalCreate, showModalDelete, setShowModalDelete , showModalEdit, setShowModalEdit} = useModals()


    let getDatos = async () => {
        try {
            let response = await axios.get("http://localhost:8080/residuo")
            setDatos(response.data)
            console.log(response.data);
        }
        catch (error) {
            console.log(error.message);
        }
    }

    useEffect(() => {
        getDatos()
    }, [showModalCreate])
    return (
        <>
            <div className='container '>
                <h1><i className="bi bi-recycle text-success" ></i> Bienvenido al gestor de materiales</h1>
                <p className='text-secondary fw-light fs-3'>Administra tus materiales </p>
                <div className='row row-cols-2 row-cols-md-3'>
                    <div className='col mt-3' onClick={() => setShowModalCreate(true)}>
                        <Card />
                    </div>

                    {datos.map((dato, i) => (
                        <div className='col mt-3' key={i}>
                            <CardMaterial dato={dato} id={i} />
                        </div>

                    ))}

                </div>

            </div>
            <ModalCreateMaterial isOpen={showModalCreate} onClose={(() => setShowModalCreate(false))} />
            <ModalDeleteMaterial isOpen={showModalDelete} onClose={(() => setShowModalDelete(false))} />
                <ModalEditMaterial isOpen={showModalEdit} onClose={(()=>setShowModalEdit(false))}/>

        </>
    )
}
