1. 1번 문제는 삭제했어요
2. ~10 의 결과는?
3. "1"+2+3+"4"의 출력 결과는?
4. long과 float의 데이터 크기는? 묵시적 형변환이 가능한 방향은?
5. for each문을 구현해보세요. 그 한계는 무엇인가요?
6. 배열을 복사하기 위한 메서드에는 무엇이 있나요? 3가지 써보세요.
7. 다음 결과는?
```java
 String a="유영";
 String b="유영";
 System.out.println(a==b);
```
8. 다음 결과는?
```java
 String a;
 String b = "정우";
 String c = "정우"
 a=c;
 System.out.println(a==b);
```
9. string의 참조값이 아닌 문자열을 비교하기 위해 사용해야하는 메서드는?
10. 객체지향프로그래밍의 네 가지 특징은?
11. 클래스의 구성요소 세 개 또는 네 개 쓰세요.

12. 생성자 메서드를 구성할 때 static을 붙여야한다?
13. final 인 멤버 변수의 작성 방식은? _____의 _____case
14. 접근 제어자 중 생략할 수 있는 것은?
15. 클래스, 인스턴스, 지역변수가 저장되는 메모리의 영역은 각각 무엇인가?

16. 다음을 지칭하는 용어는 무엇인가?
```java
void methd(String first, int second){
    system.out.println(first+second);
}
void methd(int first, String second){
    system.out.println(second+first);
}
```

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

20. 상속에 사용되는 키워드는?
    구현에 사용되는 키워드는?

21. 다음이 가능한 경우인가?
```java
class Person{
    private String name;
    private int age;
    Person(Sting name, int age){
        this.name = name;
        this.age = age;
    }
}
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

24. instanceof는 형변환 가능한 타입을 확인하는 메서드이다?

25. 상속을 하면서 자손 클래스에서 오바리이드 했을 때, 타입과 관계없이 실제 객체가 가진 메서드가 호출되는 것과 같이 / 컴파일을 하는 동안 호출될 함수가 결정되는 것이 아니라, 실행하는 동안 호출될 함수가 결정되는 것을 무엇이라 하는가?

26. static 메서드도 오버라이드가 가능하다?
27. abstract class의 가장 큰 제한점은 무엇인가?
28. abstract class는 행위가 정의되지 않은 메서드를 포함하는 class를 의미한다?
29. 29번 문제 날림!
30. 인터페이스 내에 선언된 메서드는 (        )가  기본적으로 생략되어 있음.
    인터페이스 내에 정의된 변수는 자동을 (          )가 기본적으로 생략되어 있음.

31. 어떤 경우에도 다중 상속은 불가능하다?
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

34. 다음 코드에 문제가 있는가?
``` java
interface Face{
    //code생략
}
class Box<T implements Face>{
    //code생략
}
```

35. 다음 중 인터페이스인 것과 클래스인 것을 구분하시오.
ArrayList, Vector, Stack, Collection, List, LinkedList, Queue, ArrayDeque, Deque, PrioirityQueue, HashMap, Map, HashSet, Set

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


39. entrySet()을 이용하여 Map을 순회하려한다. 빈칸을 채워보자.
```java
Map<String, int> map = new _______<>();
//put 생략
for(____________ entry : ___________){
    System.out.printf("%__ : %___ \n", _______, ________);
}
```

40. 다음 인터페이스의 구현체에 자료를 추가하기 위한 메서드를 각각 적으세요.
    List : 
    Set :
    Map :
    Queue :
    Stㅌack :

41. error와 exception의 차이는?
    checkedException과 uncheckedException의 차이는?

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

43. 에러가 발생하는 시점에 따라 구분한 세 가지 에러의 종류는?

44. 다음 코드로 인해 발생하는 애러의 클래스를 쓰시오.
    그리고 checkedException인지 uncheckedException인지 구분하시오.
    1) 
    ```java
    int[] nums ={10};
    System.out.println(nums[1]);
    ```

    2) 
    ```java
    System.out.println(10/0);
    ```

    3) 
    ```java
    public static void main (String[] args){
        method();
    }
    ```

