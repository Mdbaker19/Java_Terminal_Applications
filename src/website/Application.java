package website;

import fileIo.FileReader;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/website", "users.txt", "users.txt");

        User one = new User("Matt", "Password", "1");

        reader.writeToLog(one);

    }

}
