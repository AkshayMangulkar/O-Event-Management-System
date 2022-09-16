import { useEffect, useState } from "react";
import { BrowserRouter, Link, Route, Routes, useNavigate } from "react-router-dom";
import { Home } from "./Home";
import Login from "./Login";

import mystore from "./Store";

export function Service_Provider_Home() {
    const[flag,setFlag]=useState();
    const navigate=useNavigate();
    useEffect(()=>{
        mystore.subscribe(()=>setFlag(mystore.getState().loggedin))
        
    })

    const Logout=()=>{
        mystore.dispatch({type:'LOGGEDOUT'});
        localStorage.removeItem('loggedinuser');
        navigate('/login');
    }
    return (
        <div >
        
            
            <nav className="navbar navbar-light" style={{'backgroundColor': '#e3f2fd'}}>
                
                <Link className='nav-item' to="/home">  Home  </Link>
                <Link className='nav-item' to="/bookings"> Bookings  </Link>
                <Link className='nav-item' to="/registerService">  Register Service  </Link>
                
                <div class="d-flex justify-content-end">
                    <button className="btn btn-primary" onClick={Logout}> Logout</button>
                </div>
            
            </nav>
            <Routes>
            
            <Route path="/home" element={<Home/>}></Route>
            <Route path="/login" element={<Login/>}></Route>
            <Route path="/registerService" element={<Login/>}></Route>

            </Routes>

            
            
            <h1 >Welcome Mr/Mrs {JSON.parse(localStorage.getItem("loggedinuser")).first_name}</h1>
        </div>
    );
}