import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { Header } from './components/Header'
import  { DataDisplay }  from './components/DataDisplay'

function App() {

  const [user,setUser] = useState({});
  const [users,setUsers] = useState([]);
  const [numberOfUsers,setNumberOfUsers] = useState(0);
  
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
