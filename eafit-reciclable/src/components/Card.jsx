
export default function Card() {
  
    return (
    <>
    <div className='rounded-3 d-flex justify-content-center d-flex flex-column text-white align-items-center shadow-md container'  style={{"width":"350px","height":"250px","backgroundColor":"#0a8d0a","cursor":"pointer"}}>
        <i className="bi bi-plus-circle-fill text-white" style={{"fontSize":"4rem","color":"#9232e0aa"}}></i>
        <h3>Agregar residuo</h3>
        <p>Registra un nuevo residuo reciclable</p>
    </div>
    </>
  )
}
