import React from "react";
import ROAR from '../../assets/img/ROAR.png'
import { SnackbarProvider, enqueueSnackbar } from 'notistack'

function TransferTicketModelView() {
  const [showModal, setShowModal] = React.useState(false);

  const ticketTransfer = () => {
    enqueueSnackbar("Ticket Transferido exitosamente!", {
      variant: "success",
    });
    setShowModal(false)
  }

  return (
    <>
      <SnackbarProvider autoHideDuration={3000}
        anchorOrigin={{
          vertical: 'top',
          horizontal: 'right'
        }}
        />

      <button
        className="bg-button-orange w-60 font-bold rounded-md p-2 px-10 ml-0 lg:ml-2  mt-2 lg:mt-0"
        type="button"
        onClick={() => setShowModal(true)}
      >
        Transferir Ticket
      </button>

      {showModal ? (
        <>
          <div className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none p-4">
            <div className="relative w-full">

              <div class="lg:hidden">
                <div class="flex justify-center items-center min-h-screen">
                  <div class="h-auto w-11/12 bg-card-grey border-2 border-gold p-3 rounded-lg">
                    <p class="text-xl font-semibold">Detalles de transferencia</p>
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
                      <label for="email" class="block mb-2 text-sm font-medium text-white ml-2">Destinatario</label>
                      <input type="email" id="email" class="h-12 pl-7 outline-none px-2  w-full bg-header-bg rounded-xl mt-2" placeholder="john.doe@company.com" required />
                    </div>
                    <div class="flex justify-center mt-4">
                      <button class="mr-2 outline-none pay h-12 bg-gold text-white mb-3 
                      hover:bg-goldhov rounded-lg w-56 cursor-pointer transition-all"
                        onClick={ticketTransfer}>Enviar</button>
                      <button onClick={() => setShowModal(false)} class="outline-none pay h-12 bg-red-500 text-white mb-3 hover:bg-red-600 rounded-lg w-56 cursor-pointer transition-all">Cancelar</button>
                    </div>
                  </div>
                </div>
              </div>

              <div class="hidden lg:block">
                <div className='flex justify-center items-center min-h-screen'>
                  <div className='bg-card-grey mx-auto w-8/12 lg:mx-60 lg:my-36 rounded-sm border-2 border-gold flex flex-row justify-center mid-h-screen items-center'>
                    <div className='basis-5 w-full sm:w-auto'>
                      <div class="h-auto w-full p-3 rounded-lg">
                        <p class="text-xl font-semibold">Detalles de transferencia</p>
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
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24">
                              <path d="M5 12h14" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                            </svg>
                          </button>
                          <p className='bg-header-bg mx-4 rounded-lg px-8 py-3'>0</p>
                          <button class="btn btn-circle bg-header-bg">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24">
                              <path d="M12 3v18m9-9H3" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                            </svg>
                          </button>
                        </div>
                        <div class="mb-6">
                          <label for="email" class="block mb-2 text-sm font-medium text-white">Destinatario</label>
                          <input type="email" id="email" class="h-12 pl-7 outline-none px-2  w-full bg-header-bg rounded-xl mt-2" placeholder="john.doe@company.com" required />
                        </div>
                        <div class="flex justify-center mt-4">
                          <button class="mr-2 outline-none pay h-12 bg-gold text-white mb-3 
                          hover:bg-goldhov rounded-lg w-56 cursor-pointer transition-all"
                            onClick={ticketTransfer}>Enviar</button>

                          <button onClick={() => setShowModal(false)} class="outline-none pay h-12 bg-red-500 text-white mb-3 hover:bg-red-600 rounded-lg w-56 cursor-pointer transition-all">Cancelar</button>
                        </div>
                      </div>
                    </div>
                    <div className='basis-1 h-full w-full border-l-4'>
                      <img src={ROAR} alt="Artist" className="rounded-xl mx-auto h-full w-full" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="opacity-25 fixed inset-0 z-40 bg-black"></div>
        </>
      ) : null}
    </>
  );
}

export default TransferTicketModelView