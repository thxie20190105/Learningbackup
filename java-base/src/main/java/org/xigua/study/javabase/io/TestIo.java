package org.xigua.study.javabase.io;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author 山五洲
 */
public class TestIo {
    /**
     * 储存文件的集合
     */
    private static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) {
        //File文件类
        testFile();

        //字符输入流
        tFileReader();

        //字符输出流
        tWriter();

        //遍历文件//通过判断是否为文件夹递归
        printFileList("D:" + File.separator + "soft");

        //字节输入流
        tFileInputStream();

        //字节输出流
        tOutputStream();

        //拷贝文件
        copyFile();

        //测试缓冲流
        tBuffer();

        //序列化文件
        tOutputObject();

        //反序列化文件
        tInputObject();

        //properties
        tProperties();
    }

    private static void tProperties() {
        Properties properties = new Properties();

        File file = new File("D:" + File.separator + "Properties.txt");
        String data = "springioc.profiles.active=dev";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
            properties.load(new FileInputStream(file));
            Set<String> strings = properties.stringPropertyNames();
            strings.forEach(s -> System.out.println(s + "\t" + properties.getProperty(s)));

            fileOutputStream.close();
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                file.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void tInputObject() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:" + File.separator + "Object.obj"));
            User user = (TestIo.User) inputStream.readObject();
            inputStream.close();
            System.out.println("反序列化输出" + user.getAge() + user.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void tOutputObject() {
        User user = new User();
        user.setAge(19);
        user.setName("tom");

        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("D:" + File.separator + "Object.obj"));
            outputStream.writeObject(user);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void tBuffer() {
        //使用缓冲流一共两个目的，1、减少IP，2、使用其扩展方法
        InputStream inputStream = null;
        try {
            File file = new File("D:" + File.separator + "abc.zip");
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("创建文件");
                }

            }
            inputStream = new FileInputStream(file);

            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            byte[] bytes = new byte[4098];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void tFileReader() {
        File file = new File("D:" + File.separator + "test.txt");
        if (!file.getParentFile().exists()) {
            if (file.getParentFile().mkdirs()) {
                System.out.println("创建文件");
            }
        }
        Reader reader = null;

        try {
            reader = new FileReader(file);
            char[] chars = new char[4];
            int tem;
            while ((tem = reader.read(chars)) != -1) {
                System.out.println(chars);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printFileList(String filePath) {
        File file = new File(filePath);
        File[] fs = file.listFiles();
        if (fs != null) {
            for (File f : fs) {
                if (f.isDirectory()) {
                    System.out.println("目录为：" + f.getAbsolutePath());
                    printFileList(f.getAbsolutePath());
                } else {
                    System.out.println("\t" + f.getName());
                    fileList.add(f);
                }
            }
        }
    }

    private static void copyFile() {
        File file = new File("D:" + File.separator + "abc.zip");
        File outFile = new File("D:" + File.separator + "abc2.zip");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        if (!file.exists()) {
            System.out.println("创建成功");
        }

        try {
            inputStream = new FileInputStream(file);
            //有会覆盖没有会自动创建
            outputStream = new FileOutputStream(outFile);
            byte[] bytes = new byte[4096];
            int temp;
            while ((temp = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, temp);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    static class User implements Serializable {
        private transient String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    private static void tWriter() {
        File file = new File("D:" + File.separator + "test.txt");
        String data = "Hello World";
        if (!file.getParentFile().exists()) {
            if (file.getParentFile().mkdirs()) {
                System.out.println("200");
            }
        }
        Writer writer = null;

        try {
            writer = new FileWriter(file);
            writer.write(data);
            //如果不关闭下面的reader是读不到东西的，因为在new FileWriter时打开的文件是空的，不关闭写流就不会保存。
            //不关闭流的话数据还在内存里
            //可以使用flush方法刷新流，先保存一部分，这也回答了针对大文件如何写的疑惑。
            writer.flush();
            char[] chars = new char[1024];
            writer.close();
            System.out.println(new String(chars));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void tOutputStream() {
        // 定义文件路径
        File file = new File("D:" + File.separator + "test1.txt");
        String data = "hello world !\\r\\nhello world !\\r\\nhello world !\\r\\nhello world !";

        OutputStream outputStream = null;


        try {
            outputStream = new FileOutputStream(file);
            //从内存中输出
            outputStream.write(data.getBytes(), 0, data.getBytes().length);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void tFileInputStream() {
        // 定义文件路径
        File file = new File("D:" + File.separator + "test1.txt");

        if (!file.getParentFile().exists()) {
            if (file.getParentFile().mkdirs()) {
                System.out.println("创建文件成功");
            }
        }
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);
            //表示一次查询两个字节
            byte[] bytes = new byte[1024];

            //指定一次读多少字节
            while (inputStream.read(bytes) != -1) {
                //以字节的形式保存在bytes里。
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testFile() {

        String fileName = "D:" + File.separator + "testFile.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("文件不存在");

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            if (file.isDirectory()) {
                System.out.println(fileName + "类型为文件夹");
            } else if (file.isFile()) {
                System.out.println(fileName + "类型为文件");
            }
        }

        System.out.println("文件绝对路径为" + file.getAbsolutePath());
        System.out.println("文件抽象路径为" + file.getPath());
        System.out.println("文件名为" + file.getName());
        System.out.println("文件大小为" + file.length() + "字节");

        file.delete();

    }

}
