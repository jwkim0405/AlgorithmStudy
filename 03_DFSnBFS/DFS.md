# DFS 개념 부수기!

## 완전탐색
* `그래프`에서 모든 노드를 탐색하자!
  * What is 그래프?
  * 가장 확실한 방법!이자만... But 시간 오래 걸림~
  * 그러면 DFS는 뭐고 BFS는 뭐야?
  * DFS와 BFS의 Full Name?
  

## DFS 방문 순서를 생각해보세Yo~


### 예시 1
<img src = "https://favtutor.com/resources/images/uploads/Depth_first_search_python.jpg" width = 350>

* What's your answer >>

<br>

### 예시 2

<img src = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Depth-first-tree.svg/500px-Depth-first-tree.svg.png" width = 350>

* What's your answer >>

<br>


### DFS 장단점
* 언제?
* 구현 난이도
* 검색 속도


## 어떻게 구현?


### 1. 재귀

```java

static ArrayList<Integer>[] v;
static boolean[] visited;

static void dfs(int root) {
    visited[root] = true; // 방문했다고 표시! 중복 방문 안됩니다~
    System.out.print(root + "->");

    int size = v[root].size();
    for (int i = 0; i < size; i++) {
        int item = v[root].get(i);
        if (!visited[item])
            dfs[item];
    }
}

public static void main(String[] args) {
    
    // ArrayList들이 담겨있는 배열 크기 선언
    v = new ArrayList[12+1];

    // 각각의 ArrayList 객체 생성
    for (int i = 0; i < 12; i++)
        v[i] = new ArrayList<>();
    
    // 각 연결된 정점 집어넣는 코드
    // ~~생략~~
    // 예를 들어 입력에
    // 1 4 이런 식으로 서로 연결된 정보가 나온다!
    // v[1].add(4)
    // v[4].add(1) 이런 식으로~


    visited = new boolean[12+1];

    dfs(1);
}

```

### 2. 스택 자료구조

[블로그를 참고하자구요~](https://codingnojam.tistory.com/44)