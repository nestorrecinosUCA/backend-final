import React from 'react'
import PlaceComponent from './PlaceComponent'

function Places() {
  return (
    <>
      <div class="bg-card-grey my-10 mx-5 sm:mx-20 rounded-lg p-5 sm:p-10">
        <div class="bg-header-bg py-5 px-5 rounded-lg items-center text-center">
          <h2 class="text-2xl">LOCALIDADES</h2>
        </div>
        <div class="grid gap-4 gap-y-1 grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-2">
          <PlaceComponent />
          <PlaceComponent />
          <PlaceComponent />
          <PlaceComponent />
        </div>
      </div>
    </>
  )
}

export default Places