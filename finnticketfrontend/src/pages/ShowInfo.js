import React from 'react'
import EventInfo from '../modules/EventDeploy/EventInfo'
import Places from '../modules/EventDeploy/PlacesPanel'
import BuySection from '../modules/EventDeploy/BuySection'
import Navbar from '../components/Navbar'

function ShowInfo() {
  return (
    <>
      <Navbar />
      <div class="flex flex-col lg:flex-row h-full">
        <div class="w-full lg:basis-4"><EventInfo /></div>
        <div class="w-full lg:basis-4">
          <div class="w-full h-full bg-transparent group perspective">
            <div class="relative preserve-3d group-hover:my-rotate-y-180 w-full h-full duration-1000">
              <div class="absolute backface-hidden w-full h-full">
                <Places />
              </div>
              <div class="absolute my-rotate-y-180 backface-hidden w-full h-full bg-transparent">
                <BuySection />
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default ShowInfo