package by.viho.circledevtz.exceptions;

public class ProductErrorResponce
{
    private String msg;
    private long timestamp;

    public ProductErrorResponce(String msg, long timestamp)
    {
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(long  timestamp)
    {
        this.timestamp = timestamp;
    }
}
