
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
/**
 * Created by gregi_000 on 1/20/2017.
 */
public class TCPServer
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket serverSocket = null;
        

        try{
            serverSocket = new ServerSocket(1212);
        }catch(UnknownHostException e){}
        catch(SocketException e){}
        catch(IOException e ){}

        while(true)
        {
            Socket theConnection = serverSocket.accept();
            
            BufferedReader in = new BufferedReader(new InputStreamReader
                    (theConnection.getInputStream()));
                    
            PrintWriter out = new PrintWriter(theConnection.getOutputStream(),true);
            
            String fromClient = in.readLine();
            try {
                Files.write(Paths.get("log.txt"), (fromClient+"\n").getBytes(), StandardOpenOption.APPEND);
            }catch (IOException ignored) {}
            
            String capitalize = "";
              capitalize = fromClient.toUpperCase();
            //String capitalize = fromClient.toUpperCase();
            System.out.println(fromClient);
            
            capitalize = fromClient.toUpperCase();
            
            out.println(capitalize);
            
            theConnection.close();
            in.close();
            out.close();
        }
    }
}
