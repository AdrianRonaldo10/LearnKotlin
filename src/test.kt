import java.util.*
import kotlin.math.max

// kotlin


fun main(){
    // 变量声明只有两种val(常量). var
    val a = 10
    var b = 20
    val c = 3.1415926575
    val province = "江苏"
    // 闭区间 ..
    val range = 0..9 // [0, 9]
    // 开区间
    val range1 = 0 until a // [0, 10)
    // 降序区间
    val range2 = 10 downTo 1 // [10, 1]

    // for in 循环 可以设置step
    for(i in range step 2){print("$i ")}
    println()
    b *= 10
    println("a = $a")
    println("b = $b")
    println("""a+b = ${plus(a, b)}""")
    println("max: ${max(a, b)}")
    println("""a-b = ${minus(a, b)}""")
    println("max: ${maxi(a, b)}")
    println("Capital of $province: ${getCapital(province)}")
    println("c is ${checkNum(c)}")

    // 实例化对象
    val p = Person("zhangsan", 18)
//    p.name = "zhangsan"
//    p.age = 18
    println(p.info())
    val stu1 = Student()
    val stu2 = Student("zhangsan", 18)
    val stu3 = Student("201983290035", "大三", "GE", 20)
    stu2.read()
    doStudy(stu3)

    val cp1 = Cellphone("IPone", 6000.00)
    val cp2 = Cellphone("Huawei", 4000.00)
    println(cp1)
    println("equals方法: ${cp1 == cp2}")
    Singleton.test() // 调用时默认创造一个实例

    // list: 提供了listOf函数初始化集合
    // listOf: 不可修改集合
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    // mutableListOf: 可变集合
    var list1 = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
    list1.add("Peach")
    for(fruit in list1){print("$fruit ")}
    println()
    // 同理setOf和mutableSetOf, set无重复
    // map可以直接通过map["key"] = value来读写值
    // mapOf, to不是关键字，是infix函数
    val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    for((fruit, quantity) in map){
        println("fruit is $fruit, quantity is $quantity.")
    }
    // Lambda
    // 找到单词最长
    // 遍历集合时将每次遍历的值作为参数传递给Lambda表达式
    val maxLength = list.maxByOrNull { it.length }
    println("maxlength is $maxLength.")
    // Lambda: 传入代码。 完整的语法结构(可简化):{param1:Type, ... -> 函数体}
    // maxByOrNull:通过输入参数找到最大值
    // 可以这样写
    val lambda = {fruit: String -> fruit.length}
    // val maxlength = list.maxByOrNull{lambda}

    // lambda参数是最后一个可以将{}移到()外
    // lambda参数是唯一一个参数可以去掉()
    // 可以简化，去掉参数的类型
    // 变成了
    // val maxlength = list.maxByOrNull{fruit -> fruit.length}
    // 只有一个参数时不必声明，可以使用it代替

    // 几种常见的函数式API
    // 1.map 通过lambda指定映射规则到一个新的集合中
    val newList = list.map { it.uppercase(Locale.getDefault()) } // toUpperCase()被deprecated了
    for(fruit in newList) { print("$fruit ") }
    println()
    // 2.filter 过滤集合中的数据，可以单独使用或配合map
    val newList1 = list.filter { it.length <= 5 }
                       .map{ it.uppercase(Locale.getDefault()) }
    for(fruit in newList1) {  print("$fruit ")}
    println()
    // 3.any和all 用于判断集合中元素存在或任意满足lambda的条件
    var result = list.any{ it.length >= 5 }
    println("存在长度大于5: $result")

    // 调用java方法
    // 前提：该方法接收一个只有一个待实现方法的接口参数(多个待实现则不行
    // 匿名类object : Runnable { }
    // Runnable只有一个待实现方法run()
    Thread{ println("Thread is running") }.start()
    // SDK是用java写的，调用SDK接口时可能用到这种写法

    // Kotlin的自定义函数式API调用通过高阶函数实现

    // 空指针检查
    // Kotlin将空指针异常的检查提前到了编译时期, 所有的参数和变量都不能为空
    // Kotlin提供了可空的类型系统，即在类型后加一个, 如
    println("testNull: ${testNull(100)}")

    // Kotlin提供了判空的辅助工具
    // 如下面的testNull函数: ?. 判断非null    = 左(非null) ?: 右(null)
    // 可以通过对象后加!! 进行非空断言(变量肯定不会为空)

    // let函数式API与?.联合使用
    // ?.操作符表示对象为空时什么都不做，对象不为空时就调用let函数
    // 而let函数会将对象本身作为参数传递到lambda中
    println("letNull: ${letNull(null)}")

    // 传参可通过键值对，而非特定顺序




}

fun testNull(a: Int?) = a?.toUShort() ?: 0

fun letNull(a: Int?) = a?.let{ it.toUShort() }

fun doStudy(study: Study){

    // 实现了Study接口的类型的实例可以传进来
    study.read()
    study.homework()

}


/* 用fun来定义函数，(参数: 类型): 返回值类型 */
fun plus(a: Int, b: Int): Int {
    return a + b
}

/* 函数的syntax sugar */
fun minus(a: Int, b: Int) = a-b // 只有一行代码的函数可以这样写，且可以类型推导

/* 关于if和when(条件) */
fun maxi(a: Int, b: Int) = if(a>b) a else b // if可以有返回值，每个条件中最后一行代码

// 函数默认参数值
fun getCapital(name: String = "江苏") = when (name) {

    // 匹配值 -> {执行逻辑}
    // 还可以类型匹配
    // when也可以不带参数
    "江苏" -> "南京"
    "四川" -> "成都"
    "云南" -> "贵州"
    "辽宁" -> "沈阳"
    "西藏" -> "拉萨"
    else -> "不知道"

}

/* when进行类型匹配 */
fun checkNum(num: Number) = when (num) {

    // is 相当于java的instanceof
    is Int -> "Int"
    is Double -> "Double"
    is Float -> "Float"
    is Long -> "Long"
    else -> "not supported"

}


