import { useEffect } from "react";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";



export function Client_Bookings(params) {
    const navigate=useNavigate();
    const[bookings,setBookings]=useState([]);
    var id=JSON.parse(localStorage.getItem("loggedinuser")).user_id.user_id;
    useEffect(()=>{
        console.log(id);
        fetch("http://localhost:8080/getAllBookingsByClient_id?Client_id="+id).then(resp=>resp.json()).then(data=>(setBookings(data)))
    },[])

    const view_Invoice=(b)=>{
        localStorage.setItem("booking",JSON.stringify(b));
        navigate("/invoice");
    }
    return <div>
        <Link style={{float:"left",margin:"20px"}} className="link" to="/client_home">Back to home</Link>
        <table class="table table-hover table-light">
            <thead>
                <tr>
                <th scope="col">Booking Id</th>
                <th scope="col">Client Name</th>
                <th scope="col">Event Date</th>
                <th scope="col">Status</th>
                <th scope="col">Total Cost</th>
                <th scope="col">Details</th>
                </tr>
            </thead>
            {
                bookings.map((b)=>{
                    return <>
                    <tbody>
                        <tr>
                            <th scope="row">{b.booking_id}</th>
                            <td>{b.client.first_name} {b.client.last_name}</td>
                            <td>{b.event_date}</td>
                            <td>{b.booking_status}</td>
                            <td>{b.total_price}</td>
                            <td><button className="btn btn-success" onClick={()=>view_Invoice(b)}>Invoice</button></td>
                            
                            {/* <td>{b.booked_services}</td> */}
                        </tr>
                    </tbody>
                    </>

                })
            }
            </table>
    </div>
    
}

