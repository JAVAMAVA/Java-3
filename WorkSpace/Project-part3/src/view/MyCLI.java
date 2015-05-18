package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * {@link MyCLI} extends {@link CLI} and implements {@link Runnable} 
 *  it is the main part behind the view commands
 * @author Michael&Amit
 * @see CLI
 * @see Runnable
 *
 */

public class MyCLI extends CLI implements Runnable  {
	
	HashMap<String, presenter.Presenter.Command> hm;
	public MyCLI(BufferedReader in, PrintWriter out,View v) {
		super(in, out);
		hm=new HashMap<>();
		this.v=v;

	}
	
	@Override 
	public String start()
	{
		try {
		System.out.println("Enter a command");
		String Line=in.readLine();
		
			while (!Line.equals("exit"))
			{
				String[] sp = Line.split(" ");
								
				String commandName = sp[0]+" "+sp[1];
				String arg1 = null;
				if (sp.length > 2)
				{
					if(sp.length>3)
					{
						arg1 = sp[2]+" "+sp[3];
						
					}
					arg1=sp[2];
					return arg1;
				}
				return commandName;
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		v.notifyArg(this);		
	}

}
