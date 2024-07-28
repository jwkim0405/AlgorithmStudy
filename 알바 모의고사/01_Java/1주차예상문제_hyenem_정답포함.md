2. ~10 의 결과는? // -11
3. System.out.println("1"+2+3+"4"); 결과는? //1234
4. long과 float의 데이터 크기는? 묵시적 형변환이 가능한 방향은? // long에서 float으로 묵시적 형변환
5. for each문을 구현해보세요. 그 한계는 무엇인가요? // `for(Object obj : objs){}` -> 조회는 가능하지만 수정은 불가
6. 배열을 복사하기 위한 메서드에는 무엇이 있나요? 3가지 써보세요.
//`Arrays.copyOf(복사할 배열, 새로운배열의 길이)`, `Arrays.copyOfRange(복사할 배열, 복사 시작 인덱스, 새로운 배열의 끝인덱스)`, `System.arraycopy(복사할 배열, 원본 시작점, 새로운 배열, 새로운 배열의 복사 시작점, 복사할 길이)`
7. 다음 결과는?
```java
 String a="유영";
 String b="유영";
 System.out.println(a==b);
```
//true
8. 다음 결과는?
```java
 String a;
 String b = "정우";
 String c = "정우"
 a=c;
 System.out.println(a==b);
```
//true
9. string의 참조값이 아닌 문자열을 비교하기 위해 사용해야하는 메서드는? //equals()
10. 객체지향프로그래밍의 네 가지 특징은?
//APIE
//A : 추상화 , P: 다형성 , I: 상속, E:캡슐화
11. 클래스의 구성요소 세 개 또는 네 개 쓰세요. // 멤버변수(속성), 맴버 메서드(행위), 생성자, 중첩 클래스

12. 생성자 메서드를 구성할 때 static을 붙여야한다? // No! 붙일 수 없다.
13. final 인 멤버 변수의 작성 방식은? _____의 _____case // 대문자의 SNAKE_CASE
14. 접근 제어자 중 생략할 수 있는 것은? // default
15. 클래스, 인스턴스, 지역변수가 저장되는 메모리의 영역은 각각 무엇인가? // 메서드 영역, 힙 영역, 메모리 영역

16. 다음을 지칭하는 용어는 무엇인가? 
```java
void methd(String first, int second){
    system.out.println(first+second);
}
void methd(int first, String second){
    system.out.println(second+first);
}
```
//오버로딩 (오버라이딩 아님)


17. 다음이 가능한 경우인가?
```java
class Person{
    private String name;
    private int age;

    static void introduce(){
        System.out.println("제 이름은"+this.name+"입니다");
        System.out.println("저는"+this.age+"살입니다");
    }
}
```
//No! 객체 생성이 안됐는데 this를 쓸 수 있을리 없다!

18. 다음이 가능한 경우인가?
```java
class Person{
    private String name;
    private int age;

    static void introduce(){
        System.out.println("제 이름은"+name+"입니다");
        System.out.println("저는"+age+"살입니다");
    }
}
```
// no! static 영역에서 static이 아닌 맴버변수나 맴버 메서드를 불러올 수 없다!


19. 싱글턴 패턴을 구현하려할 때, 빈칸을 채우시오.
```java
public class Manager{
    ___________________

    ___________ Manager manager = new Manager();

    ___________ Manager getMananger(){
        return _______;
    }
}
```
// `private Manager(){}`
// `private static`
// `public static`
// `manager`

20. 상속에 사용되는 키워드는? // `extends`
    구현에 사용되는 키워드는? // `implements`

21. 다음이 가능한 경우인가?
```java
class Student extends Person{
    String major;

    Student(String name, int age, String major){
        super(name, age);
        this.major = major;
    }

    public void toString(){
        return "Student ["+name+","+age+","+major+"]";
    }
}
```
// No! name과 age는 Student의 맴버변수가 아님!
// Person에서 private로 선언된게 아니면 `super.name`, `super.age`로 가져오거나
// Person에서 private으로 선언된거면 `super.getName()`, `super.getAge()`로 가져와야함.


22. 다음의 결과는? 그리고 그 원인이 되는 키워드는 무엇인가?
```java
class Person {
    void eat(){
        System.out.println("먹는다");
    }
}

class Student extends Person{
    void eat(){
        System.out.println("지식을 먹는다.");
    }
}

public class Main{
    public static void main(String[] args){
        Person p = new Student();
        p.eat();
        Student s = new Student();
        ((Person)s).eat();
    }
}
```
// `지식을 먹는다` 오버라이드 된거여서, 힙영역의 s의 정보에 Person의 eat()이라는 메서드가 이미 바뀌어있음


23. 클래스 A, B, C, D, E, F의   관계를 설명하세요.
```java
class A{}
class B{
    F f;
}
class C{}
class D {}
class E{
    void method(){
        System.out.println("e")
    }
}
class F{
    A a;
    B b;
    C[] c; //없으면 F가 존재 불가
    D[] d; //없어도 F는 존재 가능

    void method(){
        E e = new e();
        e.method();
    }
}
```
// F는 A에 연관
// F는 B와 양방향 연관
// F는 C로 구성
// F는 D의 집합
// F는 E에 의존


24. instanceof는 형변환 가능한 타입을 확인하는 메서드이다?
// No! 형변환 가능한 타입을 확인하는 역할이긴 하지만
// 메서드가 아니고 연산자이다.

25. 상속을 하면서 자손 클래스에서 오바리이드 했을 때, 타입과 관계없이 실제 객체가 가진 메서드가 호출되는 것과 같이 / 컴파일을 하는 동안 호출될 함수가 결정되는 것이 아니라, 실행하는 동안 호출될 함수가 결정되는 것을 무엇이라 하는가?
// 동적 바인딩

26. static 메서드도 오버라이드가 가능하다? //No! static 메서드는 오버라이드가 안된다.
27. abstract class의 가장 큰 제한점은 무엇인가? // 인스턴스 생성 불가
28. abstract class는 행위가 정의되지 않은 메서드를 포함하는 class를 의미한다? // No! abstract로 선언되면 abstract메서드가 없어도 된다!
29. 29번 문제 날림!

30. 인터페이스 내에 선언된 메서드는 (        )가  기본적으로 생략되어 있음.
    인터페이스 내에 정의된 변수는 자동을 (          )가 기본적으로 생략되어 있음.
    //`public abstract`, `public static final`

31. 어떤 경우에도 다중 상속은 불가능하다? // No! 인터페이스에서 인터페이스를 다중으로 상속받는 것은 가능함!
32. 32번 문제 날림

33. 아래 두 경우가 가능한지 불가능한지 각각 밝히시오.
    1) 첫 번쨰
    ```java
    class First{
        static void static_method(){
            System.out.println("you can call me 규");
        }
    }
    class Second extends First{
    }
    class Main{
        public static void main(String[] args){
            Second S = new Second();
            S.static_method();
        }
    }
    ```
    //가능함. class의 static메서드는 상속도 되고, 인스턴스를 이용해서 꺼내 쓸 수 있음

    2) 두번째
    ```java
    interface First{
        static void static_method(){
            System.out.println("you can call me 규");
        }
    }
    class Second implements First{}
    }
    class Main{
        public static void main(String[] args){
            Second S = new Second();
            S.static_method();
        }
    }
    ```
    //불가능함. interface의 static 메서드는 반드시 그 인터페이스를 이용해서만 꺼내쓸 수 있음.


34. 다음 코드에 문제가 있는가?
``` java
interface Face{
    //code생략
}
class Box<T implements Face>{
    //code생략
}
```
//Yes. 제네릭에서 상한을 걸 때에는 인터페이스여도 extends키워드를 사용함

35. 다음 중 인터페이스인 것과 클래스인 것을 구분하시오.
ArrayList, Vector, Stack, Collection, List, LinkedList, Queue, ArrayDeque, Deque, PrioirityQueue, HashMap, Map, HashSet, Set
// 인터페이스인것 : Collection, List, Queue, Deque, Map, Set (Stack은 클래스임)

36. 다음 코드의 실행 결과는?
```java

List<String> names = new ArrayList<String>();
names.add("혜민");
names.add("희주");
names.add("홍균");
names.add("정우");
names.add("혜민");
names.add("유영");
names.remove("혜민");
System.out.println(names);

List<Integer> ages = new ArrayList<Integer>();
ages.add(26);
ages.add(25);
ages.add(26);
ages.add(26);
ages.add(0);
ages.add(27);
ages.remove(0);
System.out.println(ages);
```
//`[희주, 홍균, 정우, 혜민, 유영]`
//`[25, 26, 26, 0, 27]` : 조심할 것. remove안에 int가 들어가면 그 인덱스를 지우는 것이지 그 숫자를 찾아서 지우는 것이 아님.

37. names에서 혜민을 다 지우고 싶다. 어떻게 해야할지 빈칸을 채우시오.
```java
List<String> names = new ArrayList<String>();
names.add("혜민");
names.add("혜민");
names.add("희주");
names.add("홍균");
names.add("정우");
names.add("유영");

for(int i = ______; ________; _________){
    if(____________________)
        names.remove(___);
}
```
//`names.size()-1`, `i>=0`, `i--`
// `names.get(i).equals("혜민")`
// `i`

38. sort는 중복을 허용하지 않기 때문에 새로운 class를 정의하여 set으로 관리하려면 ________ 와 __________ 메서드를 재정의해줘야한다. 나이가 같을 때 true가 나오게 만들고 싶다. 아래처럼 하면 안되는 이유를 적고, 제대로 된 equals() 재정의 메서드를 적어보자.
```java
class Person extends Object{
    String name;
    int age;

    @Override
    public boolean equals(Person person){
        return this.age == person.age;
    }
}
```
// `hashCode()`, `equals()`
// equals를 오버로드 해야하는데 파라매터의 타입이 Person이면 오버라이딩이 된다.
```java
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Person){
            Person person = (Person)obj;
            return this.age == person.age;
        } else {
            return false;
        }
    }
```


39. entrySet()을 이용하여 Map을 순회하려한다. 빈칸을 채워보자.
```java
Map<String, int> map = new _______<>();
//put 생략
for(____________ entry : ___________){
    System.out.printf("%__ : %___ \n", _______, ________);
}
```
//`HashMap`
// `Map.Entry<String, int>`, `map.entrySet()`
// `%s`, `%d`, `entry.getKey()`, `entry.getValue()`

40. 다음 인터페이스의 구현체에 자료를 추가하기 위한 메서드를 각각 적으세요.
    List : //add()
    Set :  //add()
    Map :  //put()
    Queue : //offer()
    Stack : //push() 

41. error와 exception의 차이는? //프로그래머가 사전에 대바할 수 있는지 여부. error은 효율적인 프로그램이라면 프로그래머가 신경쓸 필요도, 신경쓸 수도 없음
    checkedException과 uncheckedException의 차이는? // 컴파일러가 처리를 강제하는지 여부. 컴파일 에러가 나는지 런타임 에러가 나는지의 차이가 있다.

42. 사람을 이름의 내림차순으로 정렬하고 싶을 때 다음 반칸을 채우세요.
```java
class Person implements _____________{
    String name;
    //코드 생략
    public int ___________(Person o){
        return __________________;
    }
}
```
//`Comparable<Person>`
//`compareTo`
//`(this.name).compareTo(o.name) * -1`

43. 에러가 발생하는 시점에 따라 구분한 세 가지 에러의 종류는?
// 컴파일 에러, 런타임 에러, 논리적 에러

44. 다음 코드로 인해 발생하는 애러의 클래스를 쓰시오.
    그리고 checkedException인지 uncheckedException인지 구분하시오.
    1) 
    ```java
    int[] nums ={10};
    System.out.println(nums[1]);
    ```
    //ArrayIndexOutOfBoundsException -> checkedException

    2) 
    ```java
    System.out.println(10/0);
    ```
    // ArthimeticException -> uncheckedException

    3) 
    ```java
    public static void main (String[] args){
        method();
    }
    ```
    // ClassNotFoundException -> checkedException
