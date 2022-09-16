
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";


import mystore from "./Store.js";







const Login = (props)=>{
    const[flag,setFlag]=useState();
  useEffect(()=>{
      mystore.subscribe(()=>setFlag(mystore.getState().loggedin))
      
  })
  const navigate=useNavigate();
  
    const[state,setState]=useState({
        mobile_number:"",
        password:"",
        loginerror:"",
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
                
                navigate('/serviceProvider_home');
            }
            else{
                setState({loginerror: "Wrong ID/pwd"})
            }
            
        }
        else
        {
            setState({loginerror: "Wrong ID/pwd"})
            
        }
       
            
    })
    }
    return(<div>
        <form style={{display:flag?'none':'block'}}>
        
            <input type="number" name="mobile_number" placeholder="Enter Mobile Number" onChange={handleInput} /> <br/> <br/>

    
            <input type="password" name="password" placeholder="Enter Password" onChange={handleInput} /> <br/> <br/>

         

            <input type="submit" value="LOGIN" onClick={submitData} />
            
        </form>
        <div >
                {JSON.stringify(state.loginerror)}
            </div>
        
    </div>);
}

export default Login;