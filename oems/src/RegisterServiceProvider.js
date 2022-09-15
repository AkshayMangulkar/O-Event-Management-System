import { useState } from "react";
import "/node_modules/bootstrap/dist/css/bootstrap.css";

function RegisterServiceProvider(){
    const[state,setState]=useState({
        mobno:"",
        pwd:"",
        fname:"",
        lname:"",
        city:"",
        state:"",
        pincode:"",
        bname:""
    });

    const handleInput = (e)=>{
        setState((state)=>({
         ...state,
         [e.target.name]:e.target.value
        }));
    }


    const submitData = (e)=>{
        e.preventDefault();
        console.log(state);
    }

    return(<div>
        
        <form>
           <table border={2} border-color="orange">
              <tr>
                 <td>    
                       <input type="text" name="fname" placeholder="First Name" onChange={handleInput}/> <br/> <br/> 

                      <input type="text" name="lname" placeholder="Last Name" onChange={handleInput}/> <br/> <br/>

                      <input type="text" name="city" placeholder="City" onChange={handleInput}/> <br/> <br/>

                       <input type="text" name="state" placeholder="State" onChange={handleInput}/> <br/> <br/>

                       <input type="number" name="pincode" placeholder="Pincode" onChange={handleInput}/> <br/> <br/> 

                       Are you ?? <br/>
                     <select name="userType" onChange={handleInput} > 
                           <option> Service Provider </option>
                           <option> Client </option>
                           <option> Admin </option>
                    </select>      <br/> <br/>

                    <input type="text" name="bname" placeholder="Buisness Name"  onChange={handleInput}/> <br/> <br/> 

                    <input type="number" name="mobno" placeholder="User Id/Mobile No"  onChange={handleInput}/> <br/> <br/> 

                    <input type="password" name="pwd" placeholder="Password" onChange={handleInput}/> <br/> <br/>

                    <input type="submit" value="REGISTER" onClick={submitData}/> <br/>
                </td>
             </tr>
            
           
        
          </table>    
        </form>
        
        {JSON.stringify(state)} <br/>
        
    </div>);
}

export default RegisterServiceProvider;