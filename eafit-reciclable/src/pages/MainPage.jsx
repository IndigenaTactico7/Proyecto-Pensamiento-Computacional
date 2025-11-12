import React, { useContext, useEffect, useState } from "react";

import Card from '../components/Card'
import CardMaterial from '../components/CardMaterial'
import ModalCreateMaterial from '../components/ModalCreateMaterial'
import PromedioCard from '../components/PromedioCard'
import axios from "axios";
import ModalDeleteMaterial from "../components/ModalDeleteMaterial";
import { useModals } from "../context/ModalsContext";
import ModalEditMaterial from "../components/ModalEditMaterial";
import { usePeticiones } from "../context/PeticionesContext";

export default function MainPage() {
    let { showModalCreate, setShowModalCreate, showModalDelete, setShowModalDelete, showModalEdit, setShowModalEdit } = useModals()
    let { getData, data, promedios, getPromedios, getPorcentajes, porcentajes } = usePeticiones()
    console.log(porcentajes);

    useEffect(() => {
        getData()
        getPromedios()
        getPorcentajes()
    }, [])

    const descargarTXT = () => {
        const texto = `
=== REPORTE DE RESIDUOS ===

--- PROMEDIOS ---
Electrónico: ${promedios.electronico}kg
Inorgánico: ${promedios.inorganico}kg
No aprovechable: ${promedios.noAprovechable}kg
Orgánico: ${promedios.organico}kg
Peligroso: ${promedios.peligroso}kg
Reciclable: ${promedios.reciclable}kg

--- PORCENTAJES ---
Reciclaje: ${porcentajes.reciclaje}%
Compostaje: ${porcentajes.compostaje}%
Disposición especial: ${porcentajes.disposicionEspecial}%

`
        const blob = new Blob([texto], { type: "text/plain" });
        const url = URL.createObjectURL(blob);
        const a = document.createElement("a");
        a.href = url;
        a.download = "Reporte de residuos.txt";
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
        URL.revokeObjectURL(url);
    };


    return (
        <>
            <div className='container '>
                <h1><i className="bi bi-recycle text-success" ></i> Bienvenido al gestor de residuos</h1>
                <p className='text-secondary fw-light fs-3'>Administra tus residuos </p>
                <div className='row row-cols-2 row-cols-md-3'>
                    <div className='col mt-3' onClick={() => setShowModalCreate(true)}>
                        <Card />
                    </div>

                    {data.map((dato, i) => (
                        <div className='col mt-3' key={i}>
                            <CardMaterial dato={dato} id={i} />
                        </div>

                    ))}

                </div>
                <div className="mt-5">
                    <h2 className="my-3">Reporte</h2>
                    <div className="bg-white p-5 rounded-5">
                        <h3 className="mb-3">Promedios</h3>
                        <div className="d-flex flex-wrap row-cols-md-1 row-cols-lg-3 justify-content-center">
                            <div className="col mb-4" >
                                <PromedioCard icon={"bi bi-clipboard-data-fill"} color={"blue"} tipo={"Electronico"} texto={"Peso promedio:"} signo={"kg"} valorPromedio={promedios.electronico} />
                            </div>
                            <div className="col mb-4">
                                <PromedioCard icon={"bi bi-clipboard-data-fill"} color={"#bbbe04"} tipo={"Inorganico"} texto={"Peso promedio:"} signo={"kg"} valorPromedio={promedios.inorganico} />
                            </div>
                            <div className="col mb-4">
                                <PromedioCard icon={"bi bi-clipboard-data-fill"} color={"gray"} tipo={"No aprovechable"} texto={"Peso promedio:"} signo={"kg"} valorPromedio={promedios.noAprovechable} />
                            </div>
                            <div className="col mb-4">
                                <PromedioCard icon={"bi bi-clipboard-data-fill"} color={"green"} tipo={"Organico"} texto={"Peso promedio:"} signo={"kg"} valorPromedio={promedios.organico} />
                            </div>
                            <div className="col mb-4">
                                <PromedioCard icon={"bi bi-clipboard-data-fill"} color={"red"} tipo={"Peligroso"} texto={"Peso promedio:"} signo={"kg"} valorPromedio={promedios.peligroso} />
                            </div>
                            <div className="col mb-4">
                                <PromedioCard icon={"bi bi-clipboard-data-fill"} color={"lightBlue"} tipo={"Reciclable"} texto={"Peso promedio:"} signo={"kg"} valorPromedio={promedios.reciclable} />
                            </div>
                        </div>
                        <hr />
                        <h3>Porcentajes</h3>
                        <div className="d-flex row-cols-3">

                            <div className="col mb-4">
                                <PromedioCard icon={"bi bi-percent"} color={"green"} texto={"Porcentaje:"} tipo={"Reciclaje"} signo={"%"} valorPromedio={porcentajes.reciclaje} />
                            </div>
                            <div className="col mb-4">
                                <PromedioCard icon={"bi bi-percent"} color={"#bbbe04"} texto={"Porcentaje:"} tipo={"Compostaje"} signo={"%"} valorPromedio={porcentajes.compostaje} />
                            </div>
                            <div className="col mb-4">
                                <PromedioCard icon={"bi bi-percent"} color={"gray"} texto={"Porcentaje:"} tipo={"Disposición especial"} signo={"%"} valorPromedio={porcentajes.disposicionEspecial} />
                            </div>
                        </div>
                        <button className="btn btn-primary" onClick={descargarTXT}>Descargar reporte</button>
                    </div>
                </div>

            </div>
            <ModalCreateMaterial isOpen={showModalCreate} onClose={(() => setShowModalCreate(false))} />
            <ModalDeleteMaterial isOpen={showModalDelete} onClose={(() => setShowModalDelete(false))} />
            <ModalEditMaterial isOpen={showModalEdit} onClose={(() => setShowModalEdit(false))} />


        </>
    )
}
