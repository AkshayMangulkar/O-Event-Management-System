/*import logo from './logo.svg';*/
import './App.css';
import Header from './header';

import RegistrationForm from './Register';

import { Home } from './Components/Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Client_Home } from './Components/Client_Home';




function App() {
  
  return (
    // <div className="App">
      
    //   <header className="App-header">
      
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
        
        
        
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
          
    //       Learn React
    //     </a>
       
    //   </header>
    // </div>
    <>
    
    
<div>
      {/* <RegisterService/> */}
      {/* <Login/> */}
      <Header/>
      <BrowserRouter>
          <Home/>
      </BrowserRouter>
      
</div>


    </>


  );
  
}


export default App;
