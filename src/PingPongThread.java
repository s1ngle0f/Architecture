import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class PingPongThread extends Thread
{
    private String msg;
    private static String turn;
    private Lock locker;
    public PingPongThread( String msg, Lock locker){
        this.msg = msg;
        this.locker = locker;
        if(turn == null)
            turn = msg;
    }

    @Override
    public void run()
    {
        while (true){
            try
            {
                playTurn();
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    private synchronized void playTurn() throws InterruptedException
    {
        locker.lock();
        if(!msg.equals(turn)){
            turn = msg;
            System.out.println(msg);
            Thread.sleep(600);
        }
        locker.unlock();
    }
}