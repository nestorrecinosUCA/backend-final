import React from 'react'
import Signin from '../modules/SingInComponent/Signin'
import OJSS from '../assets/img/OJSS.png'


function Sign() {
  return (
    <>
        {/*Plantilla para signin page*/}
      <div class="lg:hidden">
        <div><Signin /></div>
      </div>

      <div class="hidden lg:block">
        <div class="flex flex-row h-screen">
          <div class="basis-4 h-full">
            <div className='flex min-h-full flex-1 flex-col justify-end px-6 pt-6 lg:px-0'>
              <h2 className='mb-36 pt textarea-lg'>“HE PERDIDO EL HILO,PERO EL ALMA AÚN SE ME ENREDA”</h2>
              <img src={OJSS} alt='Ola japonesa' className='border-r-2'></img>
            </div>
          </div>
          <div class="basis-4"><Signin /></div>
        </div>
      </div>
    </>
  )
}
export default Sign