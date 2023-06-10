import React from 'react'
import ROAR from '../../assets/img/ROAR.png'

function TransferModal() {
    return (
        <>
            <div class="lg:hidden">
                <div class="flex justify-center items-center min-h-screen">
                    <div class="h-auto w-80 bg-card-grey border-2 border-gold p-3 rounded-lg">
                        <p class="text-xl font-semibold">Transferencia</p>
                        <div class="input_text mt-6 relative">
                            <select className="select select-bordered w-full max-w-xs">
                                <option disabled selected>Localidad</option>
                                <option>Little Big Boy</option>
                                <option>Astronomic</option>
                            </select>
                        </div>
                        <div className='flex flex-row justify-center my-4'>
                            <p className='bg-header-bg rounded-lg px-4 mx-2 lg:mx-4 py-3'>Cantidad:</p>
                            <button class="btn btn-circle bg-header-bg">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" /></svg>
                            </button>
                            <p className='bg-header-bg mx-4 rounded-lg px-5 lg:px-8 py-3'>0</p>
                            <button class="btn btn-circle bg-header-bg">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" /></svg>
                            </button>
                        </div>
                        <div class="mb-6">
                            <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white ml-2">Destinatario</label>
                            <input type="email" id="email" class="h-12 pl-7 outline-none px-2  w-full bg-header-bg rounded-xl mt-2" placeholder="john.doe@company.com" required />
                        </div>
                        <div class="flex justify-center mt-4"> <button class="outline-none pay h-12 bg-gold text-white mb-3 hover:bg-goldhov rounded-lg w-1/2 cursor-pointer transition-all">Enviar</button> </div>
                    </div>
                </div>
            </div>

            <div class="hidden lg:block">
                <div className='flex justify-center items-center min-h-screen'>
                    <div className='bg-card-grey mx-auto w-8/12 lg:mx-60 lg:my-36 rounded-sm border-4 border-gold flex flex-row justify-center mid-h-screen items-center'>
                        <div className='basis-5 w-full sm:w-auto'>
                            <div class="h-auto w-full p-3 rounded-lg">
                                <p class="text-xl font-semibold">Transferencia</p>
                                <div class="input_text mt-6 relative">
                                    <select className="select select-bordered w-full max-w-xs">
                                        <option disabled selected>Localidad</option>
                                        <option>Little Big Boy</option>
                                        <option>Astronomic</option>
                                    </select>
                                </div>
                                <div className='flex flex-row justify-center my-4'>
                                    <p className='bg-header-bg rounded-lg px-4 mx-4 py-3'>Cantidad:</p>
                                    <button class="btn btn-circle bg-header-bg">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" /></svg>
                                    </button>
                                    <p className='bg-header-bg mx-4 rounded-lg px-8 py-3'>0</p>
                                    <button class="btn btn-circle bg-header-bg">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" /></svg>
                                    </button>
                                </div>
                                <div class="mb-6">
                                    <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Destinatario</label>
                                    <input type="email" id="email" class="h-12 pl-7 outline-none px-2  w-full bg-header-bg rounded-xl mt-2" placeholder="john.doe@company.com" required />
                                </div>
                                <div class="flex justify-center mt-4"> <button class="outline-none pay h-12 bg-gold text-white mb-3 hover:bg-goldhov rounded-lg w-1/2 cursor-pointer transition-all">Enviar</button> </div>
                            </div>
                        </div>
                        <div className='basis-1 h-full w-full border-l-4'>
                            <img src={ROAR} alt="Artist" className="rounded-xl mx-auto h-full w-full" />
                        </div>
                    </div>
                </div>
            </div>



        </>
    )
}

export default TransferModal