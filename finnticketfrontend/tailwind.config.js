/** @type {import('tailwindcss').Config} */

const plugin = require("tailwindcss/plugin")

const Myclass = plugin(function({addUtilities})
{
  addUtilities({
    ".my-rotate-y-180":{
      transform:"rotateY(180deg)"
    },
    ".preserve-3d":{
      transformStyle:"preserve-3d",
    }, 
    ".perspective":{
      perspective:"1000px",
    },
    ".backface-hidden":{
      backfaceVisibility:"hidden",
    },
  })
})

module.exports = {
  content: ["./src/**/*.{html,js}"],
  theme: {
    extend: {
      colors: {
        'regal-blue': '#243c5a',
        'white-box': '#D9D9D9', 
        'gold': '#DBB86E',
        'goldhov': '#DCB259',
        'card-grey' : '#393E46',
        'header-bg': '#222831',
        'green-available': '#285430',
        'buton-hov': '#152133',
        'green-light': '#647E68',
        'card-white-grey': '#4D5A69',
        'cream-pie': '#E4DCCF',
        'button-orange': '#D88837',
        'button-green': '#2EAB9E',
        'base-yellow': '#D4AF37',
        'newGreen': '#5CA27F',
        'newGreen2': '#67AE8B',
        'btnReturn': '#78B7D8'
      },

      flexBasis: {
        '1/7': '14.2857143%',
        '1': '25%',
        '2/7': '28.5714286%',
        '3/7': '42.8571429%',
        '4': '50%',
        '4/7': '57.1428571%',
        '5/7': '71.4285714%',
        '5': '75%',
        '6/7': '85.7142857%',
      }
    },
  },
  plugins: [require("daisyui"), Myclass],
  daisyui: {
    themes: [
      {
        'finnticket': {
           'primary' : '#393E46',
           'primary-focus' : '#4506cb',
           'primary-content' : '#EEEEEE',

           'secondary' : '#f000b8',
           'secondary-focus' : '#bd0091',
           'secondary-content' : '#EEEEEE',

           'accent' : '#37cdbe',
           'accent-focus' : '#2ba69a',
           'accent-content' : '#EEEEEE',

           'neutral' : '#3b424e',
           'neutral-focus' : '#2a2e37',
           'neutral-content' : '#EEEEEE',

           'base-100' : '#222831',
           'base-200' : '#393E46',
           'base-300' : '#393E46',
           'base-content' : '#EEEEEE',

           'info' : '#EEEEEE',
           'success' : '#45934C',
           'warning' : '#FFD369',
           'error' : '#C03E3E',

          '--rounded-box': '1rem',          
          '--rounded-btn': '.5rem',        
          '--rounded-badge': '1.9rem',      

          '--animation-btn': '.25s',       
          '--animation-input': '.2s',       

          '--btn-text-case': 'uppercase',   
          '--navbar-padding': '.5rem',      
          '--border-btn': '1px',            
        },
      },
    ],
  },

}

