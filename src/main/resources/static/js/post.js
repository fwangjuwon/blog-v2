
//1. 리스너
$("#btn-write").click(() => {
    write();
});

    $("#btn-delete").click(() => {
        deletePost();
    });
    
    async function deletePost() {
        let postId = $("#postId").val();
        let response = await fetch(`/s/api/post/${postId}`, {
            method: "DELETE" // delete는 body가 없다.
        });
        let responseParse = await response.json();
    
        if (responseParse.code == 1) {
            alert("삭제성공");
            location.href = "/";
        } else {
            alert("삭제실패");
        }
    }
async function loading() {
        //console.log(location.href);
        let postId = $("#postId").val();
        let response = await fetch(`/api/post/${postId}`);
        let responseParse = await response.json();  // text(), json()
        console.log(responseParse);
        userInfoRender(responseParse);
    }
    function userInfoRender(responseParse) {
        let username = responseParse.data.post.user.username;
        let title = responseParse.data.post.title;
        let content = responseParse.data.post.content;
        let auth = responseParse.data.auth; // 권한이 있는지 없는지 판단해서 true, false
        if (auth == true) {
            $("#auth-box").css("display", "block");
        }
        $("#username").text(username);
        $("#title").text(title);
        $("#content").html(content);
    }
    loading();

//2. 기능
async function write() {
    let writeDto = {
        title: $("#title").val(),
        content: $("#content").val()
    }
    //console.log(writeDto);
    
    let response = await fetch("/s/post", {
        method: "POST",
        body: JSON.stringify(writeDto),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        }
    });
    let responseParse = await response.json();
    if (responseParse.code == 1) {
        alert("글쓰기 성공");
        location.href = "/";
    } else {
        alert("글쓰기 실패");
    }
}

