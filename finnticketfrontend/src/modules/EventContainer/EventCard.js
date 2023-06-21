import React from 'react'
import { useState } from 'react';
import MGEF from '../../assets/img/MGEF.jpg'
import { Outlet, Link } from 'react-router-dom'
import Information from '../EventDeploy/Information'
import { SnackbarProvider, enqueueSnackbar } from 'notistack'

function EventCard() {

  const [divEnabled, setDivEnabled] = useState(true);

  const handleIconClick = () => {
    setDivEnabled(!divEnabled);
  };

  const disabledEvent = () => {
    enqueueSnackbar("Evento deshabilitado!", {
      variant: "warning",
    });
  }

  const enabledEvent = () => {
    enqueueSnackbar("Evento habilitado!", {
      variant: "success",
    });
  }

  return (
    <>
      <SnackbarProvider autoHideDuration={1000}
        anchorOrigin={{
          vertical: 'top',
          horizontal: 'right'
        }}
      />

      <div className={`bg-card-white-grey rounded mt-2 mb-8 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 p-6 items-center border-2
      ${divEnabled ? '' : 'opacity-40'
        }`} >
        <div className='mb-4 sm:mb-0 sm:mr-2 md:mr-5 px-5 lh:mx-8 lg:mr-5 lg:px-5'>
          <img src={MGEF} alt="Artist" className="rounded-xl h-auto max-h-60 max-w-full mx-auto sm:h-full sm:w-full lg:h-auto lg:w-auto" />
        </div>
        <div className='mx-8 sm:col-span-2'>
          <Information />
        </div>
        <div className='flex-row grid grid-cols-5 justify-items-center lg:justify-items-end h-48 mt-8 lg:grid-cols-1'>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-6 h-6">
            <path fillRule="evenodd" d="M9.401 3.003c1.155-2 4.043-2 5.197 0l7.355 12.748c1.154 2-.29 4.5-2.599 4.5H4.645c-2.309 0-3.752-2.5-2.598-4.5L9.4 3.003zM12 8.25a.75.75 0 01.75.75v3.75a.75.75 0 01-1.5 0V9a.75.75 0 01.75-.75zm0 8.25a.75.75 0 100-1.5.75.75 0 000 1.5z" clipRule="evenodd" />
          </svg>

          <Link to="/editEvent">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-6 h-6">
              <path d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l8.4-8.4z" />
            </svg>
          </Link>

          <div
            className={` ${divEnabled ? '' : ''
              }`}
            onClick={handleIconClick}
          >
            {divEnabled ? (
              <svg xmlns="http://www.w3.org/2000/svg" onClick={disabledEvent} fill="currentColor" className="w-6 h-6">
                <path d="M12 15a3 3 0 100-6 3 3 0 000 6z" />
                <path fillRule="evenodd" d="M1.323 11.447C2.811 6.976 7.028 3.75 12.001 3.75c4.97 0 9.185 3.223 10.675 7.69.12.362.12.752 0 1.113-1.487 4.471-5.705 7.697-10.677 7.697-4.97 0-9.186-3.223-10.675-7.69a1.762 1.762 0 010-1.113zM17.25 12a5.25 5.25 0 11-10.5 0 5.25 5.25 0 0110.5 0z" clipRule="evenodd" />
              </svg>
            ) : (
              <svg xmlns="http://www.w3.org/2000/svg" onClick={enabledEvent} fill="currentColor" className="w-6 h-6"><path d="M8.137 15.147c-.71-.857-1.146-1.947-1.146-3.147 0-2.76 2.241-5 5-5 1.201 0 2.291.435 3.148 1.145l1.897-1.897c-1.441-.738-3.122-1.248-5.035-1.248-6.115 0-10.025 5.355-10.842 6.584.529.834 2.379 3.527 5.113 5.428l1.865-1.865zm6.294-6.294c-.673-.53-1.515-.853-2.44-.853-2.207 0-4 1.792-4 4 0 .923.324 1.765.854 2.439l5.586-5.586zm7.56-6.146l-19.292 19.293-.708-.707 3.548-3.548c-2.298-1.612-4.234-3.885-5.548-6.169 2.418-4.103 6.943-7.576 12.01-7.576 2.065 0 4.021.566 5.782 1.501l3.501-3.501.707.707zm-2.465 3.879l-.734.734c2.236 1.619 3.628 3.604 4.061 4.274-.739 1.303-4.546 7.406-10.852 7.406-1.425 0-2.749-.368-3.951-.938l-.748.748c1.475.742 3.057 1.19 4.699 1.19 5.274 0 9.758-4.006 11.999-8.436-1.087-1.891-2.63-3.637-4.474-4.978zm-3.535 5.414c0-.554-.113-1.082-.317-1.562l.734-.734c.361.69.583 
                1.464.583 2.296 0 2.759-2.24 5-5 5-.832 0-1.604-.223-2.295-.583l.734-.735c.48.204 1.007.318 1.561.318 2.208 0 4-1.792 4-4z"/></svg>
            )}
          </div>

          <Link to="/analysis">
            <svg xmlns="http://www.w3.org/2000/svg" className="w-6 h-6" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
              <rect x="3" y="18" width="6" height="3" />
              <rect x="9" y="12" width="6" height="9" />
              <rect x="15" y="6" width="6" height="15" />
            </svg>
          </Link>

          <Link to="/collaborators">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-6 h-6">
              <path fillRule="evenodd" d="M8.25 6.75a3.75 3.75 0 117.5 0 3.75 3.75 0 01-7.5 0zM15.75 9.75a3 3 0 116 0 3 3 0 01-6 0zM2.25 9.75a3 3 0 116 0 3 3 0 01-6 0zM6.31 15.117A6.745 6.745 0 0112 12a6.745 6.745 0 016.709 7.498.75.75 0 01-.372.568A12.696 12.696 0 0112 21.75c-2.305 0-4.47-.612-6.337-1.684a.75.75 0 01-.372-.568 6.787 6.787 0 011.019-4.38z" clipRule="evenodd" />
              <path d="M5.082 14.254a8.287 8.287 0 00-1.308 5.135 9.687 9.687 0 01-1.764-.44l-.115-.04a.563.563 0 01-.373-.487l-.01-.121a3.75 3.75 0 013.57-4.047zM20.226 19.389a8.287 8.287 0 00-1.308-5.135 3.75 3.75 0 013.57 4.047l-.01.121a.563.563 0 01-.373.486l-.115.04c-.567.2-1.156.349-1.764.441z" />
            </svg>
          </Link>

          <div class="lg:mt-2">
            <Link to="/qr">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-6 h-6"><path d="M21 21v3h3v-3h-1v-1h-1v1h-1zm2 1v1h-1v-1h1zm-23 2h8v-8h-8v8zm1-7h6v6h-6v-6zm20 3v-1h1v1h-1zm-19-2h4v4h-4v-4zm8-3v2h-1v-2h1zm2-8h1v1h-1v-1zm1-1h1v1h-1v-1zm1 
         2v-1h1v1h-1zm0-2h1v-6h-3v1h-3v1h3v1h2v3zm-1-4v-1h1v1h-1zm-7 4h-4v-4h4v4zm6 0h-1v-2h-2v-1h3v1h1v1h-1v1zm-4-6h-8v8h8v-8zm-1 
         7h-6v-6h6v6zm3 0h-1v-1h2v2h-1v-1zm-3 3v1h-1v-1h1zm15 6h2v3h-1v-1h-2v1h-1v-1h-1v-1h1v-1h1v1h1v-1zm-4 
         2h-1v1h-1v-1h-1v-1h1v-1h-2v-1h-1v1h-1v1h-2v1h-1v6h5v-1h-1v-2h-1v2h-2v-1h1v-1h-1v-1h3v-1h2v2h-1v1h1v2h1v-2h1v1h1v-1h1v-2h1v-1h-2v-1zm-1 
         3h-1v-1h1v1zm6-6v-2h1v2h-1zm-9 5v1h-1v-1h1zm5 3v-1h1v2h-2v-1h1zm-3-23v8h8v-8h-8zm7 7h-6v-6h6v6zm-1-1h-4v-4h4v4zm1 
         4h1v2h-1v1h-2v-4h1v2h1v-1zm-4 6v-3h1v3h-1zm-13-7v1h-2v1h1v1h-3v-1h1v-1h-2v1h-1v-2h6zm-1 4v-1h1v3h-1v-1h-1v1h-1v-1h-1v1h-2v-1h1v-1h4zm-4-1v1h-1v-1h1zm19-2h-1v-1h1v1zm-13 4h1v1h-1v-1zm15 2h-1v-1h1v1zm-5 
         1v-1h1v1h-1zm-1-1h1v-3h2v-1h1v-1h-1v-1h-2v-1h-1v1h-1v-1h-1v1h-1v-1h-1v1h-1v1h-1v-1h1v-1h-4v1h2v1h-2v1h1v2h1v-1h2v2h1v-4h1v2h3v1h-2v1h2v1zm1-5h1v1h-1v-1zm-2 1h-1v-1h1v1z"/></svg>
            </Link>
          </div>

        </div>
        <Outlet />
      </div >
    </>
  )
}

export default EventCard