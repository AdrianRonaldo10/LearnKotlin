
// 单例模式：某个类在全局最多只能拥有一个实例
// java中，用private关键字将Singleton的构造函数私有化’
// 然后给外部提供了一个getInstance()静态方法用于获取Singleton的实例

object Singleton {

    fun test() {
        println("Singleton test is called.")
    }

}