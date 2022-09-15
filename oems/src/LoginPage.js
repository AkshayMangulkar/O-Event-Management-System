import React from 'react';

const LoginPage=()=>{
    return(
        <>
        <form action="">
        <div>
                <label htmlFor="email">Email</label>
                <input type="email" name="email" id="email"/>
        </div>
        <div>
                <label htmlFor="password">Password</label>
                <input type="password" name="password" id="password"/>
        </div>
        <div>
                <button type="Login">Login</button>
        </div>
        </form>
        </>
    )
}
export default LoginPage;