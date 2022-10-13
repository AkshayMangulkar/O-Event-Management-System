import axios from "axios";
import { useReducer, useEffect, useState, setUser, setName } from "react";
import { Navbar, Nav, NavDropdown, Button } from 'react-bootstrap'
import { Link } from "react-router-dom";
import { useNavigate } from 'react-router-dom';
const init = {
    price: "",
    company: "",
    model: "",
    description: ""
}
const reducer = (state, action) => {
    switch (action.type) {
        case 'update':
            return { ...state, [action.field]: action.val };
        case 'clear':
            return init;

    }
}


let UploadProduct = () => {

    const [product, dispatch] = useReducer(reducer, init);
    const [uid, SetUid] = useState('')

    let navigate = useNavigate();
    const logout = () => {
        localStorage.clear();
        navigate("/login")
    };
    const [user, setUser] = useState([]);
    useEffect(() => {
        let loginid = (JSON.parse(localStorage.getItem("loggedinuser"))).uid;
        fetch("http://localhost:8080/getUser?uid=" + loginid)
            .then(resp => resp.json())
            .then(data => { setUser(data); localStorage.setItem("loggedincust", JSON.stringify(data)); let nm = data.fname });
        //let nm= (JSON.parse(localStorage.getItem("loggedincust"))).fname;
        console.log(loginid)
    }, []);


    const sendData = (e) => {
        e.preventDefault();
        console.log(JSON.stringify(product));
        const reqOptions = {
            method: "POST",
            headers: {
                'Content-Type': 'application/JSON'
            },
            body: JSON.stringify({
                userid: localStorage.getItem("loggedinuser"),
                price: product.price,
                company: product.company,
                model: product.model,
                description: product.description

            })
        }

        fetch("http://localhost:8080/saveProduct", reqOptions)
            .then(resp => resp.json())
            .then(data => {

                if (data) {
                    localStorage.setItem("loggedinuser", JSON.stringify(data))
                }
                else {
                    this.setItem({ loginerror: "Wrong Information added" })
                }
                console.log(data);
            })

    }

    return (<div>
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="/home">MobiJet</Navbar.Brand>
            <Nav className="mr-auto navbar_wrapper">
            </Nav>
            <Nav>
                <NavDropdown title={user.fname}>
                    <NavDropdown.Item onClick={logout}>Logout</NavDropdown.Item>
                </NavDropdown>
            </Nav>
        </Navbar>
        <div style={{ display: 'contents', alignItems: 'center' }}>
            <h1>Upload Product Information</h1>
            <form >
                <label>Enter Product Price: </label>
                <input type="text" name="price" value={product.price} onChange={(e) => { dispatch({ type: 'update', field: 'price', val: e.target.value }) }} />
                <br />
                <label>Enter Product Company: </label>
                <input type="text" name="company" value={product.company} onChange={(e) => { dispatch({ type: 'update', field: 'company', val: e.target.value }) }} />
                <br />
                <label>product Model: </label>
                <input type="text" name="model" value={product.model} onChange={(e) => { dispatch({ type: 'update', field: 'model', val: e.target.value }) }} />
                <br />
                <label>product Descrption: </label>
                <input type="text" name="description" value={product.description} onChange={(e) => { dispatch({ type: 'update', field: 'description', val: e.target.value }) }} />
                <br />
                <label>Upload Image: </label>
                <input type="file" onChange={product.onFileChange} />
                <button onClick={product.onFileUpload}>Upload</button>
                <br />
                <br />
                <Button type="submit" value="send" onClick={(e) => { sendData(e) }}>Submit</Button>
                <Button type="reset" value="clear" onClick={() => { dispatch({ type: 'clear' }) }}>Reset</Button>
                
            </form>

            {JSON.stringify(product)}

        </div>
    </div>
    );
}

export default UploadProduct;