import { useEffect, useState } from "react";
import { BrowserRouter, Link, Route, Routes, useNavigate } from "react-router-dom";
import { Home } from "./Home";
import Login from "./Login";
import RegisterService from "./Register_Service";
import "../navbar.css";
import mystore from "./Store";
import { Display_Services_Service_Pro } from "./Serv_Pro_Services";

export function Service_Provider_Home() {
    const[flag,setFlag]=useState();
    const navigate=useNavigate();
    useEffect(()=>{
        mystore.subscribe(()=>setFlag(mystore.getState().loggedin))
        
    })

    const Logout=()=>{
        mystore.dispatch({type:'LOGGEDOUT'});
        localStorage.removeItem('loggedinuser');
        navigate('/');
    }
    return (
        <div >
        
            
            <nav className="navbar navbar-light">
                
                <Link className='link' to="/home">  Home  </Link>
                <Link className='link' to="/spbookings"> Bookings  </Link>
                <Link className='link' to="/serv_pro_Services"> My Services  </Link>
                <Link className='link' to="/registerService">  Register Service  </Link>
                <Link className="link" to="/servPro_Profile">User : {JSON.parse(localStorage.getItem("loggedinuser")).first_name}</Link>
                <div class="d-flex justify-content-end">
                <button className="btn btn-danger" onClick={Logout}> Logout</button>
                </div>
            
            </nav>
           <Display_Services_Service_Pro/>
        </div>
    );
}