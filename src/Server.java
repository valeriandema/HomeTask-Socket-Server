import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Server {
	private static Socket clientSocket = null;
	private static ObjectOutputStream oos;
	private static ServerSocket server;
	private static ServerMessage serverMessage;
	private static ArrayList<String> listOfFields = new ArrayList<>();
	private static ArrayList<String> listOfValues = new ArrayList<>();
	
	public static void main (String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException, SQLException, IOException {
		String[] separateString, separateString2;
		
		
		/*String str = "SELECT Product.Name, Product.Price FROM Product WHERE Product.Price > 500";
		String key = "MyDifficult_pass";
		String login = "valera"; 
		String pass = "127681"; 
		String database = "HomeWorkDBShop";
		String ip = "127.0.0.1";
		String str2 = str + "=" + key + " " + login + " " + pass + " " + database + " " + ip;
		Socket socket;*/
		
		try {
			server = new ServerSocket(1437);
			System.out.println("not connect");
			//while (true) {
				
				clientSocket = server.accept();
				System.out.println("connected");
				//Encription.encrypt("Hey hey", clientSocket.getOutputStream());
				//connect.close();
				
				clientSocket.getOutputStream().write("HUYPIZDA".getBytes());
				
				/*try {
					String str2 = (String) Encription.decrypt(clientSocket.getInputStream());
					System.out.println("decrypted");
					separateString = str2.split("=");
					separateString2 = separateString[1].split("\\s+");
					DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
					Connection connect = DriverManager.getConnection("jdbc:sqlserver://" + separateString2[4] + ";databaseName=" + separateString2[3] + 
							";user=" + separateString2[1] + ";password=" + separateString2[2] + ";");
					
					Statement st = connect.createStatement();
					ResultSet rS = st.executeQuery(separateString[0]);
					
					ResultSetMetaData metaData = rS.getMetaData();
					serverMessage = new ServerMessage();
					
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						//System.out.printf("%s\t", metaData.getColumnLabel(i));
						listOfFields.add(metaData.getColumnLabel(i));
					}
					//System.out.println();
					
					while (rS.next()) {
						for (int i = 1; i <= metaData.getColumnCount(); i++) {
							//System.out.printf("%s\t", rS.getString(i));
							listOfValues.add(rS.getString(i));
						}
						//System.out.println();
					}
					
					serverMessage.setListOfFields(listOfFields);
					serverMessage.setListOfValues(listOfValues);
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
				}*/
			//}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clientSocket.close();
		}
	}
}