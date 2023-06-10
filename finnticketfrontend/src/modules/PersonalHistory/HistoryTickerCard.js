import React from 'react'
import MGEF from '../../assets/img/MGEF.jpg'
import InfoCard from './InfoCard'

function HistoryTickerCard() {
    return (
        <>
            <div className='bg-card-white-grey rounded mt-2 mb-8 border-2'>
                <div className='flex flex-col sm:flex-row md:flex-col lg:flex-row 2xl:flex-row items-center py-8'>
                    <div className='mb-4 sm:mb-0 sm:mr-2 md:mr-5 px-5 lh:mx-8 lg:mr-5 lg:px-5'>
                        <img src={MGEF} alt="Artist" className="rounded-xl h-60 max-h-60 max-w-full mx-auto sm:h-full sm:w-full lg:h-auto lg:w-auto" />
                    </div>
                    <div className='grid grid-cols-1 gap-4 py-4 px-4 w-64 sm:w-full sm:grid-cols-2 md:grid-cols-2 md:w-full  lg:grid-cols-3 lg:w-full 2xl:grid-cols-5  '>
                        <InfoCard />
                        <InfoCard />
                        <InfoCard />
                        <InfoCard />
                        <InfoCard />
                    </div>
                </div>
                <div className='p-5 w-full h-auto text-end'>
                    <a className='bg-card-grey shadow shadow-white w-60 font-bold rounded-md p-2 px-10'>Total: $300</a>
                </div>
            </div>
            
        </>
    )
}

export default HistoryTickerCard