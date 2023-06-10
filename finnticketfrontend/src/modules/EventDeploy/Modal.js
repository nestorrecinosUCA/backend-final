import React from 'react'
import ROAR from '../../assets/img/ROAR.png'

function Modal() {
    return (
        <>
            <div class="lg:hidden">
                <div class="flex justify-center items-center min-h-screen">
                    <div class="h-auto w-80 bg-card-grey border-2 border-gold p-3 rounded-lg">
                        <p class="text-xl font-semibold">Detalles del pago</p>
                        <div class="input_text mt-6 relative">
                            <input type="text" class="h-12 pl-7 outline-none px-2  transition-all w-full bg-header-bg rounded-xl mt-2 " placeholder="John Row" />
                            <span class="absolute left-0 text-sm -top-4">Nombre</span>
                        </div>
                        <div class="input_text mt-8 relative"> <input type="text" class="h-12 pl-7 outline-none px-2  transition-all w-full bg-header-bg rounded-xl mt-2 " placeholder="0000 0000 0000 0000" data-slots="0" data-accept="\d" size="19" />
                            <span class="absolute left-0 text-sm -top-4">Numero de tarjeta</span>
                        </div>
                        <div class="mt-8 flex gap-5 ">
                            <div class="input_text relative w-full">
                                <input type="text" class="h-12 pl-7 outline-none px-2  w-full bg-header-bg rounded-xl mt-2 " placeholder="mm/yyyy" data-slots="my" />
                                <span class="absolute left-0 text-sm -top-4">Fecha de expiracion</span>
                            </div>
                            <div class="input_text relative w-full">
                                <input type="text" class="h-12 pl-7 outline-none px-2  w-full bg-header-bg rounded-xl mt-2" placeholder="000" data-slots="0" data-accept="\d" size="3" />
                                <span class="absolute left-0 text-sm -top-4">CVV</span>
                            </div>
                        </div>
                        <p class="text-lg text-center mt-4 text-white font-semibold">Payment amount:$12.98</p>
                        <div class="flex justify-center mt-4"> <button class="outline-none pay h-12 bg-gold text-white mb-3 hover:bg-goldhov rounded-lg w-1/2 cursor-pointer transition-all">Pay</button> </div>
                    </div>
                </div>
            </div>

            <div class="hidden lg:block">
                <div className='flex justify-center items-center min-h-screen'>
                    <div className='bg-card-grey mx-auto w-8/12 lg:mx-60 lg:my-36 rounded-sm border-4 border-gold flex flex-row justify-center mid-h-screen items-center'>
                        <div className='basis-5 w-full sm:w-auto'>
                            <div class="h-auto w-full p-3 rounded-lg">
                                <p class="text-xl font-semibold">Detalles del pago</p>
                                <div class="input_text mt-6 relative">
                                    <input type="text" class="h-12 pl-7 outline-none px-2 transition-all w-full bg-header-bg  rounded-xl mt-2" placeholder="John Row" />
                                    <span class="absolute left-0 text-sm -top-4">Nombre</span>
                                </div>
                                <div class="input_text mt-8 relative">
                                    <input type="text" class="h-12 pl-7 outline-none px-2 transition-all w-full bg-header-bg  rounded-xl mt-2" placeholder="0000 0000 0000 0000" data-slots="0" data-accept="\d" size="19" />
                                    <span class="absolute left-0 text-sm -top-4">Numero de tarjeta</span>
                                </div>
                                <div class="mt-8 flex gap-5 ">
                                    <div class="input_text relative w-full">
                                        <input type="text" class="h-12 pl-7 outline-none px-2 transition-all w-full bg-header-bg  rounded-xl mt-8 lg:mt-2" placeholder="mm/yyyy" data-slots="my" />
                                        <span class="absolute left-0 text-sm -top-4">Fecha de expiración</span>
                                    </div>
                                    <div class="input_text relative w-full">
                                        <input type="text" class="h-12 pl-7 outline-none px-2 transition-all w-full bg-header-bg  rounded-xl mt-8 lg:mt-2" placeholder="000" data-slots="0" data-accept="\d" size="3" />
                                        <span class="absolute left-0 text-sm -top-4">CVV</span>
                                    </div>
                                </div>
                                <p class="text-lg text-center mt-4 text-slate-200 font-semibold">Total a pagar:$12.98</p>
                                <div class="flex justify-center mt-4"> <button class="outline-none pay h-12 bg-gold text-white mb-3 hover:bg-goldhov rounded-lg w-1/2 cursor-pointer transition-all">Pagar</button> </div>
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

export default Modal