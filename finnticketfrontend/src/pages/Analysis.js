import React from 'react'
import ShortCutNavBar from '../components/ShortCutNavBar'
import MGEF from '../assets/img/MGEF.jpg'
import Information from '../modules/EventDeploy/Information'
import Navbar from '../components/Navbar'
import { Link } from 'react-router-dom'


function Analysis() {
    return (
        <>


            <div class="lg:hidden p-2">
                <div className='mx-4 lg:mx-20 text-4xl mt-10'>
                    <a>Analisis del evento </a>
                    <div class="flex justify-end text-xl ">
                        <Link to="/allEvents">
                        <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                            <span class="sr-only">Regresar</span>
                        </button>
                        </Link>
                    </div>
                    <div>
                    </div>
                </div>
            </div>


            <div class="hidden lg:block">
                <div className='mx-4 lg:mx-20 text-4xl mt-10'>
                    <a>Analisis del evento </a>
                    <div class="flex justify-end text-xl ">
                        <Link to="/allEvents">
                        <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium 
                        rounded-full text-sm px-5 py-2.5 text-center mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Regresar</button>
                        </Link>
                    </div>
                    <div>
                    </div>
                </div>
            </div>

            <div className='mx-4 border-b-2 lg:mx-20 lg:border-b-4 md:border-b-4 2xl:border-b-4 rounded mb-4' />
            <div className='mx-4 lg:mx-20 bg-card-white-grey rounded mt-2 mb-8 p-6 items-center border-4 '>
                <div className='mx-4 lg:mx-20'>
                    <div className='rounded mt-2 mb-8 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 p-6 items-center'>
                        <div className='mb-4 sm:mb-0 sm:mr-2 md:mr-5 px-5 lh:mx-8 lg:mr-5 lg:px-5'>
                            <img src={MGEF} alt="Artist" className="rounded-xl h-auto max-h-60 max-w-full mx-auto sm:h-full sm:w-full lg:h-auto lg:w-auto" />
                        </div>
                        <div className='mx-0 md:mx-8 lg:mx-8 2xl:mx-8 col-span-2 sm:col-span-3 '>
                            <Information />
                        </div>
                    </div>
                </div>
                <div className='px-20 text-center lg:px-80 mb-8'>
                    <div>
                        <a>Flujo del evento</a>
                    </div>
                    <div className='border-b-4' />
                </div>
                <div className='grid  sm:grid-cols-2 sm:grid-rows-1 lg:grid-cols-4 lg:grid-rows-3 gap-4'>
                    <div className='flex border-4 rounded w-full text-center col-span-2'>
                        <p className='bg-black w-full px-4 py-2'>Tickets vendidos</p>
                        <p className='px-4 py-4 w-full'>20</p>
                    </div>
                    <div className='flex border-4 rounded w-full text-center col-span-2'>
                        <p className='bg-black px-4 py-2 w-full'>Asistencia</p>
                        <p className='px-4 py-4 w-full'>20</p>
                    </div>
                    <div className='flex border-4 rounded text-center row-span-2 col-span-2 '>
                        <p className='bg-black px-4 py-2 justify-center h-full w-full '>Localidades Populares</p>
                        <div className='text-start w-full'>
                            <p className='px-4 py-4'>1.Astronomic</p>
                            <p className='px-4 py-4'>2.Platino</p>
                            <p className='px-4 py-4'>3.Juan</p>
                        </div>
                    </div>
                    <div className='flex border-4 rounded w-full text-center col-span-2'>
                        <p className='bg-black px-4 py-2 w-full'>% Personas en grupo</p>
                        <p className='px-4 py-4 w-full'>20</p>
                    </div>
                    <div className='flex border-4 rounded w-full text-center col-span-2'>
                        <p className='bg-black px-4 py-2 w-full'>% Personas solas</p>
                        <p className='px-4 py-4 w-full'>20</p>
                    </div>
                </div>
                <div className='px-20 text-center lg:px-80 mb-8 mt-14'>
                    <div>
                        <a>Gráfica</a>
                    </div>
                    <div className='border-b-4' />

                    {/* <figure>
                        <canvas id="eventChart" width="400" height="400" className='bg-gray-800'></canvas>
                    </figure>*/}

                    {/*DISEÑO DE EJEMPLO
                        LUEGO LO CAMBIAREMOS CON EL USO DE LA API CON LA LIBRERIA DE CHART.JS */}
                    <div class="container mx-auto p-8">

                        <div class="border border-gray-300 rounded-lg overflow-hidden">
                            <svg class="w-full h-auto sm:h-96" viewBox="0 0 1000 1000">
                                <line x1="100" y1="950" x2="950" y2="950" stroke="black" stroke-dasharray="5" />
                                <line x1="100" y1="100" x2="100" y2="950" stroke="black" stroke-dasharray="5" />

                                <g class="text-2xl text-gray-500">
                                    <text x="100" y="970" text-anchor="middle">1</text>
                                    <text x="250" y="970" text-anchor="middle">2</text>
                                    <text x="400" y="970" text-anchor="middle">3</text>
                                    <text x="550" y="970" text-anchor="middle">4</text>
                                    <text x="700" y="970" text-anchor="middle">5</text>
                                    <text x="850" y="970" text-anchor="middle">6</text>
                                    <text x="1000" y="970" text-anchor="middle">7</text>
                                </g>

                                <g class="text-2xl text-gray-500">
                                    <text x="80" y="950" text-anchor="end">0</text>
                                    <text x="80" y="850" text-anchor="end">100</text>
                                    <text x="80" y="750" text-anchor="end">200</text>
                                    <text x="80" y="650" text-anchor="end">300</text>
                                    <text x="80" y="550" text-anchor="end">400</text>
                                    <text x="80" y="450" text-anchor="end">500</text>
                                    <text x="80" y="350" text-anchor="end">600</text>
                                    <text x="80" y="250" text-anchor="end">700</text>
                                    <text x="80" y="150" text-anchor="end">800</text>
                                    <text x="80" y="50" text-anchor="end">900</text>
                                </g>

                                <polyline points="100,900 250,800 400,600 550,400 700,200 850,100 1000,0" fill="none" stroke="goldenrod" stroke-width="2" />
                            </svg>
                        </div>
                    </div>



                </div>
                <div className='w-full text-end'>
                    <button className='w-40 bg-gold border-2 rounded h-12 text-lg font-semibold'>Exportar pdf</button>
                </div>

            </div >
        </>
    )
}

export default Analysis