import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import RegistrationForm from "../Register";
import Login from "./Login";
import { Client_Home } from "./Client_Home";
import { useEffect, useState } from "react";
import mystore from "./Store";
import { Service_Provider_Home } from "./Service_Provider_Home";
import RegisterService from "./Register_Service";
import Display_Services from "./Display_Services";

import ServiceProviderRegister from "./Register_Service_Provider";
import RegisterClient from "./RegisterClient";
import Cart from "./Cart";
import { Admin_Home } from "./Admin_Home";
import AllBookings from "./AllBooking";
import { Client_Bookings } from "./Client_Booking";
import { Service_Provider_Bookings } from "./Service_pro_Bookings";
import AllClients from "./AllClients";
import AllServiceProviders from "./AllService_Providers";
import { Display_Services_Service_Pro } from "./Serv_Pro_Services";
import EditService from "./EditComponents/Service_Edit";
import { Serv_Pro_Profile } from "./Serv_Pro_Profile";
import { Service_Pro_Update } from "./EditComponents/Serv_Pro_Edit";
import { Client_Profile } from "./Client_Profile";
import { Client_Update } from "./EditComponents/Client_Edit";
import { Invoice } from "./EditComponents/invoice";


export function Home() {

    const[flag,setFlag]=useState();
  useEffect(()=>{
      mystore.subscribe(()=>setFlag(mystore.getState().loggedin))
  })
    return (
    
    <div align="center">
    
    <h1 style={{color:"white",padding:"10px"}}><u>O</u>nline <u>E</u>vent <u>M</u>anagement <u>S</u>ystem</h1>
    
    <nav className="navbar " style={{display:flag?'none':'inline-list-item'}} >
        
            {/* <Link className='btn btn-primary' to="/home">  Home  </Link>
            
            <Link className='btn btn-primary' to="/registerclient">  Register client  </Link>
            <Link className='btn btn-primary' to="/registersp">  Register Service Provider  </Link> */}
            
            {/* <div class="d-flex justify-content-end">
                    <Link className='btn btn-primary' to="/login">  Login  </Link>
            </div> */}
            
    
    </nav>
    
    <Routes>
         
         <Route path="/" element={<Login/>}></Route>
         <Route path="/registerclient" element={<RegisterClient/>}></Route>
         <Route path="/registersp" element={<ServiceProviderRegister/>}></Route>
         <Route path="/client_home" element={<Client_Home/>}></Route>
         <Route path="/serviceProvider_home" element={<Service_Provider_Home/>}></Route>
         <Route path="/registerService" element={<RegisterService/>}></Route>
         <Route path="/cart" element={<Cart/>}></Route>
         <Route path="/admin_home" element={<Admin_Home/>}></Route>
         <Route path="/allbookings" element={<AllBookings/>}></Route>
         <Route path="/bookings" element={<Client_Bookings/>}></Route>
         <Route path="/spbookings" element={<Service_Provider_Bookings/>}></Route>
         <Route path="/allClients" element={<AllClients/>}></Route>
         <Route path="/allService_Pro" element={<AllServiceProviders/>}></Route>
         <Route path="/serv_pro_Services" element={<Display_Services_Service_Pro/>}></Route>
         <Route path="/edit_Service" element={<EditService/>}></Route>
         <Route path="/servPro_Profile" element={<Serv_Pro_Profile/>}></Route>
         <Route path="/servPro_update" element={<Service_Pro_Update/>}></Route>
         <Route path="/client_Profile" element={<Client_Profile/>}></Route>
         <Route path="/client_update" element={<Client_Update/>}></Route>
         <Route path="/invoice" element={<Invoice/>}></Route>
       </Routes>
        
        
        
    </div>
    
    );
    
}