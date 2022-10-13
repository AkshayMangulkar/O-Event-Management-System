import {  useState } from "react"
import { Link, useNavigate } from "react-router-dom";

export function Serv_Pro_Profile() {
    const navigate =useNavigate();
    const servProvider=JSON.parse(localStorage.getItem("loggedinuser"))
    const[servPro,setServPro]=useState({
        mobile_number:servProvider.user_id.mobile_number,
        first_name:servProvider.first_name,
        last_name:servProvider.last_name,
        business_name:servProvider.business_name,
        area:servProvider.address_id.area,
        city:servProvider.address_id.city,
        state:servProvider.address_id.state,
        pincode:servProvider.address_id.pincode
    })
    const Update=()=>{
        navigate("/servPro_update")
    }
    return (<div >
        <Link style={{float:"left",margin:"20px"}} className="link" to="/serviceProvider_home">Back to home</Link>
        <div className="card " style={{width:'25rem'}} >
            
                                <div className="card-body">
                                    <h5 className="card-title">Mr/mrs. {servPro.first_name} {servPro.last_name}</h5>
                                    <p className="card-text">Mobile Number :<b>{servPro.mobile_number}</b></p>
                                    <p className="card-text">Business Name :<b> {servPro.business_name}</b></p>
                                </div>
                                <ul className="list-group list-group-flush">
                                    <li className="list-group-item">Area : {servPro.area} </li>
                                    <li className="list-group-item">City : {servPro.city}</li>
                                    <li className="list-group-item">Pincode : {servPro.pincode}</li>
                                    <li className="list-group-item">State : {servPro.state}</li>
                                </ul>
                                <div className="card-body">
                                    <button className="btn btn-primary" onClick={()=>{Update()}}>Edit Profile</button>
                                </div>
                        </div>
    </div>);

}