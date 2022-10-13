import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./errors.css"

function ServiceProviderRegister(){
    const navigate=useNavigate();
    const [fnameErr,setFnameErr]=useState(false);
    const [lnameErr,setLnameErr]=useState(false);
    const [userErr,setUserErr]=useState(false);
    const [passErr,setPassErr]=useState(false);
    const[pincodeErr,SetPincodeError]=useState(false);
    const [confirmPassErr,setConfirmPassErr]=useState(false);
    const [businessErr,setBusinessError]=useState(false);
    const[state,setState]=useState({
        mobile_number:"",
        password:"",
        first_name:"",
        last_name:"",
        business_name:"",
        area:"",
        city:"",
        state:"",
        pincode:"" 
    });
    const[registeredobj,setRegisteredObj]=useState({});

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
        fetch("http://localhost:8080/saveServiceProvider",requestOption).then(res=>res.json()).then(data=>setRegisteredObj(data))
        navigate('/')
    }

     
    function userHandler(e){
        let item=e.target.value;
        let pattern=/^[0-9]{10}$/
        setUserErr(!pattern.test(item))
        
    }
    function pincodeValidation(e){
        let item=e.target.value;
        let pattern=/^[0-9]{6}$/
        SetPincodeError(!pattern.test(item))
    }


    function fnameHandler(e){
        let item=e.target.value;
        let pattern=/^[A-Z]{1}[a-z]{1,}$/
        setFnameErr(!pattern.test(item))
       
    }

    function lnameHandler(e){
        let item=e.target.value;
        let pattern=/^[A-Z]{1}[a-z]{1,}$/
        setLnameErr(!pattern.test(item))
        
    }
    function businessHandler(e){
        let item=e.target.value;
        let pattern=/^[A-Z]{1}[a-z]{1,}$/
        setBusinessError(!pattern.test(item))
        
    }
    function passwordHandler(e){
        var item1=e.target.value;
        
        if(item1.length<8 || item1.length>12)
       {
          setPassErr(true)
       }
       else
       {
           setPassErr(false)
       }

   }

   function confirmPassword(e){
    let item=e.target.value;
    if(state.password!=item )
    {
       setConfirmPassErr(true)
    }
    else
    {
        setConfirmPassErr(false)
    }

}


    return(<div>
        <Link style={{float:"left",margin:"20px"}} className="link" to="/">Back</Link>
       <h2 style={{color:'white'}} >Service Provider Registration Form</h2>
       
        <form className="col-sm-3 align-center form" >
                <div className="form-group">
                <label for="exampleFormControlInput1">First Name</label>
                <input type="text" name="first_name" className="form-control" placeholder="First Name" onBlur={fnameHandler} onChange={handleInput}/>{fnameErr?<span className="error"> First Letter should be capital </span>:""} 
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Last Name</label>
                <input type="text" name="last_name" className="form-control"  placeholder="Last Name" onBlur={lnameHandler} onChange={handleInput}/>{lnameErr?<span className="error"> First Letter should be capital </span>:""}
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Mobile Number</label>
                <input type="number" name="mobile_number" className="form-control" placeholder="Mobile Number" onBlur={userHandler} onChange={handleInput}/>{userErr?<span className="error">Enter 10 digit valid mobile number </span>:""}  
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Business Name </label>
                <input type="text" name="business_name" className="form-control" placeholder="Business Name" onBlur={businessHandler}  onChange={handleInput}/>{businessErr?<span className="error">Business name should have alphabets only </span>:""}  
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Area </label>
                <input type="text" name="area" className="form-control" placeholder="Area" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">City </label>
                <input type="text" name="city" className="form-control" placeholder="City" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Pincode</label>
                <input type="number" name="pincode" className="form-control" placeholder="Pincode" onBlur={pincodeValidation} onChange={handleInput}/>{pincodeErr?<span className="error">Pincode Should be 6 digit number </span>:""}
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">State</label>
                <input type="text" name="state" className="form-control" placeholder="State" onChange={handleInput}/>
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Password</label>
                <input type="password" name="password" className="form-control" placeholder="Password" onBlur={passwordHandler} onChange={handleInput}/> {passErr?<span className="error">Password Length Should be 8 to 12 </span>:""}
                </div>
                <div className="form-group">
                <label for="exampleFormControlInput1">Password</label>
                <input type="password" name="password" className="form-control" placeholder="Password" onBlur={confirmPassword}/>{confirmPassErr?<span className="error"> Password did not match </span>:""}
                </div>
                <button type="submit" class="btn btn-primary mb-2" onClick={submitData}>Register</button>
        </form>
        <br/>
        
    </div>);
}

export default ServiceProviderRegister;