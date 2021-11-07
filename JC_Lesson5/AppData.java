package JC_Lesson5;

import java.io.*;

public class AppData {
    private static class Table implements Serializable {
        public String[] header;
        private int[][] data;

        public Table(String header, int data) {
            this.header = header;
            this.data = data;
        }

        public void info() {
            System.out.println(data + " " + header);
        }
    }

        public static void main(String[] args) {
            File csvFile = new File("hw.scv");
            Table table1Out = new Table("Value1", 1);
            Table table2Out = new Table("Value2", 10);


            try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("hw"))) {
                objOut.writeObject(table1Out);
                objOut.writeObject(table2Out);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Table table1In = null;
            Table table2In = null;
            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("hw"))) {
                table1In = (Table) objIn.readObject();
                table2In = (Table) objIn.readObject();
                table1In.info();
                table2In.info();
            } catch (Exception e) {
                e.printStackTrace();
            }



        }

}
