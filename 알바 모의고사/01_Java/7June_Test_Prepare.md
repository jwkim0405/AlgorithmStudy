# 7월 과목&월말 평가 대비

1. 자바 애플리케이션의 시작점으로 가장 먼저 호출되는 이 메소드는 고정된 형태를 가집니다. 이 고정된 형태를 아래 빈칸을 채워 서술하세요.
    1. ______ ______ ____ ____()

1. 명시적 형 변환은 자료의 손실이 발생할 수 있기 때문에 개발자가 그 책임을 지고 컴파일러에게 명시적으로 알려주는 것이다( O X )

1. 아래 코드를 실행한 결과는 무엇일까요?
    
    ```java
    System.out.print("나는");
    System.out.println("Java가");
    System.out.printf("%d만큼 \n%s", 12, "좋아");
    ```
    
2. 아래 코드를 실행한 결과는 무엇일까요?
    
    ```java
    public static void main(String[] args) {
    		boolean a = true;
    		boolean b = false;
    		
    		if(a && b) {
    			System.out.println("갑이 정답입니다.");
    		} else if(a || b) {
    			System.out.println("을이 정답입니다.");
    		} else if(!a && b) {
    			System.out.println("병이 정답입니다.");
    		} else if(!a || b) {
    			System.out.println("정이 정답입니다.");
    		}		
    		
    	}
    ```
    
3. Array(배열)의 특징  중 옳지 않은 것은 무엇일까요?
    1. 객체로 취급하기 때문에 참조형 변수로 저장한다.
    2. 오로지 같은 데이터 타입의 데이터만 한 배열에 저장할 수 있다.
    3. 크기가 고정되어 있어 한 번 생성된 배열은 그 크기를 무슨 일이 있어도 바꿀 수 없다.
    4. 배열의 각 요소는 `null` 로 초기화 된다.
    
4. 생성자에 대한 설명으로 옳지 않은 것은 무엇일까요?
    1. 클래스와 동일한 이름을 가지며, 반환 타입이 없다.
    2. 객체의 멤버 필드를 초기화할 때 주로 사용된다.
    3. 생성자는 오버로딩을 통해 매개 변수의 개수나 타입이 다른 여러 개의 생성자를 정의할 수 없다.
    4. `this()` 를 이용한 생성자의 호출은 반드시 생성자 본문의 첫 번째 줄에서만 사용할 수 있다.

1. 다음 중 Static에 대한 설명으로 옳지 않은 것은 무엇일까요?
    1. 클래스 로딩 시, 클래스 당 하나의 메모리 공간만 할당 되고, 모든 인스턴스에 공통으로 사용되는 메소드나 변수 정의에 사용된다.
    2. static으로 선언한 메소드나 변수는 즉시 메모리의 메소드 영역에 생성된다.
    3. static 영역에서 non-static 영역으로 직접 접근은 불가능 하지만, non-static 영역에서 static 영역으로 접근은 가능하다.
    4. 정적 초기화 블록은 객체 생성 시마다 실행되며, 정적 변수를 초기화 하는 데 사용된다.

1. 멤버 변수를 안전하게 관리하기 위해 접근 제어자를 설정하고, getters and setters를 생성하려 합니다. 다음 getters and setters 중 올바르게 적히지 않은 것을 고르세요.
    
    ```java
    	// 멤버 변수(속성)
    	private static final String name;
    	private int age;
    	private String hobby;		
    	
    	// getters
    	public String getName() { return Member.name; }
    	public int getAge() { return this.age; }
    	public String getHobby() { return this.hobby; }
    		
    	// setters
    	public void setName(String name) { this.name = name; }
    	public void setAge(int age) { this.age = age; }
    	public void setHobby(String hobby) { this.hobby = hobby; }
    ```
    
2. 오버라이딩(재정의, Overriding)에 대한 설명으로 옳지 않은 것은 무엇일까요?
    1. 메소드의 이름, 반환형, 매개변수가 모두 동일해야한다.
    2. 반드시 상속관계에 있을 때, 부모에 있는 메소드를 자식에서만 오버라이딩 할 수 있다.
    3. 부모보다 더 큰 예외를 던질 수 없다.
    4. 자식의 접근 제어자 범위가 부모 보다 작아야 한다.
    5. 멤버 변수는 오버라이딩 할 수 없다.
    
3. 추상 메소드에 대한 설명으로 옳지 않은 것은 무엇일까요?
    1. 상속 관계에 있는 부모에서 구현이 무의미한 코드를 정리하기 위해 사용된다.(자식에서 전부 오버라이딩 해서 쓰는 경우)
    2. 코드를 정리했기 때문에 본문이 없다.
    3. 본문이 없기 때문에 마지막에 `;` 로 끝내지 않아도 된다.
    4. abstract 키워드를 명시해서 나타낸다.
    
4. 다음 밑줄을 채워 넣으세요.

```java
public interface IAmInterface {
	______ ______ _____ String iAmVariable = "난 변수처럼 보이지만 실질적으론 상수야.";
	
	______ ________ String stringReturnMethod(String var1);
}
```

1. 

