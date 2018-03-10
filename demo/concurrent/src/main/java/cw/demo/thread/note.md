1. Thread.stop() 线程终止方法，不推荐使用。因为调用会导致线程立即释放所有持有的monitor，可能破坏一些原子操作，导致系统状态错误
2. Thread.yield() 线程礼让。释放CPU资源，让所有线程重新竞争CPU，有可能竞争到资源的仍然是当前线程
3. Thread.join() 其实是调用了Object.wait()，当线程结束时，会自动调用Object.notifyAll()，来唤醒wait，所以不建议在线程类的实例上手动的调用wait()、notify()、notifyAll()方法
4. 