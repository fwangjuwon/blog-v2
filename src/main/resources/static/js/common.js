//1. listener
$("#btn-logout").click(()=>{
   logout();
});

//2. 기능
async function logout(){
    let response = await fetch("/logout");
    let responseParse = await response.json(); //json을 javascript로 바꿔주는 것

    if(responseParse.code ==1){
        location.href="/";
    }
}