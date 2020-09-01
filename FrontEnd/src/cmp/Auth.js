import React, { Component } from 'react'

export default class Auth extends Component {

    constructor()
    {
        super()
        this.state={
            isRegister:false
        }
    }

    login() {

        console.warn("state", this.state)
        fetch('https://xv6e2540aa.execute-api.us-east-2.amazonaws.com/dev/login', {
            method: "POST",
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify(this.state)
        }).then((result) => {
            result.json().then((resp) => {
                console.log(resp);
                localStorage.setItem("auth", JSON.stringify(resp))
            })
        })
        // alert("login called")
    }
    render() {
        return (
            <div>
                {
                    !this.state.isRegister?
                    <div>
                        <input type="text" onChange={(e) => { this.setState({ email: e.target.value }) }}
                        /><br /><br />
                        <input type="text" onChange={(e) => { this.setState({ password: e.target.value }) }}
                        /><br /><br />
                        <button onClick={() => this.login()}>Login</button>
                        <button onClick={() => this.setState({ isRegister: true })}>go to Register</button>
                    </div>
                    :
                    <div>
                        <input type="text" onChange={(e) => { this.setState({ email: e.target.value }) }}
                        /><br /><br />
                        <input type="text" onChange={(e) => { this.setState({ password: e.target.value }) }}
                        /><br /><br />
                        <button onClick={() => this.login()}>Register</button>
                        <button onClick={() => this.setState({ isRegister: false })}>go to Login</button>
                    </div>
                }
            </div>
        );
    }
}
