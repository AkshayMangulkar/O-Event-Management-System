import { useState } from "react"
import { Link } from "react-router-dom"

export function Invoice() {
    const booking=JSON.parse(localStorage.getItem("booking"))

    return <div>
        <div >
        {/* <Link style={{float:"left",margin:"20px"}} className="link" to="/client_home">Back to home</Link> */}
        <h1 style={{color:"white"}}>Invoice</h1>
        <div className="card " style={{width:'25rem'}} >
            
                                <div className="card-body">
                                    <h5 className="card-title">Booking Id : {booking.booking_id}</h5>
                                    <h5 className="card-title">Status : {booking.booking_status}</h5>
                                    <p className="card-text">Client Name :<b>{booking.client.first_name} {booking.client.last_name}</b></p>
                                    
                                </div>
                                <ul className="list-group list-group-flush">
                                    <li className="list-group-item"><b>Service_Name Cost</b></li>
                                    <li className="list-group-item">{booking.booked_services[0].service_name} {booking.booked_services[0].cost}</li>
                                </ul>
                                <div className="card-body">
                                    <h4 className="card-text">Total Price :<b>{booking.total_price}</b></h4>
                                </div>
                        </div>
    </div>
    </div>
}