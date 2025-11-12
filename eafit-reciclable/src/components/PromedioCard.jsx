import React from 'react'

export default function PromedioCard({icon, color, tipo, valorPromedio ,texto, signo }) {
    return (
        <>
            <div className='rounded-3 d-flex justify-content-center d-flex flex-column text-white align-items-center shadow-md container' style={{ "width": "250px", "height": "150px", "backgroundColor": color }}>
                <i className={`${icon} text-white fs-2`} style={{ "fontSize": "4rem", "color": "#9232e0aa" }}></i>
                <h3>{tipo}</h3>
                <p>{texto} {valorPromedio}{signo}</p>
            </div>
        </>
    )
}
