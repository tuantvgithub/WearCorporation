/**
 * WEBSITE: https://themefisher.com
 * TWITTER: https://twitter.com/themefisher
 * FACEBOOK: https://www.facebook.com/themefisher
 * GITHUB: https://github.com/themefisher/
 */

(function ($) {
  'use strict';

  // Preloader
  $(window).on('load', function () {
    $('#preloader').fadeOut('slow', function () {
      $(this).remove();
    });
  });


  // Instagram Feed
  if (($('#instafeed').length) !== 0) {
    var accessToken = $('#instafeed').attr('data-accessToken');
    var userFeed = new Instafeed({
      get: 'user',
      resolution: 'low_resolution',
      accessToken: accessToken,
      template: '<a href="{{link}}"><img src="{{image}}" alt="instagram-image"></a>'
    });
    userFeed.run();
  }

  setTimeout(function () {
    $('.instagram-slider').slick({
      dots: false,
      speed: 300,
      // autoplay: true,
      arrows: false,
      slidesToShow: 6,
      slidesToScroll: 1,
      responsive: [{
        breakpoint: 1024,
        settings: {
          slidesToShow: 4
        }
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 3
        }
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 2
        }
      }
      ]
    });
  }, 1500);


  // e-commerce touchspin
  $('input[name=\'product-quantity\']').TouchSpin();


  // Video Lightbox
  $(document).on('click', '[data-toggle="lightbox"]', function (event) {
    event.preventDefault();
    $(this).ekkoLightbox();
  });


  // Count Down JS
  $('#simple-timer').syotimer({
    year: 2022,
    month: 5,
    day: 9,
    hour: 20,
    minute: 30
  });

  //Hero Slider
  $('.hero-slider').slick({
    // autoplay: true,
    infinite: true,
    arrows: true,
    prevArrow: '<button type=\'button\' class=\'heroSliderArrow prevArrow tf-ion-chevron-left\'></button>',
    nextArrow: '<button type=\'button\' class=\'heroSliderArrow nextArrow tf-ion-chevron-right\'></button>',
    dots: true,
    autoplaySpeed: 7000,
    pauseOnFocus: false,
    pauseOnHover: false
  });
  $('.hero-slider').slickAnimation();


})(jQuery);


//Add to cart
const addToCart = async (id, isLogin, userId, group) => {

  if (isLogin === true) {

    window.localStorage.setItem('userId', userId);

    let payload;
    let url;
    if (group === 17) {
      url = "https://laptrinhcautrucapi.herokuapp.com/product/id?id=";
    }
    else if (group === 11) {
      url = "https://team-product-api.herokuapp.com/api/products/"
    }
    await fetch(url + id, {
      method: 'GET',
    })
      .then(response => response.json())
      .then(data => {
        console.log(data[0]);
        payload = {
          image_url: data[0].image,
          price: data[0].price+"",
          productId: data[0].id,
          name: data[0].name,
          size: data[0].size,
          quantity: 1,
          userId: userId,
          color:data[0].color
          
        }
      });

    console.log(payload);
    await fetch("https://sp12-cart.herokuapp.com/api/cart/addProduct", {
      method: 'POST', // *GET, POST, PUT, DELETE, etc
      headers: {
        'Content-Type': 'application/json'
      },

      body: JSON.stringify(payload) // body data type must match "Content-Type" header

    })
      .then(res => res.json())
      .then(data => console.log(data));
  } else {
    window.location.replace("/account/login");
  }

}


const handleAddVoucher = ()=>
{
 
  const voucher=document.getElementById('voucher-code');

  const voucher_ele=document.getElementById("voucher");

  voucher_ele.innerHTML=voucher.value;

  document.getElementById('ip_voucher_code').setAttribute('value',voucher.value);

}

const removeProduct = async (id)=>{


  let url="https://sp12-cart.herokuapp.com/api/cart";

  await fetch(url,{
    method:'DELETE',
    headers:{
      'Content-Type':'application/json'
    },
    body:JSON.stringify({
      id:id
    })
  })
  .then(res=>res.json())
  .then(data=>{
    if(data.status===200)
    {
      window.location.reload();
    }
  });

}