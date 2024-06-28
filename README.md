
# 📱shop-techmya
 1인 크리에이터들을 위한 최고의 모바일 액세서리 Shop!!

### 📋프로젝트 소개
* 개발기간 : 2024.06.25 - 2024.06.28 (4일)
* 최근 수요가 급격히 증가하고 있는 1인 크리에이터에게 필요한 방송 주변 장비 및 액세서리를 판매하는 온라인 쇼핑몰과 관리자 페이지
  

### 프로젝트 스터디 목표
- 쇼핑몰 관리 프로세스 이해 증진
- 협업 및 커뮤니케이션 능력 강화
- 실제 환경에서의 적용 가능성 탐색
- 학습 및 개인 발전


### 📈주요 목적
1. 재고 관리 최적화: 가시적인 재고 관리로 인한 업무 난이도 하향으로 인한 효율적인 재고관리로 비용 절감.
2. 주문 및 상품 관리: 상품의 등록, 수정과 주문 처리 등 통합적인 기능 수행.
3. 게시판 관리: 주요 공지사항 및 FAQ, 1:1 문의를 통한 고객 관리 용이.
   

### 🛠️주요 기능
1. 회원관리
   - 회원 정보 조회
   - 회원 계정 생성
2. 게시판 관리
   - FAQ 게시판
     - 게시글 조회
       - 전체 조회
       - 상세 조회
     - 게시글 등록
   - 공지사항 및 문의 게시판
     - 게시글 조회
       - 전체 조회
       - 상세 조회
     - 게시글 등록
3. 상품 관리
   - 상품 등록
   - 상품 조회
   - 상품 판매글 조회
   - 상품 판매글 등록
   - 상품 판매용 이미지 보여주기
4. 재고 관리
   - 재고 조회
     - 이름 조회
     - 전체 조회
   - 입고 전체 조회
   - 출고 전체 조회
5. 주문 관리
   - 주문 조회
     - 전체 조회
     - 회원명 조회
     - 주문 상세 조회
  


### 🐬데이터베이스 구성
[ERDcloud](https://www.notion.so/coffit23/ERD-dd0a633005d84a369d7bb7646868bebb?pvs=4#53c223cd509d4feea2e045b7cdb040eb)

### 📂메뉴 구조도
![DBSTRUCTOR](https://github.com/l2chmnl/shop-techmya/assets/162394517/ee47120f-514d-4f27-ab00-c00687a082a1)


### 📊기대효과
- 상품/재고 관리 효율성 향상 : 주문과 재고를 실시간으로 관리하여 서류와 현장의 차이를 최소화 할 수 있다.
- 시간과 장소의 제약 최소화 : 대면 및 방문 없이 전반적인 관리가 가능하여 제약을 최소화 하여 고객 만족을 높인다.
- 운영 피드백 용이 : 고객 및 업무 프로세스 또한 온라인 비대면으로 피드백을 주고 받을 수 있어 다양한 장단점 파악이 가능하다.


## 📑상세 다이어그램 및 기획 문서 노션
  🔗[테크먀-켓 노션](https://www.notion.so/coffit23/3-3355ABC-c26bbee54bbf44fd86fc559fd41e5981?pvs=4)
* [ERD](https://www.notion.so/coffit23/ERD-dd0a633005d84a369d7bb7646868bebb)
* [TEST CASE](https://www.notion.so/coffit23/TEST-CASE-794dbaf902654990aa8641309e937833)

* * *

## 🧑‍💻팀원 구성
1. 송재혁
2. 장준영
3. 연주현
4. 이창민
5. ~~육슬찬~~

## ⚙️ 개발 환경
* devtool : IntelliJ IDEA 2024.1.3 (Ultimate Edition)
* JAVA JDK: Temurin version '17.0.10'
* MySQL-connector-j : 8.0.33
* Mybatis : 3.5.6
* Build Tool : gradle
* Version Control : Git
* Communicate : Slack
* Collaboration Tool : Figma, Github, Notion, ERDCLOUD

## 🩻프로젝트 구조
```
  java  
  │  └─com  
  │      └─ohgiraffers  
  │          └─techmya  
  │              ├─admin  
  │              │  ├─common  
  │              │  │  └─paging  
  │              │  ├─order  
  │              │  │  ├─controller  
  │              │  │  └─model  
  │              │  │      ├─dao  
  │              │  │      ├─dto  
  │              │  │      └─service  
  │              │  ├─product  
  │              │  │  ├─controller  
  │              │  │  └─model  
  │              │  │      ├─dao  
  │              │  │      ├─dto  
  │              │  │      └─service  
  │              │  └─stock  
  │              │      ├─controller  
  │              │      └─model  
  │              │          ├─dao  
  │              │          ├─dto  
  │              │          └─service  
  │              ├─board  
  │              │  ├─controller  
  │              │  └─model  
  │              │      ├─dao  
  │              │      ├─dto  
  │              │      └─service  
  │              ├─configuration  
  │              ├─member  
  │              │  ├─controller  
  │              │  └─model  
  │              │      ├─dao  
  │              │      ├─dto  
  │              │      └─service  
  │              └─shop  
  │                  └─order  
  │                      ├─controller  
  │                      └─model  
  │                          ├─dao  
  │                          ├─dto  
  │                          └─service  
  └─resources  
      ├─mappers  
      │  ├─adminOrder  
      │  ├─product  
      │  ├─shopOrder  
      │  └─stock  
      ├─static  
      │  ├─admin  
      │  │  └─assets  
      │  │      ├─css  
      │  │      ├─img  
      │  │      │  ├─avatars  
      │  │      │  ├─backgrounds  
      │  │      │  ├─elements  
      │  │      │  ├─icons  
      │  │      │  │  ├─brands  
      │  │      │  │  └─unicons  
      │  │      │  ├─illustrations  
      │  │      │  ├─layouts  
      │  │      │  └─logo  
      │  │      ├─js  
      │  │      └─vendor  
      │  │          ├─css  
      │  │          │  └─pages  
      │  │          ├─fonts  
      │  │          │  └─boxicons  
      │  │          ├─js  
      │  │          └─libs  
      │  │              ├─apex-charts  
      │  │              ├─highlight  
      │  │              ├─jquery  
      │  │              ├─masonry  
      │  │              ├─perfect-scrollbar  
      │  │              └─popper  
      │  └─shop  
      │      ├─assets  
      │      │  ├─css  
      │      │  ├─images  
      │      │  └─js  
      │      └─order-assets  
      │          └─products-assets  
      │              ├─css  
      │              ├─img  
      │              ├─js  
      │              └─webfonts  
      └─templates  
          ├─admin  
          │  ├─board  
          │  ├─order  
          │  ├─product  
          │  └─stock  
         ├─common  
          │  ├─admin  
          │  │  └─layouts  
          │  └─shop  
          │      ├─fragments  
          │      └─layouts  
          ├─member  
          └─shop  
```


## 역할 분담 👦🏻👦🏻👧🏻👦🏻👻

#### 송재혁
* 회원관리
* 게시판


#### 장준영
* 상품관리

#### 연주현
* 주문관리

#### 이창민
* 재고관리

#### ~~육슬찬~~
* 치어리더

## 📕 프로젝트 후기

#### 송재혁
* 

#### 장준영
* 

#### 연주현
* 

#### 이창민
* 




<hr>

