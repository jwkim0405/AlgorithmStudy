# Style
> written by Sijongyeoil

# **Style 속성 (HTML)**

## **CSS 작성법**

### **CSS 작성법 예시**

```css
Selector {
	Property: Value;
	Property: Value;
}
```

**Selector 종류**

- The element Selector
- The id Selector
- The class Selector

### **The element Selector 예시**

```css
span {
	color: red;
	font-size: 15pt;
}
```

이렇게 하면, 모든 span에 해당 스타일이 지정됨.

### **The id Selector 예시**

```css
#loginpage {
	width: 300px;
	height: 400px;
}
```

이렇게 하면, id=“loginpage” 속성을 갖고 있는 태그들에 해당 스타일이 지정됨.

### **The class Selector 예시**

```css
.link {
	text-decoration: none;
	font-weight: bold;
}
```

이렇게 하면, class=“link” 속성을 갖고 있는 태그들에 해당 스타일이 지정됨.

### **The element Selector와 다른 Selector의 혼합 사용 예시**

```css
div#wrapper {
	overflow-y: auto;
}
```

이렇게 하면, id=“wrapper” 속성을 갖고 있는 div에 해당 스타일이 지정됨.

**후손 Selector 종류**

- The descendant Selector
- The child Selector
- The preceded Selector
- The immediately preceded Selector

### **The descendant Selector 예시**

```css
div a {
	font-familiy: "Malgun Gothic";
	text-transform: uppercase;
}
```

이렇게 하면, div 안에 있는 모든 a에 해당 스타일이 지정됨.

### **The child Selector 예시**

```css
div > .search {
	padding: 25px;
	border: 5px solid gray;
	margin: 25px;
}
```

이렇게 하면, div 바로 안에 있는 class=“search” 속성을 갖고 있는 태그들에 해당 스타일이 지정됨.

### **The descendant Selector와 The child Selector의 차이**

```css
<div>
	<a href="register.js" class="search">회원가입</a>
	<span>
		<a href="http://board.xyz" class="search">게시판</a>
	</span>
</div>
<a href="index.js" class="search">나가기</a>
```

이 때, 선택자가 어떻게 작동되는지 보자.

### **The descendant Selector의 경우**

'div a' 라고 하면,

div 안에 있는 모든 a를 말하므로, '회원가입', '게시판'이다.

그러나 '나가기'는 div 밖에 있으므로 해당되지 않는다.

### **The child Selector의 경우**

'div > .search' 라고 하면,

div의 바로 안에 있는 class=“search” 속성을 갖고 있는 태그들을 말하므로, '회원가입'이다.

그러나 '게시판'는 div 바로 안이 아니라 div 안의 span 안에 있는 것이므로 해당되지 않는다.

물론 '나가기'는 div 밖에 있으므로 해당되지 않는다.

### **The preceded Selector 예시**

```css
h1 ~ p {
	font-style: italic;
}
```

이렇게 하면, h1 태그 다음에 나오는 모든 p에 해당 스타일이 지정됨.

### **The immediately preceded Selector 예시**

```css
h1 + p.cotent {
	font-variant: small-caps;
}
```

이렇게 하면, h1 바로 다음에 나오는 class=“content” 속성을 갖고 있는 p에 해당 스타일이 지정됨.

**같은 속성 지정하기**

```css
p.center,
.loc > a {
	color: red;
}
```

이처럼 선택자와 선택자를 쉼표(,)로 이으면 같은 속성이 지정됨.

따라서 위와 같은 경우에는 'p.center'와 '.loc > a'에 'color: red'가 지정된 것.

**Priority Rule**

목록 위에 기술된 것일 수록 우선순위가 높음.

1. Inline Styles (태그 속성으로 style=““하여 적는 것)
2. Internal Style Sheet (같은 파일 내에 <style></style> 안에 적는 것)
3. External Style Sheet (.css를 link로 불러오는 것)

### **Same level Priority Rule**

| **선택자** | **예시** | **점수** |
| --- | --- | --- |
| !important | !important | ∞점 |
| 직접기입 | style=”” | 1000점 |
| ID | #sample | 100점 |
| Class | .sample | 10점 |
| 속성선택자 | a[href*=”sample”] | 10점 |
| 가상클래스속성 | :first-child | 10점 |
| 태그선택자 | ul | 1점 |
| 전체선택 | * | 0점 |

같은 레벨인 경우 위 점수표에 따른 환산점수로 우선순위가 결정된다.

**Comments 작성법**

/* 와 */ 사이에 있는 것은 Comment 취급되어 무시됨.

**Style 속성들**

**기본 Values**

- initial (기본값으로 설정)
- inherit (부모의 설정값과 같게 설정)

**background**

배경을 설정함.

- background-color (배경색 설정)
- background-image (배경 이미지 설정)

### **background-color 예시**

```css
background-color: black;
```

### **background-image 예시**

```css
background-image: url('logo.jpg');
```

**display**

표시 상태를 설정함.

- display
- visibility

### **display 예시**

```css
display: block;
```

### **display의 Values**

- none (element를 숨김)
- block
- inline

### **visibility 예시**

```css
visibility: visible;
visibility: hidden;
```

### **display와 visibility의 차이**

display: none;은 그 element가 아예 보이지 않지만,

visibility: hidden;은 빈 공간이 해당 자리를 대체한다.

**position**

위치를 어떻게 결정할 것인지를 설정함.

- position

### **position 예시**

```css
position: static;
```

### **position의 Values**

- static (기본)
- relative (기본 위치를 기준으로 자유 설정 가능)
- absolute (부모 위치를 기준으로 자유 설정 가능)
- fixed (보이는 화면을 기준으로 자유 설정 가능)

### **top, right, bottom, left**

위치를 설정함.

- top
- right
- bottom
- left

### **top 예시**

```css
top: 20px;
```

### **padding**

안쪽여백을 설정함.

- padding

### **padding 예시**

```css
padding: 10px; (네 방향 전부 설정)
padding: 10px 0px 3px 5px; (위쪽 오른쪽 아래쪽 왼쪽 순)
padding-top: 20px;
```

### **border**

테두리를 설정함.

- border
- border-width
- border-style
- border-color

### **border 예시**

```css
border: none;
border: 2px solid black;
```

### **border-width 예시**

```css
border-width: 2px;
border-width: 1px 2px 3px 1px;
border-left-width: 1px;
```

### **border-style 예시**

```css
border-style: solid;
```

### **border-style의 Values**

- solid
- dotted
- dashed

### **border-color 예시**

`border-color: #FF0000;`

편집

### **margin**

바깥여백을 설정함.

- margin

### **margin 예시**

`margin: 0px;
margin: 5px 4px 8px 2px;
margin-right: 10px;`

편집

### **width**

가로 길이를 설정함.

- width
- min-width (최소 가로 길이)
- max-width (최대 가로 길이)

### **width 예시**

`width: 210px;
width: 60%;`

편집

### **height**

세로 길이를 설정함.

- height
- min-height (최소 세로 길이)
- max-height (최대 세로 길이)

### **height 예시**

`height: 500px;
height: 50%;`

편집

### **overflow**

내용이 설정한 width와 height를 넘을 경우 어떻게 할 것인지를 설정함.

- overflow
- overflow-x (가로축-width-방향으로 넘을 경우)
- overflow-y (세로축-height-방향으로 넘을 경우)

### **overflow 예시**

`overflow: visible;`

### **overflow의 Values**

- visible (넘치는 내용도 전부 보임)
- hidden (넘치는 내용은 숨김)
- scroll (x, y 방향 스크롤을 만듬)
- auto (넘치는 방향 스크롤을 만듬)

편집

### **text**

글자와 관련된 속성을 설정함.

- color
- text-align (정렬 설정)
- text-decoration (글자 꾸밈 설정)
- line-height (글줄의 높이 설정)

### **color 예시**

`color: rgb(255, 255, 0);`

### **text-align 예시**

`text-align: left;`

### **text-align의 Values**

- left (왼쪽 정렬)
- center (가운데 정렬)
- right (오른쪽 정렬)
- justify (양쪽 정렬)

### **text-decoration 예시**

`text-decoration: none;`

### **text-decoration의 Values**

- none
- overline (윗줄)
- line-through (절취선)
- underline (밑줄)

### **line-height 예시**

`line-height: 2em;`

편집

### **font**

글꼴과 관련된 속성을 설정함.

- font-family (글꼴 설정)
- font-style (글꼴 꾸밈 설정)
- font-size (글자 크기 설정)
- font-weight (글가 굵기 설정)

### **font-family 예시**

`font-family: 'Malgun Gothic';
font-family: 'Times New Roman';`

### **font-style 예시**

`font-style: italic;`

### **font-style의 Values**

- normal (기본)
- italic (기울임 글꼴)
- oblique (기본 글꼴을 기울임)

### **font-size 예시**

`font-size: 12px;
font-size: 0.75em;`

### **font-weight 예시**

`font-weight: bold;`

### **font-weight의 Values**

- normal (기본)
- lighter (얇게)
- bold (굵게)

편집

## **Style 속성 Value 작성법**

편집

### **크기 단위**

- px
- %(percent)
- em
- pt

### **px**

고정된 수치 단위.

### **%**

부모를 기준으로, 상대적으로 결정하는 수치 단위.

### **em**

부모을 기준으로, 상대적으로 결정하는 글자크기 단위.

1em은 100%임.

### **pt**

고정된 글자크기 단위.

1pt는 1/72인치임.

편집

### **색 작성법**

- Color Name 방식
- HEX 방식
- rgb() 방식

### **Color Name 방식**

지정된 Color Name을 쓰는 방식

### **Color Name 예시**

- AliceBlue
- Black
- Pink
- LavenderBlush

### **HEX 방식**

RGB를 순서대로 16진법으로 0~255까지(즉 00~FF) 쓰는 방식.

### **HEX 방식 예시**

- #FFFFF0
- #ADD8E6

### **rgb() 방식**

RGB를 순서대로 0~255까지 쓰는 방식

### **rgb() 방식 예시**

- rgb(0, 0, 255)
- rgb(123, 56, 200)