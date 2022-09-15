import { useEffect, useState } from "react";
import mystore from "./Store";
import "/node_modules/bootstrap/dist/css/bootstrap.css";

function RegisterService(){
  
    const[state,setState]=useState({
      service_name:"",
      cost:"",
      description:"",
      category_id:0,
      service_provider_id:1
        
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
        fetch("http://localhost:8080/saveService",requestOption).then(res=>res.json()).then(data=>setRegisteredObj(data),setMessage("registered Successfuly !!!"))
    }

    return(<div >
       
      <div  >
        <h2 style={{"textAlign":"center"}} >Service Registration Form</h2>
        <form className="col-sm-3 align-center form">
        <div className="form-group">
          <label for="exampleFormControlInput1">Service Name</label>
          <input type="text" name="service_name" className="form-control" id="exampleFormControlInput1" placeholder="example :- Sahil Photography" onChange={handleInput}/>
        </div>
        <div className="form-group">
          <label for="exampleFormControlInput1">Cost</label>
          <input type="text" name="cost" className="form-control" id="exampleFormControlInput1" placeholder="4000 Rs" onChange={handleInput}/>
        </div>
        <div className="form-group">
          <label for="exampleFormControlSelect1">select Category</label>
          <select className="form-control" name="category_id" id="exampleFormControlSelect1" onChange={handleInput}>
            <option >--select--</option>
            <option value={1}>Hall</option>
            <option value={2}>Catering</option>
            <option value={3}>Photography</option>
            <option value={4}>Decoration</option>
            
          </select>
        </div>

        <div className="form-group">
          <label for="exampleFormControlTextarea1">Add Description</label>
          <textarea className="form-control" name="description" id="exampleFormControlTextarea1" rows="3" onChange={handleInput}></textarea>
        </div>
        <button type="submit" class="btn btn-primary mb-2" onClick={submitData}>Add</button>
  
        </form>
        <p style={{color:'white'}}>
        {JSON.stringify(state)}
        {JSON.stringify(registeredobj)} <br/>
        {message}
        
        </p>

        
        
        </div>
    </div>
        
    );
}

export default RegisterService;