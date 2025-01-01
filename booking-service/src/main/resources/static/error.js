
  var plus="";
  var kif;
  var wrong;
  var marker
  var message= "Sorry that command is not recognized."

    var inputReady = true;
var input = $('.404-input');
input.focus();
$('.container').on('click', function(e){
  input.focus();
});

input.on('keyup', function(e){
  $('.new-output').text(input.val());
  // console.log(inputReady);
});

$('.four-oh-four-form').on('submit', function(e){
  wrong=0
  marker="";

  e.preventDefault();
  var val = $(this).children($('.404-input')).val().toLowerCase();
/* // $('.wrong').wrapAll('<p>').parent().html(''); */
const key =["kittens","home"] ; 
  if (key.indexOf(val)==-1)
  {
      wrong=1; 
      if (wrong)
      {
      marker='<p class="output wrong prompt">' + message +' Try typing \'home\'.</p>'
      resetForm();
      }//endof if wrong
  }
  else
 {  
  resetForm();
  if (val === 'kittens')
  {
    kill()
    showKittens();
  }
  else if(val==='home')
  location.href=location.origin;
  
}//end of of else > of below 
//end of input value matches keys or not 
  



});

function resetForm(withKittens){
  // message = "Sorry that command is not recognized."
  var input = $('.404-input');

  /* if(kif.length==0) 
  {
    plus="";
    console.log(kif.html())
  }
 */

  if (withKittens){

    $('.kittens').removeClass('kittens');
    // message = "Huzzzzzah Kittehs!";
  }


  $('.new-output').removeClass('new-output');
  // input.val('');
  //$x=$('.terminal').html();
  //alert(message+"\n"+$x);

/*   marker="";
  if (wrong)
  marker='<p class="output wrong prompt">' + message +' Try typing \'home\'.</p>' */

  $('.terminal').html(marker+'<p class="prompt">The page you requested cannot be found right meow. Try typing \'kittens\'.</p><p class="prompt output new-output"></p>'+plus);
   $('.new-output').velocity(
    'scroll'
  ), {duration: 100}



}

  function showKittens(){

/*     var gif='https://cataas.com/cat/gif';


        
    if(plus=="")//if kittens unpressed
    {
    plus='<p><img class="kitten-gif" src="' + gif + '""></p>'
    $('.terminal').append(plus);
    console.log(plus)
    }//endofplus
    else
    {
      kif=$('.kitten-gif');
      $('p .kitten-gif').parent()[0].outerHTML=""
     var time=new Date().getTime();
     console.log($('.kitten-gif'));
     var s=   kif [0].src +"?"+ time;
    //  kif [0].src = s
     plus='<p><img class="kitten-gif" src="' + s + '""></p>'
    }//endof if plus is null */

      $('.terminal').append("<div class='kittens'>"+
                  "<p class='prompt'>                               ,----,         ,----,                                          ,---,</p>" +
                  "<p class='prompt'>       ,--.                ,/   .`|       ,/   .`|                     ,--.              ,`--.' |</p>" +
                  "<p class='prompt'>   ,--/  /|    ,---,     ,`   .'  :     ,`   .'  :     ,---,.        ,--.'|   .--.--.    |   :  :</p>" +
                  "<p class='prompt'>,---,': / ' ,`--.' |   ;    ;     /   ;    ;     /   ,'  .' |    ,--,:  : |  /  /    '.  '   '  ;</p>" +
                  "<p class='prompt'>:   : '/ /  |   :  : .'___,/    ,'  .'___,/    ,'  ,---.'   | ,`--.'`|  ' : |  :  /`. /  |   |  |</p>" +
                  "<p class='prompt'>|   '   ,   :   |  ' |    :     |   |    :     |   |   |   .' |   :  :  | | ;  |  |--`   '   :  ;</p>" +
                  "<p class='prompt'>'   |  /    |   :  | ;    |.';  ;   ;    |.';  ;   :   :  |-, :   |   \\ | : |  :  ;_     |   |  '</p>" +
                  "<p class='prompt'>|   ;  ;    '   '  ; `----'  |  |   `----'  |  |   :   |  ;/| |   : '  '; |  \\  \\    `.  '   :  |</p>" +
                  "<p class='prompt'>:   '   \\   |   |  |     '   :  ;       '   :  ;   |   :   .' '   ' ;.    ;   `----.   \\ ;   |  ;</p>" +
                  "<p class='prompt'>'   : |.  \\ |   |  '     '   :  |       '   :  |   '   :  ;/| '   : |  ; .'  /  /`--'  /  `--..`;  </p>" +
                  "<p class='prompt'>|   | '_\\.' '   :  |     ;   |.'        ;   |.'    |   |    \\ |   | '`--'   '--'.     /  .--,_   </p>" +
                  "<p class='prompt'>'   : |     ;   |.'      '---'          '---'      |   :   .' '   : |         `--'---'   |    |`.  </p>" +
                  "<p class='prompt'>;   |,'     '---'                                  |   | ,'   ;   |.'                    `-- -`, ; </p>" +
                  "<p class='prompt'>'---'                                              `----'     '---'                        '---`'</p>" +
                  "<p class='prompt'>                                                              </p></div>");

 var lines = $('.kittens p');

printer();//or Animate

    setTimeout(function(){
     
        resetForm(true);
        var gif='https://cataas.com/cat/gif';


        
        if(plus=="")//if kittens unpressed
        {
        plus='<p><img class="kitten-gif" src="' + gif + '" ></p>'
        $('.terminal').append(plus);
        console.log(plus)
        }//endofplus
        else
        {
          kif=$('.kitten-gif');
          $('p .kitten-gif').parent()[0].outerHTML=""
         var time=new Date().getTime();
         console.log($('.kitten-gif'));
         var s=   kif [0].src +"?"+ time;
        //  kif [0].src = s
         plus='<p><img class="kitten-gif" src="' + s + '" ></p>'
        //  kif[0].src=s
        $('terminal').append(plus)
        }//endof if plus is null


     }//end of function
     , (lines.length * 100) + 1000);
     //end of setTimeOUT

  }//end of show kittens

 $('.eAni').velocity(
      'scroll'
    ), {duration: 100}

  function textEffect(line){
    var alpha = [';', '.', ',', ':', ';', '~', '`'];
    var animationSpeed = 10;
    var index = 0;
    var string = line.text();
    var splitString = string.split("");
    var copyString = splitString.slice(0);

    var emptyString = copyString.map(function(el){
        return [alpha[Math.floor(Math.random() * (alpha.length))], index++];
    })

    emptyString = shuffle(emptyString);

    $.each(copyString, function(i, el){
        var newChar = emptyString[i];
        toUnderscore(copyString, line, newChar);

        setTimeout(function(){
          fromUnderscore(copyString, splitString, newChar, line);
        },i * animationSpeed);
      })
  }

  function toUnderscore(copyString, line, newChar){
    copyString[newChar[1]] = newChar[0];
    line.text(copyString.join(''));
  }

  function fromUnderscore(copyString, splitString, newChar, line){
    copyString[newChar[1]] = splitString[newChar[1]];
    line.text(copyString.join(""));
  }


  function shuffle(o){
      for(var j, x, i = o.length; i; j = Math.floor(Math.random() * i), x = o[--i], o[i] = o[j], o[j] = x);
      return o;
  };
let printer=Animate 
function Animate()
{
var lines = $('.kittens p');


    $.each(lines, function(index, line){
      setTimeout(function(){
        $(line).css({
          "opacity": 1
        });

        textEffect($(line))
      }, index * 100);
    });//end of each lines function

    $('.new-output').velocity(
      'scroll'
    ), {duration: 100}
    //end of velocity process 

}//end of Animate 

function Home_MSG()
{
  $('.terminal').append("<div class='kittens'>"+
    "<p class='prompt'>          _____                   _______                   _____                    _____                  </p>" +
    "<p class='prompt'>         /\\    \\                 /::\\    \\                 /\\    \\                  /\\    \\                 </p>" +
    "<p class='prompt'>        /::\\____\\               /::::\\    \\               /::\\____\\                /::\\    \\                </p>" +
    "<p class='prompt'>       /:::/    /              /::::::\\    \\             /::::|   |               /::::\\    \\               </p>" +
    "<p class='prompt'>      /:::/    /              /::::::::\\    \\           /:::::|   |              /::::::\\    \\              </p>" +
    "<p class='prompt'>     /:::/    /              /:::/~~\\:::\\    \\         /::::::|   |             /:::/\\:::\\    \\             </p>" +
    "<p class='prompt'>    /:::/____/              /:::/    \\:::\\    \\       /:::/|::|   |            /:::/__\\:::\\    \\            </p>" +
    "<p class='prompt'>   /::::\\    \\             /:::/    / \\:::\\    \\     /:::/ |::|   |           /::::\\   \\:::\\    \\           </p>" +
    "<p class='prompt'>  /::::::\\    \\   _____   /:::/____/   \\:::\\____\\   /:::/  |::|___|______    /::::::\\   \\:::\\    \\          </p>" +
    "<p class='prompt'> /:::/\\:::\\    \\ /\\    \\ |:::|    |     |:::|    | /:::/   |::::::::\\    \\  /:::/\\:::\\   \\:::\\    \\         </p>" +
    "<p class='prompt'>/:::/  \\:::\\    /::\\____\\|:::|____|     |:::|    |/:::/    |:::::::::\\____\\/:::/__\\:::\\   \\:::\\____\\        </p>" +
    "<p class='prompt'>\\::/    \\:::\\  /:::/    / \\:::\\    \\   /:::/    / \\::/    / ~~~~~/:::/    /\\:::\\   \\:::\\   \\::/    /        </p>" +
    "<p class='prompt'> \\/____/ \\:::\/:::/    /   \\:::\\    \\ /:::/    /   \\/____/      /:::/    /  \\:::\\   \\:::\\   \\/____/         </p>" +
    "<p class='prompt'>          \\::::::/    /     \\:::\\    /:::/    /                /:::/    /    \\:::\\   \\:::\\    \\             </p>" +
    "<p class='prompt'>           \\::::/    /       \\:::\\__/:::/    /                /:::/    /      \\:::\\   \\:::\\____\\            </p>" +
    "<p class='prompt'>           /:::/    /         \\::::::::/    /                /:::/    /        \\:::\\   \\::/    /            </p>" +
    "<p class='prompt'>          /:::/    /           \\::::::/    /                /:::/    /          \\:::\\   \\/____/             </p>" +
    "<p class='prompt'>         /:::/    /             \\::::/    /                /:::/    /            \\:::\\    \\                 </p>" +
    "<p class='prompt'>        /:::/    /               \\::/____/                /:::/    /              \\:::\\____\\                </p>" +
    "<p class='prompt'>        \\::/    /                 ~~                      \\::/    /                \\::/    /                 </p>" +
    "<p class='prompt'>         \\/____/                                           \\/____/                  \\/____/                  </p>" +
    "<p class='prompt'>                                                                                                             </p>" +
    "<p class='prompt'>                                                                                                             </p>" +
    "<p class='prompt'>                                                                                                             </p>" +
    "<p class='prompt'>                                                                                                             </p>" +
    "<p class='prompt'>                                                                                                             </p>" +
"</div>");

}//end of Home_MSG

function kittens_MSG()
{

}//end of kittens_MSG

function kill()
{
  if($('img').length!=0)
  $('img')[0].outerHTML=""; 
}

$(document).keydown(function(event) {
  if (event.key === "Escape") {
      kill( plus="");
     
      // Your logic here
  }
});//kill on escape 