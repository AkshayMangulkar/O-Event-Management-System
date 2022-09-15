import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import RegistrationForm from "../Register";
import Login from "./Login";
import { Client_Home } from "./Client_Home";
import { useEffect, useState } from "react";
import mystore from "./Store";
export function Home() {

    const[flag,setFlag]=useState();
  useEffect(()=>{
      mystore.subscribe(()=>setFlag(mystore.getState().loggedin))
  })
    return (
    <BrowserRouter>
    <div align="center">
    
    
    <nav className="navbar navbar-light" style={{'backgroundColor': '#e3f2fd'}}>
        
            <Link className='nav-item' to="/home">  Home  </Link>
            <Link className='nav-item' to="/login">  Login  </Link>
            <Link className='nav-item' to="/registerclient">  Register client  </Link>
            <Link className='nav-item' to="/registersp">  Register Service Provider  </Link>

        
        
        <form className="form-inline my-2 my-lg-0">
        <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"></input>
        <button className="btn  my-1 my-sm-0" type="submit">Search</button>
        </form>
    
    </nav>
      <Routes>
         
          <Route path="/login" element={<Login/>}></Route>
          <Route path="/registerclient" element={<RegistrationForm/>}></Route>
          
        </Routes>
    </div>
    </BrowserRouter>
    );
    
}