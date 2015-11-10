package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur  extends Liason{

        private ServerSocket serverSocket;
        private Socket clientSocket;
        private int portNumber ;
        private Analyseur analyseur ;

    /**
     *
     * @param portNumber
     *
     */
    public Serveur(int portNumber){
        this.portNumber = portNumber;
        this.analyseur = new AnalyseurJson();
    }

    /**
     * initialise la serverSocket avec le portNumber
     */
    public void initialiserServerSocket(){
        try {
             this.serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void  startListening(){
        initialiserServerSocket();
        try {
            clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                super.send(analyseur);
                out.println(inputLine);
                analyseur.analyser(inputLine);
                System.out.println("serveur : "+inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        Serveur s = new Serveur(10000);
        s.startListening();
    }

}
