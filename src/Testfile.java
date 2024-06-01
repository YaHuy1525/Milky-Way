import java.io.*;

public class Testfile {
    public void test(){
        try{
            InputStream map = getClass().getResourceAsStream("/Map/Map01.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(map));
            StringBuilder line = new StringBuilder();
            while(reader.readLine() != null){
                line.append(reader.readLine());
            }
            System.out.println(line.capacity());
            char[] tilenum = line.toString().toCharArray();
            System.out.println(tilenum);
            int a = tilenum[1];
            System.out.println(a);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Testfile test = new Testfile();
        test.test();
    }
}
