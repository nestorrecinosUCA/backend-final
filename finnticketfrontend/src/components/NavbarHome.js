import React from 'react'
import { Outlet, Link } from 'react-router-dom'
import iconlogo from '../assets/img/logo.png';

function NavbarHome() {
    return (
        <>
            <div class="sticky top-0 z-10 navbar bg-base-100">
                <div class="navbar-start">
                    <img class="w-52 h-auto " src={iconlogo} alt="Logo"></img>
                </div>


                {/*MENU FULL SCREEN*/}
                <div class="navbar-center hidden lg:flex">   
                </div>
                <div class="navbar-end">
                    <Link to="/signin"><a class="btn btn-warning rounded-lg">Sign In</a></Link>
                </div>
                <Outlet />
            </div>
        </>
    )
}

export default NavbarHome