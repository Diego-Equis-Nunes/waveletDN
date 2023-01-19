import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // This server will support tracking, adding and quering strings.
    List <String> storage = new ArrayList()<String>;

    public String handleRequest(URI url) {
        
        if (url.getPath().equals("/")) {
            return String.format("Diego Nunes' String: ", storage);
        } 
        //When search
        if (url.getPath().equals("/search")) {
           System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("app")) {}
        } else {
                //When add, have all add options.
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("anewstringtoadd")) {
                    num += Integer.parseInt(parameters[1]);
                    return String.format("Diego Nunes' Number increased by %s! It's now %d", parameters[1], num);
                }
                if (parameters[0].equals("pineapple")) {}
                if (parameters[0].equals("apple")) {}
            }
            return "404 Not Found!";
        }
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
