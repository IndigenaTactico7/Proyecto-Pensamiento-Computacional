import React, { createContext, useContext, useState } from 'react'

export const ModalsContext = createContext()

export default function ModalsProvider({ children }) {

    const [showModalCreate, setShowModalCreate] = useState(false)
    const [showModalDelete, setShowModalDelete] = useState(false)
    const [showModalEdit, setShowModalEdit] = useState(false)
    const [idCard, setIdCard] = useState("")
    const [formInfo,setFormInfo] = useState([])

    return (
        <ModalsContext.Provider value={{ showModalCreate, setShowModalCreate, showModalDelete, setShowModalDelete, idCard, setIdCard, showModalEdit, setShowModalEdit,formInfo,setFormInfo }}>
            {children}
        </ModalsContext.Provider>
    )
}
export function useModals() {
    return useContext(ModalsContext)
}