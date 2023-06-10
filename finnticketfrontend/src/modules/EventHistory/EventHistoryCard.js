import React from 'react'
import MGEF from '../../assets/img/MGEF.jpg'
import Information from '../EventDeploy/Information'

function EventHistoryCard() {
  return (
    <>
        <div className='bg-card-white-grey rounded mt-2 mb-8 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 p-6 items-center border-4'>
        <div className='mb-4 sm:mb-0 sm:mr-2 md:mr-5 px-5 lh:mx-8 lg:mr-5 lg:px-5'>
          <img src={MGEF} alt="Artist" className="rounded-xl h-auto max-h-60 max-w-full mx-auto sm:h-full sm:w-full lg:h-auto lg:w-auto" />
        </div>
        <div className='mx-0 md:mx-8 lg:mx-8 2xl:mx-8 col-span-2 sm:col-span-3 '>
          <Information />
        </div>
        </div>
    </>
  )
}

export default EventHistoryCard