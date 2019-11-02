
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TextFileReadingAndWriting {

    private static final String FILE_NAME = "FileWrite1.txt";

    public static void main(String[] args) throws IOException {
        clearFile(FILE_NAME);
        writeToFile(FILE_NAME, "first line");
        writeToFile(FILE_NAME, "second line");
        readFromFile(FILE_NAME);
    }

    public static void clearFile(String FILE_NAME){
        new File(FILE_NAME).deleteOnExit();
    }
    private static void writeToFile(final String fileName, String text) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true), true);
        printWriter.append(text);
        printWriter.flush();
    }

    private static void readFromFile(final String file) throws IOException{
        BufferedReader bufferedReader= new BufferedReader(new FileReader(file));
        List<String> lines=new ArrayList();
        bufferedReader.lines().forEach(a-> {
            lines.add(a);
        });
        System.out.println(lines);
    }

    private static void readAndWriteToTextFile() {
        File file = new File("FileWrite1.txt");
        char charArray[] = new char[225];
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("abc");
            bufferedWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.read(charArray);
            for (char a : charArray) {
                System.out.println(a);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
