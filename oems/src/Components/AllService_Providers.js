
import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import { BookingDetails } from "./Booking_Details";

export default function AllServiceProviders() {
    const[servicePro,setServicePro]=useState([]);
    const[details,setDetails]=useState({});

    useEffect(()=>{
        fetch("http://localhost:8080/getAllServiceProviders").then(resp=>resp.json()).then(data=>(setServicePro(data)))
        
    },[])

    const Details=(s)=>{
        setDetails(s);
        
    }

    return <div>
        <Link style={{float:"left",margin:"20px"}} className="link" to="/admin_home">Back to home</Link>
        <table class="table table-hover table-light">
            <thead>
                <tr>
                <th scope="col">Service_Provider Id</th>
                <th scope="col">Service Provider Name</th>
                <th scope="col">Mobile Number</th>
                <th scope="col">Area</th>
                <th scope="col">City</th>
                <th scope="col">Pincode</th>
                <th scope="col">State</th>
                </tr>
            </thead>
            {
                servicePro.map((s)=>{
                    return <>
                    <tbody>
                        <tr>
                            <th scope="row">{s.service_provider_id}</th>
                            <td>{s.first_name} {s.last_name}</td>
                            <td>{s.user_id.mobile_number}</td>
                            <td>{s.address_id.area}</td>
                            <td>{s.address_id.city}</td>
                            <td>{s.address_id.pincode}</td>
                            <td>{s.address_id.state}</td>
                        </tr>
                    </tbody>
                    </>

                })
            }
            </table>
    </div>
}