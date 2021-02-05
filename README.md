Run `test.spec` in IntelliJ or do `mvn test`.

In both cases, the test will get stuck at the end of the test.
It seems to wait on a timeout.

It ends up being successful but we get a `Killing runner with PID:123 forcefully` message.
