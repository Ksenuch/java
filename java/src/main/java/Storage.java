import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String fileName = "storage.json";
    static ObjectMapper objectMapper = new ObjectMapper();
    static ArrayList<Consumer> buffer = new ArrayList<Consumer>();

    public Storage() throws IOException {
        this.readInBuffer();
    }

    public Storage(String fileName) throws IOException {
        this();
        this.fileName = fileName;
    }

    public void addConsumer(Consumer consumer) {
        buffer.add(consumer);
        this.writeFromBuffer();
    }

    private void writeFromBuffer() {
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            String text = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(buffer);
            writer.write(text);

            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void readInBuffer() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try(FileReader reader = new FileReader(fileName))
        {
            int c;
            while((c=reader.read()) != -1){
                stringBuilder.append((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        String result = stringBuilder.toString();

        if (result.length() > 0) {
            Consumer[] consumers = objectMapper.readValue(result, Consumer[].class);
            buffer = new ArrayList<Consumer>(List.of(consumers));
        }
    }
}
