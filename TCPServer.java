package edu.clemson.cpsc3600.prog1;
import java.io.*;
import java.net.*;

/**
 * Created by gregi_000 on 1/20/2017.
 */
public class TCPServer
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(6789);
        }catch(UnknownHostException e){}
        catch(SocketException e){}
        catch(IOException e ){}

        while(true)
        {
            Socket theConnection = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader
                    (theConnection.getInputStream()));
            PrintWriter out = new PrintWriter(theConnection.getOutputStream());
            String fromClient = in.readLine();

            System.out.println(fromClient);
            out.println("This is a message from the server");
            theConnection.close();
            in.close();
            out.close();
        }
    }





}
