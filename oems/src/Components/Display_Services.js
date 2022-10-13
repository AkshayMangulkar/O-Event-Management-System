import { useEffect, useState } from "react";


function Display_Services(){
  
    const[state,setState]=useState([]);
    const[cart,setCart]=useState([]);
    const[city,setCity]=useState();
    const[services,setServices]=useState([]);
    useEffect(()=>{
        fetch("http://localhost:8080/getAllServices").then(res=>res.json()).then(data=>(setState(data)))
        var arr=localStorage.getItem("cart");
        var arrserv=localStorage.getItem("services")
        if (arr!==null) {
            setCart(JSON.parse(arr))
            setServices(JSON.parse(arrserv))
        }
        
    },[])

    const sort=(e)=>{
        e.preventDefault();
        setState(state.filter((s)=>s.service_provider_id.address_id.city===city));
    }
    const AddtoCart=(s)=>{
            if (cart.includes(s,0)) {
                alert("Already present !!!")
            } else {
                cart.push(s);
                services.push(s.service_id);
                alert("service Added SuccessFully !!!  "+JSON.stringify(s.service_name))
                
            }
            
        localStorage.setItem("cart",JSON.stringify(cart))
        localStorage.setItem("services",JSON.stringify(services))
        // localStorage.setItem("services",)
        // alert(JSON.stringify(cart));
    }

    return(
        <div>
                <form style={{color:"white",display:'flex',padding:"20px"}}>
                        Your city : 
                        <input style={{width:"250px"}} className="form-control" name="city" placeholder="city" type="text" onChange={(c)=>setCity(c.target.value)}/>
                        <button className="btn btn-success" onClick={(e)=>{sort(e)}}>Search</button>
                        </form>
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
                                    <button className="btn btn-primary" onClick={(e)=>AddtoCart(s)}>Add To Cart</button>
                                    {/* <a href="#" className="card-link">Card link</a>
                                    <a href="#" className="card-link">Another link</a> */}
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

export default Display_Services;