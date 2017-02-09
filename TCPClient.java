package edu.clemson.cpsc3600.prog1;
import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * Created by gregi_000 on 1/20/2017.
 */
public class TCPClient {
    public static void main(String args[])throws Exception
    {
        Socket clientSocket = null;
        try{
            clientSocket = new Socket("local host", 6789);

    } catch(UnknownHostException e1){}
        catch (SocketException e1) {}
        catch (IOException e1) {}


        BufferedReader in = new BufferedReader(new InputStreamReader
            (clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
            true);
        out.println("Hi there");
        String fromServer = in.readLine();
        System.out.println(fromServer);

        clientSocket.close();
        in.close();
        out.close();

    }
}
