import { useEffect, useState } from "react";
import mystore from "./Store";

export function Client_Home() {
    const[flag,setFlag]=useState();
    useEffect(()=>{
        mystore.subscribe(()=>setFlag(mystore.getState().loggedin))
        
    })
    return (
        <div style={{display:flag?'none':'block'}}>
            <h1 >Welcome Mr/Mrs {JSON.parse(localStorage.getItem("loggedinuser")).first_name}</h1>
        </div>
    );
}