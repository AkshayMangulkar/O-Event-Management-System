import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import "../Cart.css"

function Cart() {
    const[intems,setitem]=useState([]);
    const[msg,setMsg]=useState();
    var total=0;
    var navigate=useNavigate();
    var serv_id=[];
    const[buttonflg,setButtonFlag]=useState(true);
    
    const[bookedItems,setBookedItems]=useState({
        c_id:JSON.parse(localStorage.getItem("loggedinuser")).client_id,
        event_date:"",
        service_id:[]
    });

    useEffect(()=>{
        if (localStorage.getItem("cart")!==null) {
            setitem(JSON.parse(localStorage.getItem("cart")))
            // setitem((e)=>{e=JSON.parse(localStorage.getItem("cart"))})
            setMsg("");
        } else {
            setMsg("Sorry the cart is empty");
            setButtonFlag(true)
        }
    },[])

    
    const deleteItem=(s)=>{
        // alert(s.service_name)
        // alert(intems.indexOf(s));
        intems.splice(intems.indexOf(s),1);
        localStorage.setItem("cart",JSON.stringify(intems));
        serv_id.splice(serv_id.indexOf(s.service_id),1);
        navigate('/cart');
    }

    const setDate=(e)=>{
        setBookedItems((bookedItems)=>({
            ...bookedItems,
            event_date:e.target.value
           }));
        setButtonFlag(false);
    }

    const book = ()=>{
        intems.forEach(item => {
            serv_id.push(item.service_id);
        });
   
        if (serv_id.length>0) {
            setBookedItems((bookedItems)=>({
                ...bookedItems,
                service_id:serv_id
               }));
                
            const requestOption= {
                method:"post",
                headers:{
                    'content-type':'application/json'
                },
                body:JSON.stringify(bookedItems)
            }
            fetch("http://localhost:8080/saveBooking",requestOption)
            .then(resp=>resp.text())
            .then(data=>{
                if(data){
                    alert("booking is Successfull !!!")
                }
            })
        } else {
            alert("cart is empty")
        }

    
        

    }
    return (
        
        <div>

        <a className="link" href="/client_home">Continue surfing</a>
        
        <div className="cart_body" width={100} height={100} style={{backgroundColor:"aqua"}}>
            <span>
                <h1 className="message">{msg}</h1>
                Select Date Of event :<input type="date" name="event_date" onChange={(e)=>{setDate(e)}}></input>
            </span>
           {
                intems.map((s)=>{
                    {total+=s.cost}
                    return  <div className="card">
                    <div className="card-header">
                            {s.service_name}
                    </div>
                    <div className="card-body">
                        <h5 className="card-title">Item Cost : {s.cost}</h5>
                        <p className="card-text">{s.description}</p>
                        <button className="btn btn-primary" onClick={()=>{deleteItem(s)}}>Remove Item</button>
                    </div>
                    </div>
                })
           }
           <div className=""><b>Total Cost :  {total}  </b><br/><button className="btn btn-success book" disabled={buttonflg} onClick={()=>{book()}}>Book</button></div>
            
            
           
            
            </div>
        </div>
        
    )
}

export default Cart;