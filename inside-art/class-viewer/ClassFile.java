import java.io.*;

class ClassFile {
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
