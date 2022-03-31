//1. event listener: 회원가입 버튼을 클릭할 때!
$("#btn-join").click(()=>{
    join();
});

$("#btn-login").click(()=>{
    login();
});

$("#btn-update").click(()=>{
    update();
});


//2. 기능 function 내부는 순차적!
//회원가입 요청 함수
async function join(){
//(1)username, password, email, addr 찾아서 자바스크립트 오브젝트로 만들기
  let joinDto = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            addr: $("#addr").val()
        }

   //(3)fetch로 요청 
        let response = await fetch("/join",{
            method: "POST",
            body: JSON.stringify(joinDto), //(2)자바스크립트 오브젝트를 json으로 변환
            headers: {
                'Content-Type': 'application/json; charset=utf-8',
            }
        });

        let responseParse = await response.json();

//(4)회원가입이 잘 되면 알림창 띄우고, 로그인 page로 이동 
 if (responseParse.code == 1) {
            alert("회원가입에 성공하였습니다.");
            location.href = "/loginForm";
        } else {
            alert("회원가입에 실패하였습니다");
        }
}

//로그인 요청 함수
async function login(){

    //checkbox의 체크 여부를 제이쿼리에서 확인하는 법!! 
    let checked= $("#remember").is(':checked'); //true, false
    
//(1)username, password찾아서 자바스크립트 오브젝트로 만들기
  let loginDto = {

            username: $("#username").val(),
            password: $("#password").val(),
            remember: checked ? "on" : "off" // true이면 on, false이면 off
               }

        let response = await fetch("/login",{
            method: "POST",
            body: JSON.stringify(loginDto), //(2)자바스크립트 오브젝트를 json으로 변환
            headers: {
                'Content-Type': 'application/json; charset=utf-8',
            }
        });

        let responseParse = await response.json();

         if (responseParse.code == 1) {
            alert("로그인에 성공하였습니다.");
            location.href = "/";
        } else {
            alert("로그인에 실패하였습니다");
        }
    }


    async function update() {
        let id = $("#id").val();
        let updateDto = {
            password: $("#password").val(),
            email: $("#email").val(),
            addr: $("#addr").val()
        }
    
        let response = await fetch(`/s/api/user/${id}`, {
            method: "PUT",
            body: JSON.stringify(updateDto),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        });
        let responseParse = await response.json();
    
        if (responseParse.code == 1) {
            alert("업데이트 성공");
            location.href = `/s/user/${id}`;
        } else {
            alert("업데이트 실패");
        }
    }