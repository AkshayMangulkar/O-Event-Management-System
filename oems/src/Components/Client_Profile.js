import { useState } from "react"
import { Link, useNavigate } from "react-router-dom";

export function Client_Profile() {
    const navigate =useNavigate();
    const client=JSON.parse(localStorage.getItem("loggedinuser"))
    const[clientObject,setClientObject]=useState({
        mobile_number:client.user_id.mobile_number,
        first_name:client.first_name,
        last_name:client.last_name,
        city:client.city,
        state:client.state,
        pincode:client.pincode
    })
    const Update=()=>{
        navigate("/client_update")
    }
    return (<div >
        <Link style={{float:"left",margin:"20px"}} className="link" to="/client_home">Back to home</Link>
        <h1 style={{color:"white"}}>Profile</h1>
        <div className="card " style={{width:'25rem'}} >
            
                                <div className="card-body">
                                    <h5 className="card-title">Mr/mrs. {clientObject.first_name} {clientObject.last_name}</h5>
                                    <p className="card-text">Mobile Number :<b>{clientObject.mobile_number}</b></p>
                                    
                                </div>
                                <ul className="list-group list-group-flush">
                                    <li className="list-group-item">City : {clientObject.city}</li>
                                    <li className="list-group-item">Pincode : {clientObject.pincode}</li>
                                    <li className="list-group-item">State : {clientObject.state}</li>
                                </ul>
                                <div className="card-body">
                                    <button className="btn btn-primary" onClick={()=>{Update()}}>Edit Profile</button>
                                </div>
                        </div>
    </div>);

}