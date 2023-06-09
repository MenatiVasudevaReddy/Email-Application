package main;
import main.*;
import java.util.*;
public class Main {
	public static User RootUser=null;
	public static MailRecieved RootMailrec;
	public static MailSent RootMailsend;
	
	
	public static void  loadUserData()
	{
		
		//creating static users
		User user1 = new User();
		User user2 = new User();
		
		user1.username="a1@z.com";
		user1.password="a1z";
		user1.next=null;
		user1.RootMailrec=null;
		user1.RootMailsend=null;
		
		user2.username = "a2@z.com";
		user2.password = "a2z";
		user2.next=null;
		user2.RootMailrec=null;
		user2.RootMailsend=null;
		
		addUser(user1);
		addUser(user2);
		
		//User1 reciced mails
		MailRecieved mail1U1 = new MailRecieved();
		MailRecieved mail2U1 = new MailRecieved();
		MailRecieved mail3U1 = new MailRecieved();
		MailRecieved mail4U1 = new MailRecieved();
		MailRecieved mail5U1 = new MailRecieved();
		
		mail1U1.username = user1.username;
		mail1U1.MessageId = 1001;
		mail1U1.from = "a2@z.com";
		mail1U1.to = "a1@az.com,b1@z.com";
		mail1U1.subject="Hello1";
		mail1U1.body="sample";
		
		mail2U1.username = user1.username;
		mail2U1.MessageId = 1007;
		mail2U1.from = "a2@z.com";
		mail2U1.to = "a1@az.com,b1@z.com";
		mail2U1.subject="Hello2";
		mail2U1.body="sample";
		
		mail3U1.username = user1.username;
		mail3U1.MessageId = 1012;
		mail3U1.from = "a2@z.com";
		mail3U1.to = "a1@az.com,b1@z.com";
		mail3U1.subject="Hello3";
		mail3U1.body="sample";
		
		mail4U1.username = user1.username;
		mail4U1.MessageId = 1015;
		mail4U1.from = "a2@z.com";
		mail4U1.to = "a1@az.com,b1@z.com";
		mail4U1.subject="Hello4";
		mail4U1.body="sample";
		
		mail5U1.username = user1.username;
		mail5U1.MessageId = 1021;
		mail5U1.from = "a2@z.com";
		mail5U1.to = "a1@az.com,b1@z.com";
		mail5U1.subject="Hello5";
		mail5U1.body="sample";
		
		
		//adding recieved mails to user
		user1.addMailRecieved(mail1U1);
		user1.addMailRecieved(mail2U1);
		user1.addMailRecieved(mail3U1);
		user1.addMailRecieved(mail4U1);
		user1.addMailRecieved(mail5U1);
		
		
		//user2 recieved mails
		MailRecieved mail1U2 = new MailRecieved();
		MailRecieved mail2U2 = new MailRecieved();
		MailRecieved mail3U2 = new MailRecieved();
		MailRecieved mail4U2 = new MailRecieved();
		MailRecieved mail5U2 = new MailRecieved();
		
		mail1U2.username = user2.username;
		mail1U2.MessageId = 2001;
		mail1U2.from="a1@z.com";
		mail1U2.to="a1@z.com,b1@z.com";
		mail1U2.subject="Hello1";
		mail1U2.body="sample";
		
		mail2U2.username = user2.username;
		mail2U2.MessageId = 2001;
		mail2U2.from="a1@z.com";
		mail2U2.to="a1@z.com,b1@z.com";
		mail2U2.subject="Hello1";
		mail2U2.body="sample";
		
		mail3U2.username = user2.username;
		mail3U2.MessageId = 2001;
		mail3U2.from="a1@z.com";
		mail3U2.to="a1@z.com,b1@z.com";
		mail3U2.subject="Hello1";
		mail3U2.body="sample";
		
		mail4U2.username = user2.username;
		mail4U2.MessageId = 2001;
		mail4U2.from="a1@z.com";
		mail4U2.to="a1@z.com,b1@z.com";
		mail4U2.subject="Hello1";
		mail4U2.body="sample";
		
		mail5U2.username = user2.username;
		mail5U2.MessageId = 2001;
		mail5U2.from="a1@z.com";
		mail5U2.to="a1@z.com,b1@z.com";
		mail5U2.subject="Hello1";
		mail5U2.body="sample";
		
		
		user2.addMailRecieved(mail1U2);
		user2.addMailRecieved(mail2U2);
		user2.addMailRecieved(mail3U2);
		user2.addMailRecieved(mail4U2);
		user2.addMailRecieved(mail5U2);
		
		
		
	}
	public static void addUser(User user)
	{
		if(RootUser==null)
		{
			RootUser = user;
			//System.out.println("user added");
		}
		else
		{
			User temp = RootUser;
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			temp.next = user;
			//System.out.println("user added");
		}
	}
	
	public static boolean checkUsername(String username)
	{
		User temp = RootUser;
		while(temp!=null)
		{
			if(temp.username.equals(username))
				return false;
			temp = temp.next;
		}
		return true;
	}
	public static void newAccount()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Username:");
		String username = input.nextLine();
		if(checkUsername(username))
		{	
			System.out.println("Password:");
			String password = input.nextLine();
			User user = new User();
			user.username = username;
			user.password = password;
			user.next=null;
			user.RootMailrec=null;
			user.RootMailsend=null;
			addUser(user);
			System.out.println("Account created");
			displayLogin();
			
		}
		else
		{
			System.out.println("Username already exists");
			displayLogin();
			
		}
		
		
	}
	public static int getmessageId()
	{
		Date s = new Date();
		return s.getHours();
	}
	public static int countSentEmails(User user)
	{
		MailSent mail = user.RootMailsend;
		int count=0;
		while(mail!=null)
		{
			count++;
			mail = mail.next;
			
		}
		return count;
	}
	
	public static void Compose(User user)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("To:");
		String to = input.nextLine();
		System.out.println("");
		String from = user.username;
		System.out.println("Subject:");
		String subject = input.nextLine();
		System.out.println("Message:");
		String body = input.nextLine();
		
		int messageId = countSentEmails(user)+getmessageId()+3;
		
		MailSent mail = new MailSent();
		mail.MessageId = messageId;
		mail.body=body;
		mail.to = to;
		mail.from = from;
		mail.subject = subject;
		
		user.addMailSent(mail);
		
		User  temp = RootUser;
		while(!temp.username.equals(to))
		{
			temp = temp.next;
		}
		MailRecieved mail1 = new MailRecieved();
		mail1.body = mail.body;
		mail1.from = mail.from;
		mail1.to = mail.to;
		mail1.MessageId = mail.MessageId;
		mail1.subject = mail.subject;
		mail1.next=null;
		
		temp.addMailRecieved(mail1);
		
		System.out.println("Mail Sent");
		UserMenu(user);
	}
	public static void DisplayMails(User user)
	{
		MailRecieved temp = user.RootMailrec;
		while(temp!=null)
		{
			System.out.print("MessageId:"+temp.MessageId+",From: "+temp.from+", To: "+temp.to+", subject: "+temp.subject);
			System.out.println();
			temp = temp.next;
		}
	
		UserMenu(user);
	}
	public static void DisplaySentMails(User user)
	{
		MailSent temp = user.RootMailsend;
		while(temp!=null)
		{
			System.out.print("MessageId:"+temp.MessageId+",From: "+temp.from+", To: "+temp.to+", subject: "+temp.subject);
			System.out.println();
			temp = temp.next;
		}
		
		UserMenu(user);
	}
	public static void DeleteMail(User user)
	{
		Scanner input = new Scanner(System.in);
		int messageid = input.nextInt();
		MailRecieved mail = user.RootMailrec;
		MailRecieved prev = null;
		if(mail.MessageId==messageid)
		{
			user.RootMailrec = mail.next;
		}
		else
		{
			while(mail.MessageId!=messageid)
			{
				prev = mail;
				mail = mail.next;
				
			}
			if(mail.next==null)
			{
				prev.next=null;
			}
			else
			{
				prev.next = mail.next;
				mail.next=null;
				
			}
		}
		System.out.println("Mail Deleted");
		UserMenu(user);
	}
	public static void DeleteSentMail(User user)
	{
		Scanner input = new Scanner(System.in);
		int messageid = input.nextInt();
		MailSent mail = user.RootMailsend;
		MailSent prev = null;
		if(mail.MessageId==messageid)
		{
			user.RootMailsend = mail.next;
		}
		else
		{
			while(mail.MessageId!=messageid)
			{
				prev = mail;
				mail = mail.next;
				
			}
			if(mail.next==null)
			{
				prev.next=null;
			}
			else
			{
				prev.next = mail.next;
				mail.next=null;
				
			}
		}
		System.out.println("Mail Deleted");
		UserMenu(user);
	}
	public static void UserMenu(User user)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("User Menu: \n 1.Compose \n 2.List Mails \n 3.List Sent Mails \n 4.Delete Mails \n 5.Delete Sent Mails \n 6.Logout");
		int choice  = input.nextInt();
		switch(choice)
		{
		case 1: Compose(user);
		break;
		case 2: DisplayMails(user);
		break;
		case 3: DisplaySentMails(user);
		break;
		case 4: DeleteMail(user);
		break;
		case 5: DeleteSentMail(user);
		break;
		case 6: displayLogin();
		break;
		default:
			System.out.println("Invalid choice");
		}
	}
	public static boolean Validate(String username,String password)
	{
		User temp = RootUser;
		
		while(temp!=null)
		{
			if(temp.username.equals(username))
				break;
			else
				temp=temp.next;
		}
		if(temp==null)
		{
			return false;
		}
		if(temp.password.equals(password))
			return true;
		else 
			return false;
		
	}
	public static User findUser(String username)
	{
		User temp = RootUser;
		while(temp!=null)
		{
			if(temp.username.equals(username))
				return temp;
			else
				temp=temp.next;
		}
		return null;
	}
	public static void Login()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Username:");
		String username = input.nextLine();
		System.out.println("Password:");
		String password = input.nextLine();
		if(Validate(username,password))
		{
			UserMenu(findUser(username));
		}
		else
		{
			System.out.println("Invalid crendetials");
			displayLogin();
		}
	}
	public static void displayLogin()
	{
		System.out.println("Login Menu \n 1.New account \n 2.Login \n 3.Exit");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice)
		{
			case 1: newAccount();
			break;
			case 2: Login();
			break;
			case 3: Exit();
			break;
			default:
				System.out.println("Invalid choice");
		}
	}
	public static void Exit()
	{
		System.out.println("Program ended");
	}
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		loadUserData();
		//System.out.println(RootUser.username+","+RootUser.password);
		
		
		displayLogin();
		
		
		
	}
}
