1. Thread.stop() 线程终止方法，不推荐使用。因为调用会导致线程立即释放所有持有的monitor，可能破坏一些原子操作，导致系统状态错误
2. Thread.yield() 线程礼让。释放CPU资源，让所有线程重新竞争CPU，有可能竞争到资源的仍然是当前线程
3. Thread.join() 其实是调用了Object.wait()，当线程结束时，会自动调用Object.notifyAll()，来唤醒wait，所以不建议在线程类的实例上手动的调用wait()、notify()、notifyAll()方法
4. 线程可见性问题

    例子1：
    
    Thread1 | Thread2
    --- | --- 
    r2=A; | r1=B; 
    B=1; | A=2; 
    
    可能会重排成
    
    Thread1 | Thread2
    --- | --- 
    B=1; | r1=B; 
    r2=A; | A=2; 
    
    可能的最后执行结果 r1==1 ，r2==2
    
    例子2：p=q
    
    Thread1 | Thread2
    --- | ---
    r1=p | r6=q
    r2=r1.x | r6.x=3
    r3=q |
    r4=r3.x |
    r5=r1.x |
    
    编译可能发生变量替换
    
     Thread1 | Thread2
     --- | ---
     r1=p | r6=q
     r2=r1.x | r6.x=3
     r3=q |
     r4=r3.x |
     r5=r2(这里的r1.x被r2替换) |
    
    因为r2是栈内存变量，所以出于优化考虑，编译器可能优化最后一行代码，使用r2替代r1.x。最后可能出现r2==r5==0，r4==3的现象，给我们的感觉是p.x的值先从0变成3，然后又变成0了
 
 5. 