document.addEventListener("DOMContentLoaded", function () {
  var menuItems = document.querySelectorAll("nav ul li");
  var body = document.querySelector("body");

  // 메뉴 항목에 서브메뉴 동작 추가
  menuItems.forEach(function (item) {
    var submenu = item.querySelector("ul");

    if (submenu) {
      item.addEventListener("mouseenter", function () {
        submenu.style.maxHeight = submenu.scrollHeight + "px";
        submenu.style.opacity = "1";
        submenu.style.transition = "max-height 0.5s ease, opacity 0.5s ease";
      });

      item.addEventListener("mouseleave", function () {
        submenu.style.maxHeight = "0";
        submenu.style.opacity = "0";
        submenu.style.transition = "max-height 0.5s ease, opacity 0.5s ease";
      });
    }
  });

  // 링크 클릭 시 페이지 로드와 페이드 효과
  document.body.addEventListener("click", function (e) {
    var target = e.target;

    while (target && target.nodeName !== "A") {
      target = target.parentNode;
    }

    if (target && target.nodeName === "A") {
      var url = target.getAttribute("href");

      if (
        url === `${rootPath}/` ||
        window.location.pathname === `${rootPath}/`
      ) {
        return;
      }

      e.preventDefault();

      // POST 요청이 필요한 URL인지 확인
      var method =
        target.getAttribute("data-method") === "POST" ? "POST" : "GET";

      fadeOutAndLoadPage(
        url,
        method,
        method === "POST" ? { key1: "value1", key2: "value2" } : null
      );
    }
  });

  // 페이드 아웃 후 페이지 로드
  function fadeOutAndLoadPage(url, method = "GET", data = null) {
    body.style.transition = "opacity 0.5s";
    body.style.opacity = "0";

    setTimeout(function () {
      loadPage(url, method, data);
    }, 500);
  }

  // 페이지 로드 함수
  function loadPage(url, method = "GET", data = null) {
    var xhr = new XMLHttpRequest();
    xhr.open(method, url, true);
    xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");

    if (method === "POST") {
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      xhr.send(encodeFormData(data));
    } else {
      xhr.send();
    }

    xhr.onload = function () {
      if (xhr.status >= 200 && xhr.status < 400) {
        var parser = new DOMParser();
        var doc = parser.parseFromString(xhr.responseText, "text/html");

        var newContent = doc.querySelector("body").innerHTML;
        body.innerHTML = newContent;

        var newBodyClass = doc.querySelector("body").className;
        body.className = newBodyClass;

        fadeIn();
        reinitializeScripts(); // 스크립트 재초기화
      }
    };
  }

  // 폼 데이터를 URL 인코딩 형식으로 변환하는 함수
  function encodeFormData(data) {
    if (!data) return "";
    return Object.keys(data)
      .map(function (key) {
        return encodeURIComponent(key) + "=" + encodeURIComponent(data[key]);
      })
      .join("&");
  }

  // 페이드 인 효과
  function fadeIn() {
    body.style.transition = "opacity 0.5s";
    body.style.opacity = "1";
  }

  // 스크립트 재초기화 함수
  function reinitializeScripts() {
    // 필요한 스크립트나 이벤트를 다시 설정합니다.
    var fireworkButtons = document.querySelectorAll(".fireworkBtn");

    fireworkButtons.forEach((btn) => {
      btn.addEventListener("click", () => {
        btn.classList.add("on");

        setTimeout(() => {
          btn.classList.remove("on");
        }, 3000);
      });
    });

    // 여기서 추가적으로 필요한 초기화 작업들을 넣을 수 있습니다.
    initializeMenuItems(); // 메뉴 초기화
    initializeLoginForm(); // 로그인 폼 초기화
  }

  // 처음 페이지 로드 시 이벤트 초기화
  reinitializeScripts();
});

function initializeMenuItems() {
  var menuItems = document.querySelectorAll("nav ul li");

  menuItems.forEach(function (item) {
    var submenu = item.querySelector("ul");

    if (submenu) {
      item.addEventListener("mouseenter", function () {
        submenu.style.maxHeight = submenu.scrollHeight + "px";
        submenu.style.opacity = "1";
        submenu.style.transition = "max-height 0.5s ease, opacity 0.5s ease";
      });

      item.addEventListener("mouseleave", function () {
        submenu.style.maxHeight = "0";
        submenu.style.opacity = "0";
        submenu.style.transition = "max-height 0.5s ease, opacity 0.5s ease";
      });
    }
  });
}

function initializeLoginForm() {
  const INPUT_INDEX = {
    ID: 0,
    PASSWORD: 1,
    BUTTON: 2,
  };

  const ERROR_MESSAGE = [
    "* 아이디는 필수 항목입니다",
    "* 비밀번호는 필수 항목입니다",
  ];

  const login_form = document.querySelector("form.user.join");
  login_form.action = `${rootPath}/user/login`; // 로그인 폼의 액션을 설정합니다.
  const login_inputs = login_form.querySelectorAll("input");
  const error_inputs = login_form.querySelectorAll("span");

  const emptyValid = (index) => {
    const text = login_inputs[index].value;
    if (!text) {
      error_inputs[index].textContent = ERROR_MESSAGE[index];
      error_inputs[index].style.display = "inline-block";
      login_inputs[index].select();
      return false;
    }
    return true;
  };

  const onLoginSubmit = (event) => {
    event.preventDefault(); // prevent default form submission

    let yesValid = true;
    for (let i = 0; i < error_inputs.length; i++) {
      const span = error_inputs[i];
      span.style.display = "none";
      if (!(yesValid = emptyValid(i))) break;
    }

    if (yesValid) {
      // Handle form submission via AJAX
      const xhr = new XMLHttpRequest();
      xhr.open("POST", login_form.action, true); // 여기에서 수정된 URL이 사용됩니다.
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      xhr.onload = function () {
        if (xhr.status >= 200 && xhr.status < 400) {
          // Handle successful login
          window.location.href = `${rootPath}/`; // Redirect after successful login
        } else {
          // Handle error response
          alert("Login failed. Please try again.");
        }
      };
      const formData = new FormData(login_form);
      xhr.send(new URLSearchParams(formData).toString());
    }
  };

  login_inputs[INPUT_INDEX.BUTTON].addEventListener("click", onLoginSubmit);
}
