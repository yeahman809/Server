
import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 * Created by gregi_000 on 1/20/2017.
 */
public class TCPClient {
    public static void main(String args[])throws Exception
    {
        Socket clientSocket = null;
       
        try{
            clientSocket = new Socket("koala1.cs.clemson.edu", 1212);

        } catch(UnknownHostException e1){}
        catch (SocketException e1) {}
        catch (IOException e1) {}


        BufferedReader in = new BufferedReader(new InputStreamReader
            (clientSocket.getInputStream()));
            
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
            true);
            
        Scanner clientInput = new Scanner(System.in);
        String toServer = clientInput.nextLine();
        
        out.println(toServer);
        
        String toClient = in.readLine();
        
        System.out.println(toClient);
        
        clientSocket.close();
        in.close();
        out.close();

    }
}
