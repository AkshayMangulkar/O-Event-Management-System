
import {  useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import mystore from "./Store";


function RegisterService(){
    const navigate=useNavigate();
    let[flag,setFlag]=useState(true);
    const[state,setState]=useState({
      service_name:"",
      cost:"",
      description:"",
      category_id:0,
      service_provider_id:0
      
    });
    const[picture,setPicture]=useState();
    const[service_id,setService_id]=useState();
    const[message,setMessage]=useState("");
    const handleInput = (e)=>{
        setState((state)=>({
         ...state,
         [e.target.name]:e.target.value,
         service_provider_id:JSON.parse(localStorage.getItem("loggedinuser")).service_provider_id
        }));
    }

    const Logout=()=>{
      mystore.dispatch({type:'LOGGEDOUT'});
      localStorage.removeItem('loggedinuser');
      navigate('/');
  }

    const submitData = (e)=>{
        e.preventDefault();
        const requestOption1= {
          method:"post",
          headers:{
              "content-type":"application/json"
          },
          body:JSON.stringify(state)
      }
       fetch("http://localhost:8080/saveService",requestOption1)
      .then(res=>res.json())
      .then(data=>{setService_id(data)
      setFlag(false);
      })
    }

    const uploadImg=(e)=>{
      e.preventDefault();
      var fd = new FormData();
        fd.append("file",picture)
        const requestOption= {
            method:"post",
            headers:{

            },
            body:fd
        }
        fetch("http://localhost:8080/addimage/"+service_id,requestOption)
        .then(res=>res.json())
        .then(data =>{ console.log(JSON.stringify(data))

            
          if(data == 1)
          {
              alert("Product Image uploaded successfully.")
          }
          else
          {
              alert("failed to upload Product Image Try again...")

          }
  
          })
    }

    return(<div >
      <nav className="navbar navbar-light">
                
                <Link className='link' to="/serviceProvider_home">  Home  </Link>
                <Link className='link' to="/spbookings"> Bookings  </Link>
                <Link className='link' to="/registerService">  Register Service  </Link>
                <Link className="link" to="/servPro_Profile">User : {JSON.parse(localStorage.getItem("loggedinuser")).first_name}</Link>
                <div class="d-flex justify-content-end">
                    <button className="btn btn-success" onClick={Logout}> Logout</button>
                </div>
            
            </nav>
       
      <div >
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
            <option value={5}>Music</option>
          </select>
        </div>

        <div className="form-group">
          <label for="exampleFormControlTextarea1">Add Description</label>
          <textarea className="form-control" name="description" id="exampleFormControlTextarea1" rows="3" onChange={handleInput}></textarea>
        </div>
        <button type="submit" class="btn btn-primary mb-2" onClick={(e)=>submitData(e)}>Submit</button>

        <div style={{display:flag?'none':'block'}}>
            <label>Upload an image :</label>
            <input type="file" name="file" class="form-control-file" onChange={(e)=>setPicture(e.target.files[0])}></input>
            <button type="submit" class="btn btn-primary mb-2" onClick={(e)=>{uploadImg(e)}}>Upload Image</button>
        </div>
        
        
        </form>
        <p style={{color:'white'}}>
        
        {message}
        
        </p>

        
        
        </div>
    </div>
        
    );
}

export default RegisterService;