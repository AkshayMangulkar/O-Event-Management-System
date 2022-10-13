import { useEffect, useState } from "react";
import { BrowserRouter, Link, Route, Routes, useNavigate } from "react-router-dom";
import Display_Services from "./Display_Services";
import { Home } from "./Home";
import Login from "./Login";
import '../navbar.css';
import mystore from "./Store";

export function Client_Home() {
    const[flag,setFlag]=useState();
    const navigate=useNavigate();
    useEffect(()=>{
        mystore.subscribe(()=>setFlag(mystore.getState().loggedin))
        
    })

    const Logout=()=>{
        // if (localStorage.getItem("cart").length!=0) {
        //     if (window.confirm("Your cart has some items")) {
        //         localStorage.removeItem("cart");
        //     }
        // }
        mystore.dispatch({type:'LOGGEDOUT'});
        localStorage.clear();
        navigate('/');
        
    }
    return (
        <div >
        
            
            <nav className="navbar navbar-light" >
                
                <Link className='link' to="/client_home">  Home  </Link>
                <Link className='link' to="/bookings">My Bookings  </Link>
                <Link className="link" to="/client_Profile">User : {JSON.parse(localStorage.getItem("loggedinuser")).first_name}</Link>
              
                
                <div class="d-flex justify-content-end">
                     <Link className='link' to="/cart">
                        <svg xmlns="http://www.w3.org/2000/svg" width="3rem" height="2rem" fill="currentColor" className="bi bi-cart-check-fill" viewBox="0 0 16 16">
                            <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm-1.646-7.646-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L8 8.293l2.646-2.647a.5.5 0 0 1 .708.708z"/>
                        </svg>
                        {/* {JSON.parse(localStorage.getItem("cart")).length} */}
                     </Link>
                     <button className="btn btn-danger" onClick={Logout}> Logout</button>
                </div>
                
            
            {/* <form className="form-inline my-2 my-lg-0">
            <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"></input>
            <button className="btn  my-1 my-sm-0" type="submit">Search</button>
            </form> */}

            </nav>
            {/* <Routes>
            
            <Route path="/home" element={<Home/>}></Route>
            <Route path="/login" element={<Login/>}></Route>
            

            </Routes> */}

            
            
            

            <Display_Services/>
        </div>
    );
}