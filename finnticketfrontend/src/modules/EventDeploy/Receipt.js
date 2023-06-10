import React from 'react'
import { Link } from 'react-router-dom'

function Receipt() {
    return (
        <>
            <div className='flex justify-center items-center min-h-screen'>
                <div className='px-20 py-7 bg-cream-pie rounded-xl items-center text-black mx-4 lg:w-2/5'>
                    <h1 className='text-center text-2xl font-semibold mt-4 tracking-wider mb-5'>MARTIN GARRIX</h1>
                    <div className='flex flex-row gap-7 w-full justify-center font-semibold text-lg mt-5 '>
                        <p>2</p>
                        <p>Little Big Boy</p>
                        <p>$20</p>
                    </div>
                    <div className='flex flex-row gap-7 w-full justify-center font-bold text-lg mt-5'>
                        <p>Total:</p>
                        <p>$40</p>
                    </div>
                    <div className='w-full justify-center'>
                        <button className='bg-gold hover:bg-goldhov text-white font-bold w-full p-2 rounded-lg mt-5' >Seguir</button>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Receipt