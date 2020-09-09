// https://developer.ibm.com/zh/articles/j-lo-javaio/
// https://developer.ibm.com/zh/articles/j-lo-chinesecoding/

import java.io.*;

class ClassViewer {
    static class ClassFile {
        public static int SIGNATURE = 0xCAFEBABE;

        public int magic;
        public short minor_version;
        public short major_version;

        public void read(DataInputStream input) throws IOException {
            magic = input.readInt();
            minor_version = input.readShort();
            major_version = input.readShort();
        }

        public void printInfo() {
            System.out.println("ClassFile:");
            System.out.println("  version - " + major_version + "." + minor_version);
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage:");
            System.out.println("  java ClassViewer <.class file>");
            return;
        }

        try {
            DataInputStream input = new DataInputStream(new FileInputStream(args[0]));

            // static nested class
            // https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
            ClassViewer.ClassFile classFile = new ClassViewer.ClassFile();
            classFile.read(input);
            if (classFile.magic != ClassFile.SIGNATURE) {
                System.out.println("Invalid .class file: " + args[0]);
            }

            classFile.printInfo();
        }
        catch (FileNotFoundException e) {
            System.out.println("Can't open file: " + args[0]);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
