import React from 'react'

function buy() {
    return (
        <>
            <div className='bg-card-grey my-10 mx-4 sm:mx-20 rounded-lg p-5 sm:p-10 ' >
                <div className=' bg-header-bg py-5 px-5 rounded-lg items-center text-center'>
                    <h2 class=' text-2xl'>COMPRA</h2>
                </div>
                <div className='text-center justify-center  bg-white rounded-lg text-black py-14 my-4'>
                    <h2 className='card-title justify-center'>LOCALIDAD 1</h2>
                    <p>$45</p>
                    <h3 className=' text-green-available'>Disponibles:31</h3>
                </div>
                <div className='flex space-x-4 justify-center mt-5'>
                    <h2 className='bg-header-bg font-bold p-3 rounded-lg'>Cantidad:</h2>
                    <label className='bg-header-bg font-bold p-3 rounded-lg w-10 text-center hover:bg-buton-hov'>-</label>
                    <label className='bg-header-bg font-bold p-3 rounded-lg w-10 text-center'>0</label>
                    <label className='bg-header-bg font-bold p-3 rounded-lg w-10 text-center hover:bg-buton-hov'>+</label>
                </div>
                <div className='flex mt-5 justify-center'>
                    <label className='bg-header-bg font-bold p-3 rounded-l-lg w-auto text-center '>Precio total:</label>
                    <label className='bg-white font-bold p-3 rounded-r-lg w-auto text-center text-black px-10'>0</label>
                </div>
                <div className='flex justify-center'>
                    <button className='bg-green-light rounded-lg p-4 mt-5 font-bold mb-7 hover:bg-green-available px-10'>Realizar pago</button>
                </div>
            </div>

        </>

    )
}

export default buy