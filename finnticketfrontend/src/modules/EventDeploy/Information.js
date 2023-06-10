import React from 'react'

function Information() {
    return (
        <>

            <div className=' rounded px-10 border-2 border-white-box w-full items-center text-center py-5'>
                <h2 class="card-title justify-center">Martin Garrix</h2>
                <div className='flex-row h-full '>
                    <div className='w-full flex mb-2 sm:mb-0'>
                        <div className='w-40'>
                            <p className='text-left'>Lugar y fecha:</p>
                        </div>
                        <div className='basis-4'>
                            <p className='text-left'>Estadio cuscatlán - 12/05/2023</p>
                        </div>
                    </div>
                    <div className='w-full flex  mb-2 sm:mb-0'>
                        <div className='w-40'>
                            <p className='text-left'>Hora:</p>
                        </div>
                        <div className='basis-4'>
                            <p className='text-left'>8:30 pm</p>
                        </div>
                    </div>
                    <div className='w-full flex  mb-2 sm:mb-0'>
                        <div className='w-40'>
                            <p className='text-left'>Duración:</p>
                        </div>
                        <div className='basis-4'>
                            <p className='text-left'>8:30pm - 1:00am</p>
                        </div>
                    </div>
                    <div className='w-full flex mb-2 sm:mb-0'>
                        <div className='w-40'>
                            <p className='text-left'>Patrocinador:</p>
                        </div>
                        <div className='basis-4'>
                            <p className='text-left'>La tecleña</p>
                        </div>
                    </div>
                    <div className='w-full flex mb-2 sm:mb-0'>
                        <div className='w-40'>
                            <p className='text-left'>Categoria:</p>
                        </div>
                        <div className='basis-4'>
                            <p className='text-left'>Musical</p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Information