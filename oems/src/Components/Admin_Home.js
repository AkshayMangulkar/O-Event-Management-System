import { useEffect, useState } from "react";
import { BrowserRouter, Link, Route, Routes, useNavigate } from "react-router-dom";
import { Home } from "./Home";
import Login from "./Login";
import "../navbar.css";
import mystore from "./Store";
import AllBookings from "./AllBooking";

export function Admin_Home() {
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
        
            
            <nav className="navbar" >
                
                <Link className='link' to="/admin_home">  Home  </Link>
                <Link className='link' to="/allbookings"> Bookings  </Link>
                <Link className='link' to="/allClients"> All Clients  </Link>
                <Link className='link' to="/allService_Pro"> All Service Providers  </Link>
                <Link className='link' to="/admin_home">  User : Admin  </Link>
                <div class="d-flex justify-content-end">
                    <button className="btn btn-danger" onClick={Logout}> Logout</button>
                    {/* <button type="button" class="btn btn-outline-danger" onClick={Logout}>Logout</button> */}
                </div>
            {/* <form className="form-inline my-2 my-lg-0">
            <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"></input>
            <button className="btn  my-1 my-sm-0" type="submit">Search</button>
            </form> */}

            </nav>
            <Routes>
            <Route path="/allbookings" element={<AllBookings/>}></Route>
            </Routes>

            
            
            {/* <h1 style={{color:"white"}} >Welcome Admin {JSON.parse(localStorage.getItem("loggedinuser")).first_name}</h1> */}
        </div>
    );
}