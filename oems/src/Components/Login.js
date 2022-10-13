
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";


import mystore from "./Store.js";


import '../Login.css';




const Login = (props)=>{
    const[flag,setFlag]=useState();
  useEffect(()=>{
      mystore.subscribe(()=>setFlag(mystore.getState().loggedin))
      
  })
  const navigate=useNavigate();
  
    const[state,setState]=useState({
        mobile_number:"",
        password:"",
        loginerror:false,
        Client:"",
        Service_Provider:"",
        Admin:""
        
    });
    
    
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
        fetch("http://localhost:8080/checkLogin",requestOption)
        .then(resp=>resp.text())
        .then(data=>{ if(data.length!==0)
            {
            const json = JSON.parse(data);
            if(json.user_id.user_type =="Clients"){
                setState({Client:json});
                localStorage.setItem("loggedinuser",JSON.stringify(json));
                mystore.dispatch({type:'LOGGEDIN'})
                navigate('/client_home');
            }
            
            else if(json.user_id.user_type =="Service_Provider")
            {
                setState({Service_Provider:json});
                localStorage.setItem("loggedinuser",JSON.stringify(json))
                
                mystore.dispatch({type:'LOGGEDIN'})
                
                navigate('/serviceProvider_home');
            }
            else if(json.user_type =="Admin")
            {
                setState({Admin:json});
                localStorage.setItem("loggedinuser",JSON.stringify(json))
                
                mystore.dispatch({type:'LOGGEDIN'})
                
                navigate('/admin_home');
            }
            else{
                setState({loginerror:true})
            }
            
        }
        else
        {
            setState({loginerror: true})
        }
       
            
    })
    }
    return(<div className="login-box">
            <form style={{display:flag?'none':'block'}}>
            <div className="user-box">
                <input type="text" name="mobile_number" placeholder="Enter Mobile Number" onChange={handleInput} />
                <label>Username</label>
            </div>
            

            <div class="user-box">
                <input type="password" name="password" placeholder="Enter Password" onChange={handleInput} />
                <label>Password</label>
            </div>
         
            <div style={{display:state.loginerror?'block':'none'}} >
                <p className="text-warning">Incorrect LoginId or Password</p>
            </div>
            {/* <input type="submit" value="LOGIN" onClick={submitData} /> */}
            <a href="" style={{color: "white"}} onClick={submitData}>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Submit
            </a>
            <p>
                <a href="/registerclient" style={{color:'aqua'}}>Register Client ?</a> <br/>
                <a href="/registersp" style={{color:'aqua'}}>Register Service Provider ?</a>
            </p>
            
        </form>
        
        
    </div>);
}

export default Login;