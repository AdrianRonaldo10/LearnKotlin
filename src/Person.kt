
/* open关键字使Person类可以被继承，非抽象类默认无法被继承(final */
open class Person(val name: String, val age: Int) {

//    var name = ""
//    var age = 0

    // 可见性修饰
    // 默认是public,对所有类都可见
    // protected 只对当前类和子类可见
    // private 只对当前类内部可见
    // internal 只对同一模块下的类可见


    fun info() = "name: $name, age: $age"

}