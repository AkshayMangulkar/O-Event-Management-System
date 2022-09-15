import { useState } from "react";
import "/node_modules/bootstrap/dist/css/bootstrap.css";

function RegisterClient(){
    const[state,setState]=useState({
        mobile_number:"",
        password:"",
        first_name:"",
        last_name:"",
        city:"",
        state:"",
        pincode:"",
        
    });
    const[registeredobj,setRegisteredObj]=useState({});
    const[message,setMessage]=useState("");
    const handleInput = (e)=>{
        setState((state)=>({
         ...state,
         [e.target.name]:e.target.value
        }));
    }


    const submitData = (e)=>{
        e.preventDefault();
        const requestOption= {
            method:"post",
            headers:{
                'content-type':'application/json'
            },
            body:JSON.stringify(state)
        }
        fetch("http://localhost:8080/clients",requestOption).then(res=>res.json()).then(data=>setRegisteredObj(data),setMessage("registered Successfuly !!!"))
    }

    return(<div>
        <h2 style={{color:'white'}}>Registration Form</h2>
        <form>
            <input type="text" name="first_name" placeholder="First Name" onChange={handleInput}/> <br/> <br/>

            <input type="text" name="last_name" placeholder="Last Name" onChange={handleInput}/> <br/> <br/>

            <input type="text" name="city" placeholder="City" onChange={handleInput}/> <br/> <br/>

            <input type="text" name="state" placeholder="State" onChange={handleInput}/> <br/> <br/>

            <input type="number" name="pincode" placeholder="Pincode" onChange={handleInput}/> <br/> <br/>

            <input type="number" name="mobile_number" placeholder="User Id/Mobile No"  onChange={handleInput}/> <br/> <br/> 

            <input type="password" name="password" placeholder="Password" onChange={handleInput}/> <br/> <br/>

            <input type="submit" value="REGISTER" onClick={submitData}/> <br/>
            
        </form>
        <p style={{color:'white'}}>
        {JSON.stringify(registeredobj)} <br/>
        {message}
        </p>
        
        
    </div>);
}

export default RegisterClient;