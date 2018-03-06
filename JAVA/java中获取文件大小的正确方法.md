### java中获取文件大小的功能
1. 使用File的length方法
2. 使用FileInputStream的available()方法
### 使用的文件
![img](images/java_file_size.png)
1. 使用File的length()方法
    ```
    public static void main(String[] args) {
        File f= new File("D:\\CentOS-6.5-x86_64-bin-DVD1.iso");  
        if (f.exists() && f.isFile()){
            logger.info(f.length());
        }else{
            logger.info("file doesn't exist or is not a file");  
        }
    }
    ```
    > 输出的结果 4467982336 结果是4.16GB，与Windows上显示的结果一致。
2. 使用FileInputStream的available()方法
    ```
    public static void main(String[] args) {
        FileInputStream fis= null;
        try {
            File f= new File("D:\\CentOS-6.5-x86_64-bin-DVD1.iso");  
            fis= new FileInputStream(f);
            logger.info(fis.available());  
        } catch(Exception e) {
            logger.error(e);
        }finally{
            if (null!=fis){  
                try {
                    fis.close();  
                } catch (IOException e) {  
                    logger.error(e);
                }
            }
        }
    }
    ```
    > 输出的结果 2147483647 结果约等于2GB。它是Integer.MAX_VALUE，也就是有符号整型能表示的最大数值。
    
    > 原因
    > 1. File的length()方法返回的类型为long，long型能表示的正数最大值为：9223372036854775807，
    > 折算成最大能支持的文件大小为：8954730132868714 EB字节，这个量级将在人类IT发展史上受用很多很多年，
    > 2. 而FileInputStream的avaliable()方法返回值是int，在之前也介绍了最大的表示范围，
    > 所能支持的最大文件大小为：1.99GB，而这个量级我们现在很容易就达到了。
    
### 通过流的方式读文件大小
> 通过java.nio.* 
```
public static void main(String[] args) {
    FileChannel fc = null;
    try {
        File f = new File("D:\\CentOS-6.5-x86_64-bin-DVD1.iso");
        if (f.exists() && f.isFile()) {
            FileInputStream fis = new FileInputStream(f);
            fc = fis.getChannel();
            logger.info(fc.size());
        } else {
            logger.info("file doesn't exist or is not a file");
        }
    } catch (FileNotFoundException e) {
        logger.error(e);
    } catch (IOException e) {
        logger.error(e);
    } finally {
        if (null != fc)){
            try {
                fc.close();
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
}
```
    