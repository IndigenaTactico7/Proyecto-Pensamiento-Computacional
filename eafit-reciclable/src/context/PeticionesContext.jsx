import axios from 'axios'
import React, { createContext, useContext, useState } from 'react'

export const PeticionesContext = createContext()
export default function PeticionesProvider({children}) {
    const [data,setData] = useState([])
    const [promedios,setPromedios] = useState({})
    const [porcentajes,setPorcentajes] = useState({})
    let getData = async () => {
        try {
            let response = await axios.get("http://localhost:8080/residuo")
            setData(response.data)
        }
        catch (error) {
            console.log(error.message);
        }
    }

    let getPromedios = async () => {
        try {
          let response = await axios.get("http://localhost:8080/residuo/promedio")
          setPromedios(response.data);
        } catch (error) {
          console.log(error.message);
        }
      }

      let getPorcentajes = async () => {
        try {
          let response = await axios.get("http://localhost:8080/residuo/porcentaje")
          setPorcentajes(response.data);
        } catch (error) {
          console.log(error.message);
        }
      }
    return (
    <PeticionesContext.Provider value={{data,setData,getData,promedios,getPromedios,getPorcentajes,porcentajes}}>
        {children}
    </PeticionesContext.Provider>
  )
}

export function usePeticiones(){
    return useContext(PeticionesContext)
}
