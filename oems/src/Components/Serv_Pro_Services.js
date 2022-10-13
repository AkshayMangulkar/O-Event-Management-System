import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";


export function Display_Services_Service_Pro(){
    const navigate=useNavigate();
    const[state,setState]=useState([]);
    let servPro_id=JSON.parse(localStorage.getItem("loggedinuser")).service_provider_id;
    useEffect(()=>{
        fetch("http://localhost:8080/getAllServicesByServ_pro?serv_Pro_id="+servPro_id).then(res=>res.json()).then(data=>(setState(data)))
        
    },[])

    const editService=(s)=>{
        console.log(s)
        localStorage.setItem("edit_service",JSON.stringify(s))
        navigate("/edit_Service")
    }


    return(
        <div>
            {/* <Link style={{float:"left",margin:"20px"}} className="link" to="/serviceProvider_home">Back to home</Link> */}
                {
                    state.map((s)=>{
                        
                        return <div style={{display:'inline-block',margin:'20px'}}>
                        <div className="card " style={{width:'25rem'}} >
                                <img className="card-img-top" style={{height:'250px'}} src={"http://localhost:8080/getPath/"+s.service_id} alt=""/>
                                <div className="card-body">
                                    <h5 className="card-title">{s.service_name}</h5>
                                    <p className="card-text"><b>Description</b> : {s.description}</p>
                                </div>
                                <ul className="list-group list-group-flush">
                                    <li className="list-group-item">Cost : {s.cost}</li>
                                    <li className="list-group-item">Category : {s.category_id.category_name}</li>
                                    <li className="list-group-item">Provided by : {s.service_provider_id.business_name}</li>
                                    <li className="list-group-item">Location : {s.service_provider_id.address_id.city}</li>
                                </ul>
                                <div className="card-body">
                                    <button className="btn btn-primary" style={{width:'150px'}} onClick={()=>{editService(s)}}>Edit</button>
                                </div>
                        </div>
                        <br/>
                        <br/>

                        </div>
                    })
                }
        </div>
        
    );
}

