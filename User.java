package main;
import main.*;
public class User {

	public String username;
	public String password;
	public User next = null;	
	public MailRecieved RootMailrec=null;
	public MailSent RootMailsend=null;
	
	
	public  void addMailRecieved(MailRecieved mail)
	{
		if(RootMailrec==null)
		{
			RootMailrec = mail;
		}
		else
		{
			MailRecieved temp = RootMailrec;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=mail;
		}
	}
	
	public void addMailSent(MailSent mail)
	{
		if(RootMailsend==null)
		{
			RootMailsend = mail;
		}
		else
		{
			MailSent temp = RootMailsend;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=mail;
		}
	}
	
}
