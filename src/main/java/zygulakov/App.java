package zygulakov;

import java.io.*;

public class App {
	private static BufferedReader reader;
	private static int id;
	private static String name,lastName,city,str;

	public static void main(String[] args) throws Exception {

		System.out.println("checking settings getting ready...");
		Json json = new Json();
		System.out.println("OK connection established!");
		System.out.println("pls enter \"-h\" for help");
		EmpDao em = new EmpDaoImpl(json.getSettings());
		// if everything is ok create the object
		// read from console
		reader = new BufferedReader(new InputStreamReader(System.in));

		while (!(str = reader.readLine()).equals("")) {
			String[] s = str.split(" ");
			// if first argument of entered String is -a then add new Employee
			// with a given parameters(-a id name lastName city)
			if (s[0].equals("-a")) {
				id = Integer.parseInt(s[1]);
				name = s[2];
				lastName = s[3];
				city = s[4];
				em.add(new Employee(name, lastName, city, id));
			}
			// if first argument is -ga(Get All) then return all objects and print them
			if (s[0].equals("-ga")) {
				System.out.println("getting all Eployees ...");
				System.out.println("\nempID : name : lastName : city");
				for (Employee emp : em.getAll()) {
					System.out.println(emp);
				}
			}
			//if string is -g then get second argument and get the 
			//object by provided argument if exist and print
			if (s[0].equals("-g")) {
				id = Integer.parseInt(s[1]);
				Employee e = em.get(id);
				if (e != null)
					System.out.println("\nempID : name : lastName : city");
					System.out.println(e);
			}
			if(s[0].equals("-r")) {
				id = Integer.parseInt(s[1]);
				em.remove(id);
				
			}
			//-u for updating data <old id> <new name> <new lastname> <new city>
			if(s[0].equals("-u")) {
				id = Integer.parseInt(s[1]);
				name = s[2];
				lastName = s[3];
				city = s[4];
				
			}

		}

	}
}
