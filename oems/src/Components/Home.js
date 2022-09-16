import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import RegistrationForm from "../Register";
import Login from "./Login";
import { Client_Home } from "./Client_Home";
import { useEffect, useState } from "react";
import mystore from "./Store";
import { Service_Provider_Home } from "./Service_Provider_Home";
export function Home() {

    const[flag,setFlag]=useState();
  useEffect(()=>{
      mystore.subscribe(()=>setFlag(mystore.getState().loggedin))
  })
    return (
    
    <div align="center">
    
    
    <nav className="navbar " style={{display:flag?'none':'inline-list-item'}} >
        
            <Link className='btn btn-primary' to="/home">  Home  </Link>
            <Link className='btn btn-primary' to="/login">  Login  </Link>
            <Link className='btn btn-primary' to="/registerclient">  Register client  </Link>
            <Link className='btn btn-primary' to="/registersp">  Register Service Provider  </Link>

        
        
        <form className="form-inline my-2 my-lg-0">
        <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"></input>
        <button className="btn  my-1 my-sm-0" type="submit">Search</button>
        </form>
    
    </nav>
      <Routes>
         
          <Route path="/login" element={<Login/>}></Route>
          <Route path="/registerclient" element={<RegistrationForm/>}></Route>
          <Route path="/client_home" element={<Client_Home/>}></Route>
          <Route path="/serviceProvider_home" element={<Service_Provider_Home/>}></Route>
        </Routes>
    </div>
    
    );
    
}