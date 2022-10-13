import { useState } from "react";
import { useNavigate } from "react-router-dom";

export function Service_Pro_Update(params) {
    const navigate=useNavigate();
   
    const servProvider=JSON.parse(localStorage.getItem("loggedinuser"))
    const serv_Pro_id=servProvider.service_provider_id;
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
    const[registeredobj,setRegisteredObj]=useState({});

    const handleInput = (e)=>{
        setServPro((servPro)=>({
         ...servPro,
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
            body:JSON.stringify(servPro)
        }
        
        fetch("http://localhost:8080/updateServiceProvider/"+serv_Pro_id,requestOption).then(res=>res.json()).then(data=>console.log(data))
        navigate('/servPro_Profile')
    }

    return(
        
        <div>
            <h2 style={{color:"white"}}>Update Profile</h2>
                <form className="col-sm-3 align-center form" >
                <div className="form-group">
                <label for="exampleFormControlInput1">First Name</label>
                <input type="text" name="first_name" disabled value={servPro.first_name} className="form-control" placeholder="First Name" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Last Name</label>
                <input type="text" name="last_name" disabled value={servPro.last_name} className="form-control"  placeholder="Last Name" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Mobile Number</label>
                <input type="text" name="mobile_number" value={servPro.mobile_number} className="form-control" placeholder="Mobile Number" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Business Name </label>
                <input type="text" name="business_name" value={servPro.business_name} className="form-control" placeholder="Business Name" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Area </label>
                <input type="text" name="area" value={servPro.area} className="form-control" placeholder="Area" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">City </label>
                <input type="text" name="city" value={servPro.city} className="form-control" placeholder="City" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Pincode</label>
                <input type="text" name="pincode" value={servPro.pincode} className="form-control" placeholder="Pincode" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">State</label>
                <input type="text" name="state" value={servPro.state} className="form-control" placeholder="State" onChange={handleInput}/>
                </div>
                
                <button type="submit" className="btn btn-primary mb-2" onClick={(e)=>{submitData(e)}} >Update</button>
        </form>
        </div>
    )
}