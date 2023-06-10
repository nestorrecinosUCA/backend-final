import React from 'react'
import iconlogo from '../assets/img/iconlogo.png'
import { Link } from 'react-router-dom'

function ChangePassword() {
    return (
        <>

            <div className='mx-4 lg:mx-20 justify-center justify-items-center text-center'>
                <div className='bg-card-white-grey rounded mt-2 lg:mt-10 justify-self-center mb-8 p-6 items-center border-4 lg:px-40 sm: md:px-20 xl:px-60 2xl:px-96 '>
                    <div className="flex min-h-full flex-1 flex-col text-center justify-items-center justify-center pb-12 lg:px-8">
                        <img
                            className="mx-auto h-auto w-auto"
                            src={iconlogo}
                            alt="FinnTicket"
                        />
                        <div className='text-center'>
                            <h1 className='text-2xl font-bold mb-5'>
                                Cambiar contraseña
                            </h1>
                        </div>
                        <div className="flex items-center justify-between">
                            <label htmlFor="password" className="block text-sm font-medium leading-6 text-white">
                                Contraseña actual
                            </label>

                        </div>
                        <div className="mt-2">
                            <input
                                id="password"
                                name="password"
                                type="password"
                                autoComplete="current-password"
                                required
                                className="block w-full rounded-md border-0 py-1.5 px-2 mb-4 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-gold sm:text-sm sm:leading-6"
                            />
                        </div>
                        <div className="flex items-center justify-between">
                            <label htmlFor="password" className="block text-sm font-medium leading-6 text-white">
                                Nueva contraseña
                            </label>

                        </div>
                        <div className="mt-2">
                            <input
                                id="password"
                                name="password"
                                type="password"
                                autoComplete="current-password"
                                required
                                className="block w-full rounded-md border-0 py-1.5 px-2 mb-4 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-gold sm:text-sm sm:leading-6"
                            />
                        </div>
                        <div className="flex items-center justify-between">
                            <label htmlFor="password" className="block text-sm font-medium leading-6 text-white">
                                Confirmar contraseña
                            </label>
                        </div>
                        <div className="mt-2">
                            <input
                                id="password"
                                name="password"
                                type="password"
                                autoComplete="current-password"
                                required
                                className="block w-full rounded-md border-0 py-1.5 px-2 mb-4 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-gold sm:text-sm sm:leading-6"
                            />
                        </div>
                        <Link to="/HomeWNavbar">
                            <div className='justify-center flex'>

                                <button
                                    type="submit"
                                    className="flex w-1/2 mt-8 justify-center rounded-md bg-gold px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-goldhov focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-white"
                                >
                                    Aceptar
                                </button>
                            </div>
                        </Link>
                    </div>
                </div>

            </div>



        </>
    )
}

export default ChangePassword