document.addEventListener("DOMContentLoaded", () => {
  const citySelect = document.getElementById("citySelect");
  const districtSelect = document.getElementById("districtSelect");
  const searchInput = document.getElementById("searchInput");
  const searchButton = document.getElementById("searchButton");
  const resultSection = document.getElementById("resultSection");

  const districts = {
    서울: [
      "전체",
      "종로구",
      "중구",
      "용산구",
      "성동구",
      "광진구",
      "동대문구",
      "중랑구",
      "성북구",
      "강북구",
      "도봉구",
      "노원구",
      "은평구",
      "서대문구",
      "마포구",
      "양천구",
      "강서구",
      "구로구",
      "금천구",
      "영등포구",
      "동작구",
      "관악구",
      "서초구",
      "강남구",
      "송파구",
      "강동구",
    ],
    대구: ["전체", "동구", "달서구", "달성군", "서구", "수성구", "중구"],
    부산: ["전체", "서구", "수영구", "금정구", "남구", "사상구", "연제구", "해운대구"],
    대전: ["전체", "중구", "대덕구", "서구", "동구"],
    광주: ["전체", "동구", "서구", "남구", "북구", "광산구"],
    인천: ["전체", "중구", "동구", "미추홀구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "옹진군"],
  };

  const onCityChange = () => {
    const city = citySelect.value;
    console.log("City selected:", city); // 도시 선택 확인
    districtSelect.innerHTML = '<option value="">구 선택</option>'; // 초기화
    if (city) {
      const options = districts[city].map((district) => `<option value="${district}">${district}</option>`).join("");
      districtSelect.innerHTML += options;
    }
    console.log("District options updated:", districtSelect.innerHTML); // 구 옵션 업데이트 확인
  };

  const onSearch = () => {
    const city = citySelect.value;
    const district = districtSelect.value;

    console.log("Selected city:", city);
    console.log("Selected district:", district);

    if (!city || !district) {
      alert("도시와 구를 모두 선택하세요.");
      return;
    }

    const region = encodeURIComponent(`${city} ${district}`);
    const url = `${rootPath.endsWith("/") ? rootPath : rootPath + "/"}search?region=${region}`;

    console.log("Fetch URL:", url);

    fetch(url)
      .then((response) => {
        if (!response.ok) throw new Error("Network response was not ok.");
        return response.text();
      })
      .then((html) => {
        resultSection.innerHTML = html;
      })
      .catch((error) => {
        console.error("There was a problem with the fetch operation:", error);
        resultSection.innerHTML = `<p>검색 중 오류가 발생했습니다. 다시 시도해 주세요.</p>`;
      });
  };

  const onEnterSearch = (event) => {
    if (event.key === "Enter") {
      const query = searchInput.value.trim();
      if (!query) {
        alert("검색어를 입력하세요.");
        return;
      }

      const url = `${rootPath.endsWith("/") ? rootPath : rootPath + "/"}search?search=${encodeURIComponent(query)}`;

      fetch(url)
        .then((response) => {
          if (!response.ok) throw new Error("Network response was not ok.");
          return response.text();
        })
        .then((html) => {
          resultSection.innerHTML = html;
        })
        .catch((error) => {
          console.error("There was a problem with the fetch operation:", error);
          resultSection.innerHTML = `<p>검색 중 오류가 발생했습니다. 다시 시도해 주세요.</p>`;
        });
    }
  };

  citySelect.addEventListener("change", onCityChange);
  searchButton.addEventListener("click", onSearch);
  searchInput.addEventListener("keydown", onEnterSearch);

  onCityChange(); // 초기 로드 시 구 목록 설정
});
