import react from 'react'
import {Link} from "react-router-dom";
import React from "react";

function UserHome(){
    return(
        <div>
            <h1>Welcome Back!</h1>

            <button className='btn btn-link' style={{color: "black"}} type="button"><Link to="/showTransactions">Transaction History</Link></button>

        </div>
    )
}
export default UserHome