import { Alert } from "bootstrap";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

export function Client_Update(params) {
    const navigate=useNavigate();
   
    const client=JSON.parse(localStorage.getItem("loggedinuser"))
    const client_id=client.client_id;
    const[clientObject,setClientObject]=useState({
        mobile_number:client.user_id.mobile_number,
        first_name:client.first_name,
        last_name:client.last_name,
        city:client.city,
        state:client.state,
        pincode:client.pincode
    })
    const[registeredobj,setRegisteredObj]=useState({});

    const handleInput = (e)=>{
        setClientObject((clientObject)=>({
         ...clientObject,
         [e.target.name]:e.target.value
        }));
    }


    const submitData = (e)=>{
        e.preventDefault();
        const requestOption= {
            method:"PUT",
            headers:{
                'content-type':'application/json'
            },
            body:JSON.stringify(clientObject)
        }
        
        fetch("http://localhost:8080/updateClient/"+client_id,requestOption).then(res=>res.json()).then(data=>{
            if (data) {
                localStorage.setItem("loggedinuser",JSON.stringify(data))
                navigate('/client_Profile')
            }
        })
        
    }

    return(
        
        <div>
            
            <h2 style={{color:"white"}}>Update Profile</h2>
                <form className="col-sm-3 align-center form" >
                <div className="form-group">
                <label for="exampleFormControlInput1">First Name</label>
                <input type="text" name="first_name" disabled value={clientObject.first_name} className="form-control" placeholder="First Name" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Last Name</label>
                <input type="text" name="last_name" disabled value={clientObject.last_name} className="form-control"  placeholder="Last Name" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Mobile Number</label>
                <input type="text" name="mobile_number" value={clientObject.mobile_number} className="form-control" placeholder="Mobile Number" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">City </label>
                <input type="text" name="city" value={clientObject.city} className="form-control" placeholder="City" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Pincode</label>
                <input type="text" name="pincode" value={clientObject.pincode} className="form-control" placeholder="Pincode" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">State</label>
                <input type="text" name="state" value={clientObject.state} className="form-control" placeholder="State" onChange={handleInput}/>
                </div>
                
                <button type="submit" className="btn btn-primary mb-2" onClick={(e)=>{submitData(e)}} >Update</button>
        </form>
        </div>
    )
}