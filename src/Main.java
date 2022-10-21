import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock locker = new ReentrantLock();

        PingPongThread pong = new PingPongThread("Pong", locker);
        PingPongThread ping = new PingPongThread("Ping", locker);

        ping.start();
        pong.start();
    }
}
