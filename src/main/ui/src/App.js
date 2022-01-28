import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { Header } from './components/Header'
import  { DataDisplay }  from './components/DataDisplay'

function App() {
  
  return (
      <>
       <div className="container mrgnbtm">
        <Header></Header>
        <DataDisplay></DataDisplay>
      </div>
      </>
    );
}

export default App;
