import React from 'react'
import iconlogo from '../../assets/img/iconlogo.png'
import google from '../../assets/img/google-logo-9827.png'
import { Outlet, Link } from 'react-router-dom'
import { gapi } from 'gapi-script'
import GoogleLogin from 'react-google-login'
import { useEffect } from 'react'

function Signin() {

  const clientID = "199267379325-pvol6fa9781qc2vos0iscna8l1kai1bn.apps.googleusercontent.com";

  useEffect(() => {
    const start = () => {
      gapi.auth2.init({
        clientId: clientID,
      })

    }
    gapi.load("client:auth2", start)
  }, [])

  const onSucces = (res) => {
    console.log("Login exitoso")
    console.log(res)
  }

  const onFailure = (res) => {
    console.log("Login fallido")
    console.log(res)
  }

  return (
    <>


      <div className="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
        <div className="sm:mx-auto sm:w-full sm:max-w-sm">
          <img
            className="mx-auto h-auto w-auto"
            src={iconlogo}
            alt="FinnTicket"
          />
          <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-white ">
            INICIO DE SESION
          </h2>
        </div>
        <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
          <form className="space-y-6" action="#" method="POST">
            <div>
              <label htmlFor="email" className="block text-sm font-medium leading-6 text-white-box">
                Usuario
              </label>
              <div className="mt-2">
                <input
                  id="email"
                  name="email"
                  type="email"
                  autoComplete="email"
                  required
                  className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-gold sm:text-sm sm:leading-6"
                />
              </div>
            </div>

            <div>
              <div className="flex items-center justify-between">
                <label htmlFor="password" className="block text-sm font-medium leading-6 text-white">
                  Contraseña
                </label>

              </div>
              <div className="mt-2">
                <input
                  id="password"
                  name="password"
                  type="password"
                  autoComplete="current-password"
                  required
                  className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-gold sm:text-sm sm:leading-6"
                />
              </div>
            </div>

            <div>
              <Link to="/homeWNavbar">
                <button
                  type="submit"
                  className="flex w-full justify-center rounded-md bg-gold px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-goldhov focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-white"
                >
                  Iniciar sesion
                </button>
              </Link>
            </div>
            <div>
              {/*<button
                type="submit"
                className="flex w-full justify-center rounded-md bg-gold px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-goldhov focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-white">
                <img
                  className="mx-3 h-5 w-5"
                  src={google}
                  alt="Google Logo"
                />
                <a>Inicia Sesion con google</a>
                </button>*/}
              <GoogleLogin clientId={clientID}
                onSuccess={onSucces}
                onFailure={onFailure}
                cookiePolicy={"single_host_policy"}
                className='w-full justify-center' />
            </div>
          </form>
        </div>
      </div>
      <Outlet />
    </>
  )
}

export default Signin