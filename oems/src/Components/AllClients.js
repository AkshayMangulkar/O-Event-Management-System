
import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import { BookingDetails } from "./Booking_Details";

export default function AllClients() {
    const[clients,setClients]=useState([]);
    const[details,setDetails]=useState({});

    useEffect(()=>{
        fetch("http://localhost:8080/allClients").then(resp=>resp.json()).then(data=>(setClients(data)))
        
    },[])

    const Details=(s)=>{
        setDetails(s);
        <BookingDetails id={details}/>
    }

    return <div>
        <Link style={{float:"left",margin:"20px"}} className="link" to="/admin_home">Back to home</Link>
        <table class="table table-hover table-light">
            <thead>
                <tr>
                <th scope="col">Client Id</th>
                <th scope="col">Client Name</th>
                <th scope="col">City</th>
                <th scope="col">Mobile Number</th>
                <th scope="col">Pincode</th>
                <th scope="col">State</th>
                </tr>
            </thead>
            {
                clients.map((c)=>{
                    return <>
                    <tbody>
                        <tr>
                            <th scope="row">{c.client_id}</th>
                            <td>{c.first_name} {c.last_name}</td>
                            <td>{c.city}</td>
                            <td>{c.user_id.mobile_number}</td>
                            <td>{c.pincode}</td>
                            <td>{c.state}</td>
                            {/* <td>{b.booked_services}</td> */}
                        </tr>
                    </tbody>
                    </>

                })
            }
            </table>
    </div>
}