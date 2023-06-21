import React from 'react'
import PermitsTable from '../modules/PermitsPage/PermitsTable'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'

function Permits() {
    return (
        <>
            <Navbar />
            <div className='mx-4 lg:mx-20 text-4xl mt-10 mb-4 '>
                <a>Permisos de usuarios</a>
            </div>
            <div className='mx-4 border-b-2 lg:mx-20 lg:border-b-4 md:border-b-4 2xl:border-b-4 rounded' />
            <div className="mx-4 lg:mx-20 flex justify-end mt-2">
                <div class="relative w-60 sm:w-auto">
                    <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none ">
                        <svg
                            aria-hidden="true"
                            class="w-5 h-5 text-gray-500 dark:text-gray-400"
                            fill="none"
                            stroke="currentColor"
                            viewBox="0 0 24 24"
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                stroke-linecap="round"
                                stroke-linejoin="round"
                                stroke-width="2"
                                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
                            ></path>
                        </svg>
                    </div>
                    <input
                        type="text"
                        class="pl-10 pr-4 py-2 rounded-full w-60 sm:w-96 border-gray-300 text-gray-800  focus:outline-none"
                        placeholder="Buscar un usuario"
                    />
                </div>
            </div>

            <div className='mx-4 lg:mx-20 bg-card-white-grey rounded mt-2 mb-8 p-6 items-center border-4 '>
                <PermitsTable />
            </div>
        </>
    )
}

export default Permits