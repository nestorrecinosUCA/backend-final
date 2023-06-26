import React from 'react'
import { Outlet, Link } from 'react-router-dom'
import iconlogo from '../assets/img/logo.png';

function Navbar() {
    return (
        <>
            <div class="sticky top-0 z-10 navbar bg-base-100">
                <div class="navbar-start">
                    <div class="dropdown">
                        <label tabindex="0" class="btn btn-ghost lg:hidden">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h8m-8 6h16" /></svg>
                        </label>
                        <ul tabindex="0" class="menu menu-compact dropdown-content mt-3 p-2 shadow bg-base-200 rounded-box w-52 font-sans font-bold">
                            <li ><Link to="/homeWNavbar"><a>Inicio</a></Link></li>
                            <li>
                                <a>Eventos
                                    <svg class="fill-current" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M8.59,16.58L13.17,12L8.59,7.41L10,6L16,12L10,18L8.59,16.58Z" /></svg>
                                </a>
                                <ul class="p-2">
                                    <li class="bg-base-200"><Link to="/allEvents"><a>Eventos</a></Link></li>
                                    <li class="bg-base-200"><Link to="/purchasedTicket"><a>Tickets Comprados</a></Link></li>
                                    <li class="bg-base-200"><Link to="/personalHistory"><a>Historial Eventos</a></Link></li>
                                </ul>
                            </li>

                            <li><a><Link to="">Moderadores</Link></a></li>

                            <li>
                                <a>Administracion
                                    <svg class="fill-current" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M8.59,16.58L13.17,12L8.59,7.41L10,6L16,12L10,18L8.59,16.58Z" /></svg>
                                </a>
                                <ul class="p-2">
                                    <li class="bg-base-200"><Link to="/permits"><a>Permisos</a></Link></li>
                                    <li class="bg-base-200"><Link to="/createEvent"><a>Agregar Evento</a></Link></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <img class="w-52 h-auto " src={iconlogo}></img>
                </div>


                {/*MENU FULL SCREEN*/}
                <div class="navbar-center hidden lg:flex">
                    <ul class="menu menu-horizontal px-1 font-sans font-bold">
                        <li ><Link to="/homeWNavbar"><a>Inicio</a></Link></li>
                        <li>
                            <a>Eventos
                                <svg class="fill-current" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><path d="M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z" /></svg>
                            </a>
                            <ul class="p-2">
                                <li class="bg-base-200"><Link to="/allEvents"><a>Eventos</a></Link></li>
                                <li class="bg-base-200"><Link to="/purchasedTicket"><a>Tickets Comprados</a></Link></li>
                                <li class="bg-base-200"><Link to="/personalHistory"><a>Historial Eventos</a></Link></li>
                            </ul>
                        </li>

                        <li><a><Link to="/moderator">Moderadores</Link></a></li>

                        <li>
                            <a>Administracion
                                <svg class="fill-current" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><path d="M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z" /></svg>
                            </a>
                            <ul class="p-2">
                                <li class="bg-base-200"><Link to="/permits"><a>Permisos</a></Link></li>
                                <li class="bg-base-200"><Link to="/createEvent"><a>Agregar Evento</a></Link></li>
                            </ul>
                        </li>
                    </ul>
                    <Outlet />
                </div>

                <div class="navbar-end ">
                    <Link to="/changePassword">
                    <div class="w-10 h-10 bg-gray-300 rounded-full flex items-center justify-center">
                        <img class="w-6 h-6 rounded-full" src="https://upload.wikimedia.org/wikipedia/commons/9/99/Sample_User_Icon.png" alt="Imagen de persona logueada" />
                    </div>
                    </Link>
                </div>
            </div>
        </>
    )
}

export default Navbar