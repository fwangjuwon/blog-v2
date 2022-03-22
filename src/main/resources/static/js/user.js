//1. event listener: 회원가입 버튼을 클릭할 때!
$("#btn-join").click(()=>{
    join();
});

$("#btn-login").click(()=>{
    login();
});

//2. 기능 function 내부는 순차적!

//회원가입 요청 메소드
async function join(){
//(1)username, password, email, addr 찾아서 자바스크립트 오브젝트로 만들기
  let joinDto = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            addr: $("#addr").val()
        }

   //(3)fetch로 요청 
        let response = await fetch("/api/join",{
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

//로그인 요청 메소드
async function login(){
//(1)username, password찾아서 자바스크립트 오브젝트로 만들기
  let loginDto = {
            username: $("#username").val(),
            password: $("#password").val(),
               }

        let response = await fetch("/api/login",{
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