import { useEffect, useState } from 'react'
import MainPage from './pages/MainPage';
import axios from 'axios';
import '../src/App.css'
import ModalsProvider from './context/ModalsContext';
import PeticionesProvider, { PeticionesContext } from './context/PeticionesContext';


function App() {

  return (
    <>
      <PeticionesProvider>
        <ModalsProvider>
          <MainPage />
        </ModalsProvider>
      </PeticionesProvider>


    </>
  )
}
export default App
