<template>
  <div class="nav-wrapper position-relative end-0">
    <!-- 사람유형 -->
    <ul class="nav nav-pills nav-fill p-1" role="tablist" data-id="hi">
      <li
        class="nav-item"
        v-for="(item, index) in withWhomArr"
        :key="item"
        @click="selectWithWhom(index)"
      >
        <a
          class="nav-link mb-0 px-0 py-1 active"
          data-bs-toggle="tab"
          role="tab"
          aria-selected="true"
        >
          #{{ item }}
        </a>
      </li>
    </ul>
  </div>
  <div class="nav-wrapper position-relative end-0">
    <!-- 계절 유형 -->
    <ul class="nav nav-pills nav-fill p-1" role="tablist">
      <li
        class="nav-item"
        v-for="(item, index) in seasonArr"
        :key="item"
        @click="selectSeason(index)"
      >
        <a
          class="nav-link mb-0 px-0 py-1 active"
          data-bs-toggle="tab"
          role="tab"
          aria-selected="true"
        >
          #{{ item }}
        </a>
      </li>
    </ul>
  </div>
  <div class="nav-wrapper position-relative end-0">
    <!-- 지역유형 -->
    <ul class="nav nav-pills nav-fill p-1" role="tablist">
      <li
        class="nav-item"
        v-for="(item, index) in areaArr"
        :key="item"
        @click="selectArea(index)"
      >
        <a
          class="nav-link mb-0 px-0 py-1 active"
          data-bs-toggle="tab"
          role="tab"
          aria-selected="true"
        >
          #{{ item }}
        </a>
      </li>
    </ul>
  </div>
  <div class="nav-wrapper position-relative end-0">
    <!-- 여행 유형 -->
    <ul class="nav nav-pills nav-fill p-1" role="tablist">
      <li
        class="nav-item"
        v-for="(item, index) in themeArr"
        :key="item"
        @click="selectTheme(index)"
      >
        <a
          class="nav-link mb-0 px-0 py-1 active"
          data-bs-toggle="tab"
          role="tab"
          aria-selected="true"
        >
          #{{ item }}
        </a>
      </li>
    </ul>
  </div>
</template>

<script>
import setNavPills from "@/assets/js/nav-pills.js";
import { mapMutations } from "vuex";
import axios from "axios";
import { API_BASE_URL } from "@/config/index.js";

const boardStore = "boardStore";
export default {
  name: "BoardCategory",
  data() {
    return {
      withWhomArr: [
        "상관없음",
        "남자끼리",
        "여자끼리",
        "연인끼리",
        "부모님과",
        "아이들과",
        "혼자",
        "기타",
      ],
      seasonArr: ["상관없음", "봄", "여름", "가을", "겨울"],
      areaArr: ["상관없음", "서울", "부산", "여수", "대구", "제주도", "기타"],
      themeArr: ["상관없음", "바다,강", "산", "액티비티", "호캉스", "기타"],
      withWhom: "0",
      season: "0",
      area: "0",
      theme: "0",
    };
  },
  mounted() {
    setNavPills();
  },
  created() {
    this.getListByCategory();
  },
  methods: {
    ...mapMutations(boardStore, ["setSearchByCategoryBoards", "setCategory"]),
    getListByCategory() {
      axios({
        method: "post",
        url: API_BASE_URL + "board/searchByCategory",
        data: {
          categoryArea: this.area,
          categorySeason: this.season,
          categoryTheme: this.theme,
          categoryWithWhom: this.withWhom,
        },
      }).then((res) => {
        this.setSearchByCategoryBoards(res.data.boards);
        var category = [this.withWhom, this.season, this.area, this.theme];
        this.setCategory(category);
      });
    },
    selectWithWhom(index) {
      this.withWhom = index;
      this.getListByCategory();
    },
    selectSeason(index) {
      this.season = index;
      this.getListByCategory();
    },
    selectArea(index) {
      this.area = index;
      this.getListByCategory();
    },
    selectTheme(index) {
      this.theme = index;
      this.getListByCategory();
    },
  },
};
</script>
