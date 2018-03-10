- 程序顺序原则：一个线程内保证语义串行性
 ``` java
  a=1;
  b=a+1;
 ```
- volatile规则：volatile规则：volatile变量的写，先于发生读，这保证了volatile变量的可见性
- 锁规则：解锁(unlock)必然发生在随后的加锁(lock)前
- 传递性：A先于B，B先于C，那么A必然先于C
- 线程的start()方法先于它的每一个动作
- 线程的所有操作先于线程的终结（Thread.join()）
- 线程的中断（interrupt()）先于被中断线程的代码
- 对象的构造函数执行结束先于finalize()方法