import { useEffect, useState } from 'react'
import MainPage from './pages/MainPage';
import axios from 'axios';
import '../src/App.css'
import ModalsProvider from './context/ModalsContext';


function App() {
 
  let promedios = async ()=>{
    try{
      let response = await axios.get("http://localhost:8080/residuo/promedio")
      console.log(response.data);
    }catch(error){
      console.log(error.message);
    }
  }

  useEffect(()=>{
    promedios()
  },[])

  return (
    <>
    <ModalsProvider>
       <MainPage/>
    </ModalsProvider>
   
    </>
  )
}
export default App
