

/* 主构造函数直接定义在类名后(没有函数体),实例化时必须传入所有参数 */
/* Person类后面的一对空括号表示主构造函数在初始化的时候会调用Person类的无参数构造函数 */
class Student(number: String, grade: String, name: String, age: Int) : Person(name, age), Study {

    // 主构造函数通过init函数写一些逻辑,一般不用写
    init {

        println("调用主构造函数，传入参数，实例化对象")
        println("name: $name, age: $age")
        println("number: $number, grade: $grade")

    }

//    var number = ""
//    var grade = ""
    // 用constructor声明次构造函数
    // 任何一个类只能有一个主构造函数，但是可以有多个次构造函数，可以有函数体
    // 当一个类既有主构造函数又有次构造函数时，所有的次构造函数都必须调用主构造函数（包括间接调用）
    // 次构造函数是不必要的，可以通过给主构造设置默认值实现
    constructor() : this("", 0)
    constructor(name: String, age: Int) : this("", "", name, age)

    // 实现接口，使用override关键字
    override fun read() {
        println("$name is reading.")
    }

//    override fun homework() {
//        println("$name is doing homework.")
//    }


}

/* 没有主构造函数只有次构造函数的写法 */
class Teacher : Person {

    // 没有主构造函数，次构造函数只能直接调用父类的构造函数, 使用super
    constructor(name: String, age: Int) : super(name, age){}
    
}

/* 接口 */
interface Study{
    fun read()

    // 允许对接口定义的函数默认实现
    fun homework(){
        println("Default Implementation of homework")
    }
}